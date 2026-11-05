package com.ryorama.calamitycraft.world.biomes;


import com.mojang.datafixers.util.Pair;
import com.ryorama.calamitycraft.init.CCBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class SulphurousSeaBiome extends Region {
    public SulphurousSeaBiome(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.NEUTRAL, ParameterUtils.Temperature.NEUTRAL))
                .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.NEUTRAL))
                .continentalness(ParameterUtils.Continentalness.COAST)
                .erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_3)
                .depth(ParameterUtils.Depth.SURFACE, ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.FULL_RANGE, ParameterUtils.Weirdness.LOW_SLICE_VARIANT_ASCENDING)
                .build().forEach(point -> builder.add(point, CCBiomes.SULPHUROUS_SEA));
        builder.build().forEach(mapper);
    }
}