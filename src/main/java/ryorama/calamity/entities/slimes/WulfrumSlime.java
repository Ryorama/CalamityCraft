package ryorama.calamity.entities.slimes;

import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import org.zeith.terraria.api.entity.ITintedEntity;
import org.zeith.terraria.common.content.entity.api.EntityProps;
import org.zeith.terraria.common.content.entity.hostile.slimes.EntityBaseSlime;
import ryorama.calamity.items.ItemsC;

import java.util.Random;

public class WulfrumSlime extends EntityBaseSlime implements ITintedEntity {

   public WulfrumSlime(World worldIn) {
      super(worldIn);
      //this.setContainedStack(new ItemStack(ItemsC.WULFRUM_SHARD, 1));
   }

   public void createDrop(int looting, DamageSource source, NonNullList drops) {
      drops.add(ItemsC.WULFRUM_SHARD.stack(2));
   }

   public int getTintColor() {
      return 15198183;
   }

   public void initProps(EntityProps props) {
      props.damage = this.Main.expertMode ? 16.0F : 8.0F;
      props.lifeMax = this.Main.expertMode ? 24.0F : 12.0F;
      props.defense = 4.0F;
      props.width = 16.0F;
      props.height = 16.0F;
      props.value = 150;
   }
}
