package com.ryorama.calamitycraft.utils;

import net.minecraft.util.ResourceLocation;
import org.zeith.hammerlib.util.mcf.Resources;

public interface InfoCC {
    static ResourceLocation id(String path) {
        return Resources.location("calamitycraft", path);
    }
}
