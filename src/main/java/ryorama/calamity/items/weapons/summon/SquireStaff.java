package ryorama.calamity.items.weapons.summon;

import com.zeitheron.hammercore.raytracer.RayTracer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.zeith.terraria.api.core.TerrariaCraftAPI;
import org.zeith.terraria.api.enums.EnumDamageType;
import org.zeith.terraria.api.items.ILeftClickableItem;
import org.zeith.terraria.api.items.IWeapon;
import org.zeith.terraria.api.items.tabs.TabInfo;
import org.zeith.terraria.api.tooltip.ITooltipElement;
import org.zeith.terraria.api.tooltip.TooltipBody;
import org.zeith.terraria.common.content.entity.minions.MinionBabySlime;
import org.zeith.terraria.common.content.items.magic.ItemMagicTool;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.init.BuffsTC;
import org.zeith.terraria.init.SoundsTC;
import org.zeith.terraria.utils.Translator;
import ryorama.calamity.CreativeTabsC;

public class SquireStaff extends ItemMagicTool implements ILeftClickableItem, IWeapon {

    public SquireStaff() {
        this.setTranslationKey("squire_staff");
        this.setMaxStackSize(1);
        this.rarity = ItemRarity.WHITE;
        this.sellValue = 1000;
        this.inTab(new TabInfo[]{CreativeTabsC.TI_ITEMS_SUMMON});
    }


    //ToDo: Placeholder, swap out slime minion with the custom summon
    public void onLeftClick(EntityPlayer player, ItemStack swingStack) {
        player.swingArm(EnumHand.MAIN_HAND);
        PlayerDataTC.get(player).cooldown(this.getBaseUseTime());
        Vec3d spawn = player.getLook(1.0F);
        double reach = RayTracer.getBlockReachDistance(player) / 2.0;
        spawn = RayTracer.getCorrectedHeadVec(player).add(spawn.x * reach, spawn.y * reach, spawn.z * reach);
        RayTraceResult rtr = RayTracer.retrace(player);
        if (rtr != null && rtr.typeOfHit == RayTraceResult.Type.BLOCK) {
            spawn = (new Vec3d(rtr.getBlockPos().offset(rtr.sideHit))).add(0.5, 0.25, 0.5);
        }

        if (!player.world.isRemote && this.hasEnoughMana(player, 10.0F)) {
            this.tryUseMana(player, 10.0F);
            PlayerDataTC pd = PlayerDataTC.get(player);
            TerrariaCraftAPI.SOUNDS.playSound(SoundsTC.MINION_SUMMON, player.world, player.getPositionVector(), 1.0F, 1.0F, SoundCategory.PLAYERS);
            MinionBabySlime slime = new MinionBabySlime(player.world, player.getUniqueID());
            slime.setPositionAndUpdate(spawn.x, spawn.y, spawn.z);
            pd.minions().allocateMinion(slime);
            if (pd.minions().countMinionsOfType(MinionBabySlime.class) > 0) {
                pd.activeBuffs().applyBuff(BuffsTC.BABY_SLIME, 720020, 0);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void describeStack(ItemStack stack, TooltipBody lines, EntityPlayer player) {
        lines.append(new ITooltipElement[]{EnumDamageType.SUMMON.getTranslationTooltipElementCorrected(8)});
        lines.append(new ITooltipElement[]{Translator.tooltipE("uses_mana", new Object[]{10})});
    }

    @Override
    public float getCritChance(ItemStack itemStack, PlayerDataTC playerDataTC) {
        return 0;
    }

    @Override
    public int getBaseUseTime() {
        return 34;
    }
}
