package ryorama.calamity.items;

import org.zeith.terraria.common.content.items.magic.ItemMagicTool;
import org.zeith.terraria.common.content.items.tools.base.ItemTerrariaBow;
import org.zeith.terraria.common.content.items.tools.base.ItemTerrariaSword;
import ryorama.calamity.Calamity;
import ryorama.calamity.items.bows.GaleforceBow;
import ryorama.calamity.items.bows.WulfrumBow;
import ryorama.calamity.items.weapons.summon.SquireStaff;
import ryorama.calamity.items.weapons.swords.WindBlade;
import ryorama.calamity.items.weapons.swords.WulfrumBlade;

public class WeaponsC {
   public static ItemTerrariaSword WULFRUM_BLADE;
   public static ItemTerrariaSword SKY_BLADE;
   public static ItemTerrariaBow WULFRUM_BOW;
   public static ItemTerrariaBow AERIALITE_BOW;

   public static ItemMagicTool SQUIRE_STAFF;

   static {
      WULFRUM_BLADE = new WulfrumBlade();
      SKY_BLADE = new WindBlade();
      WULFRUM_BOW = new WulfrumBow();
      AERIALITE_BOW = new GaleforceBow();
      SQUIRE_STAFF = new SquireStaff();
   }
}
