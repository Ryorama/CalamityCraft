package com.ryorama.calamitycraft.common.content.entity.hostile.wulfrum;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.zeith.hammeranims.api.animsys.AnimationSystem;
import org.zeith.terraria.common.content.entity.ai.behaviors.AI;
import org.zeith.terraria.common.content.entity.api.EntityAnimatedGenericTerrariaMob;
import org.zeith.terraria.common.content.entity.api.EntityProps;

public abstract class WulfrumBaseEntity<T extends AI<?>> extends EntityAnimatedGenericTerrariaMob<T> {

    public boolean isSupercharged;

    public WulfrumBaseEntity(World worldIn) {
        super(worldIn);
    }

    @Override
    public void setupSystem(AnimationSystem.Builder builder) {

    }

    @Override
    protected abstract T createAI();

    @Override
    public void initProps(EntityProps entityProps) {

    }

    @Override
    public void writeEntityToNBT(@NotNull NBTTagCompound tag) {
        tag.setBoolean("isSupercharged", isSupercharged);
    }

    @Override
    public void readEntityFromNBT(@NotNull NBTTagCompound tag) {
        isSupercharged = tag.getBoolean("isSupercharged");
    }
}
