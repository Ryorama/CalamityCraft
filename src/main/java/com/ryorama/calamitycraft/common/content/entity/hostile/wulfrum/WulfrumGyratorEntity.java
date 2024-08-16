package com.ryorama.calamitycraft.common.content.entity.hostile.wulfrum;

import com.ryorama.calamitycraft.common.content.entity.ai.behaviours.WulfrumGyratorAI;
import com.ryorama.calamitycraft.common.content.entity.ai.behaviours.WulfrumRoverAI;
import com.ryorama.calamitycraft.init.SoundsCC;
import net.minecraft.world.World;
import org.zeith.hammeranims.api.animsys.AnimationSystem;
import org.zeith.terraria.common.content.entity.api.EntityProps;
import org.zeith.terraria.init.SoundsTC;

public class WulfrumGyratorEntity extends WulfrumBaseEntity<WulfrumGyratorAI> {
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
    public void initProps(EntityProps entityProps) {
        entityProps.noGravity = true;
        entityProps.lifeMax = 18;
        entityProps.damage = 15;
        entityProps.defense = 5;
        entityProps.knockBackResist = 15;
        entityProps.deathSound = SoundsCC.WULFRUM_DEATH.sound;
        entityProps.hitSound = SoundsTC.HIT_4.sound;
    }
}
