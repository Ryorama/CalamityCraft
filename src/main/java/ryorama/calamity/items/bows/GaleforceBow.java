package ryorama.calamity.items.bows;

import net.minecraft.item.ItemStack;
import org.zeith.terraria.common.content.items.tools.base.ItemTerrariaBow;
import org.zeith.terraria.init.BlocksTC;
import ryorama.calamity.CreativeTabsC;
import ryorama.calamity.blocks.BlocksC;
import ryorama.calamity.items.ItemsC;
import ryorama.calamity.items.WeaponsC;

public class GaleforceBow extends ItemTerrariaBow {
   public GaleforceBow() {
      super("aerialite", 18.0F);
      this.useTime = 16;
      this.velocity = 20.0F;
      this.critChancePercent = 4;
      this.inTab(CreativeTabsC.TI_ITEMS_BOWS);
   }

   @Override
   public void addRecipes(Craftery c) {
      c.addPrehardmodeAnvilRecipe(WeaponsC.AERIALITE_BOW.stack(), new ItemStack(BlocksC.AERIALITE_BAR, 8), new ItemStack(BlocksTC.SUNPLATE_BLOCK, 3));
   }
}
