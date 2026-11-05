package com.ryorama.calamitycraft.datacomponents;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.Nullable;

public class BlightedGelVariantComponent implements DataComponentType<BlightedGelVariantComponent> {
    public record BlightedGelVariant(int worldEvil) {}

    public static final Codec<BlightedGelVariantComponent.BlightedGelVariant> BLIGHTED_GEL_VARIANT_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("value1").forGetter(BlightedGelVariantComponent.BlightedGelVariant::worldEvil)
            ).apply(instance, BlightedGelVariantComponent.BlightedGelVariant::new)
    );
    public static final StreamCodec<ByteBuf, BlightedGelVariantComponent.BlightedGelVariant> BLIGHTED_GEL_VARIANT_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, BlightedGelVariantComponent.BlightedGelVariant::worldEvil,
            BlightedGelVariantComponent.BlightedGelVariant::new
    );

    @Override
    public @Nullable Codec codec() {
        return BLIGHTED_GEL_VARIANT_CODEC;
    }

    @Override
    public StreamCodec streamCodec() {
        return BLIGHTED_GEL_VARIANT_STREAM_CODEC;
    }
}
