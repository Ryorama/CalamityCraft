package ryorama.calamity.world.passes;

import net.minecraft.util.math.BlockPos;
import org.lwjgl.Sys;
import org.zeith.terraria.common.data.world.world.WorldDataTC;
import org.zeith.terraria.init.BlocksTC;
import org.zeith.terraria.world.api.passes.CubeGenPass;
import org.zeith.terraria.world.api.passes.GenPass;
import org.zeith.terraria.world.api.passes.PassData;
import ryorama.calamity.blocks.BlocksC;

@GenPass(name = "sulphurous_sea_pass", priority = 100f)
public class SulphurousSeaBiomePass extends CubeGenPass {

    @Override
    public void populate(PassData passData) {
        WorldDataTC wd = WorldDataTC.get(passData.world);

        int currentXPos = -wd.getWorldSize().getWorldRadius();
        int currentZPos = -wd.getWorldSize().getWorldRadius();

        //System.out.println("X: " + currentXPos + " - Z: " + currentZPos);

        while (currentXPos < wd.getWorldSize().getWorldRadius()) {
            if (currentXPos > wd.getWorldSize().getWorldRadius() - 250) {
                for (int y = -wd.getWorldSize().getWorldHeight(); y < wd.getWorldSize().getWorldHeight(); y++) {
                    //System.out.println(y);
                    if (passData.world.getBlockState(new BlockPos(currentXPos, y, currentZPos)) == BlocksTC.SAND.getDefaultState()) {
                        //System.out.println("X: " + currentXPos + " - Z: " + currentZPos + " - Y: " + y);
                        passData.world.setBlockState(new BlockPos(currentXPos, y, currentZPos), BlocksC.SULPHUROUS_SAND.getDefaultState());
                    }
                }
            }
            currentXPos++;
            currentZPos++;
        }

        /*
        if (passData.generator) {
            passData.world.setBlockState(new BlockPos(passData.pos.getX(), passData.pos.getY(), passData.pos.getZ()), BlocksC.SULPHUROUS_SAND.getDefaultState());
        }
        */
    }
}
