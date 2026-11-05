package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.CalamityCraft;
import com.ryorama.calamitycraft.block.materials.EnergyCoreBlock;
import com.ryorama.calamitycraft.item.CustomBlockItemRarity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.lib.common.component.ModRarity;

import java.util.function.Supplier;

public class CCBlocks {
    public static final DeferredRegister.Blocks BLOCK_REGISTRY = DeferredRegister.createBlocks(CalamityCraft.MODID);
    public static final DeferredRegister.Items ITEM_REGISTRY = DeferredRegister.createItems(CalamityCraft.MODID);

    public static final DeferredBlock<Block> ABYSS_GRAVEL = registerDefaultBlockWithItem("abyss_gravel", BlockBehaviour.Properties.ofFullCopy(Blocks.GRAVEL), new Item.Properties());
    public static final DeferredBlock<Block> HARDENED_SULPHUROUS_SANDSTONE = registerDefaultBlockWithItem("hardened_sulphurous_sandstone", BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE), new Item.Properties());
    public static final DeferredBlock<Block> PLANTY_MUSH = registerDefaultBlockWithItem("planty_mush", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), new Item.Properties());
    public static final DeferredBlock<Block> PYRE_MANTLE = registerDefaultBlockWithItem("pyre_mantle", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), new Item.Properties());
    public static final DeferredBlock<Block> SULPHUROUS_SAND = registerDefaultBlockWithItem("sulphurous_sand", BlockBehaviour.Properties.ofFullCopy(Blocks.SAND), new Item.Properties());
    public static final DeferredBlock<Block> SULPHUROUS_SANDSTONE = registerDefaultBlockWithItem("sulphurous_sandstone", BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE), new Item.Properties());
    public static final DeferredBlock<Block> SULPHUROUS_SHALE = registerDefaultBlockWithItem("sulphurous_shale", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), new Item.Properties());
    public static final DeferredBlock<Block> VOIDSTONE = registerDefaultBlockWithItem("voidstone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), new Item.Properties());

    public static final DeferredBlock<Block> ENERGY_CORE = registerBlockWithItemRarity("materials/energy_core", EnergyCoreBlock::new, new Item.Properties(), ModRarity.BLUE);

    public static DeferredBlock<Block> registerBlockWithItem(String name, Supplier<Block> supplier, Item.Properties itemProperties) {
        DeferredBlock<Block> block = BLOCK_REGISTRY.register(name, supplier);
        ITEM_REGISTRY.register(name, () -> new BlockItem(block.get(), itemProperties));
        return block;
    }

    public static DeferredBlock<Block> registerBlockWithItemRarity(String name, Supplier<Block> supplier, Item.Properties itemProperties, ModRarity rarity) {
        DeferredBlock<Block> block = BLOCK_REGISTRY.register(name, supplier);
        ITEM_REGISTRY.register(name, () -> new CustomBlockItemRarity(block.get(), itemProperties, rarity));
        return block;
    }

    public static DeferredBlock<Block> registerDefaultBlockWithItem(String name, BlockBehaviour.Properties blockProperties, Item.Properties itemProperties) {
        DeferredBlock<Block> block = BLOCK_REGISTRY.register(name, () -> new Block(blockProperties));
        ITEM_REGISTRY.register(name, () -> new BlockItem(block.get(), itemProperties));
        return block;
    }

    public static DeferredBlock<Block> registerDefaultBlockWithItemRarity(String name, BlockBehaviour.Properties blockProperties, Item.Properties itemProperties, ModRarity rarity) {
        DeferredBlock<Block> block = BLOCK_REGISTRY.register(name, () -> new Block(blockProperties));
        ITEM_REGISTRY.register(name, () -> new CustomBlockItemRarity(block.get(), itemProperties, rarity));
        return block;
    }
}
