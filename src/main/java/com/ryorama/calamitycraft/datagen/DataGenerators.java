package com.ryorama.calamitycraft.datagen;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.datagen.server.CCBlockTags;
import com.ryorama.calamitycraft.datagen.server.CCItemTags;
import com.ryorama.calamitycraft.datagen.server.recipes.CalamityCraftDataMapProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = CalamityCraft.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void registerDataGenerators(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        if (event.includeServer()) {
            CCBlockTags blockTags = generator.addProvider(event.includeServer(), new CCBlockTags(packOutput, event.getLookupProvider(), fileHelper));

            generator.addProvider(true, new CCItemTags(packOutput, event.getLookupProvider(), blockTags.contentsGetter()));
            generator.addProvider(true, new CalamityCraftDataMapProvider(packOutput, lookupProvider));
        }
    }
}
