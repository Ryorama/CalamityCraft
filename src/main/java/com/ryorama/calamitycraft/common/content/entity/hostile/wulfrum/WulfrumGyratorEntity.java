package com.ryorama.calamitycraft.common.content.entity.hostile.wulfrum;

import com.ryorama.calamitycraft.common.content.entity.ai.behaviours.WulfrumGyratorAI;
import com.ryorama.calamitycraft.common.content.entity.ai.behaviours.WulfrumRoverAI;
import com.ryorama.calamitycraft.init.SoundsCC;
import com.ryorama.calamitycraft.init.items.AccessoriesCC;
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

public class WulfrumGyratorEntity extends WulfrumBaseEntity<WulfrumGyratorAI> implements IShowEntityHealth {
    public WulfrumGyratorEntity(World worldIn) {
        super(worldIn);
    }

    @Override
    public void setupSystem(AnimationSystem.Builder builder) {

    }

    @Override
    protected WulfrumGyratorAI createAI() {
        return new WulfrumGyratorAI(this);
    }

    @Override
    public float getHealthBarInfoOffsetY() {
        return 1.5F;
    }

    @Override
    public void initProps(EntityProps entityProps) {
        entityProps.noGravity = false;
        entityProps.lifeMax = 18;
        entityProps.damage = 15;
        entityProps.defense = 5;
        entityProps.knockBackResist = 15;
        entityProps.value = 115;
        entityProps.deathSound = SoundsCC.WULFRUM_DEATH.sound;
        entityProps.hitSound = SoundsTC.HIT_4.sound;
        this.setScale(2);
    }
}
