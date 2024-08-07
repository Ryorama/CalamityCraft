package com.ryorama.calamitycraft.common;

import net.minecraft.nbt.NBTTagCompound;
import org.zeith.terraria.common.data.player.PlayerDataTC;

public class PlayerDataCC extends PlayerDataTC {
    public static float sulphuricPoisoning;

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setFloat("sulphuricPoisoning", sulphuricPoisoning);

        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        sulphuricPoisoning = nbt.getFloat("sulphuricPoisoning");
    }
}