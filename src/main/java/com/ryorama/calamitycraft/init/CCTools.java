package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CCTools {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(CalamityCraft.MODID);

    public static final DeferredItem<Item> WULFRUM_PICKAXE = registerPickaxe("wulfrum", Tiers.STONE, 5, -2.8F);
    public static final DeferredItem<Item> WULFRUM_AXE = registerAxe("wulfrum", Tiers.STONE, 6, -2.8F);
    public static final DeferredItem<Item> WULFRUM_SHOVEL = registerShovel("wulfrum", Tiers.STONE, 3, -2.8F);
    public static final DeferredItem<Item> WULFRUM_HOE = registerHoe("wulfrum", Tiers.STONE, 2, -2.8F);


    public static DeferredItem<Item> registerPickaxe(String name, Tier tier, float attackDamage, float attackSpeed) {
        return REGISTRY.register("tools/pickaxes/" + name, () -> new PickaxeItem(tier, new Item.Properties().attributes(PickaxeItem.createAttributes(tier, attackDamage, attackSpeed))));
    }

    public static DeferredItem<Item> registerAxe(String name, Tier tier, float attackDamage, float attackSpeed) {
        return REGISTRY.register("tools/axes/" + name, () -> new AxeItem(tier, new Item.Properties().attributes(AxeItem.createAttributes(tier, attackDamage, attackSpeed))));
    }

    public static DeferredItem<Item> registerShovel(String name, Tier tier, float attackDamage, float attackSpeed) {
        return REGISTRY.register("tools/shovels/" + name, () -> new ShovelItem(tier, new Item.Properties().attributes(ShovelItem.createAttributes(tier, attackDamage, attackSpeed))));
    }

    public static DeferredItem<Item> registerHoe(String name, Tier tier, float attackDamage, float attackSpeed) {
        return REGISTRY.register("tools/hoes/" + name, () -> new HoeItem(tier, new Item.Properties().attributes(HoeItem.createAttributes(tier, attackDamage, attackSpeed))));
    }
}