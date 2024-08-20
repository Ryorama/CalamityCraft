package com.ryorama.calamitycraft;

import com.ryorama.calamitycraft.common.LootTablesCC;
import com.ryorama.calamitycraft.common.events.EntityEvents;
import com.ryorama.calamitycraft.init.SoundsCC;
import com.ryorama.calamitycraft.init.TagsCC;
import com.ryorama.calamitycraft.init.biomes.BiomeTypesCC;
import com.ryorama.calamitycraft.proxy.CommonProxy;
import com.zeitheron.hammercore.HammerCore;
import lombok.Getter;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zeith.hammerlib.util.mcf.Resources;
import org.zeith.terraria.TerrariaCraft;
import org.zeith.terraria.api.crafting.ExtractinatorManager;
import org.zeith.terraria.api.entity.reg.EntityCounter;
import org.zeith.terraria.api.events.world.crafting.RegisterCraftingEvent;
import org.zeith.terraria.api.mod.ITerrariaMod;
import org.zeith.terraria.common.loot.TerraLootManager;
import org.zeith.terraria.init.TagsTC;

@Mod(
		modid = CalamityCraft.MODID,
		name = CalamityCraft.NAME,
		version = "@VERSION@", // This gets automatically replaced with actual version from build.txt when compiling the mod into jarfile.
		dependencies = "required-after:terraria"
)
public class CalamityCraft
		implements ITerrariaMod
{
	public static final Logger LOG = LogManager.getLogger("CalamityCraft");
	public static EventBus EVENT_BUS = MinecraftForge.EVENT_BUS;
	public static final String MODID = "calamitycraft";
	public static final String NAME = "CalamityCraft";
	
	@Getter
	private static EntityCounter entityCounter;
	
	@SidedProxy( // TODO: Update package names whenever you refactor!
			clientSide = "com.ryorama.calamitycraft.proxy.ClientProxy",
			serverSide = "com.ryorama.calamitycraft.proxy.CommonProxy",
			modId = MODID
	)
	public static CommonProxy PROXY;
	
	public CalamityCraft()
	{
		entityCounter = new EntityCounter(this);
		
		// Used to add custom recipes
		TerrariaCraft.EVENT_BUS.register(this);
	}
	
	public static ResourceLocation id(String id)
	{
		return Resources.location(MODID, id);
	}
	
	@EventHandler
	public void construction(FMLConstructionEvent event)
	{
		// This is very recommended for common addon setup.
		ITerrariaMod.super.constructionEvent(event);
		
		// Pass construction to proxies.
		EVENT_BUS.register(PROXY);
		PROXY.construct();
		
		LOG.info("Constructed.");
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// This performs registration of things in time!
		HammerCore.registerKernelsForMod(MODID);
		SoundsCC.register();
		BiomeTypesCC.init();
		TagsCC.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ExtractinatorManager.bindMaterial(TagsCC.Items.WULFRUM_BATTERY, LootTablesCC.WULFRUM_BATTERY);
	}
	
	@SubscribeEvent
	public void addRecipes(RegisterCraftingEvent e)
	{

	}
	
	// This is left like so intentionally.
	// When compiled, will get replaced by "12.5.1".contains("@VERSION") thus returning FALSE
	@SuppressWarnings("ConstantValue")
	public static final boolean IN_DEV = "@VERSION@".contains("@VERSION");
}