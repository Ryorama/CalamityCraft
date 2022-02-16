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

public class ArticArrow extends ItemTerrariaArrow {
   public ArticArrow() {
      this.setTranslationKey("artic_arrow");
      this.sellValue = 2;
      this.info = (new AmmoProperty(16.0F, EnumDamageType.RANGED)).setVelocity(3.5F);
   }

   public void onArrowTick(EntityGeneralAmmo arrow) {
      if (arrow.isInWater()) {
         arrow.ammo = ItemsC.ARTIC_ARROW;
         arrow.ammoStack = new ItemStack(ItemsC.ARTIC_ARROW);
         arrow.clientTicker = null;
         arrow.powerup -= 2.0F;
      }

   }

   public void onArrowSpawned(EntityGeneralAmmo arrow) {
      arrow.setLight(ColoredLight.builder().pos(Vec3d.ZERO).color(1.0F, 0.5F, 0.0F, 1.0F).radius(7.0F).build());
   }

   public ResourceLocation getTexture(ItemStack stack) {
      return new ResourceLocation("calamity", "textures/items/ammo/artic.png");
   }

   public void dropAmmo(World world, Vec3d position, EntityGeneralAmmo arrow) {
      arrow.dropItem(ItemsC.ARTIC_ARROW, 1);
   }
}
