package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.world.biomes.BiomeSulphurousSea;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;

@SimplyRegister
public interface BiomesCC
{
	@RegistryName("sulphurous_sea")
	BiomeSulphurousSea SULPHUROUS_SEA = new BiomeSulphurousSea();
}