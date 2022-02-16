package ryorama.calamity.items.arrow;

import com.zeitheron.hammercore.api.lighting.ColoredLight;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.zeith.terraria.api.enums.EnumDamageType;
import org.zeith.terraria.api.items.weaponry.AmmoProperty;
import org.zeith.terraria.common.content.entity.projectile.EntityGeneralAmmo;
import org.zeith.terraria.common.content.items.ammo.ItemTerrariaArrow;
import ryorama.calamity.items.ItemsC;

public class BloodfireArrow extends ItemTerrariaArrow {
   public BloodfireArrow() {
      this.setTranslationKey("bloodfire_arrow");
      this.sellValue = 2;
      this.info = (new AmmoProperty(40.0F, EnumDamageType.RANGED)).setVelocity(3.5F);
   }

   public void onArrowTick(EntityGeneralAmmo arrow) {
      if (arrow.isInWater()) {
         arrow.ammo = ItemsC.BLOODFIRE_ARROW;
         arrow.ammoStack = new ItemStack(ItemsC.BLOODFIRE_ARROW);
         arrow.clientTicker = null;
         arrow.powerup -= 2.0F;
      }

   }

   public void onArrowSpawned(EntityGeneralAmmo arrow) {
      arrow.setLight(ColoredLight.builder().pos(Vec3d.ZERO).color(1.0F, 0.5F, 0.0F, 1.0F).radius(7.0F).build());
   }

   public ResourceLocation getTexture(ItemStack stack) {
      return new ResourceLocation("calamity", "textures/items/ammo/bloodfire.png");
   }

   public void dropAmmo(World world, Vec3d position, EntityGeneralAmmo arrow) {
      arrow.dropItem(ItemsC.BLOODFIRE_ARROW, 1);
   }
}
