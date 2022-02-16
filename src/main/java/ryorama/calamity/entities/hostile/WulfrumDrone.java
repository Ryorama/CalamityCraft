package ryorama.calamity.entities.hostile;

import com.zeitheron.hammercore.utils.AABBUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.zeith.terraria.api.entity.IGoreEntity;
import org.zeith.terraria.api.enums.EnumDamageType;
import org.zeith.terraria.common.content.entity.ai.behaviors.AI;
import org.zeith.terraria.common.content.entity.ai.behaviors.FighterAI;
import org.zeith.terraria.common.content.entity.api.EntityGenericTerrariaMob;
import org.zeith.terraria.common.content.entity.api.EntityProps;
import ryorama.calamity.entities.ai.WulfrumDroneAI;
import ryorama.calamity.items.ItemsC;

public class WulfrumDrone extends EntityGenericTerrariaMob implements IGoreEntity {
   int chaseTime = 0;

   public WulfrumDrone(World worldIn) {
      super(worldIn);
   }

   public void createDrop(int looting, DamageSource source, NonNullList drops) {
      drops.add(ItemsC.WULFRUM_SHARD.stack());
   }

   public AI createAI() {
      return new FighterAI(this, DATA_DIRECTION, 0.30000001192092896D);
   }

   public void onCollideWithPlayer(EntityPlayer entityIn) {
      super.onCollideWithPlayer(entityIn);
      Vec3d ourCenter = AABBUtils.getCenter(this.getEntityBoundingBox());
      Vec3d plCenter = AABBUtils.getCenter(entityIn.getEntityBoundingBox());
      if (this.isEntityAlive() && entityIn != null && ourCenter.distanceTo(plCenter) <= 1.5D && this.attackCD <= 0) {
         if (this.Main.expertMode = false) {
            EnumDamageType.ENEMY.attackEntity(entityIn, this, 10.0F);
         }

         if (this.Main.expertMode = true) {
            EnumDamageType.ENEMY.attackEntity(entityIn, this, 20.0F);
         }

         this.attackCD += 10;
         this.chaseTime = 0;
      }

   }

   public void initProps(EntityProps props) {
      props.damage = this.Main.expertMode ? 20.0F : 10.0F;
      props.lifeMax = this.Main.expertMode ? 44.0F : 22.0F;
      props.damage = 10.0F;
      props.defense = 6.0F;
      props.width = 32.0F;
      props.height = 32.0F;
      props.value = 150;
   }
}
