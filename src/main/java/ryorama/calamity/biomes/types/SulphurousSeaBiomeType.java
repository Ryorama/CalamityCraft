package ryorama.calamity.biomes.types;

import net.minecraft.util.ResourceLocation;
import org.zeith.terraria.api.world.WorldBiomeType;
import org.zeith.terraria.init.BlocksTC;
import ryorama.calamity.blocks.BlocksC;
import ryorama.calamity.init.BiomesC;

public class SulphurousSeaBiomeType extends WorldBiomeType {

    public SulphurousSeaBiomeType() {
        super(new ResourceLocation("calamity", "sulphurous_sea_biome_type"), new WorldBiomeType.Climate(1.0F, 1.0F, 0.0F));
        this.surroundBiome = BiomesC.SULPHUROUS_SEA_BIOME;
    }

    @Override
    protected void initBlocks() {
        mapBiomeBlock(BlocksTC.SAND.getDefaultState(), BlocksC.SULPHUROUS_SAND.getDefaultState());
        mapBiomeBlock(BlocksTC.SANDSTONE.getDefaultState(), BlocksC.SULPHUROUS_SANDSTONE.getDefaultState());
    }
}
