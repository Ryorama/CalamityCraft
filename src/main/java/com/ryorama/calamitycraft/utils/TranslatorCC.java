package com.ryorama.calamitycraft.utils;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class TranslatorCC {
    public static String tooltip(ResourceLocation postfix, Object... objects) {
        return I18n.format("tooltip." + postfix, objects);
    }

    public static String tooltip(String postfix, Object... objects) {
        return I18n.format("tooltip.calamitycraft:" + postfix, objects);
    }
}
