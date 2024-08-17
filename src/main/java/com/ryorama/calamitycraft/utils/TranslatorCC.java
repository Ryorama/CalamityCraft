package com.ryorama.calamitycraft.utils;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.zeith.terraria.api.tooltip.I18nTooltipElement;

public class TranslatorCC {
    public static String tooltip(ResourceLocation postfix, Object... objects) {
        return I18n.format("tooltip." + postfix, objects);
    }

    public static String tooltip(String postfix, Object... objects) {
        return I18n.format("tooltip.calamitycraft:" + postfix, objects);
    }

    public static I18nTooltipElement tooltipE(String postfix, Object... objects) {
        return new I18nTooltipElement("tooltip.calamitycraft:" + postfix, objects);
    }
}
