package com.ryorama.calamitycraft.init;

import com.zeitheron.hammercore.utils.SoundObject;

public class SoundsCC
{
    public static final SoundObject WULFRUM_DEATH = createSound("death/wulfrum_death");

    private static SoundObject createSound(String id) {
        return new SoundObject("calamitycraft", id);
    }
}
