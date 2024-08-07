package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.common.data.PlayerCalamityData;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.data.player.PlayerDataProvider;

@SimplyRegister
public interface DataProvidersTC
{
	@RegistryName("calamity")
	PlayerDataProvider<PlayerCalamityData> PLAYER_CALAMITY = PlayerDataProvider.of(PlayerCalamityData::new);
}