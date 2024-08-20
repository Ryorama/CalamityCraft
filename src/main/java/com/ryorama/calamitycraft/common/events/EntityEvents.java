package com.ryorama.calamitycraft.common.events;

import com.ryorama.calamitycraft.init.items.MaterialsCC;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.zeith.terraria.api.events.CreateAuxiliaryDropsEvent;
import org.zeith.terraria.init.EntityTypesTC;

@Mod.EventBusSubscriber
public class EntityEvents {
    @SubscribeEvent
    public static void createEntityDrops(CreateAuxiliaryDropsEvent e) {
        if (EntityTypesTC.BLOOD_ZOMBIE.is(e.getEntity()) || EntityTypesTC.DRIPPLER.is(e.getEntity())) {
            if (e.player.random.nextInt(100) <= 25) {
                e.stack.add(1, MaterialsCC.BLOOD_ORB.stack());
            }
        }
    }
}
