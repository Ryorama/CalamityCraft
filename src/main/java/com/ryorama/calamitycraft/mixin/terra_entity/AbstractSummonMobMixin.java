package com.ryorama.calamitycraft.mixin.terra_entity;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.init.CCAccessories;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.confluence.terraentity.api.entity.ICollisionAttackEntity;
import org.confluence.terraentity.api.entity.IPartEntityTargetable;
import org.confluence.terraentity.api.entity.ISummonMob;
import org.confluence.terraentity.entity.summon.AbstractSummonMob;
import org.mesdag.particlestorm.PSGameClient;
import org.mesdag.particlestorm.particle.ParticleEmitter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.geckolib.animatable.GeoEntity;
import top.theillusivec4.curios.api.CuriosApi;

@Mixin(AbstractSummonMob.class)
public abstract class AbstractSummonMobMixin extends TamableAnimal implements GeoEntity, ISummonMob, ICollisionAttackEntity, IPartEntityTargetable {
    @Unique
    private ParticleEmitter emitter;

    protected AbstractSummonMobMixin(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    public void tick(CallbackInfo ci) {
        Player owner;

        if (this.level().isClientSide()) {
            if (this.getOwner() instanceof Player) {
                owner = (Player) this.getOwner();

                if (CuriosApi.getCuriosInventory(owner).get().isEquipped(CCAccessories.WULFRUM_BATTERY.asItem())) {
                    if ((emitter == null || emitter.isRemoved())) {
                        this.emitter = new ParticleEmitter(this.level(), this.position(), ResourceLocation.parse("calamitycraft:wulfrum_battery_effect"));
                        emitter.attachEntity(this);
                        PSGameClient.LOADER.addEmitter(emitter, false);
                    }
                } else {
                    if (emitter != null) {
                        emitter.remove();
                    }
                }
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "onRemovedFromLevel")
    public void onRemovedFromLevel(CallbackInfo ci) {
        if (level().isClientSide() && emitter != null) {
            emitter.remove();
        }
    }
}
