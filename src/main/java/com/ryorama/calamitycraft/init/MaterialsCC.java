package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.common.ItemRarityCC;
import com.ryorama.calamitycraft.common.events.ItemTabEvents;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.common.content.items.ItemAbstractSoul;
import org.zeith.terraria.common.content.items.ItemSimpleMaterial;

@SimplyRegister(prefix = "materials/")
public class MaterialsCC {
    @RegistryName("wulfrum_metal_scrap")
    public static final ItemSimpleMaterial WULFRUM_METAL_SCRAP = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
    @RegistryName("energy_core")
    public static final ItemSimpleMaterial ENERGY_CORE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
    @RegistryName("ancient_bone_dust")
    public static final ItemSimpleMaterial ANCIENT_BONE_DUST = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
    @RegistryName("blood_orb")
    public static final ItemSimpleMaterial BLOOD_ORB = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
    @RegistryName("blood_sample")
    public static final ItemSimpleMaterial BLOOD_SAMPLE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.ORANGE);
    @RegistryName("demonic_bone_ash")
    public static final ItemSimpleMaterial DEMONIC_BONE_ASH = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.ORANGE);
    @RegistryName("dubious_plating")
    public static final ItemSimpleMaterial DUBIOUS_PLATING = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.DARK_ORANGE);
    @RegistryName("murky_paste")
    public static final ItemSimpleMaterial MURKY_PASTE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
    @RegistryName("mysterious_circuitry")
    public static final ItemSimpleMaterial MYSTERIOUS_CIRCUITRY = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.DARK_ORANGE);
    @RegistryName("pearl_shard")
    public static final ItemSimpleMaterial PEARL_SHARD = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.GREEN);
    @RegistryName("purified_gel")
    public static final ItemSimpleMaterial PURIFIED_GEL = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIGHT_RED);
    @RegistryName("rotten_matter")
    public static final ItemSimpleMaterial ROTTEN_MATTER = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.ORANGE);
    @RegistryName("stormlion_mandible")
    public static final ItemSimpleMaterial STORMLION_MANDIBLE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
    @RegistryName("sulphuric_scale")
    public static final ItemSimpleMaterial SULPHURIC_SCALE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.GREEN);

    @RegistryName("plasma_drive_core")
    public static final ItemSimpleMaterial PLASMA_DRIVE_CORE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.DARK_ORANGE);
    @RegistryName("blighted_gel")
    public static final ItemSimpleMaterial BLIGHTED_GEL = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
    @RegistryName("blighted_gel_red")
    public static final ItemSimpleMaterial BLIGHTED_GEL_RED = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
    @RegistryName("armored_shell")
    public static final ItemSimpleMaterial ARMORED_SHELL = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.TURQUOISE);

    @RegistryName("bloodstone")
    public static final ItemSimpleMaterial BLOODSTONE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.TURQUOISE);
    @RegistryName("bloodstone_core")
    public static final ItemSimpleMaterial BLOODSTONE_CORE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.TURQUOISE);
    @RegistryName("corroded_fossil")
    public static final ItemSimpleMaterial CORRODED_FOSSIL = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.PINK);
    @RegistryName("depth_cells")
    public static final ItemSimpleMaterial DEPTH_CELLS = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIME);
    @RegistryName("divine_geode")
    public static final ItemSimpleMaterial DIVINE_GEODE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.TURQUOISE);
    @RegistryName("essence_of_eleum")
    public static final ItemAbstractSoul ESSENCE_OF_ELEUM = (ItemAbstractSoul) new ItemAbstractSoul().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIGHT_RED);
    @RegistryName("essence_of_havoc")
    public static final ItemAbstractSoul ESSENCE_OF_HAVOC = (ItemAbstractSoul) new ItemAbstractSoul().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIGHT_RED);
    @RegistryName("essence_of_sunlight")
    public static final ItemAbstractSoul ESSENCE_OF_SUNLIGHT = (ItemAbstractSoul) new ItemAbstractSoul().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIGHT_RED);
    @RegistryName("exo_prism")
    public static final ItemSimpleMaterial EXO_PRISM = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.VIOLET);
    @RegistryName("grand_scale")
    public static final ItemSimpleMaterial GRAND_SCALE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIME);
    @RegistryName("infected_armor_plating")
    public static final ItemSimpleMaterial INFECTED_ARMOR_PLATING = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.YELLOW);
    @RegistryName("life_alloy")
    public static final ItemSimpleMaterial LIFE_ALLOY = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.YELLOW);
    @RegistryName("living_shard")
    public static final ItemSimpleMaterial LIVING_SHARD = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIME);
    @RegistryName("lumenyl")
    public static final ItemSimpleMaterial LUMENYL = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIME);
    @RegistryName("meld_blob")
    public static final ItemSimpleMaterial MELD_BLOB = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.RED);
    @RegistryName("meld_construct")
    public static final ItemSimpleMaterial MELD_CONSTRUCT = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.RED);

    @RegistryName("miracle_matter")
    public static final ItemSimpleMaterial MIRACLE_MATTER = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.VIOLET);
    @RegistryName("mollusk_husk")
    public static final ItemSimpleMaterial MOLLUSK_HUSK = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.PINK);
    @RegistryName("plague_cell_canister")
    public static final ItemSimpleMaterial PLAGUE_CELL_CANISTER = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.YELLOW);
    @RegistryName("reaper_tooth")
    public static final ItemSimpleMaterial REAPER_TOOTH = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.PURE_GREEN);
    @RegistryName("sea_remains")
    public static final ItemSimpleMaterial SEA_REMAINS = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.GREEN);
    @RegistryName("starblight_soot")
    public static final ItemSimpleMaterial STARBLIGHT_SOOT = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIGHT_RED);
    @RegistryName("trapper_bulb")
    public static final ItemSimpleMaterial TRAPPER_BULB = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIGHT_RED);
    @RegistryName("twisting_nether")
    public static final ItemSimpleMaterial TWISTING_NETHER = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
    @RegistryName("unholy_core")
    public static final ItemSimpleMaterial UNHOLY_CORE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.TURQUOISE);
    @RegistryName("yharon_soul_fragment")
    public static final ItemSimpleMaterial YHARON_SOUL_FRAGMENT = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.VIOLET);
}