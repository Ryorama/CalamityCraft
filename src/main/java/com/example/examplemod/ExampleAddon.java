package com.example.examplemod;

import com.example.examplemod.init.BlocksEM;
import com.example.examplemod.proxy.CommonProxy;
import com.zeitheron.hammercore.HammerCore;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.*;
import org.zeith.terraria.api.crafting.events.RegisterCraftingEvent;
import org.zeith.terraria.api.mod.ITerrariaMod;
import org.zeith.terraria.init.ItemsTC;

@Mod(
		modid = ExampleAddon.MODID,
		name = ExampleAddon.NAME,
		version = "@VERSION@", // This gets automatically replaced with actual version from build.txt when compiling the mod into jarfile.
		dependencies = "required-after:terraria"
)
public class ExampleAddon
		implements ITerrariaMod
{
	public static final Logger LOG = LogManager.getLogger("ExampleAddon");
	
	public static final String MODID = "examplemod";
	public static final String NAME = "Example Mod";
	
	@SidedProxy( // TODO: Update package names whenever you refactor!
			clientSide = "com.example.examplemod.proxy.ClientProxy",
			serverSide = "com.example.examplemod.proxy.CommonProxy",
			modId = MODID
	)
	public static CommonProxy PROXY;
	
	public ExampleAddon()
	{
		// Used to add custom recipes
		MinecraftForge.EVENT_BUS.register(this);
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
	}
	
	@SubscribeEvent
	public void addRecipes(RegisterCraftingEvent e)
	{
		e.addHeavyWorkBenchRecipe(BlocksEM.EXAMPLE_BAR.stack(), BlocksEM.EXAMPLE_BLOCK.stack(4));
		e.addHandRecipe(BlocksEM.EXAMPLE_TORCH.stack(3), BlocksEM.EXAMPLE_BLOCK.stack(), ItemsTC.GEL.stack());
	}
	
	// This is left like so intentionally.
	// When compiled, will get replaced by "12.5.1".contains("@VERSION") thus returning FALSE
	@SuppressWarnings("ConstantValue")
	public static final boolean IN_DEV = "@VERSION@".contains("@VERSION");
}