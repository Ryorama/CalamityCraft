package ryorama.calamity.entities.ai;

import org.zeith.terraria.common.content.entity.ai.behaviors.AI;
import org.zeith.terraria.common.content.entity.api.EntityGenericTerrariaMob;

public class WulfrumDroneAI<T extends EntityGenericTerrariaMob> extends AI<T> {

    public WulfrumDroneAI(T entity) {
        super(entity);
    }

    @Override
    public void onLivingUpdatePre() {
        if (this.base.attackCD > 0) {
            --this.base.attackCD;
        }

        double yawX = this.base.rotationYaw;
        double yawY = this.base.rotationYaw;
        if (this.base.target == null) {
            this.base.targetClosest();
        }

        if (this.base.target != null) {
            this.faceEntity(this.base.target, 5.0F, 5.0F, false);
            this.base.velX = (float)Math.cos(Math.toRadians(yawX) + 90.0D);
            this.base.velZ = (float)Math.sin(Math.toRadians(yawY) + 90.0D);
            this.base.velY = -3.0F;
        }
    }

    @Override
    public void onLivingUpdatePost() {

    }
}
