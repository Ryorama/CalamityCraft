package ryorama.calamity.items.life_items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import org.zeith.terraria.TerrariaCraft;
import org.zeith.terraria.api.core.TerrariaCraftAPI;
import org.zeith.terraria.api.items.ILeftClickableItem;
import org.zeith.terraria.common.content.items.base.ItemBaseTC;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.init.SoundsTC;
import ryorama.calamity.LifeExpansionManager;

public class MiracleFruit extends ItemBaseTC implements ILeftClickableItem {
   public MiracleFruit() {
      this.setTranslationKey("miracle_fruit");
      this.stackSize = 1;
      this.rarity = ItemRarity.LIME;
   }

   public void onLeftClick(EntityPlayer player, ItemStack stack) {
      if (!player.world.isRemote) {
         TerrariaCraftAPI.SOUNDS.playSoundTo(player, SoundsTC.ITEMS_4_CRYSTAL_USE, player.getEntityWorld(), player.getPositionVector(), 1.0F, 1.0F, SoundCategory.PLAYERS);
      }
      useMiracleFruit(player, stack);
   }

   public static boolean useMiracleFruit(EntityPlayer player, ItemStack stack) {
      if ((float) PlayerDataTC.get(player).health().additionalHealthAddedByFruits >= 100.0F) {
         PlayerDataTC pd = PlayerDataTC.get(player);
         boolean did = ((LifeExpansionManager)pd.getData(LifeExpansionManager.class)).addMiracleFruit();
         if (did && !pd.isCreative()) {
            stack.shrink(1);
         }

         return did;
      } else {
         return false;
      }
   }
}
