package com.ryorama.calamitycraft.common.content.entity.ai.behaviours;

import com.ryorama.calamitycraft.utils.UtilsCC;
import org.zeith.terraria.common.content.entity.ai.behaviors.AI;
import org.zeith.terraria.common.content.entity.api.EntityGenericTerrariaMob;
import org.zeith.terraria.common.data.world.spawn.MobDespawner;
import org.zeith.terraria.init.BuffsTC;

public class WulfrumRoverAI extends AI<EntityGenericTerrariaMob<WulfrumRoverAI>> {
    public WulfrumRoverAI(EntityGenericTerrariaMob<WulfrumRoverAI> base) {
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

                base.velX = UtilsCC.lerp((float) base.velX, (float) (6 * directionX), 0.0125f);
                base.velZ = UtilsCC.lerp((float) base.velZ, (float) (6 * directionZ), 0.0125f);
                base.setVelocity(base.velX, -1, base.velZ);
            }
        }
    }
}
