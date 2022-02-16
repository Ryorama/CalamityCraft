package ryorama.calamity.items.tools.picks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.zeith.terraria.api.items.tabs.TabInfo;
import org.zeith.terraria.common.content.items.tools.base.ItemTerrariaPick;
import org.zeith.terraria.init.CraftingTC;
import org.zeith.terraria.init.ItemTabsTC;
import ryorama.calamity.CreativeTabsC;
import ryorama.calamity.blocks.BlocksC;
import ryorama.calamity.items.ItemsC;
import ryorama.calamity.items.ToolsC;

import java.util.Collections;
import java.util.List;

public class WulfrumPick extends ItemTerrariaPick {
   public WulfrumPick() {
      super(6, "wulfrum");
      this.useTime = 15;
      this.attackDmg = 5.0F;
      this.toolSpeed = 16.0F;
   }

   @Override
   public List<TabInfo> getTabGroups() {
      return Collections.singletonList(CreativeTabsC.TI_ITEMS_PICKS);
   }

   public float getPower(EntityPlayer player, ItemStack stack) {
      return 35.0F;
   }

   @Override
   public void addRecipes(Craftery c) {
      c.addPrehardmodeAnvilRecipe(ToolsC.WULFRUM_PICKAXE.stack(), new ItemStack(ItemsC.WULFRUM_SHARD, 12));
   }
}
