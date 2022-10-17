package ryorama.calamity.biomes;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.zeith.terraria.common.content.biome.api.BiomeSky;
import org.zeith.terraria.common.content.biome.api.TerrariaBiome;
import org.zeith.terraria.common.data.world.world.WorldDataTC;
import org.zeith.terraria.compat.mccue.rgb.DotNetColors;
import org.zeith.terraria.init.biomes.BiomeTypesTC;
import org.zeith.terraria.utils.math.Vector4;
import ryorama.calamity.Calamity;
import ryorama.calamity.blocks.BlocksC;
import ryorama.calamity.init.BiomeTypesC;

public class SulphurousSeaBiome extends TerrariaBiome {

    public SulphurousSeaBiome() {
        super(new ResourceLocation("calamity", "sulphurous_sea"));
    }

    @Override
    protected void initBiome() {
        this.music.replaceNightMusic = true;
        this.weather.waterColor = Vector4.rgb2vec(62217145);
        this.music.setSurfaceMusic(new ResourceLocation("terraria", "music/desert"));
        this.music.setUndergroundMusic(new ResourceLocation("terraria", "music/desert_underground"));
        this.weather.isSandy = true;
        this.blocks.add(BlocksC.SULPHUROUS_SAND);
        this.blocks.add(BlocksC.SULPHUROUS_SANDSTONE);
        this.ampBiomeType = BiomeTypesC.SULPHUROUS_SEA_BIOME_TYPE;
        this.sky = new BiomeSky();
        this.sky.skyColor = new DotNetColors.DNColor(62217145);
        this.sky.fogColor = new DotNetColors.DNColor(62217145);
    }
}
