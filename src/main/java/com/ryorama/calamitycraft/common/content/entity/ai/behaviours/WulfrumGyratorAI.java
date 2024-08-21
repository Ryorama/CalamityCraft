package com.ryorama.calamitycraft.common.content.entity.ai.behaviours;

import com.ryorama.calamitycraft.common.content.entity.hostile.wulfrum.WulfrumBaseEntity;
import com.ryorama.calamitycraft.utils.UtilsCC;
import org.zeith.terraria.common.content.entity.ai.behaviors.AI;
import org.zeith.terraria.common.content.entity.api.EntityGenericTerrariaMob;
import org.zeith.terraria.common.data.world.spawn.MobDespawner;
import org.zeith.terraria.utils.math.Vector2;

public class WulfrumGyratorAI extends AI<EntityGenericTerrariaMob<WulfrumGyratorAI>> {
    public float maxMovementSpeedX = 6f;
    public float timeSpentStuck;
    public WulfrumGyratorAI(EntityGenericTerrariaMob<WulfrumGyratorAI> base) {
        super(base);
    }

    @Override
    public void onLivingUpdatePre() {
        if (this.base.ticksExisted > 400 && !MobDespawner.isInViewAngleOfAnyPlayer(this.base, 24.0)) {
            this.base.setDead();
        } else {
            if (this.base.target == null) {
                this.base.targetClosest();
            } else {
                double directionX = Math.signum(base.target.posX - base.posX * 1);
                double directionZ = Math.signum(base.target.posZ - base.posZ * 1);

                WulfrumBaseEntity entity = ((WulfrumBaseEntity)base.getStateEntity());
                float chargeJumpSpeed = 12;
                float maxHeight = (float) (chargeJumpSpeed * chargeJumpSpeed * (float)Math.pow(Math.sin(UtilsCC.angleTo(new Vector2(base.target.height / 2, base.target.width / 2))), 2) / (4f * 0.3));
                boolean jumpWouldHitPlayer = 40 > Math.abs(base.target.height / 2 - base.width / 2) && maxHeight < Math.abs(base.target.height / 2 - base.width / 2) + base.target.height;

                base.velX = UtilsCC.lerp((float) base.velX, (float) (maxMovementSpeedX * directionX * (entity.isSupercharged ? 1.25f : 1f)), entity.isSupercharged ? 0.02f : 0.0125f);
                base.velY = -4;
                base.velZ = UtilsCC.lerp((float) base.velZ, (float) (maxMovementSpeedX * directionZ * (entity.isSupercharged ? 1.25f : 1f)), entity.isSupercharged ? 0.02f : 0.0125f);

                if (jumpWouldHitPlayer && base.collideY && base.velY <= 0) {
                    base.velY = chargeJumpSpeed;
                }

                if (base.collideX && base.collideZ && base.collideY && base.velY <= 0) {
                    base.velY = 20;
                }

                if (base.prevPosX == base.posX && base.prevPosZ == base.posZ) {
                    timeSpentStuck++;
                    if (timeSpentStuck > 90) {
                        base.velY = 20;
                        timeSpentStuck = 0;
                    }
                }
            }
        }
    }

    @Override
    public void onLivingUpdatePost() {

    }
}
