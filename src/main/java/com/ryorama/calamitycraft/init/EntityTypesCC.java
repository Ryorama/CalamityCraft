package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.zeith.terraria.api.entity.reg.EntityType;

import java.util.function.Function;

@SimplyRegister
public interface EntityTypesCC
{
	static <T extends Entity> EntityType<T> $(Class<T> cls, Function<World, T> factory)
	{
		return new EntityType<>(CalamityCraft.getEntityCounter(), cls, factory);
	}
}