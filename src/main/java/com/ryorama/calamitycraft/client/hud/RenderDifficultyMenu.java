package com.ryorama.calamitycraft.client.hud;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.common.data.PlayerCalamityData;
import com.ryorama.calamitycraft.common.data.WorldCalamityData;
import com.zeitheron.hammercore.client.utils.RenderUtil;
import com.zeitheron.hammercore.client.utils.UtilsFX;
import lombok.val;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.zeith.terraria.api.client.hud.Hud;
import org.zeith.terraria.api.client.hud.HudAnchor;
import org.zeith.terraria.api.client.hud.HudRenderer;
import org.zeith.terraria.api.client.hud.IHudElement;
import org.zeith.terraria.client.cursor.Cursor;
import org.zeith.terraria.client.cursor.CursorsTC;
import org.zeith.terraria.client.gui.api.inventory.ContainerTerraria;
import org.zeith.terraria.client.gui.terra.GuiNewInventory;
import org.zeith.terraria.common.container.ContainerNewInventory;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.common.data.world.world.WorldDataTC;

// Use a widget instead. It has access to input as well as rendering capabilities.
@Deprecated
@Hud(value = HudAnchor.TOP_RIGHT, renderOrder = 80F)
public class RenderDifficultyMenu implements IHudElement {
    public static final ResourceLocation ICON_NONE = CalamityCraft.id("textures/ui/difficulty/mode_indicator_none.png");
    public static final ResourceLocation ICON_REVENGEANCE = CalamityCraft.id("textures/ui/difficulty/mode_indicator_rev.png");
    public static final ResourceLocation ICON_DEATH = CalamityCraft.id("textures/ui/difficulty/mode_indicator_death.png");
    public static final ResourceLocation ICON_OUTLINE = CalamityCraft.id("textures/ui/difficulty/mode_indicator_outline.png");

    public static ResourceLocation CURRENT_ICON;

    WorldCalamityData wd;
    PlayerDataTC pd;

    @Override
    public void update(PlayerDataTC player)
    {
        wd = WorldCalamityData.get(player.world);
        pd = player;
    }

    @Override
    public int width() {
        return 10;
    }

    @Override
    public int height() {
        return 18;
    }

    @Override
    public void render(HudRenderer hudRenderer) {
        if (wd != null && pd != null) {
            if (pd.getPlayer().openContainer instanceof ContainerTerraria) {
                if (wd.isDeath) {
                    CURRENT_ICON = ICON_DEATH;
                } else if (wd.isRevengeance) {
                    CURRENT_ICON = ICON_REVENGEANCE;
                } else {
                    CURRENT_ICON = ICON_NONE;
                }


                val gfx = hudRenderer.getGraphics();
                gfx.color(1F, 1F, 1F, 1F);
                gfx.blitTexture(CURRENT_ICON, 0, 0, 16, 20);
            }
        }
    }
}
