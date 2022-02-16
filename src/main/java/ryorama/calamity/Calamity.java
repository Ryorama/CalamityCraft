package ryorama.calamity;

import com.zeitheron.hammercore.internal.SimpleRegistration;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.zeith.terraria.TerrariaCraft;
import org.zeith.terraria.api.crafting.events.RegisterCraftingEvent;
import org.zeith.terraria.api.crafting.predicate.CraftingPredicateFurnace;
import org.zeith.terraria.api.mod.ITerrariaMod;
import org.zeith.terraria.common.content.biome.api.TerrariaBiomeRegistry;
import org.zeith.terraria.common.content.biome.impl.SurfaceBiomeEntity;
import org.zeith.terraria.common.content.entity.api.EntityGenericTerrariaMob;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.common.data.world.world.WorldDataTC;
import org.zeith.terraria.init.BlocksTC;
import org.zeith.terraria.init.biomes.BiomesTC;
import org.zeith.terraria.init.items.CrittersTC;
import org.zeith.terraria.init.items.ItemsTC;
import org.zeith.terraria.utils.Luck;
import org.zeith.terraria.utils.forge.DeferredRegistries;
import ryorama.calamity.biomes.SulphurousSeaBiome;
import ryorama.calamity.blocks.BlocksC;
import ryorama.calamity.client.Commonproxy;
import ryorama.calamity.entities.hostile.WulfrumDrone;
import ryorama.calamity.entities.slimes.WulfrumSlime;
import ryorama.calamity.items.ItemsC;
import ryorama.calamity.items.ToolsC;
import ryorama.calamity.items.WeaponsC;
import org.zeith.terraria.common.data.player.BasePlayerDataTC;

@Mod(
   modid = "calamity",
   name = "CalamityCraft",
   version = "1.2",
   useMetadata = false,
   dependencies = "required-after:terraria",
   acceptedMinecraftVersions = "[1.12.2]"
)
@Mod.EventBusSubscriber
public class Calamity implements ITerrariaMod {
   private static int nextEntityID;
   @SidedProxy(
      modId = "calamity",
      clientSide = "ryorama.calamity.client.ClientProxy",
      serverSide = "ryorama.calamity.client.Commonproxy"
   )
   public static Commonproxy proxy;
   @Instance("calamity")
   public static Calamity instance;

   public final DeferredRegistries REG = new DeferredRegistries(this);

   public static final SulphurousSeaBiome SulphurousSea = new SulphurousSeaBiome();

   @EventHandler
   public void preInit(FMLPreInitializationEvent event) {
      MinecraftForge.EVENT_BUS.register(instance);
      proxy.preInit();
      SimpleRegistration.registerFieldItemsFrom(ItemsC.class, "calamity", CreativeTabsC.TAB_ITEMS_CC);
      SimpleRegistration.registerFieldBlocksFrom(BlocksC.class, "calamity", CreativeTabsC.TAB_ITEMS_CC);
      SimpleRegistration.registerFieldItemsFrom(WeaponsC.class, "calamity", CreativeTabsC.TAB_ITEMS_CC);
      SimpleRegistration.registerFieldItemsFrom(ToolsC.class, "calamity", CreativeTabsC.TAB_ITEMS_CC);
      EntityRegistry.registerModEntity(new ResourceLocation("calamity", "wulfrum_slime"), WulfrumSlime.class, "calamity:wulfrum_slime", ++nextEntityID, instance, 64, 1, true, 16777215, 15198183);
      EntityRegistry.registerModEntity(new ResourceLocation("calamity", "wulfrum_drone"), WulfrumDrone.class, "calamity:wulfrum_drone", ++nextEntityID, instance, 64, 1, true, 16777215, 15198183);
      TerrariaBiomeRegistry.registerSpawnableEntity((new SurfaceBiomeEntity(0.1F, (w, pos) -> {
         Block d = w.getBlockState(pos.down()).getBlock();
         return TerrariaCraft.isDaytime(w) && (d == BlocksTC.GRASS_FOREST || d == BlocksTC.STONE);
      }, WulfrumDrone::new, true)).setBiome(BiomesTC.FOREST));
      TerrariaBiomeRegistry.registerSpawnableEntity((new SurfaceBiomeEntity(0.4F, (w, pos) -> {
         Block d = w.getBlockState(pos.down()).getBlock();
         return TerrariaCraft.isDaytime(w) && (d == BlocksTC.GRASS_FOREST || d == BlocksTC.STONE);
      }, WulfrumSlime::new, true)).setBiome(BiomesTC.FOREST));

      TerrariaBiomeRegistry.registerBiome(SulphurousSea);
   }

