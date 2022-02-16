package ryorama.calamity.items;

import org.zeith.terraria.api.items.IRareItem;
import org.zeith.terraria.common.content.entity.hostile.slimes.EntityGreenSlime;
import org.zeith.terraria.common.content.items.ItemSimpleMaterial;
import org.zeith.terraria.common.content.items.consumables.hostile.ItemHostile;
import org.zeith.terraria.common.content.items.grab_bags.ItemTreasureBag;
import ryorama.calamity.Calamity;
import ryorama.calamity.CreativeTabsC;
import ryorama.calamity.entities.hostile.WulfrumDrone;
import ryorama.calamity.entities.slimes.WulfrumSlime;
import ryorama.calamity.items.arrow.ArticArrow;
import ryorama.calamity.items.arrow.BloodfireArrow;
import ryorama.calamity.items.life_items.BloodOrange;
import ryorama.calamity.items.life_items.Dragonfruit;
import ryorama.calamity.items.life_items.Elderberry;
import ryorama.calamity.items.life_items.MiracleFruit;
import ryorama.calamity.items.tresure_bags.StarterBag;

public class ItemsC {
   public static final ItemSimpleMaterial WULFRUM_SHARD;
   public static final ItemSimpleMaterial BLOOD_ORB;
   public static final ArticArrow ARTIC_ARROW;
   public static final BloodfireArrow BLOODFIRE_ARROW;
   public static final BloodOrange BLOOD_ORANGE;
   public static final MiracleFruit MIRACLE_FRUIT;
   public static final Dragonfruit DRAGONFRUIT;
   public static final Elderberry ELDERBERRY;
   public static final StarterBag STARTER_BAG;

   public static final ItemHostile<WulfrumSlime> WULFRUM_SLIME;
   public static final ItemHostile<WulfrumDrone> WULFRUM_DRONE;

   static {
      WULFRUM_SHARD = new ItemSimpleMaterial("wulfrum_shard", IRareItem.ItemRarity.BLUE).setMaxStackSize(999).inTab(CreativeTabsC.TI_ITEMS_MATERIALS);
      BLOOD_ORB = new ItemSimpleMaterial("blood_orb", IRareItem.ItemRarity.BLUE).setMaxStackSize(999).inTab(CreativeTabsC.TI_ITEMS_MATERIALS);
      ARTIC_ARROW = (ArticArrow)(new ArticArrow()).inTab(CreativeTabsC.TI_ITEMS_AMMO);
      BLOODFIRE_ARROW = (BloodfireArrow)(new BloodfireArrow()).inTab(CreativeTabsC.TI_ITEMS_AMMO);
      BLOOD_ORANGE = (BloodOrange)(new BloodOrange()).inTab(CreativeTabsC.TI_ITEMS_CC);
      MIRACLE_FRUIT = (MiracleFruit)(new MiracleFruit()).inTab(CreativeTabsC.TI_ITEMS_CC);
      DRAGONFRUIT = (Dragonfruit) (new Dragonfruit()).inTab(CreativeTabsC.TI_ITEMS_CC);
      ELDERBERRY = (Elderberry) (new Elderberry()).inTab(CreativeTabsC.TI_ITEMS_CC);
      STARTER_BAG = new StarterBag();
      WULFRUM_SLIME = new ItemHostile(WulfrumSlime.class, "slimes/wulfrum");
      WULFRUM_DRONE = new ItemHostile(WulfrumDrone.class, "wulfrum_drone");
   }
}
