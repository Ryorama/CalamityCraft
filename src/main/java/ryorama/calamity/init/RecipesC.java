package ryorama.calamity.init;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.zeith.terraria.api.crafting.events.RegisterCraftingEvent;
import org.zeith.terraria.api.crafting.predicate.CraftingPredicateFurnace;
import org.zeith.terraria.init.BlocksTC;
import org.zeith.terraria.init.items.CrittersTC;
import org.zeith.terraria.init.items.ItemsTC;
import ryorama.calamity.blocks.BlocksC;
import ryorama.calamity.items.ItemsC;

public class RecipesC {

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
}
