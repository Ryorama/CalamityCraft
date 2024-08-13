package com.ryorama.calamitycraft.client.widgets;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.common.data.WorldCalamityData;
import com.zeitheron.hammercore.client.utils.RenderUtil;
import com.zeitheron.hammercore.client.utils.UtilsFX;
import com.zeitheron.hammercore.client.utils.texture.gui.DynGuiTex;
import com.zeitheron.hammercore.client.utils.texture.gui.GuiTexBakery;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;
import org.zeith.terraria.client.gui.TerrariaCraftTheme;
import org.zeith.terraria.client.gui.api.inventory.ContainerTerraria;
import org.zeith.terraria.client.gui.api.inventory.ItemSlot;
import org.zeith.terraria.client.gui.api.widget.WidgetBase;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.common.data.world.world.WorldDataTC;

import java.awt.*;
import java.util.Iterator;

public class WidgetDifficultyMenu extends WidgetBase {
    public static final ResourceLocation ICON_NONE = CalamityCraft.id("textures/ui/difficulty/mode_indicator_none.png");
    public static final ResourceLocation ICON_REVENGEANCE = CalamityCraft.id("textures/ui/difficulty/mode_indicator_rev.png");
    public static final ResourceLocation ICON_DEATH = CalamityCraft.id("textures/ui/difficulty/mode_indicator_death.png");
    public static final ResourceLocation ICON_OUTLINE = CalamityCraft.id("textures/ui/difficulty/mode_indicator_outline.png");

    public static ResourceLocation CURRENT_ICON;

    final Rectangle rect = new Rectangle();
    protected final Rectangle box = new Rectangle();
    DynGuiTex tx;
    protected boolean mouseInArea;
    private boolean isMenuShown;

    public void initWidget(int width, int height) {
        this.width = 16;
        this.height = 20;
        super.initWidget(width, height);
        this.x = 0;
        this.y = 0;
        this.rect.setBounds((int)this.getActualX(), (int)this.getActualY(), this.width, this.height);
        GuiTexBakery b = GuiTexBakery.start();
        this.tx = b.bake();
        this.tx.theme = TerrariaCraftTheme.INSTANCE;
    }

    public void drawWidget(float partialTicks, Point mouse) {
        this.tx.render(0, 0);
        this.box.setBounds(0, 0, this.width, this.height);
        this.mouseInArea = this.box.contains(mouse);

        EntityPlayer player = Minecraft.getMinecraft().player;
        PlayerDataTC pd = PlayerDataTC.get(player);
        WorldCalamityData wd = WorldCalamityData.get(WorldDataTC.get(pd.getWorld()));
        TextureManager tm = Minecraft.getMinecraft().getTextureManager();
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());

        if (wd != null && pd != null) {
            if (wd.isDeath) {
                CURRENT_ICON = ICON_DEATH;
            } else if (wd.isRevengeance) {
                CURRENT_ICON = ICON_REVENGEANCE;
            } else {
                CURRENT_ICON = ICON_NONE;
            }

            if (tm != null) {
                GlStateManager.pushMatrix();
                GL11.glTranslated(sr.getScaledWidth_double() / 2.0 - 49.0, sr.getScaledHeight_double() / 2.0 + 20.0 - 11.0, 1);                UtilsFX.bindTexture(CURRENT_ICON);
                RenderUtil.drawFullTexturedModalRect(150, -200, 20, 20);
                GlStateManager.popMatrix();

                if (isMenuShown) {

                }
            }
        }
    }

    public void mouseReleased(int button) {
        if (button == 0) {
            if (!isMenuShown) {
                isMenuShown = true;
            } else {
                isMenuShown = false;
            }
        }
    }
}