   @EventHandler
   public void Init(FMLInitializationEvent event) {
      BasePlayerDataTC.register("calamity:health", LifeExpansionManager.class, LifeExpansionManager::new);
   }

   @SubscribeEvent
   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
      if (!event.player.world.isRemote) {
         PlayerDataTC pd = PlayerDataTC.get(event.player);

         if(pd != null && pd.givenItems.markGiven(ItemsC.STARTER_BAG)) {
            pd.giveOrDrop(ItemsC.STARTER_BAG.stack(1));
         }
      }
   }

   @SubscribeEvent
   public static void onPlayerJoin(EntityJoinWorldEvent event) {
      WorldDataTC wd = WorldDataTC.get(event.getWorld());

      System.out.println(wd.getWorldSize().getWorldRadius());
   }

   @SubscribeEvent
   public static void onEntityDeath(LivingDeathEvent event) {
      if (WorldDataTC.get(event.getEntity().getEntityWorld()).isEventActive(WorldDataTC.EventIDs.BLOOD_MOON)) {
         if (Luck.rollLuckZero(event.getSource(), 5)) {
            event.getEntity().dropItem(ItemsC.BLOOD_ORB, 1);
         }
      }
   }

   @SubscribeEvent
   public static void createRecipes(RegisterCraftingEvent event) {
      event.addSmeltingRecipe(BlocksC.AERIALITE_BAR.stack(), CraftingPredicateFurnace.EnumFurnaceTier.ANY, BlocksC.AERIALITE_ORE.stack(5));
      event.addSmeltingRecipe(BlocksC.PERENNIAL_BAR.stack(), CraftingPredicateFurnace.EnumFurnaceTier.HARDMODE, BlocksC.PERENNIAL_ORE.stack(5));

      //Extra vanilla recipes
      event.addPrehardmodeAnvilRecipe(ItemsTC.AGLET.stack(), BlocksTC.IRON_BAR.stack(5));
      event.addPrehardmodeAnvilRecipe(ItemsTC.AGLET.stack(), BlocksTC.LEAD_BAR.stack(5));
      event.addPrehardmodeAnvilRecipe(ItemsTC.BLIZZARD_IN_A_BOTTLE.stack(), ItemsTC.FEATHER.stack(4), BlocksTC.EMPTY_BOTTLE.stack(1), BlocksTC.SNOW.stack(50));
      event.addPrehardmodeAnvilRecipe(ItemsTC.CLOUD_IN_A_BOTTLE.stack(), ItemsTC.FEATHER.stack(2), BlocksTC.EMPTY_BOTTLE.stack(1), BlocksTC.CLOUD.stack(25));
      event.addPrehardmodeAnvilRecipe(ItemsTC.WATER_WALKING_BOOTS.stack(), ItemsTC.WATER_WALKING_POTION.stack(8), ItemsTC.LEATHER.stack(5));
      //event.addPrehardmodeAnvilRecipe(ItemsTC.LAVA_CHARM.stack(), Items.LAVA_BUCKET, 5), BlocksTC.OBSIDIAN, 25), BlocksTC.IRON_BAR, 5));
      //event.addPrehardmodeAnvilRecipe(ItemsTC.LAVA_CHARM.stack(), Items.LAVA_BUCKET, 5), BlocksTC.OBSIDIAN, 25), BlocksTC.LEAD_BAR, 5));
      event.addPrehardmodeAnvilRecipe(ItemsTC.LUCKY_HORSESHOE.stack(), BlocksTC.SUNPLATE_BLOCK.stack(10), BlocksTC.CLOUD.stack(10), BlocksTC.GOLD_BAR.stack(5));
      event.addPrehardmodeAnvilRecipe(ItemsTC.LUCKY_HORSESHOE.stack(), BlocksTC.SUNPLATE_BLOCK.stack(10), BlocksTC.CLOUD.stack(10), BlocksTC.PLATINUM_BAR.stack(5));
      event.addPrehardmodeAnvilRecipe(ItemsTC.FROG_LEG.stack(), CrittersTC.FROG.stack(16));
      event.addPrehardmodeAnvilRecipe(ItemsTC.HERMES_BOOTS.stack(), ItemsTC.SILK.stack(10), ItemsTC.SWIFTNESS_POTION.stack(2));
      event.addPrehardmodeAnvilRecipe(ItemsTC.FLOWER_BOOTS.stack(), ItemsTC.SILK.stack(7), ItemsTC.JUNGLE_ROSE.stack(1), ItemsTC.JUNGLE_GRASS_SEEDS.stack(5));
      event.addPrehardmodeAnvilRecipe(ItemsTC.OBSIDIAN_ROSE.stack(), BlocksTC.OBSIDIAN.stack(10), ItemsTC.JUNGLE_ROSE.stack(1), BlocksTC.HELLSTONE_ORE.stack(10));
      event.addPrehardmodeAnvilRecipe(BlocksTC.LIFE_CRYSTAL.stack(), BlocksTC.STONE.stack(5), ItemsTC.HEALING_POTION.stack(1), ItemsTC.GEMS_RUBY.stack(2));
      event.addDyeVatRecipe(ItemsTC.BLACK_LENS.stack(), ItemsTC.LENS.stack(1), ItemsTC.DYE_BLACK.stack(1));
      event.addCraftingRecipe(ItemsTC.LEATHER.stack(), ItemsTC.VERTEBRA.stack(5));
      event.addPrehardmodeAnvilRecipe(ItemsTC.BUG_NET.stack(), BlocksTC.IRON_BAR.stack(3), BlocksTC.COBWEB.stack(30));
      event.addPrehardmodeAnvilRecipe(ItemsTC.BUG_NET.stack(), BlocksTC.LEAD_BAR.stack(3), BlocksTC.COBWEB.stack(30));
      event.addPrehardmodeAnvilRecipe(ItemsTC.MAGIC_MIRROR.stack(), BlocksTC.IRON_BAR.stack(10), BlocksTC.GLASS.stack(10), ItemsTC.FALLEN_STAR.stack(10));
      event.addPrehardmodeAnvilRecipe(ItemsTC.MAGIC_MIRROR.stack(), BlocksTC.LEAD_BAR.stack(10), BlocksTC.GLASS.stack(10), ItemsTC.FALLEN_STAR.stack(10));
      event.addPrehardmodeAnvilRecipe(ItemsTC.SHURIKEN.stack(50), BlocksTC.IRON_BAR.stack(1));
      event.addPrehardmodeAnvilRecipe(ItemsTC.SHURIKEN.stack(50), BlocksTC.LEAD_BAR.stack(1));
      event.addPrehardmodeAnvilRecipe(ItemsTC.SLIME_STAFF.stack(), BlocksTC.WOOD_FOREST.stack(6), ItemsTC.GEL.stack(40), ItemsTC.PINK_GEL.stack(10));
      event.addPrehardmodeAnvilRecipe(ItemsTC.THROWING_KNIFE.stack(50), BlocksTC.IRON_BAR.stack(1));
      event.addPrehardmodeAnvilRecipe(ItemsTC.THROWING_KNIFE.stack(50), BlocksTC.LEAD_BAR.stack(1));
      event.addPrehardmodeAnvilRecipe(ItemsTC.WAND_OF_SPARKING.stack(), BlocksTC.WOOD_FOREST.stack(5), BlocksTC.TORCH.stack(3), ItemsTC.FALLEN_STAR.stack(1));

      //Temporary compatibility recipes
      event.addPrehardmodeAnvilRecipe(BlocksTC.ALCHEMY_TABLE.stack(), BlocksTC.IRON_BAR.stack(10), BlocksTC.EMPTY_BOTTLE.stack(2), ItemsTC.WATER_BOTTLE.stack(1));
      event.addPrehardmodeAnvilRecipe(BlocksTC.ALCHEMY_TABLE.stack(), BlocksTC.LEAD_BAR.stack(10), BlocksTC.EMPTY_BOTTLE.stack(2), ItemsTC.WATER_BOTTLE.stack(1));

      //Alchemy blood orb recipes
      event.addRecipe(ItemsTC.REGENERATION_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.IRONSKIN_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.SWIFTNESS_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.LESSER_HEALING_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.HEALING_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.SPELUNKER_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.RECALL_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.BUILDER_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.SHINE_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.WATER_WALKING_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.GILLS_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.MINING_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.AMMO_RESERVATION_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.FISHING_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.CRATE_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.BATTLE_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.ENDURANCE_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.WRATH_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.GRAVITATION_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.LESSER_MANA_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.MANA_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.LUCK_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.LESSER_LUCK_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.HEARTREACH_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.MAGIC_POWER_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));
      event.addRecipe(ItemsTC.WORMHOLE_POTION.stack(), BlocksTC.ALCHEMY_TABLE, ItemsTC.WATER_BOTTLE.stack(1), ItemsC.BLOOD_ORB.stack(10));

   }

   @Override
   public DeferredRegistries getRegistries() {
      return REG;
   }
}
