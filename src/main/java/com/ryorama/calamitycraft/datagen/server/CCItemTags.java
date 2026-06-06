package com.ryorama.calamitycraft.datagen.server;

import com.ryorama.calamitycraft.init.CCAccessories;
import com.ryorama.calamitycraft.init.CCMaterials;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.confluence.mod.common.init.ModTags;
import org.confluence.terra_curio.common.init.TCTags;

import java.util.concurrent.CompletableFuture;

public class CCItemTags extends ItemTagsProvider {
    public CCItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> tagLookup) {
        super(packOutput, lookupProvider, tagLookup);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        IntrinsicTagAppender<Item> accessory = tag(TCTags.ACCESSORY);
        CCAccessories.REGISTRY.getEntries().forEach(itemDeferredHolder -> accessory.add(itemDeferredHolder.get()));
        tag(ModTags.Items.ANTIGRAVITY).add(CCMaterials.ESSENCE_OF_ELEUM.asItem(), CCMaterials.ESSENCE_OF_HAVOC.asItem(), CCMaterials.ESSENCE_OF_SUNLIGHT.asItem(), CCMaterials.YHARON_SOUL_FRAGMENT.get());
    }
}
