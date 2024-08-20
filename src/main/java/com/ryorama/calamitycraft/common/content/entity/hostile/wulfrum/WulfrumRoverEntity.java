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

    public WulfrumRoverEntity(World worldIn) {
        super(worldIn);
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
        entityProps.lifeMax = 32;
        entityProps.damage = 10;
        entityProps.defense = isSupercharged ? 13 : 4;
        entityProps.knockBackResist = 85;
        entityProps.value = 115;
        entityProps.deathSound = SoundsCC.WULFRUM_DEATH.sound;
        entityProps.hitSound = SoundsTC.HIT_4.sound;
    }
    
    @Override
    public void createDrop(int looting, DamageSource source, NonNullList<ItemStack> drops) {
        super.createDrop(looting, source, drops);
    }
}