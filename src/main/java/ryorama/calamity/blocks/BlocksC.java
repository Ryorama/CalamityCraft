package ryorama.calamity.blocks;

import org.zeith.terraria.api.blocks.SoundTypesTC;
import org.zeith.terraria.api.items.IRareItem;
import org.zeith.terraria.common.content.blocks.simple.*;
import org.zeith.terraria.init.AchievementsTC;
import ryorama.calamity.Calamity;
import ryorama.calamity.CreativeTabsC;

public class BlocksC {

   public static final BlockBaseDirt SULPHUROUS_SAND;
   public static final BlockBaseDirt SULPHUROUS_SANDSTONE;

   public static final BlockOre AERIALITE_ORE;
   public static final BlockOre PERENNIAL_ORE;

   public static final BlockBar AERIALITE_BAR;
   public static final BlockBar PERENNIAL_BAR;

   static {
      SULPHUROUS_SAND = new BlockBaseDirt().setTranslationKey("sulphurous_sand").setSoundType(SoundTypesTC.COMMON).inTab(CreativeTabsC.TI_ITEMS_CC);
      SULPHUROUS_SANDSTONE = new BlockBaseDirt().setTranslationKey("sulphurous_sandstone").setSoundType(SoundTypesTC.COMMON).inTab(CreativeTabsC.TI_ITEMS_CC);

      AERIALITE_ORE = (BlockOre)(new BlockOre("aerialite_ore", new BlockOre.SparkleInfo(0.1F, 4611455, 14), true, (BlockOre.ICollideListener)null, AchievementsTC.OOO_SHINY, 65, 0.04F, false, IRareItem.ItemRarity.ORANGE)).inTab(CreativeTabsC.TI_ITEMS_CC);
      PERENNIAL_ORE = (BlockOre)(new BlockOre("perennial_ore", new BlockOre.SparkleInfo(0.1F, 81500, 14), true, (BlockOre.ICollideListener)null, AchievementsTC.OOO_SHINY, 200, 0.04F, false, IRareItem.ItemRarity.ORANGE)).inTab(CreativeTabsC.TI_ITEMS_CC);

      AERIALITE_BAR = (BlockBar)(new BlockBar("aerialite", IRareItem.ItemRarity.ORANGE)).inTab(CreativeTabsC.TI_ITEMS_CC);
      PERENNIAL_BAR = (BlockBar)(new BlockBar("perennial", IRareItem.ItemRarity.ORANGE)).inTab(CreativeTabsC.TI_ITEMS_CC);
   }
}
