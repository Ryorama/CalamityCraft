package com.ryorama.calamitycraft.world.passes;

import com.ryorama.calamitycraft.common.data.WorldCalamityData;
import com.ryorama.calamitycraft.init.biomes.BiomeTypesCC;
import com.ryorama.calamitycraft.init.biomes.BiomesCC;
import com.ryorama.calamitycraft.utils.UtilsCC;
import lombok.Getter;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import org.zeith.terraria.common.data.world.world.WorldDataTC;
import org.zeith.terraria.world.api.passes.CubeGenPass;
import org.zeith.terraria.world.api.passes.GenPass;
import org.zeith.terraria.world.api.passes.PassData;

import java.util.List;

@GenPass(name = "abyss", priority = 99)
public class GpAbyss extends CubeGenPass {
    @Getter
    private static GpAbyss instance;

    public GpAbyss()
    {
        instance = this;
    }
    
    @Override
    public void populate(PassData data) {
        BlockPos pos = data.pos.getCenterBlockPos();
        if (!data.isBeachOrOceanAt(pos) && data.getActualBiomeType(pos) == BiomeTypesCC.SULPHUROUS_SEA) {
            if (!WorldCalamityData.get(WorldDataTC.get(data.world)).generatedAbyss) {
                if (pos.getY() > 20) {
                    List<BlockPos> blocksForRemoval = UtilsCC.getCylinderBlocks(pos.getX(), pos.getY(), pos.getZ(), pos.getX(), data.hellStart + 30, pos.getZ());
                    System.out.println(blocksForRemoval.size());

                    for (int i = 0; i < blocksForRemoval.size(); i++) {
                        BlockPos blockPos =  blocksForRemoval.get(i);
                        System.out.println("Current Pos: " + blockPos);
                        data.world.setBlockState(new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ()), Blocks.AIR.getDefaultState());
                    }
                    WorldCalamityData.get(WorldDataTC.get(data.world)).generatedAbyss = true;
                }
            }
        }
    }
}
