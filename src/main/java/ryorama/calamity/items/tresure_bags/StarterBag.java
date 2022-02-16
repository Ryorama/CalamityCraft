package ryorama.calamity.items.tresure_bags;

import org.zeith.terraria.common.content.items.grab_bags.ItemTreasureBag;
import ryorama.calamity.CreativeTabsC;
import ryorama.calamity.loot.StarterBagLoot;

public class StarterBag extends ItemTreasureBag {
    public StarterBag() {
        super("starter_bag", new StarterBagLoot());
        this.rarity = ItemRarity.BLUE;
        this.inTab(CreativeTabsC.TI_ITEMS_CC);
    }
}
