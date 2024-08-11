package com.ryorama.calamitycraft.common.data;

import com.ryorama.calamitycraft.init.DataProvidersCC;
import com.zeitheron.hammercore.api.io.NBTSerializable;
import net.minecraft.util.ITickable;
import org.zeith.terraria.api.data.world.BaseWorldDataTC;
import org.zeith.terraria.api.data.world.WorldDataProvider;
import org.zeith.terraria.common.data.world.world.WorldDataTC;

public class WorldCalamityData extends BaseWorldDataTC<WorldCalamityData> implements ITickable {

    @NBTSerializable
    public boolean isRevengeance;
    @NBTSerializable
    public boolean isDeath;

    public WorldCalamityData(WorldDataProvider<WorldCalamityData> holder, WorldDataTC data) {
        super(holder, data);
    }

    public static WorldCalamityData get(WorldDataTC data) {
        return data.getData(DataProvidersCC.WORLD_CALAMITY);
    }

    @Override
    public void update() {}
}
