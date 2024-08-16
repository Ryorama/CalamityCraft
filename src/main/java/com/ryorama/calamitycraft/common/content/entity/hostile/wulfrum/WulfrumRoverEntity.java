package com.ryorama.calamitycraft.common.content.entity.hostile.wulfrum;

import com.ryorama.calamitycraft.common.content.entity.ai.behaviours.WulfrumRoverAI;
import com.ryorama.calamitycraft.init.SoundsCC;
import com.ryorama.calamitycraft.init.items.MaterialsCC;
import com.ryorama.calamitycraft.utils.UtilsCC;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import org.zeith.hammeranims.api.animsys.AnimationSystem;
import org.zeith.terraria.api.entity.IShowEntityHealth;
import org.zeith.terraria.common.content.entity.api.EntityProps;
import org.zeith.terraria.init.SoundsTC;

public class WulfrumRoverEntity extends WulfrumBaseEntity<WulfrumRoverAI> implements IShowEntityHealth {
    public WulfrumRoverEntity(World worldIn) {
        super(worldIn);
    }

    @Override
    public void setupSystem(AnimationSystem.Builder builder) {

    }

    @Override
    protected WulfrumRoverAI createAI() {
        return new WulfrumRoverAI(this);
    }

    @Override
    public float getHealthBarInfoOffsetY() {
        return 1.0F;
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

        if (isSupercharged) {
            drops.add(MaterialsCC.ENERGY_CORE.stack());
        }
    }
}