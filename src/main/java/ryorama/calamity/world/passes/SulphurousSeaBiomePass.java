package ryorama.calamity.world.passes;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.Sys;
import org.zeith.terraria.common.content.biome.api.BiomeSelectEvent;
import org.zeith.terraria.common.content.biome.api.TerrariaBiome;
import org.zeith.terraria.common.data.world.world.WorldDataTC;
import org.zeith.terraria.init.BlocksTC;
import org.zeith.terraria.world.api.passes.CubeGenPass;
import org.zeith.terraria.world.api.passes.GenPass;
import org.zeith.terraria.world.api.passes.PassData;
import ryorama.calamity.blocks.BlocksC;
import ryorama.calamity.init.BiomesC;

@GenPass(name = "sulphurous_sea_pass", priority = 100f)
public class SulphurousSeaBiomePass extends CubeGenPass {

    @Override
    public void populate(PassData passData) {

    }
}
