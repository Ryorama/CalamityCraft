package com.ryorama.calamitycraft.world.struct;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.zeith.terraria.api.world.WorldBiomeType;
import org.zeith.terraria.common.content.blocks.grass.BlockTerrariaGrass;
import org.zeith.terraria.common.content.fluids.FluidAPI;
import org.zeith.terraria.init.BlocksTC;
import org.zeith.terraria.init.FluidsTC;
import org.zeith.terraria.utils.math.EnumStructureRotation;
import org.zeith.terraria.utils.math.Vector2;
import org.zeith.terraria.world.api.WorldgenHelper;
import org.zeith.terraria.world.struct.base.Structure;

public class StUndergroundShrine extends Structure {
    public static final StUndergroundShrine INSTANCE = new StUndergroundShrine();

    static final int[][] Y_RADIUSES = {
            {
                    9,
                    4,
                    3,
                    2
            },
            {
                    8,
                    7,
                    6,
                    5,
                    4
            },
            {
                    7,
                    9,
                    8,
                    7
            },
            {
                    6,
                    10,
                    9
            },
            {
                    5,
                    10
            },
            {
                    4,
                    11
            },
            {
                    3,
                    12
            },
            {
                    2,
                    12
            },
            {
                    1,
                    12
            },
            {
                    0,
                    12
            },
            {
                    -1,
                    12,
                    0,
                    1
            },
            {
                    -2,
                    12,
                    0,
                    1,
                    2
            },
            {
                    -3,
                    10,
                    0,
                    1,
                    2,
                    3
            },
            {
                    -4,
                    9,
                    4,
                    3,
                    2,
                    1,
                    0
            },
            {
                    -5,
                    9,
                    8,
                    7,
                    6,
                    5,
                    4,
                    3,
                    2,
                    1,
                    0
            }
    };

    private boolean generateTunnelToSurface = false;

    public Structure setContext(World world, BlockPos pivot, boolean generateTunnelToSurface)
    {
        this.generateTunnelToSurface = generateTunnelToSurface;
        return super.setContext(world, pivot, EnumStructureRotation.rand(world.rand));
    }

    @Override
    protected StructureGenerateResult finish(boolean success)
    {
        generateTunnelToSurface = true;
        return super.finish(success);
    }

    @Override
    public StructureGenerateResult generate()
    {
        for(int[] ints : Y_RADIUSES)
        {
            int y = ints[0];
            boolean water = y < -1 && y > -5;
            for(int i = 1; i < ints.length; ++i)
            {
                int rad = ints[i];
                for(int x = -rad; x <= rad; ++x)
                    for(int z = -rad; z <= rad; ++z)
                    {
                        double l = Vector2.length(x, z);
                        if(l < rad - 1F)
                        {
                            if(l > 2.5F && water)
                                FluidAPI.setFluidLevel(7, pivot.add(x, y, z), world, FluidsTC.WATER);
                            else clearBlock(pivot.add(x, y, z));
                        } else if(l < rad + 1F)
                            setBlock(pivot.add(x, y, z), BlocksTC.DIRT.getDefaultState());
                    }
            }
        }

        rotateHorizontalBlocks = false;

        BlockTerrariaGrass grass = BlocksTC.GRASS_FOREST;

        for(BlockPos placedBlock : placedBlocks)
        {
            if(world.getBlockState(placedBlock).getBlock() == BlocksTC.DIRT && grass.canSpreadTo(world, placedBlock, placedBlock))
                grass.spreadTo(world, placedBlock, placedBlock);

            WorldBiomeType bt = WorldgenHelper.getBiome(WorldgenHelper.getCubeGenerator(world), placedBlock);
            bt.applyBiome2Block(world, placedBlock);
        }

        if(generateTunnelToSurface)
        {
            int yTop = WorldgenHelper.getSurfaceY(world, pivot);

            for(int y = pivot.getY() + 9; y <= yTop; ++y)
            {
                if(rand.nextInt(4) != 0)
                    world.setBlockToAir(new BlockPos(pivot.getX(), y, pivot.getZ()));

                for(EnumFacing f : EnumFacing.HORIZONTALS)
                    if(rand.nextInt(2) != 0)
                    {
                        world.setBlockToAir(new BlockPos(pivot.getX() + f.getXOffset(), y, pivot.getZ() + f.getZOffset()));

                        if(rand.nextInt(4) == 0)
                        {
                            EnumFacing f2 = f.rotateY();
                            world.setBlockToAir(new BlockPos(pivot.getX() + f2.getXOffset(), y, pivot.getZ() + f2.getZOffset()));
                        }

                        if(rand.nextInt(4) == 0)
                        {
                            EnumFacing f2 = f.rotateYCCW();
                            world.setBlockToAir(new BlockPos(pivot.getX() + f2.getXOffset(), y, pivot.getZ() + f2.getZOffset()));
                        }
                    }
            }
        }

        return finish(true);
    }
}
