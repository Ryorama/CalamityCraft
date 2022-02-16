package ryorama.calamity.entities.renders;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.zeith.terraria.client.model.entity.hostile.slimes.ModelSlime;
import ryorama.calamity.entities.slimes.WulfrumSlime;

public class RenderWulfrumSlime extends Render<WulfrumSlime> {
   public ResourceLocation texture = new ResourceLocation("calamity", "textures/entity/hostile/slime.png");
   public static ModelBase MODEL = new ModelSlime();

   public RenderWulfrumSlime(RenderManager renderManager) {
      super(renderManager);
   }

   protected ResourceLocation getEntityTexture(WulfrumSlime entity) {
      return this.texture;
   }

   public void doRender(WulfrumSlime entity, double x, double y, double z, float entityYaw, float partialTicks) {
      super.doRender(entity, x, y, z, entityYaw, partialTicks);
      int ticksBeforeJump = entity.getTicksBeforeJump() + 15;
      double scaleY = 1.0D;
      if (ticksBeforeJump < 25) {
         scaleY = Math.pow((double)(25 - ticksBeforeJump), 0.05D);
      }

      if (ticksBeforeJump > 40) {
         scaleY = Math.pow((double)(ticksBeforeJump - 40), 0.05D);
      }

      GL11.glPushMatrix();
      GL11.glTranslated(x, y, z);
      GL11.glScaled(1.0D, scaleY, 1.0D);
      GL11.glTranslated(0.0D, 1.5D, 0.0D);
      GL11.glBlendFunc(770, 771);

      try {
         GlStateManager.pushMatrix();
         GlStateManager.rotate((float)(entity.getUniqueID().getMostSignificantBits() % 36000L) / 100.0F - (entity.prevRotationYawHead + (entity.rotationYawHead - entity.prevRotationYawHead) * partialTicks), 0.0F, 1.0F, 0.0F);
         GlStateManager.translate(0.0F, -1.35F, 0.0F);
         GlStateManager.popMatrix();
         this.bindEntityTexture(entity);
         GlStateManager.enableBlend();
         GL11.glPushMatrix();
         GL11.glRotatef(entity.rotationYawHead, 0.0F, -1.0F, 0.0F);
         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
         MODEL.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
         GL11.glPopMatrix();
      } catch (Throwable var14) {
         ;
      }

      GL11.glPopMatrix();
   }
}
