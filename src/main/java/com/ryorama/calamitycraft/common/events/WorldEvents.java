package com.ryorama.calamitycraft.common.events;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.init.OresCC;
import com.ryorama.calamitycraft.utils.UtilsCC;
import com.zeitheron.hammercore.world.gen.WorldGenMinableHC;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.zeith.terraria.api.events.world.gen.FloatingIslandGenerateEvent;
import org.zeith.terraria.init.BlocksTC;

@Mod.EventBusSubscriber
public class WorldEvents {

    @SubscribeEvent
    public static void generateAerialiteOre(FloatingIslandGenerateEvent e) {
        World data = e.getWorld();
        BlockPos pos = e.getCenterPos();

        for (int x = (int) -e.getRadius(); x <= e.getRadius(); x++) {
            for (int z = (int) -e.getRadius(); z <= e.getRadius(); z++) {
                int finalX = x;
                int finalZ = z;
                if (data.rand.nextInt(4) == 0) {
                    UtilsCC.generateOre(data, data.rand, new BlockPos(pos.getX() - x, pos.getY(), pos.getZ() - z), 8, OresCC.AERIALITE_ORE_DISENCHANTED.getDefaultState(), (s) -> {
                        System.out.println("Gen Ore Pos: " + new BlockPos(pos.getX() - finalX, pos.getY(), pos.getZ() - finalZ));
                        return s.getBlock() == BlocksTC.CLOUD || s.getBlock() == BlocksTC.RAIN_CLOUD;
                    });
                }
            }
        }
    }
}
