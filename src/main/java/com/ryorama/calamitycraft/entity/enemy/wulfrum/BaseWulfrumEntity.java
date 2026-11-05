package com.ryorama.calamitycraft.entity.enemy.wulfrum;

import com.ryorama.calamitycraft.init.CCSoundEvents;
import com.ryorama.calamitycraft.utils.Utils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class BaseWulfrumEntity extends Monster {
    public static final EntityDataAccessor<Boolean> IS_OVERCLOCKED;
    public static final EntityDataAccessor<Float> OVERCLOCK_TIMER;

    public BaseWulfrumEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public void defineSynchedData(SynchedEntityData.Builder syncBuilder) {
        super.defineSynchedData(syncBuilder);
        syncBuilder.define(IS_OVERCLOCKED, false);
        syncBuilder.define(OVERCLOCK_TIMER, 0f);
    }

    @Override
    @Nullable
    public SoundEvent getHurtSound(DamageSource damageSource) {
        return Utils.pickRandomSoundEvent(this.random, CCSoundEvents.WULFRUM_HIT1.get(), CCSoundEvents.WULFRUM_HIT2.get(), CCSoundEvents.WULFRUM_HIT3.get());
    }

    @Override
    @Nullable
    public SoundEvent getDeathSound() {
        return CCSoundEvents.WULFRUM_DEATH.get();
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("is_overclocked", isOverclocked());
        tag.putFloat("overclock_timer", getOverclockTimer());
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setIsOverclocked(tag.getBoolean("is_overclocked"));
        this.setOverclockTimer(tag.getFloat("overclock_timer"));
    }

    public boolean isOverclocked() {
        return this.entityData.get(IS_OVERCLOCKED);
    }

    public void setIsOverclocked(boolean value) {
        this.entityData.set(IS_OVERCLOCKED, value);
    }

    public float getOverclockTimer() {
        return this.entityData.get(OVERCLOCK_TIMER);
    }

    public void setOverclockTimer(float value) {
        this.entityData.set(OVERCLOCK_TIMER, value);
    }

    static {
        IS_OVERCLOCKED = SynchedEntityData.defineId(BaseWulfrumEntity.class, EntityDataSerializers.BOOLEAN);
        OVERCLOCK_TIMER = SynchedEntityData.defineId(BaseWulfrumEntity.class, EntityDataSerializers.FLOAT);
    }
}
