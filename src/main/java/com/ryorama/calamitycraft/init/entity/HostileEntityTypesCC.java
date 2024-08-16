package com.ryorama.calamitycraft.init.entity;

import com.ryorama.calamitycraft.common.content.entity.hostile.wulfrum.WulfrumGyratorEntity;
import com.ryorama.calamitycraft.common.content.entity.hostile.wulfrum.WulfrumRoverEntity;
import com.ryorama.calamitycraft.init.EntityTypesCC;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.entity.reg.EntityType;
import org.zeith.terraria.api.world.EnumLayer;
import org.zeith.terraria.client.render.EntityRendersTC;
import org.zeith.terraria.common.MobSpawnConditions;
import org.zeith.terraria.common.content.biome.impl.LayeredBiomeEntity;
import org.zeith.terraria.init.biomes.BiomesTC;

@SimplyRegister(prefix = "hostile/")
public interface HostileEntityTypesCC {
	@RegistryName("wulfrum_rover")
	EntityType<WulfrumRoverEntity> WULFRUM_ROVER = EntityTypesCC.$(WulfrumRoverEntity.class, WulfrumRoverEntity::new)
			.sizePx(22F, 18F)
			.withSpawn((f) -> new LayeredBiomeEntity<>(EnumLayer.SURFACE, 0.5F, MobSpawnConditions.SPAWN_ON_SURFACE, f).setBiome(BiomesTC.FOREST))
			.withRenderer(EntityRendersTC.bedrock(HostileGeomCC.WULFRUM_ROVER, 0.15F));

	@RegistryName("wulfrum_gyrator")
	EntityType<WulfrumGyratorEntity> WULFRUM_GYRATOR = EntityTypesCC.$(WulfrumGyratorEntity.class, WulfrumGyratorEntity::new)
			.sizePx(22F, 18F)
			.withSpawn((f) -> new LayeredBiomeEntity<>(EnumLayer.SURFACE, 0.5F, MobSpawnConditions.SPAWN_ON_SURFACE, f).setBiome(BiomesTC.FOREST))
			.withRenderer(EntityRendersTC.bedrock(HostileGeomCC.WULFRUM_GYRATOR, 0.15F));
}
