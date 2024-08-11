package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.common.data.PlayerCalamityData;
import com.ryorama.calamitycraft.common.data.WorldCalamityData;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.data.player.PlayerDataProvider;
import org.zeith.terraria.api.data.world.WorldDataProvider;

@SimplyRegister
public interface DataProvidersCC
{
	@RegistryName("calamity_player")
	PlayerDataProvider<PlayerCalamityData> PLAYER_CALAMITY = PlayerDataProvider.of(PlayerCalamityData::new);

	@RegistryName("calamity_world")
	WorldDataProvider<WorldCalamityData> WORLD_CALAMITY = WorldDataProvider.of(WorldCalamityData::new);
}