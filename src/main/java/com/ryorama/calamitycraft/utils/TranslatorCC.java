package com.ryorama.calamitycraft.utils;

import com.ryorama.calamitycraft.CalamityCraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.zeith.terraria.api.tooltip.I18nTooltipElement;
import org.zeith.terraria.init.TranslationKeysTC;

/**
 * Use TranslationKeysTC directly!
 * Ensures a safer approach.
 */
@Deprecated
public class TranslatorCC {
    public static String tooltip(ResourceLocation path, Object... objects) {
        return TranslationKeysTC.TOOLTIP.toTranslatedText(path, objects);
    }
    
    @SideOnly(Side.CLIENT)
    public static String tooltip(String path, Object... objects) {
        return TranslationKeysTC.TOOLTIP.toTranslatedText(CalamityCraft.id(path), objects);
    }

    public static I18nTooltipElement tooltipE(String path, Object... objects) {
        return TranslationKeysTC.TOOLTIP.toTooltipElement(CalamityCraft.id(path), objects);
    }
}
