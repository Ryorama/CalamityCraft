package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CCWeapons {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(CalamityCraft.MODID);

    public static final DeferredItem<Item> WULFRUM_SWORD = registerSword("wulfrum", Tiers.STONE, 5, -3);

    public static DeferredItem<Item> registerSword(String name, Tier tier, float attackDamage, float attackSpeed) {
        return REGISTRY.register("weapons/melee/swords/" + name, () -> new SwordItem(tier, new Item.Properties().attributes(SwordItem.createAttributes(tier, attackDamage, attackSpeed))));
    }
}
