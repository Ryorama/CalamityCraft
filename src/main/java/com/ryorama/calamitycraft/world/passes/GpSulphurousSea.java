package com.ryorama.calamitycraft.world.passes;

import com.ryorama.calamitycraft.init.BlocksCC;
import net.minecraft.util.math.BlockPos;
import org.zeith.terraria.api.world.EnumLayer;
import org.zeith.terraria.init.BlocksTC;
import org.zeith.terraria.utils.ImprovedRandom;
import org.zeith.terraria.world.api.passes.CubeGenPass;
import org.zeith.terraria.world.api.passes.GenPass;
import org.zeith.terraria.world.api.passes.PassData;

@GenPass(name = "sulphurous_sea", priority = 99)
public class GpSulphurousSea extends CubeGenPass {

    @Override
    public void populate(PassData data) {
        ImprovedRandom oceanRng = new ImprovedRandom(data.getWorldSubSeed(this));
        double yaw = oceanRng.nextDouble(Math.PI * 2);
        double dist = oceanRng.nextDouble(data.worldSizeD + 16, data.worldSizeD + 32);
        int xCenter = (int) (Math.sin(yaw) * dist);
        int zCenter = (int) (Math.cos(yaw) * dist);
        double oceanRadius = oceanRng.nextDouble(64, 128);

        for (int x = 0; x <= -oceanRadius; x++) {
            for (int z = 0; z <= -oceanRadius; z++) {
                for (int y = 0; y <= data.undergroundStart + 1; y++) {
                    int newX = (int) (oceanRadius - x);
                    int newZ = (int) (oceanRadius - z);
                    BlockPos pos = new BlockPos(newX, y, newZ);

                    if (data.isBeachOrOceanAt(pos)) {
                        if (data.getLayer(pos) == EnumLayer.SURFACE) {
                            if (data.world.getBlockState(pos) == BlocksTC.SAND.getDefaultState()) {
                                data.world.setBlockState(pos, BlocksCC.SULPHUROUS_SAND.getDefaultState());
                            }
                            if (data.world.getBlockState(pos) == BlocksTC.SANDSTONE.getDefaultState()) {
                                data.world.setBlockState(pos, BlocksCC.SULPHUROUS_SANDSTONE.getDefaultState());
                            }
                        }
                    }
                }
            }
        }
    }
}
