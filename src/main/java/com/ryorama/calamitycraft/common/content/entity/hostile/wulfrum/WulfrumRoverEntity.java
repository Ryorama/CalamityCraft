package com.ryorama.calamitycraft.common.content.entity.hostile.wulfrum;

import com.ryorama.calamitycraft.common.content.entity.ai.behaviours.WulfrumRoverAI;
import net.minecraft.world.World;
import org.zeith.hammeranims.api.animsys.AnimationSystem;
import org.zeith.terraria.common.content.entity.api.EntityProps;

public class WulfrumRoverEntity extends WulfrumBaseEntity<WulfrumRoverAI> {
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
    public void initProps(EntityProps entityProps) {
        entityProps.noGravity = true;
        entityProps.lifeMax = 32;
        entityProps.damage = 10;
        entityProps.defense = isSupercharged ? 13 : 4;
        entityProps.knockBackResist = 85;
        entityProps.deathSound = null;

        //ToDo: NPCHit4 for hit sound
        //entityProps.hitSound = null;
    }
}
