package com.ryorama.calamitycraft.world.biomes;

import com.ryorama.calamitycraft.init.BlocksCC;
import org.zeith.terraria.InfoTC;
import org.zeith.terraria.api.client.music.MusicMood;
import org.zeith.terraria.common.content.biome.api.TerrariaBiome;
import org.zeith.terraria.init.BlocksTC;

public class BiomeSulphurousSea extends TerrariaBiome {
    @Override
    protected void initBiome() {
        this.isMinibiome = true;
        this.music.replaceNightMusic = true;
        this.music.replaceRainMusic = true;
        this.music.tolerateTownMusic = false;
        this.music.setAllMusic(MusicMood.of(0.75F, InfoTC.id("music/eerie")));
        this.blocks.add(BlocksCC.SULPHUROUS_SAND);
        this.blocks.add(BlocksCC.SULPHUROUS_SANDSTONE);
        this.blocks.add(BlocksCC.HARDENED_SULPHUROUS_SANDSTONE);
    }
}
