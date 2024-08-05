package com.ryorama.calamitycraft.common.content.items.loot_bags;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.zeith.terraria.common.content.items.grab_bags.ITreasureBagLoot;
import org.zeith.terraria.common.loot.TerraLootContext;
import org.zeith.terraria.init.AmmoTypesTC;
import org.zeith.terraria.init.BlocksTC;
import org.zeith.terraria.init.ItemsTC;
import org.zeith.terraria.init.blocks.FurnitureTC;
import org.zeith.terraria.init.items.WeaponsTC;
import org.zeith.terraria.utils.ImprovedRandom;

public class StarterBagLoot implements ITreasureBagLoot {
    @Override
    public void generateDrops(TerraLootContext terraLootContext, ItemStack itemStack, NonNullList<ItemStack> drops, ImprovedRandom improvedRandom) {
        drops.add(WeaponsTC.COPPER_SWORD.stack());
        drops.add(WeaponsTC.COPPER_BOW.stack());
        drops.add(new ItemStack(ItemsTC.WOODEN_ARROW, 100));
        drops.add(WeaponsTC.AMBER_GEM_STAFF.stack());
        drops.add(ItemsTC.MANA_CRYSTAL.stack());
        drops.add(ItemsTC.COPPER_HAMMER.stack());
        drops.add(ItemsTC.MINING_POTION.stack());
        drops.add(new ItemStack(ItemsTC.SPELUNKER_POTION, 2));
        drops.add(new ItemStack(ItemsTC.SWIFTNESS_POTION, 3));
        drops.add(new ItemStack(ItemsTC.GILLS_POTION, 2));
        drops.add(ItemsTC.SHINE_POTION.stack());
        drops.add(new ItemStack(ItemsTC.RECALL_POTION, 3));
        drops.add(new ItemStack(FurnitureTC.WOOD_FURNITURE.chest().gameItem(), 3));
        drops.add(new ItemStack(BlocksTC.ROPE, 50));
        drops.add(new ItemStack(ItemsTC.BOMB, 10));


    }

    @Override
    public boolean isHardmode(ItemStack itemStack) {
        return false;
    }
}
