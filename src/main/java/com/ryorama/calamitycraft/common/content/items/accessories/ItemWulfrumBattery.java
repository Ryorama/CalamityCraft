package com.ryorama.calamitycraft.common.content.items.accessories;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.common.content.items.accessories.typed.IWulfrumBattery;
import com.zeitheron.hammercore.utils.AABBUtils;
import com.zeitheron.hammercore.utils.forge.RegisterHook;
import java.awt.Color;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.zeith.terraria.api.enums.EnumDamageType;
import org.zeith.terraria.api.events.entity.EntityAttackEvent;
import org.zeith.terraria.common.content.items.base.ItemBaseArtifactTC;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.init.ParticleTypesTC;

import java.util.Random;

public class ItemWulfrumBattery extends ItemBaseArtifactTC implements IWulfrumBattery {
    @RegisterHook
    protected final void wulfrumBatteryRegistered() {
        CalamityCraft.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void dealDamage(EntityAttackEvent e) {
        if (e.getDamageType() == EnumDamageType.SUMMON && e.getAttacker() instanceof EntityPlayerMP && e.getVictim() instanceof EntityLivingBase) {
            if (e.getVictim().isEntityInvulnerable(e.getSource())) {
                return;
            }

            EntityPlayerMP mp = (EntityPlayerMP) e.getAttacker();
            PlayerDataTC.optionally(mp).ifPresent((pd) -> {
                if (pd.artifactInventory.contains((stack) -> {
                    return !stack.isEmpty() && stack.getItem() instanceof IWulfrumBattery;
                })) {
                    if (pd.minions().minionUUIDs.length > 0) {
                        if (pd.getWorld().isRemote) {
                            Random rand = pd.random;

                            for (int i = 0; i < rand.nextInt(4); i++) {
                                ParticleTypesTC.DUST.create(pd.getWorld()).setPosition(pd.minions().data.pos()).setEmission(5).setColor(rand.nextBoolean() ? Color.CYAN : Color.GREEN).setMaxAge(10).spawn();
                            }
                        }
                    }

                    if (e.getDamageType() == EnumDamageType.SUMMON) {
                        e.setNewDamage(e.getDamage() + (e.getDamage() * 0.07f));
                    }
                }
            });
        }
    }

    @Override
    public void onArtifactWearTick(EntityPlayer player, ItemStack stack, int slot, PlayerDataTC data) {
        PlayerDataTC.optionally(player).ifPresent((pd) -> {
            if (pd.artifactInventory.contains((s) -> {
                return !s.isEmpty() && s.getItem() instanceof IWulfrumBattery;
            })) {
                if (pd.minions().minionUUIDs.length > 0) {
                    if (pd.getWorld().isRemote) {
                        Random rand = pd.random;
                        Random rng = pd.getPlayer().getRNG();
                        AxisAlignedBB ebox = pd.minions().data.getEntityBoundingBox().grow(0.25);
                        Vec3d c = AABBUtils.getCenter(ebox);
                        Vec3d pos = AABBUtils.randomPosWithin(ebox, player.world.rand);

                        for (int i = 0; i < rand.nextInt(4); i++) {
                            ParticleTypesTC.DUST.create(pd.getWorld()).setPosition(pos).setVelocity(pos.subtract(c).normalize().scale(0.05).add(0.0, 0.05000000074505806, 0.0)).setIdx(50).setEmission(1.0F).setScale(1.0F + rand.nextFloat() * 1.5F).setMaxAge(10).setFrameCount(3).setColor(rand.nextBoolean() ? Color.CYAN : Color.GREEN).spawn();
                        }
                    }
                }}
        });
    }
}