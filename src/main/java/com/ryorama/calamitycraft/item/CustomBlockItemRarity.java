package com.ryorama.calamitycraft.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.block.Block;
import org.confluence.lib.ConfluenceMagicLib;
import org.confluence.lib.common.component.ModRarity;

import java.util.function.Consumer;

public class CustomBlockItemRarity extends BlockItem {
    protected ItemAttributeModifiers modifiers;

    public CustomBlockItemRarity(Block block, Properties properties) {
        this(block, properties, ModRarity.GRAY);
    }

    public CustomBlockItemRarity(Block block, Properties properties, ModRarity rarity) {
        super(block, properties.component(ConfluenceMagicLib.MOD_RARITY, rarity));
    }

    public CustomBlockItemRarity addAttributeModifiers(Consumer<ItemAttributeModifiers.Builder> consumer) {
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        consumer.accept(builder);
        this.modifiers = builder.build();
        return this;
    }

    public ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        return this.modifiers == null ? super.getDefaultAttributeModifiers(stack) : this.modifiers;
    }
}
