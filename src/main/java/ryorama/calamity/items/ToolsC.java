package ryorama.calamity.items;

import org.zeith.terraria.common.content.items.tools.base.ItemTerrariaPick;
import ryorama.calamity.items.tools.picks.SkyfringePick;
import ryorama.calamity.items.tools.picks.WulfrumPick;

public class ToolsC {
   public static ItemTerrariaPick WULFRUM_PICKAXE;
   public static ItemTerrariaPick SKYFRINGE_PICKAXE;

   static {
      WULFRUM_PICKAXE = new WulfrumPick();
      SKYFRINGE_PICKAXE = new SkyfringePick();
   }
}
