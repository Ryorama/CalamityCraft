package ryorama.calamity.mixins;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.zeith.terraria.api.world.WorldSize;
import org.zeith.terraria.common.data.world.world.WorldDataTC;
import org.zeith.terraria.init.BlocksTC;
import org.zeith.terraria.world.surface.ChunkGeneratorTerraria;
import ryorama.calamity.blocks.BlocksC;

@Mixin(ChunkGeneratorTerraria.class)
public class MixinChunkGeneratorTerraria {

    @Shadow
    private World world;

    @Inject(at = @At("TAIL"), method = "populate")
    public void populate(int x, int z, CallbackInfo ci) {
        WorldDataTC wd = WorldDataTC.get(world);
        for (int y = 0; y < -wd.worldSize.getWorldHeight(); y++) {
            if (world.getBlockState(new BlockPos(x, y, z)) == BlocksTC.SAND.getDefaultState()) {
                world.setBlockState(new BlockPos(x, y, z), BlocksC.SULPHUROUS_SAND.getDefaultState());
            }
        }
    }
}
