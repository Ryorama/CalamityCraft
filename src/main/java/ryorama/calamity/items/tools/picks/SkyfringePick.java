package ryorama.calamity.items.tools.picks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.zeith.terraria.api.items.tabs.TabInfo;
import org.zeith.terraria.common.content.items.tools.base.ItemTerrariaPick;
import org.zeith.terraria.init.BlocksTC;
import ryorama.calamity.CreativeTabsC;
import ryorama.calamity.blocks.BlocksC;
import ryorama.calamity.items.ToolsC;

import java.util.Collections;
import java.util.List;

public class SkyfringePick extends ItemTerrariaPick {
   public SkyfringePick() {
      super(6, "aerialite");
      this.useTime = 15;
      this.attackDmg = 12.0F;
      this.toolSpeed = 16.0F;
   }

   @Override
   public List<TabInfo> getTabGroups() {
      return Collections.singletonList(CreativeTabsC.TI_ITEMS_PICKS);
   }

   public float getPower(EntityPlayer player, ItemStack stack) {
      return 95.0F;
   }

   @Override
   public void addRecipes(Craftery c) {
      c.addPrehardmodeAnvilRecipe(ToolsC.SKYFRINGE_PICKAXE.stack(), new ItemStack(BlocksC.AERIALITE_BAR, 7), new ItemStack(BlocksTC.SUNPLATE_BLOCK, 3));
   }
}
