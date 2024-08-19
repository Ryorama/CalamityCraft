package com.ryorama.calamitycraft.common.content.items.accessories;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.common.content.items.accessories.typed.IWulfrumBattery;
import com.zeitheron.hammercore.utils.forge.RegisterHook;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.zeith.terraria.api.enums.EnumDamageType;
import org.zeith.terraria.api.events.calc.GetDamageAffectEvent;
import org.zeith.terraria.common.content.items.base.ItemBaseArtifactTC;
import org.zeith.terraria.common.data.player.PlayerDataTC;

public class ItemWulfrumBattery extends ItemBaseArtifactTC implements IWulfrumBattery {
    @RegisterHook
    private void subscribe() {
        CalamityCraft.EVENT_BUS.register(this);
    }
    
    @Override
    public boolean isEquipped(PlayerDataTC pd)  {
        return !pd.artifactInventory.find(s -> s.getItem() instanceof IWulfrumBattery).isEmpty();
    }
    
    @SubscribeEvent
    public void increaseDamage(GetDamageAffectEvent e) {
        if(e.damageType != EnumDamageType.SUMMON || !isEquipped(e.getPlayerData())) return;
        // NB: the addTag method deduplicates the effect so it does not stack.
        // TLDR: 'tags' inside events are a one-time-add thing.
        // To implement stacking, simply use a different key, or avoid using tags altogether!
        //                                  - Zeith
        if(e.addTag("calamitycraft:wulfrum_battery")) e.mult(0.07F);
    }
}
