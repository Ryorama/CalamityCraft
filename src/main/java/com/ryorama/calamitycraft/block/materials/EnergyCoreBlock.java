package com.ryorama.calamitycraft.block.materials;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EnergyCoreBlock extends Block {
    private static final VoxelShape SHAPE = Block.box(4.0F, 1.0F, 4.0F, 12.0F, 9.0F, 12.0F);
    
    public EnergyCoreBlock() {
        super(Properties.of().instabreak().sound(SoundType.HEAVY_CORE).lightLevel((blockState) -> 5));
    }
    
    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }
}
