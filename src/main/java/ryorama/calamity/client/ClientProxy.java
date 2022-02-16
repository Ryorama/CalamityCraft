package ryorama.calamity.client;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import ryorama.calamity.entities.hostile.WulfrumDrone;
import ryorama.calamity.entities.renders.RenderWulfrumDrone;
import ryorama.calamity.entities.renders.RenderWulfrumSlime;
import ryorama.calamity.entities.slimes.WulfrumSlime;

public class ClientProxy extends Commonproxy {
   public void preInit() {
      RenderingRegistry.registerEntityRenderingHandler(WulfrumSlime.class, RenderWulfrumSlime::new);
      RenderingRegistry.registerEntityRenderingHandler(WulfrumDrone.class, RenderWulfrumDrone::new);
   }
}
