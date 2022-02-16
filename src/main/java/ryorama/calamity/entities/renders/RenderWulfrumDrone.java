package ryorama.calamity.entities.renders;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import ryorama.calamity.entities.hostile.WulfrumDrone;
import ryorama.calamity.entities.models.ModelWulfrumDrone;

public class RenderWulfrumDrone extends RenderLiving<WulfrumDrone> {
   public RenderWulfrumDrone(RenderManager rendermanagerIn) {
      super(rendermanagerIn, new ModelWulfrumDrone(), 0.5F);
   }

   @Nullable
   protected ResourceLocation getEntityTexture(WulfrumDrone entity) {
      return new ResourceLocation("calamity", "textures/entity/hostile/wulfrum_drone.png");
   }
}
