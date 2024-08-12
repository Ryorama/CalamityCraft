package com.ryorama.calamitycraft.init.items;

import com.ryorama.calamitycraft.common.ItemRarityCC;
import com.ryorama.calamitycraft.common.events.ItemTabEvents;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.items.ItemRarity;
import org.zeith.terraria.common.content.items.ItemAbstractSoul;
import org.zeith.terraria.common.content.items.ItemSimpleMaterial;

@SimplyRegister(prefix = "materials/")
public interface MaterialsCC
{
	@RegistryName("wulfrum_metal_scrap")
	ItemSimpleMaterial WULFRUM_METAL_SCRAP = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
	@RegistryName("energy_core")
	ItemSimpleMaterial ENERGY_CORE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
	@RegistryName("ancient_bone_dust")
	ItemSimpleMaterial ANCIENT_BONE_DUST = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
	@RegistryName("blood_orb")
	ItemSimpleMaterial BLOOD_ORB = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
	@RegistryName("blood_sample")
	ItemSimpleMaterial BLOOD_SAMPLE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.ORANGE);
	@RegistryName("demonic_bone_ash")
	ItemSimpleMaterial DEMONIC_BONE_ASH = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.ORANGE);
	@RegistryName("dubious_plating")
	ItemSimpleMaterial DUBIOUS_PLATING = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.DARK_ORANGE);
	@RegistryName("murky_paste")
	ItemSimpleMaterial MURKY_PASTE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
	@RegistryName("mysterious_circuitry")
	ItemSimpleMaterial MYSTERIOUS_CIRCUITRY = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.DARK_ORANGE);
	@RegistryName("pearl_shard")
	ItemSimpleMaterial PEARL_SHARD = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.GREEN);
	@RegistryName("purified_gel")
	ItemSimpleMaterial PURIFIED_GEL = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIGHT_RED);
	@RegistryName("rotten_matter")
	ItemSimpleMaterial ROTTEN_MATTER = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.ORANGE);
	@RegistryName("stormlion_mandible")
	ItemSimpleMaterial STORMLION_MANDIBLE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
	@RegistryName("sulphuric_scale")
	ItemSimpleMaterial SULPHURIC_SCALE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.GREEN);
	
	@RegistryName("plasma_drive_core")
	ItemSimpleMaterial PLASMA_DRIVE_CORE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.DARK_ORANGE);
	@RegistryName("blighted_gel")
	ItemSimpleMaterial BLIGHTED_GEL = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
	@RegistryName("blighted_gel_red")
	ItemSimpleMaterial BLIGHTED_GEL_RED = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
	@RegistryName("armored_shell")
	ItemSimpleMaterial ARMORED_SHELL = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.TURQUOISE);
	
	@RegistryName("bloodstone")
	ItemSimpleMaterial BLOODSTONE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.TURQUOISE);
	@RegistryName("bloodstone_core")
	ItemSimpleMaterial BLOODSTONE_CORE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.TURQUOISE);
	@RegistryName("corroded_fossil")
	ItemSimpleMaterial CORRODED_FOSSIL = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.PINK);
	@RegistryName("depth_cells")
	ItemSimpleMaterial DEPTH_CELLS = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIME);
	@RegistryName("divine_geode")
	ItemSimpleMaterial DIVINE_GEODE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.TURQUOISE);
	@RegistryName("essence_of_eleum")
	ItemAbstractSoul ESSENCE_OF_ELEUM = (ItemAbstractSoul) new ItemAbstractSoul().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIGHT_RED);
	@RegistryName("essence_of_havoc")
	ItemAbstractSoul ESSENCE_OF_HAVOC = (ItemAbstractSoul) new ItemAbstractSoul().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIGHT_RED);
	@RegistryName("essence_of_sunlight")
	ItemAbstractSoul ESSENCE_OF_SUNLIGHT = (ItemAbstractSoul) new ItemAbstractSoul().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIGHT_RED);
	@RegistryName("exo_prism")
	ItemSimpleMaterial EXO_PRISM = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.VIOLET);
	@RegistryName("grand_scale")
	ItemSimpleMaterial GRAND_SCALE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIME);
	@RegistryName("infected_armor_plating")
	ItemSimpleMaterial INFECTED_ARMOR_PLATING = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.YELLOW);
	@RegistryName("life_alloy")
	ItemSimpleMaterial LIFE_ALLOY = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.YELLOW);
	@RegistryName("living_shard")
	ItemSimpleMaterial LIVING_SHARD = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIME);
	@RegistryName("lumenyl")
	ItemSimpleMaterial LUMENYL = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIME);
	@RegistryName("meld_blob")
	ItemSimpleMaterial MELD_BLOB = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.RED);
	@RegistryName("meld_construct")
	ItemSimpleMaterial MELD_CONSTRUCT = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.RED);
	
	@RegistryName("miracle_matter")
	ItemSimpleMaterial MIRACLE_MATTER = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.VIOLET);
	@RegistryName("mollusk_husk")
	ItemSimpleMaterial MOLLUSK_HUSK = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.PINK);
	@RegistryName("plague_cell_canister")
	ItemSimpleMaterial PLAGUE_CELL_CANISTER = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.YELLOW);
	@RegistryName("reaper_tooth")
	ItemSimpleMaterial REAPER_TOOTH = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.PURE_GREEN);
	@RegistryName("sea_remains")
	ItemSimpleMaterial SEA_REMAINS = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.GREEN);
	@RegistryName("starblight_soot")
	ItemSimpleMaterial STARBLIGHT_SOOT = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIGHT_RED);
	@RegistryName("trapper_bulb")
	ItemSimpleMaterial TRAPPER_BULB = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.LIGHT_RED);
	@RegistryName("twisting_nether")
	ItemSimpleMaterial TWISTING_NETHER = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarity.BLUE);
	@RegistryName("unholy_core")
	ItemSimpleMaterial UNHOLY_CORE = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.TURQUOISE);
	@RegistryName("yharon_soul_fragment")
	ItemSimpleMaterial YHARON_SOUL_FRAGMENT = (ItemSimpleMaterial) new ItemSimpleMaterial().inTab(ItemTabEvents.TI_MATERIALS).withRarity(ItemRarityCC.VIOLET);
}