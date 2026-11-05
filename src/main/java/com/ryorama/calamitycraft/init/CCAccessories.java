package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.item.WulfrumBattery;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.terra_curio.common.item.curio.BaseCurioItem;

import java.util.function.Supplier;

public class CCAccessories {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(CalamityCraft.MODID);

    public static final DeferredItem<Item> WULFRUM_BATTERY = registerAccessory("wulfrum_battery", () -> new WulfrumBattery(BaseCurioItem.builder("wulfrum_battery")));

    public static DeferredItem<Item> registerAccessory(String name, Supplier<Item> supplier) {
        return REGISTRY.register("accessories/" + name, supplier);
    }
}
