package com.ryorama.calamitycraft.common.content.entity.hostile.wulfrum;

import com.ryorama.calamitycraft.common.content.entity.ai.behaviours.WulfrumRoverAI;
import com.ryorama.calamitycraft.init.SoundsCC;
import com.ryorama.calamitycraft.init.items.AccessoriesCC;
import com.ryorama.calamitycraft.init.items.MaterialsCC;
import com.ryorama.calamitycraft.utils.UtilsCC;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.zeith.hammeranims.api.animsys.AnimationSystem;
import org.zeith.terraria.api.entity.IHasRotation;
import org.zeith.terraria.api.entity.IShowEntityHealth;
import org.zeith.terraria.common.content.entity.api.EntityProps;
import org.zeith.terraria.init.SoundsTC;
import org.zeith.terraria.utils.math.Vector2;

public class WulfrumRoverEntity extends WulfrumBaseEntity<WulfrumRoverAI> implements IShowEntityHealth, IHasRotation {
    protected float xRot;
    protected float prevXRot;
    protected float xRotMultiplier = 1.0F;

    public WulfrumRoverEntity(World worldIn) {
        super(worldIn);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void FX() {
        super.FX();
        Vec3d dir = this.getVel();
        this.prevXRot = this.xRot;
        this.xRot = (float)Math.atan2(dir.y, Vector2.length(dir.x, dir.z));
    }

    @Override
    protected WulfrumRoverAI createAI() {
        return new WulfrumRoverAI(this);
    }

    @Override
    public float getHealthBarInfoOffsetY() {
        return 1.0F;
    }

    public Vec3d getEntityRotation(float partialTicks) {
        return new Vec3d((double)((this.prevXRot + (this.xRot - this.prevXRot) * partialTicks) * this.xRotMultiplier), 0.0, 0.0);
    }

    @Override
    public void initProps(EntityProps entityProps) {
        entityProps.noGravity = true;
        entityProps.lifeMax = 32;
        entityProps.damage = 10;
        entityProps.defense = isSupercharged ? 13 : 4;
        entityProps.knockBackResist = 85;
        entityProps.value = 115;
        entityProps.deathSound = SoundsCC.WULFRUM_DEATH.sound;
        entityProps.hitSound = SoundsTC.HIT_4.sound;
    }

    public void createDrop(int looting, DamageSource source, NonNullList<ItemStack> drops) {
        drops.add(MaterialsCC.WULFRUM_METAL_SCRAP.stack(UtilsCC.randBetweenInt(1, 2)));
        if (rand.nextInt(6) == 1) {
            drops.add(AccessoriesCC.WULFRUM_BATTERY.stack());
        }

        if (isSupercharged) {
            drops.add(MaterialsCC.ENERGY_CORE.stack());
        }
    }
}