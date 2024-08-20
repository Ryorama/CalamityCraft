package com.ryorama.calamitycraft.common.content.entity.hostile.wulfrum;

import com.ryorama.calamitycraft.common.content.items.accessories.typed.IWulfrumBattery;
import com.ryorama.calamitycraft.init.items.AccessoriesCC;
import com.ryorama.calamitycraft.init.items.MaterialsCC;
import com.ryorama.calamitycraft.utils.UtilsCC;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.zeith.hammeranims.api.animsys.AnimationSystem;
import org.zeith.terraria.common.content.entity.ai.behaviors.AI;
import org.zeith.terraria.common.content.entity.api.EntityAnimatedGenericTerrariaMob;
import org.zeith.terraria.common.content.entity.api.EntityProps;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.utils.math.Vector2;

public abstract class WulfrumBaseEntity<T extends AI<?>> extends EntityAnimatedGenericTerrariaMob<T> {

    public boolean isSupercharged;
    protected float xRot;
    protected float prevXRot;
    protected float xRotMultiplier = 1.0F;

    public WulfrumBaseEntity(World worldIn) {
        super(worldIn);
    }

    @Override
    public void setupSystem(AnimationSystem.Builder builder) {

    }

    @Override
    protected abstract T createAI();

    @Override
    public void initProps(EntityProps entityProps) {

    }

    @Override
    public void sharedTick() {
        super.sharedTick();

        Vec3d dir = this.dataManager.get(DATA_DIRECTION);
        if (dir != null) {
            this.facePosition(dir.add(this.getPositionVector().add(0.0, this.getEyeHeight(), 0.0)), 30.0F, 30.0F);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void FX() {
        super.FX();
        Vec3d dir = this.getVel();
        this.prevXRot = this.xRot;
        this.xRot = (float)Math.atan2(dir.y, Vector2.length(dir.x, dir.z));
    }

    public Vec3d getEntityRotation(float partialTicks) {
        return new Vec3d((this.prevXRot + (this.xRot - this.prevXRot) * partialTicks) * this.xRotMultiplier, 0.0, 0.0);
    }

    @Override
    public void createDrop(int looting, DamageSource source, NonNullList<ItemStack> drops) {
        drops.add(MaterialsCC.WULFRUM_METAL_SCRAP.stack(UtilsCC.randBetweenInt(1, 2)));
        if (getLastAttackedEntity() instanceof EntityPlayer) {
            EntityPlayer player = ((EntityPlayer)getLastAttackedEntity());
            PlayerDataTC playerData = PlayerDataTC.get(player);

            if (playerData.artifactInventory.contains((stack) -> {
                return !stack.isEmpty() && stack.getItem() instanceof IWulfrumBattery;
            })) {
                if (rand.nextInt(2) == 0) {
                    drops.add(MaterialsCC.WULFRUM_METAL_SCRAP.stack());
                }
            }
        }

        if (rand.nextInt(100) <= 7) {
            drops.add(AccessoriesCC.WULFRUM_BATTERY.stack());
        }

        if (isSupercharged) {
            drops.add(MaterialsCC.ENERGY_CORE.stack());
        }
    }

    @Override
    public void writeEntityToNBT(@NotNull NBTTagCompound tag) {
        tag.setBoolean("isSupercharged", isSupercharged);
    }

    @Override
    public void readEntityFromNBT(@NotNull NBTTagCompound tag) {
        isSupercharged = tag.getBoolean("isSupercharged");
    }
}
