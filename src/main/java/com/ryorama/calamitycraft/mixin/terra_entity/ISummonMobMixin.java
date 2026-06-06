package com.ryorama.calamitycraft.mixin.terra_entity;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalFloatRef;
import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.init.CCAccessories;
import com.ryorama.calamitycraft.utils.Utils;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.player.Player;
import org.confluence.terraentity.api.entity.ISummonMob;
import org.confluence.terraentity.init.TETags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.theillusivec4.curios.api.CuriosApi;

@Mixin(value = ISummonMob.class, remap = false)
public interface ISummonMobMixin extends OwnableEntity {
    @Shadow LivingEntity summon_getOwner();

    @ModifyVariable(at = @At("STORE"), method = "summon_doHurtTarget", ordinal = 0)
    default float damage(float damage) {
        return 1;
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"), method = "summon_doHurtTarget")
    default void summon_doHurtTarget(Entity entity, CallbackInfoReturnable<Boolean> cir, @Local LocalFloatRef damage, @Local DamageSource damageSource) {
        if (summon_getOwner() instanceof Player) {
            Player player = (Player) summon_getOwner();
            CalamityCraft.LOGGER.info("Damage Type: " + damageSource.type());
            CalamityCraft.LOGGER.info("Is Bat Equipped: " + CuriosApi.getCuriosInventory(player).get().isEquipped(CCAccessories.WULFRUM_BATTERY.asItem()));
            if (damageSource.is(TETags.DamageTypes.SUMMONER) && CuriosApi.getCuriosInventory(player).get().isEquipped(CCAccessories.WULFRUM_BATTERY.asItem())) {
                damage.set(Utils.mul(damage.get(), 7));
            }
        }
    }
}
