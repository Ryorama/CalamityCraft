package com.ryorama.calamitycraft.datagen.server.recipes;

import com.ryorama.calamitycraft.init.CCAccessories;
import com.ryorama.calamitycraft.init.CCMaterials;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import org.confluence.mod.common.data.map.ExtractinatorData;
import org.confluence.mod.common.init.ModDataMaps;
import org.confluence.mod.mixin.accessor.DataMapProviderAccessor;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public final class CalamityCraftDataMapProvider extends DataMapProvider {
    public CalamityCraftDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        CalamityCraftDataMapProvider.extractinator(() -> builder(ModDataMaps.EXTRACTINATOR));
    }

    public static void extractinator(CalamityCraftDataMapProvider.Appender<DataMapProvider.Builder<ExtractinatorData, Item>> appender) {
        appender.create().add(CCAccessories.WULFRUM_BATTERY, ExtractinatorData.builder()
                .withPool(ExtractinatorData.Pool.builder()
                        .add(ExtractinatorData.Entry.of(CCMaterials.ENERGY_CORE.get(), 1, 20))
                        .add(ExtractinatorData.Entry.of(CCMaterials.WULFRUM_METAL_SCRAP.get(), 3, 5, 80))
                ).build(), false);
    }

    @SuppressWarnings("unchecked")
    protected <T, R, B extends DataMapProvider.Builder<T, R>> Appender<B> builder(DataMapType<R, T> type, Supplier<B> supplier) {
        return () -> (B) ((DataMapProviderAccessor)(Object) this).getBuilders().computeIfAbsent(type, dataMapType -> supplier.get());
    }

    @FunctionalInterface
    public interface Appender<T extends DataMapProvider.Builder<?, ?>> {
        T create();
    }
}