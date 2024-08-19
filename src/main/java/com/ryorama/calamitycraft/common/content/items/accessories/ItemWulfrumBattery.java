package com.ryorama.calamitycraft.common.content.items.accessories;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.common.content.items.accessories.typed.IWulfrumBattery;
import com.zeitheron.hammercore.utils.AABBUtils;
import com.zeitheron.hammercore.utils.forge.RegisterHook;
import java.awt.Color;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.zeith.terraria.api.entity.pets.IPlayerOwned;
import org.zeith.terraria.api.enums.EnumDamageType;
import org.zeith.terraria.api.events.calc.GetDamageAffectEvent;
import org.zeith.terraria.common.content.items.base.ItemBaseArtifactTC;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.init.ParticleTypesTC;

import java.util.Random;

public class ItemWulfrumBattery extends ItemBaseArtifactTC implements IWulfrumBattery {
    @RegisterHook
    private void subscribe() {
        CalamityCraft.EVENT_BUS.register(this);
    }

    @Override
    public boolean isEquipped(PlayerDataTC pd)  {
        return !pd.artifactInventory.find(s -> s.getItem() instanceof IWulfrumBattery).isEmpty();
    }
    
    @SubscribeEvent
    public void increaseDamage(GetDamageAffectEvent e) {
        if(e.damageType != EnumDamageType.SUMMON || !isEquipped(e.getPlayerData())) return;
        // NB: the addTag method deduplicates the effect so it does not stack.
        // TLDR: 'tags' inside events are a one-time-add thing.
        // To implement stacking, simply use a different key, or avoid using tags altogether!
        //                                  - Zeith
        if(e.addTag("calamitycraft:wulfrum_battery")) e.mult(0.07F);
    }

    @Override
    public void onArtifactWearTick(EntityPlayer player, ItemStack stack, int slot, PlayerDataTC data) {
        PlayerDataTC.optionally(player).ifPresent((pd) -> {
            if (pd.artifactInventory.contains((s) -> {
                return !s.isEmpty() && s.getItem() instanceof IWulfrumBattery;
            })) {
                if (pd.minions().minionUUIDs.length > 0) {
                    for (int m = 0; m < pd.minions().minionUUIDs.length; m++) {
                        IPlayerOwned.get((WorldServer) pd.getWorld(), pd.minions().minionUUIDs[m]);

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
                    }
                }}
        });
    }
}