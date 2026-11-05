package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.world.biomes.SulphurousSeaBiome;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

public class CCBiomes {
    public static final ResourceKey<Biome> SULPHUROUS_SEA = registerBiome("sulphurous_sea");
    public static final ResourceKey<Biome> SUNKEN_SEA = registerBiome("sunken_sea");
    public static final ResourceKey<Biome> ABYSS = registerBiome("abyss");
    public static final ResourceKey<Biome> BRIMSTONE_CRAG = registerBiome("brimstone_crag");

    private static ResourceKey<Biome> registerBiome(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.parse(name));
    }

    public static void registerRegionAndSurface() {
        //Regions.register(new SulphurousSeaBiome(ResourceLocation.fromNamespaceAndPath(CalamityCraft.MODID, "sulphurous_sea"), 1));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, CalamityCraft.MODID, CCSurfaceRules.makeCCOverWorldRules());
    }
}
