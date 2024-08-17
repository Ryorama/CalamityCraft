package com.ryorama.calamitycraft.common.data;

import com.ryorama.calamitycraft.init.DataProvidersCC;
import com.ryorama.calamitycraft.init.InvasionsCC;
import com.zeitheron.hammercore.api.io.NBTSerializable;
import net.minecraft.util.ITickable;
import org.zeith.terraria.api.data.world.BaseWorldDataTC;
import org.zeith.terraria.api.data.world.WorldDataProvider;
import org.zeith.terraria.common.data.world.world.WorldDataTC;
import org.zeith.terraria.common.data.world.world.impl.WorldInvasionData;

public class WorldCalamityData extends BaseWorldDataTC<WorldCalamityData> implements ITickable {

    @NBTSerializable
    public boolean isRevengeance;
    @NBTSerializable
    public boolean isDeath;
	
	@NBTSerializable
	public int lastAcidRainPoints = -1;
	
	@NBTSerializable
	public long lastAcidRainProgressTime;

	@NBTSerializable
	public boolean generatedAbyss;

    public WorldCalamityData(WorldDataProvider<WorldCalamityData> holder, WorldDataTC data) {
        super(holder, data);
    }

    public static WorldCalamityData get(WorldDataTC data) {
        return data.getData(DataProvidersCC.WORLD_CALAMITY);
    }

    @Override
    public void update() {
		WorldInvasionData invasions = data.invasions();
		
		if(invasions.isActive(InvasionsCC.ACID_RAIN))
		{
			int points = invasions.getActiveInvasionPoints();
			if(points > lastAcidRainPoints)
			{
				lastAcidRainPoints = points;
				lastAcidRainProgressTime = data.totalGameTime;
			}
			
			// Stop after 4 minutes
			if(data.totalGameTime - lastAcidRainProgressTime > 4 * 60 * 20)
			{
				lastAcidRainProgressTime = data.totalGameTime;
				lastAcidRainPoints = -1;
				invasions.stopInvasion(InvasionsCC.ACID_RAIN, false);
			}
		} else
		{
			lastAcidRainPoints = -1;
			
			// This is how you'd start an acid rain:
			// invasions.enqueueInvasion(InvasionsCC.ACID_RAIN, 0, null);
		}
	}
}
