package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.component.CCRarity;
import com.ryorama.calamitycraft.datacomponents.BlightedGelVariantComponent;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.lib.common.component.ModRarity;
import org.confluence.lib.common.item.CustomRarityItem;

import java.util.function.Supplier;

public class CCMaterials {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(CalamityCraft.MODID);

    public static final DeferredItem<Item> ANCIENT_BONE_DUST = registerMaterial("ancient_bone_dust", () -> new CustomRarityItem(ModRarity.BLUE));
    public static final DeferredItem<Item> ARMORED_SHELL = registerMaterial("armored_shell", () -> new CustomRarityItem(new Item.Properties(), CCRarity.TURQUOISE));
    public static final DeferredItem<Item> BLIGHTED_GEL = registerMaterial("blighted_gel", () -> new CustomRarityItem(new Item.Properties().component(CCDataComponents.BLIGHTED_GEL_VARIANT.value(), new BlightedGelVariantComponent.BlightedGelVariant(1)), ModRarity.BLUE));
    public static final DeferredItem<Item> BLOOD_ORB = registerMaterial("blood_orb", () -> new CustomRarityItem(new Item.Properties(), ModRarity.GREEN));
    public static final DeferredItem<Item> BLOODSTONE = registerMaterial("bloodstone", () -> new CustomRarityItem(new Item.Properties(), CCRarity.TURQUOISE));
    public static final DeferredItem<Item> BLOODSTONE_CORE = registerMaterial("bloodstone_core", () -> new CustomRarityItem(new Item.Properties(), CCRarity.TURQUOISE));
    public static final DeferredItem<Item> CORRODED_FOSSIL = registerMaterial("corroded_fossil", () -> new CustomRarityItem(new Item.Properties(), ModRarity.PINK));
    public static final DeferredItem<Item> DEPTH_CELLS = registerMaterial("depth_cells", () -> new CustomRarityItem(new Item.Properties(), ModRarity.LIME));
    public static final DeferredItem<Item> DIVINE_GEODE = registerMaterial("divine_geode", () -> new CustomRarityItem(new Item.Properties(), CCRarity.TURQUOISE));
    public static final DeferredItem<Item> DUBIOUS_PLATING = registerMaterial("dubious_plating", () -> new CustomRarityItem(new Item.Properties(), CCRarity.DARK_ORANGE));
    public static final DeferredItem<Item> ESSENCE_OF_ELEUM = registerMaterial("essence_of_eleum", () -> new CustomRarityItem(new Item.Properties(), ModRarity.LIGHT_RED));
    public static final DeferredItem<Item> ESSENCE_OF_HAVOC = registerMaterial("essence_of_havoc", () -> new CustomRarityItem(new Item.Properties(), ModRarity.LIGHT_RED));
    public static final DeferredItem<Item> ESSENCE_OF_SUNLIGHT = registerMaterial("essence_of_sunlight", () -> new CustomRarityItem(new Item.Properties(), ModRarity.LIGHT_RED));
    public static final DeferredItem<Item> GRAND_SCALE = registerMaterial("grand_scale", () -> new CustomRarityItem(new Item.Properties(), ModRarity.LIME));
    public static final DeferredItem<Item> INFECTED_ARMOR_PLATING = registerMaterial("infected_armor_plating", () -> new CustomRarityItem(new Item.Properties(), ModRarity.YELLOW));
    public static final DeferredItem<Item> LIFE_ALLOY = registerMaterial("life_alloy", () -> new CustomRarityItem(new Item.Properties(), ModRarity.YELLOW));
    public static final DeferredItem<Item> LIVING_SHARD = registerMaterial("living_shard", () -> new CustomRarityItem(new Item.Properties(), ModRarity.LIME));
    public static final DeferredItem<Item> LUMENYL = registerMaterial("lumenyl", () -> new CustomRarityItem(new Item.Properties(), ModRarity.LIME));
    public static final DeferredItem<Item> MELD_BLOB = registerMaterial("meld_blob", () -> new CustomRarityItem(new Item.Properties(), ModRarity.RED));
    public static final DeferredItem<Item> MIRACLE_MATTER = registerMaterial("miracle_matter", () -> new CustomRarityItem(new Item.Properties(), CCRarity.BURNISHED_AURIC));
    public static final DeferredItem<Item> MOLLUSK_HUSK = registerMaterial("mollusk_husk", () -> new CustomRarityItem(new Item.Properties(), ModRarity.PINK));
    public static final DeferredItem<Item> MYSTERIOUS_CIRCUITRY = registerMaterial("mysterious_circuitry", () -> new CustomRarityItem(new Item.Properties(), CCRarity.DARK_ORANGE));
    public static final DeferredItem<Item> PEARL_SHARD = registerMaterial("pearl_shard", () -> new CustomRarityItem(new Item.Properties(), ModRarity.GREEN));
    public static final DeferredItem<Item> PLAGUE_CELL_CANISTER = registerMaterial("plague_cell_canister", () -> new CustomRarityItem(new Item.Properties(), ModRarity.YELLOW));
    public static final DeferredItem<Item> PLASMA_DRIVE_CORE = registerMaterial("plasma_drive_core", () -> new CustomRarityItem(new Item.Properties(), CCRarity.DARK_ORANGE));
    public static final DeferredItem<Item> PURIFIED_GEL = registerMaterial("purified_gel", () -> new CustomRarityItem(new Item.Properties(), ModRarity.LIGHT_RED));
    public static final DeferredItem<Item> REAPER_TOOTH = registerMaterial("reaper_tooth", () -> new CustomRarityItem(new Item.Properties(), CCRarity.PURE_GREEN));
    public static final DeferredItem<Item> SEA_REMAINS = registerMaterial("sea_remains", () -> new CustomRarityItem(new Item.Properties(), ModRarity.GREEN));
    public static final DeferredItem<Item> SOLAR_VEIL = registerMaterial("solar_veil", () -> new CustomRarityItem(new Item.Properties(), ModRarity.LIME));
    public static final DeferredItem<Item> STARBLIGHT_SOOT = registerMaterial("starblight_soot", () -> new CustomRarityItem(new Item.Properties(), ModRarity.LIGHT_RED));
    public static final DeferredItem<Item> STORMLION_MANDIBLE = registerMaterial("stormlion_mandible", () -> new CustomRarityItem(new Item.Properties(), ModRarity.BLUE));
    public static final DeferredItem<Item> SULPHURIC_SCALE = registerMaterial("sulphuric_scale", () -> new CustomRarityItem(new Item.Properties(), ModRarity.GREEN));
    public static final DeferredItem<Item> TWISTING_NETHER = registerMaterial("twisting_nether", () -> new CustomRarityItem(new Item.Properties(), CCRarity.TURQUOISE));
    public static final DeferredItem<Item> UNHOLY_CORE = registerMaterial("unholy_core", () -> new CustomRarityItem(new Item.Properties(), ModRarity.PINK));
    public static final DeferredItem<Item> WULFRUM_METAL_SCRAP = registerMaterial("wulfrum_metal_scrap", () -> new CustomRarityItem(new Item.Properties(), ModRarity.BLUE));
    public static final DeferredItem<Item> WULFRUM_INGOT = registerMaterial("wulfrum_ingot", () -> new CustomRarityItem(new Item.Properties(), ModRarity.BLUE));
    public static final DeferredItem<Item> YHARON_SOUL_FRAGMENT = registerMaterial("yharon_soul_fragment", () -> new CustomRarityItem(new Item.Properties(), CCRarity.BURNISHED_AURIC));

    public static DeferredItem<Item> registerMaterial(String name, Supplier<Item> supplier) {
        return REGISTRY.register("materials/" + name, supplier);
    }
}
