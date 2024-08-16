package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import com.zeitheron.hammercore.internal.SimpleRegistration;
import com.zeitheron.hammercore.utils.SoundObject;

import java.lang.reflect.Field;

public class SoundsCC
{
    public static final SoundObject WULFRUM_DEATH = createSound("death/wulfrum_death");

    private static SoundObject createSound(String id) {
        return new SoundObject(CalamityCraft.MODID, id);
    }
    
    static {
        Field[] fs = SoundsCC.class.getDeclaredFields();
        for(Field f : fs)
            if(SoundObject.class.isAssignableFrom(f.getType()))
                try
                {
                    f.setAccessible(true);
                    SoundObject so = (SoundObject) f.get(null);
                    SimpleRegistration.registerSound(so);
					CalamityCraft.LOG.debug("Registered sound {}", so.name);
                } catch(Throwable err)
                {
                    CalamityCraft.LOG.error("Failed to register mod sounds.", err);
                }
    }
}
