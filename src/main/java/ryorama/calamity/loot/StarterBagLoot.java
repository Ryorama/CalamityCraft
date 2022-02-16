package ryorama.calamity.loot;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.zeith.terraria.api.blocks.AlternativeOre;
import org.zeith.terraria.common.content.items.grab_bags.ItemTreasureBag;
import org.zeith.terraria.common.loot.TerraLootContext;
import org.zeith.terraria.init.BlocksTC;
import org.zeith.terraria.init.items.ItemsTC;

import java.util.Random;

public class StarterBagLoot implements ItemTreasureBag.ITreasureBagLoot {
    @Override
    public void generateDrops(TerraLootContext terraLootContext, ItemStack itemStack, NonNullList<ItemStack> drops, Random random) {
        terraLootContext.getWorldData().map(wd -> wd.worldMP).ifPresent(world ->
        {
            Block copperTin = AlternativeOre.COPPER_TIN.forWorld(world.getSeed());
            if (copperTin == BlocksTC.COPPER_ORE) {
                drops.add(ItemsTC.COPPER_SWORD.stack());
                drops.add(ItemsTC.COPPER_BOW.stack());
                drops.add(ItemsTC.COPPER_HAMMER.stack());
            } else if (copperTin == BlocksTC.TIN_ORE) {
                drops.add(ItemsTC.TIN_SWORD.stack());
                drops.add(ItemsTC.TIN_BOW.stack());
                drops.add(ItemsTC.TIN_HAMMER.stack());
            }
        });
        drops.add(ItemsTC.WOODEN_ARROW.stack(100));
        drops.add(ItemsTC.MANA_CRYSTAL.stack());
        drops.add(ItemsTC.MINING_POTION.stack());
        drops.add(ItemsTC.SPELUNKER_POTION.stack(2));
        drops.add(ItemsTC.SWIFTNESS_POTION.stack(3));
        drops.add(ItemsTC.GILLS_POTION.stack(2));
        drops.add(ItemsTC.SHINE_POTION.stack());
        drops.add(ItemsTC.RECALL_POTION.stack(3));
        drops.add(BlocksTC.CHEST.stack(3));
        drops.add(BlocksTC.TORCH.stack(25));
        drops.add(ItemsTC.BOMB.stack(10));
    }

    @Override
    public boolean isHardmode(ItemStack itemStack) {
        return false;
    }
}