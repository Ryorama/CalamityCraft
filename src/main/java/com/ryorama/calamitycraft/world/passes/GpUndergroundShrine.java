package com.ryorama.calamitycraft.world.passes;

import com.ryorama.calamitycraft.world.struct.StUndergroundShrine;
import net.minecraft.util.math.BlockPos;
import org.zeith.terraria.init.biomes.BiomeTypesTC;
import org.zeith.terraria.world.api.passes.CubeGenPass;
import org.zeith.terraria.world.api.passes.GenPass;
import org.zeith.terraria.world.api.passes.PassData;

@GenPass(name = "underground_shrine", priority = 99)
public class GpUndergroundShrine extends CubeGenPass {
    @Override
    public void populate(PassData data) {
        if (data.rand.nextInt(75) == 0) {
            BlockPos pos = data.randomPopulationPos();
            if (data.isBeachOrOceanAt(pos)) {
                return;
            }
            pos = pos.add(0, data.getSurfaceY(pos.getX(), pos.getZ(), true) - pos.getY(), 0);
            if (data.pos.containsBlock(pos) && data.getBiomeType(pos) == BiomeTypesTC.FOREST) {
                StUndergroundShrine.INSTANCE.setContext(data.world, pos.down(20 + data.rand.nextInt(30)), data.rand.nextInt(3) == 0).generate();
            }
        }
    }
}
