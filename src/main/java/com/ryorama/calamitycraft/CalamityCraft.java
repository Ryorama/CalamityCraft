package com.ryorama.calamitycraft;

import com.ryorama.calamitycraft.init.biomes.BiomeTypesCC;
import com.ryorama.calamitycraft.proxy.CommonProxy;
import com.zeitheron.hammercore.HammerCore;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zeith.hammerlib.util.mcf.Resources;
import org.zeith.terraria.TerrariaCraft;
import org.zeith.terraria.api.events.world.crafting.RegisterCraftingEvent;
import org.zeith.terraria.api.mod.ITerrariaMod;

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
	
	public static final String MODID = "calamitycraft";
	public static final String NAME = "CalamityCraft";
	
	@SidedProxy( // TODO: Update package names whenever you refactor!
			clientSide = "com.ryorama.calamitycraft.proxy.ClientProxy",
			serverSide = "com.ryorama.calamitycraft.proxy.CommonProxy",
			modId = MODID
	)
	public static CommonProxy PROXY;
	
	public CalamityCraft()
	{
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
		PROXY.construct();
		
		LOG.info("Constructed.");
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// This performs registration of things in time!
		HammerCore.registerKernelsForMod(MODID);
		
		BiomeTypesCC.init();
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