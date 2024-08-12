package com.ryorama.calamitycraft.common.data;

import com.ryorama.calamitycraft.init.biomes.BiomesCC;
import com.ryorama.calamitycraft.init.BuffsCC;
import com.ryorama.calamitycraft.init.DataProvidersCC;
import com.zeitheron.hammercore.api.io.NBTSerializable;
import lombok.val;
import net.minecraft.util.ITickable;
import org.zeith.terraria.api.DamageSourcesTC;
import org.zeith.terraria.api.data.player.BasePlayerDataTC;
import org.zeith.terraria.api.data.player.PlayerDataProvider;
import org.zeith.terraria.common.data.player.PlayerDataTC;

public class PlayerCalamityData
		extends BasePlayerDataTC<PlayerCalamityData>
		implements ITickable
{
	@NBTSerializable
	public float sulphuricPoisoning;
	
	public static PlayerCalamityData get(PlayerDataTC data)
	{
		return data.getData(DataProvidersCC.PLAYER_CALAMITY);
	}
	
	public PlayerCalamityData(PlayerDataProvider<PlayerCalamityData> holder, PlayerDataTC data)
	{
		super(holder, data);
	}
	
	@Override
	public void update()
	{
		// Early return on client so we don't process unnecessary things on it. Stuff just gets synched instead.
		if(data.isClientSide()) return;
		
		if(data.inBiome(BiomesCC.SULPHUROUS_SEA) && data.inWater())
		{
			boolean wasClean = sulphuricPoisoning < 0.01F;
			
			if (data.activeBuffs().isBuffActive(BuffsCC.SULPHURSKIN)) {
				sulphuricPoisoning += 0.02F;
			} else {
				sulphuricPoisoning += 0.05F;
			}
			// Sync to client once a second.
			if(data.ticksExisted % 5 == 0 || wasClean) markDirty();
		}
		
		if(data.ticksExisted % 4 == 0 && !data.inWater())
		{
			boolean wasDirty = sulphuricPoisoning > 0F;
			sulphuricPoisoning = Math.max(sulphuricPoisoning - 0.2F, 0F);
			if(data.ticksExisted % 8 == 0 || (sulphuricPoisoning <= 0F && wasDirty)) markDirty();
		}
		
		if(sulphuricPoisoning >= 12)
		{
			val health = data.health();
			if (health.maxHP * 0.25 < 150) {
				health.damage(health.maxHP * 0.25F, DamageSourcesTC.GENERIC, true, false);
			} else {
				health.damage(150, DamageSourcesTC.GENERIC, true, false);
			}
			sulphuricPoisoning = 0;
			markDirty();
		}
	}
}