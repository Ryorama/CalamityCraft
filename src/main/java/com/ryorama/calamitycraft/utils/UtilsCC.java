package com.ryorama.calamitycraft.utils;

import com.google.common.base.Predicate;
import com.zeitheron.hammercore.world.WorldGenHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UtilsCC {
    public static boolean generateOre(World worldIn, Random rand, BlockPos position, int numberOfBlocks, IBlockState oreBlock, Predicate<IBlockState> predicate) {
        float f = rand.nextFloat() * 3.1415927F;
        double d0 = (double) ((float) (position.getX() + 8) + MathHelper.sin(f) * numberOfBlocks / 8.0F);
        double d1 = (double) ((float) (position.getX() + 8) - MathHelper.sin(f) * numberOfBlocks / 8.0F);
        double d2 = (double) ((float) (position.getZ() + 8) + MathHelper.cos(f) * numberOfBlocks / 8.0F);
        double d3 = (double) ((float) (position.getZ() + 8) - MathHelper.cos(f) * numberOfBlocks / 8.0F);
        double d4 = (double) (position.getY() + rand.nextInt(3) - 2);
        double d5 = (double) (position.getY() + rand.nextInt(3) - 2);

        for (int i = 0; i < numberOfBlocks; ++i) {
            float f1 = (float) i / numberOfBlocks;
            double d6 = d0 + (d1 - d0) * (double) f1;
            double d7 = d4 + (d5 - d4) * (double) f1;
            double d8 = d2 + (d3 - d2) * (double) f1;
            double d9 = rand.nextDouble() * numberOfBlocks / 16.0;
            double d10 = (double) (MathHelper.sin(3.1415927F * f1) + 1.0F) * d9 + 1.0;
            double d11 = (double) (MathHelper.sin(3.1415927F * f1) + 1.0F) * d9 + 1.0;
            int j = MathHelper.floor(d6 - d10 / 2.0);
            int k = MathHelper.floor(d7 - d11 / 2.0);
            int l = MathHelper.floor(d8 - d10 / 2.0);
            int i1 = MathHelper.floor(d6 + d10 / 2.0);
            int j1 = MathHelper.floor(d7 + d11 / 2.0);
            int k1 = MathHelper.floor(d8 + d10 / 2.0);

            for (int l1 = j; l1 <= i1; ++l1) {
                double d12 = ((double) l1 + 0.5 - d6) / (d10 / 2.0);
                if (d12 * d12 < 1.0) {
                    for (int i2 = k; i2 <= j1; ++i2) {
                        double d13 = ((double) i2 + 0.5 - d7) / (d11 / 2.0);
                        if (d12 * d12 + d13 * d13 < 1.0) {
                            for (int j2 = l; j2 <= k1; ++j2) {
                                double d14 = ((double) j2 + 0.5 - d8) / (d10 / 2.0);
                                if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0) {
                                    BlockPos blockpos = new BlockPos(l1, i2, j2);
                                    IBlockState state = worldIn.getBlockState(blockpos);
                                    if (state.getBlock().isReplaceableOreGen(state, worldIn, blockpos, predicate)) {
                                        WorldGenHelper.setBlockState(worldIn, blockpos, oreBlock, 2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static int randBetweenInt(int min, int max) {
        Random r = new Random();
        return r.nextInt((max-min)+1) + min;
    }

    public static float lerp(float a, float b, float f)
    {
        return (float) (a * (1.0 - f) + (b * f));
    }

    //Source: https://bitbucket.org/Requios/effortless-building/src/master/src/main/java/nl/requios/effortlessbuilding/buildmode/buildmodes/Circle.java
    public static List<BlockPos> getCircleBlocks(int x1, int y1, int z1, int x2, int y2, int z2) {
        List<BlockPos> list = new ArrayList<>();

        float centerX = x1;
        float centerZ = z1;

        x1 = (int) (centerX - (x2 - centerX));
        z1 = (int) (centerZ - (z2 - centerZ));

        float radiusX = Math.abs(x2 - centerX);
        float radiusZ = Math.abs(z2 - centerZ);

        addCircleBlocks(list, x1, y1, z1, x2, y2, z2, centerX, centerZ, radiusX, radiusZ);

        return list;
    }

    public static void addCircleBlocks(List<BlockPos> list, int x1, int y1, int z1, int x2, int y2, int z2, float centerX, float centerZ, float radiusX, float radiusZ) {

        for (int l = x1; x1 < x2 ? l <= x2 : l >= x2; l += x1 < x2 ? 1 : -1) {

            for (int n = z1; z1 < z2 ? n <= z2 : n >= z2; n += z1 < z2 ? 1 : -1) {

                float distance = distance(l, n, centerX, centerZ);
                float radius = calculateEllipseRadius(centerX, centerZ, radiusX, radiusZ, l, n);
                if (distance < radius + 0.4f)
                    list.add(new BlockPos(l, y1, n));
            }
        }
    }

    private static float distance(float x1, float z1, float x2, float z2) {
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (z2 - z1) * (z2 - z1));
    }

    public static float calculateEllipseRadius(float centerX, float centerZ, float radiusX, float radiusZ, int x, int z) {
        float theta = (float) Math.atan2(z - centerZ, x - centerX);
        float part1 = (float) (radiusX * radiusX * Math.sin(theta) * Math.sin(theta));
        float part2 = (float) (radiusZ * radiusZ * Math.cos(theta) * Math.cos(theta));
        return (float) (radiusX * radiusZ / Math.sqrt(part1 + part2));
    }

    //Source: https://bitbucket.org/Requios/effortless-building/src/master/src/main/java/nl/requios/effortlessbuilding/buildmode/buildmodes/Cylinder.java
    public static List<BlockPos> getCylinderBlocks(int x1, int y1, int z1, int x2, int y2, int z2) {
        List<BlockPos> list = new ArrayList<>();

        List<BlockPos> circleBlocks = getCircleBlocks(x1, y1, z1, x2, y2, z2);

        int lowest = Math.min(y1, y2);
        int highest = Math.max(y1, y2);

        for (int y = lowest; y <= highest; y++) {
            for (BlockPos blockPos : circleBlocks) {
                list.add(new BlockPos(blockPos.getX(), y, blockPos.getZ()));
            }
        }

        return list;
    }
}
