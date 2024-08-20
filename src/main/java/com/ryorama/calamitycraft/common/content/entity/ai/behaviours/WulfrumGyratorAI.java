package com.ryorama.calamitycraft.common.content.entity.ai.behaviours;

import com.ryorama.calamitycraft.common.content.entity.hostile.wulfrum.WulfrumBaseEntity;
import com.ryorama.calamitycraft.utils.UtilsCC;
import org.zeith.terraria.common.content.entity.ai.behaviors.AI;
import org.zeith.terraria.common.content.entity.api.EntityGenericTerrariaMob;
import org.zeith.terraria.common.data.world.spawn.MobDespawner;

public class WulfrumGyratorAI extends AI<EntityGenericTerrariaMob<WulfrumGyratorAI>> {
    public float maxMovementSpeedX = 6f;
    public WulfrumGyratorAI(EntityGenericTerrariaMob<WulfrumGyratorAI> base) {
        super(base);
    }

    @Override
    public void onLivingUpdatePre() {

    }

    @Override
    public void onLivingUpdatePost() {
        if (this.base.ticksExisted > 400 && !MobDespawner.isInViewAngleOfAnyPlayer(this.base, 24.0)) {
            this.base.setDead();
        } else {
            if (this.base.target == null) {
                this.base.targetClosest();
            } else {
                double directionX = Math.signum(base.target.posX - base.posX * 1);
                double directionZ = Math.signum(base.target.posZ - base.posZ * 1);

                WulfrumBaseEntity entity = ((WulfrumBaseEntity)base.getStateEntity());

                base.velX = UtilsCC.lerp((float) base.velX, (float) (maxMovementSpeedX * directionX * (entity.isSupercharged ? 1.25f : 1f)), entity.isSupercharged ? 0.02f : 0.0125f);
                base.velZ = UtilsCC.lerp((float) base.velZ, (float) (maxMovementSpeedX * directionZ * (entity.isSupercharged ? 1.25f : 1f)), entity.isSupercharged ? 0.02f : 0.0125f);
                base.setVelocity(base.velX, -1, base.velZ);
            }
        }
    }
}
