package ryorama.calamity.items.bows;

import net.minecraft.item.ItemStack;
import org.zeith.terraria.common.content.items.tools.base.ItemTerrariaBow;
import ryorama.calamity.CreativeTabsC;
import ryorama.calamity.blocks.BlocksC;
import ryorama.calamity.items.ItemsC;
import ryorama.calamity.items.ToolsC;
import ryorama.calamity.items.WeaponsC;

public class WulfrumBow extends ItemTerrariaBow {
   public WulfrumBow() {
      super("wulfrum", 11.0F);
      this.useTime = 25;
      this.velocity = 12.0F;
      this.critChancePercent = 4;
      this.inTab(CreativeTabsC.TI_ITEMS_BOWS);
   }

   @Override
   public void addRecipes(Craftery c) {
      c.addPrehardmodeAnvilRecipe(WeaponsC.WULFRUM_BOW.stack(), new ItemStack(ItemsC.WULFRUM_SHARD, 10));
   }
}
