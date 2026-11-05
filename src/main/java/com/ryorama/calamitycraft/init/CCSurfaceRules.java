package com.ryorama.calamitycraft.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class CCSurfaceRules {
    public static SurfaceRules.RuleSource state(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static final SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
    private static final SurfaceRules.ConditionSource deepslateSeed = SurfaceRules.verticalGradient("minecraft:deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8));

    private static SurfaceRules.RuleSource sulphurousSeaSurface() {
        return SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, state(CCBlocks.SULPHUROUS_SAND.get())));
    }

    public static SurfaceRules.RuleSource makeCCOverWorldRules() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(CCBiomes.SULPHUROUS_SEA),
                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(deepslateSeed), state(CCBlocks.SULPHUROUS_SANDSTONE.get()))))
        );
    }
}
