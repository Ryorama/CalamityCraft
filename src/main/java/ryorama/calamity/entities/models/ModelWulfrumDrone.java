package ryorama.calamity.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWulfrumDrone extends ModelBase {
   private final ModelRenderer bb_main;

   public ModelWulfrumDrone() {
      this.textureWidth = 128;
      this.textureHeight = 128;
      this.bb_main = new ModelRenderer(this);
      this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
      this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, -6.0F, -6.0F, -6.0F, 12, 4, 12, 0.0F, false));
      this.bb_main.cubeList.add(new ModelBox(this.bb_main, 26, 26, 5.0F, -7.0F, -8.0F, 3, 7, 3, 0.0F, false));
      this.bb_main.cubeList.add(new ModelBox(this.bb_main, 38, 26, -8.0F, -7.0F, -8.0F, 3, 7, 3, 0.0F, false));
      this.bb_main.cubeList.add(new ModelBox(this.bb_main, 38, 16, 5.0F, -7.0F, 5.0F, 3, 7, 3, 0.0F, false));
      this.bb_main.cubeList.add(new ModelBox(this.bb_main, 26, 16, -8.0F, -7.0F, 5.0F, 3, 7, 3, 0.0F, false));
      this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 16, -6.0F, -5.0F, 6.0F, 12, 3, 1, 0.0F, false));
      this.bb_main.cubeList.add(new ModelBox(this.bb_main, 48, 0, -5.0F, -5.0F, -7.0F, 10, 3, 1, 0.0F, false));
      this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 21, -4.0F, -15.0F, -2.0F, 8, 9, 1, 0.0F, false));
      this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 43, -4.0F, -14.0F, -1.0F, 8, 8, 4, 0.0F, false));
      this.bb_main.cubeList.add(new ModelBox(this.bb_main, 25, 47, -4.0F, -13.0F, 3.0F, 8, 7, 1, 0.0F, false));
      this.bb_main.cubeList.add(new ModelBox(this.bb_main, 44, 48, -3.0F, -12.0F, 4.0F, 6, 6, 1, 0.0F, false));
      this.bb_main.cubeList.add(new ModelBox(this.bb_main, 5, 32, 4.0F, -15.0F, -1.0F, 1, 9, 1, 0.0F, false));
      this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 32, -5.0F, -15.0F, -1.0F, 1, 9, 1, 0.0F, false));
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.bb_main.render(f5);
   }

   public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.rotateAngleX = x;
      modelRenderer.rotateAngleY = y;
      modelRenderer.rotateAngleZ = z;
   }
}