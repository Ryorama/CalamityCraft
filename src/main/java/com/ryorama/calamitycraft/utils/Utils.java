package com.ryorama.calamitycraft.utils;

import com.ryorama.calamitycraft.datacomponents.BlightedGelVariantComponent;
import com.ryorama.calamitycraft.init.CCDataComponents;
import com.ryorama.calamitycraft.init.CCMaterials;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;

public class Utils {
    public static float mul(float input, int percent) {
        return input * (1 + percentOf(percent));
    }

    public static float percentOf(float value) {
        return value / 100;
    }

    public ItemStack dropBlightedGelOfVariant(int variant, int amount) {
        ItemStack itemStack = new ItemStack(CCMaterials.BLIGHTED_GEL.get(), amount);
        itemStack.set(CCDataComponents.BLIGHTED_GEL_VARIANT, new BlightedGelVariantComponent.BlightedGelVariant(variant));
        return itemStack;
    }

    public static SoundEvent pickRandomSoundEvent(RandomSource random, SoundEvent... soundEvents) {
        int count = random.nextInt(0, soundEvents.length);
        return soundEvents[count];
    }

    public int getSecondForTicks(int ticks) {
        return ticks % 20;
    }
}
