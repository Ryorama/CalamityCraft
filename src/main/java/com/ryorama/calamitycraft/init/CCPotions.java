package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.component.CCRarity;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.common.item.potion.HealingPotionItem;

import java.util.function.Supplier;

public class CCPotions {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(CalamityCraft.MODID);

    public static final DeferredItem<Item> SUPREME_HEALING_POTION = registerPotion("supreme_healing", () -> new HealingPotionItem(80, CCRarity.TURQUOISE, 1200));
    public static final DeferredItem<Item> OMEGA_HEALING_POTION = registerPotion("omega_healing", () -> new HealingPotionItem(100, CCRarity.COSMIC_PURPLE, 1200));

    public static DeferredItem<Item> registerPotion(String name, Supplier<Item> supplier) {
        return REGISTRY.register("potions/" + name, supplier);
    }
}
