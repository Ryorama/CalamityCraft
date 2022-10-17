package ryorama.calamity;

import com.zeitheron.hammercore.internal.SimpleRegistration;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
import org.zeith.terraria.common.content.biome.api.BiomeSelectEvent;
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
import ryorama.calamity.init.BiomesC;
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

   @Override
   public DeferredRegistries getRegistries() {
      return REG;
   }

   @SubscribeEvent
   public static void sulphurousSea(BiomeSelectEvent e) {
      BlockPos pos = e.getActualPosition();
      World world = e.getWorld();
      WorldDataTC worldDataTC = WorldDataTC.get(world);
      if (!world.isRemote) {
         int rad = e.getRadius();
         for (int x = -rad; x <= rad; x++) {
            for (int z = -rad; z <= rad; z++) {
               int xf = pos.getX() + x;
               int zf = pos.getZ() + z;
               if (xf > worldDataTC.worldSize.getWorldRadius() - 65 && zf > worldDataTC.worldSize.getWorldRadius() - 65) {
                  e.setOverridenBiome(BiomesC.SULPHUROUS_SEA_BIOME);
                  return;
               }
            }
         }
      }
   }
}
