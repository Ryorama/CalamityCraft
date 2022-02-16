package ryorama.calamity.items.weapons.swords;

import net.minecraft.item.ItemStack;
import org.zeith.terraria.common.content.items.tools.base.ItemTerrariaSword;
import org.zeith.terraria.init.BlocksTC;
import ryorama.calamity.CreativeTabsC;
import ryorama.calamity.blocks.BlocksC;
import ryorama.calamity.items.ToolsC;
import ryorama.calamity.items.WeaponsC;

public class WindBlade extends ItemTerrariaSword {
   public WindBlade() {
      super(41, "aerialite");
      this.useTime = 19;
      this.sellValue = 20;
      this.inTab(CreativeTabsC.TI_ITEMS_SWORDS);
   }

   @Override
   public void addRecipes(Craftery c) {
      c.addPrehardmodeAnvilRecipe(WeaponsC.SKY_BLADE.stack(), new ItemStack(BlocksC.AERIALITE_BAR, 9), new ItemStack(BlocksTC.SUNPLATE_BLOCK, 3));
   }
}
