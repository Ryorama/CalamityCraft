package ryorama.calamity.init;

import org.zeith.terraria.common.content.biome.api.TerrariaBiomeRegistry;
import ryorama.calamity.biomes.SulphurousSeaBiome;

public class BiomesC {
    public static final SulphurousSeaBiome SULPHUROUS_SEA_BIOME = new SulphurousSeaBiome();

    public static void init() {
        TerrariaBiomeRegistry.registerBiome(SULPHUROUS_SEA_BIOME);
    }
}
