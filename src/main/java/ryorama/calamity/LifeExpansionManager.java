package ryorama.calamity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.zeith.terraria.api.events.calc.CalculateHealthEvent;
import org.zeith.terraria.common.data.player.BasePlayerDataTC;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.common.data.player.impl.PlayerHealthData;

@Mod.EventBusSubscriber
public class LifeExpansionManager extends BasePlayerDataTC {
    public int hpByBloodOrange = 0;
    public int hpByMiracleFruit = 0;
    public int hpByDragonfruit = 0;
    public int hpByElderberry = 0;

    public boolean alreadyUsedBloodOrange = false;
    public boolean alreadyUsedMiracleFruit = false;
    public boolean alreadyUsedDragonfruit = false;
    public boolean alreadyUsedElderberry = false;

    public LifeExpansionManager(PlayerDataTC data) {
        super(data);
    }

    public boolean addBloodOrange() {
        int oneBloodOrange = 25;

        if (!alreadyUsedBloodOrange) {
            this.hpByBloodOrange += 25;
            PlayerHealthData hpd = this.data.health();
            for (int p = 0; p < hpd.textures.length; p++) {
                hpd.setTexture(p, new ResourceLocation("calamity", "textures/ui/boh.png"));
            }
            hpd.recalcMaxHP();
            hpd.heal((float)oneBloodOrange);
            alreadyUsedBloodOrange = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean addMiracleFruit() {
        int oneMiracleFruit = 25;

        if (!alreadyUsedMiracleFruit) {
            this.hpByMiracleFruit += 25;
            PlayerHealthData hpd = this.data.health();
            for (int p = 0; p < hpd.textures.length; p++) {
                hpd.setTexture(p, new ResourceLocation("calamity", "textures/ui/mfh.png"));
            }
            hpd.recalcMaxHP();
            hpd.heal((float)oneMiracleFruit);
            alreadyUsedMiracleFruit = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean addDragonfruit() {
        int oneDragonfruit = 25;

        if (!alreadyUsedDragonfruit) {
            this.hpByDragonfruit += 25;
            PlayerHealthData hpd = this.data.health();
            for (int p = 0; p < hpd.textures.length; p++) {
                hpd.setTexture(p, new ResourceLocation("calamity", "textures/ui/dfh.png"));
            }
            hpd.recalcMaxHP();
            hpd.heal((float)oneDragonfruit);
            alreadyUsedDragonfruit = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean addElderberry() {
        int oneElderberry = 25;

        if (!alreadyUsedElderberry) {
            this.hpByElderberry += 25;
            PlayerHealthData hpd = this.data.health();
            for (int p = 0; p < hpd.textures.length; p++) {
                hpd.setTexture(p, new ResourceLocation("calamity", "textures/ui/ebh.png"));
            }
            hpd.recalcMaxHP();
            hpd.heal((float)oneElderberry);
            alreadyUsedElderberry = true;
            return true;
        } else {
            return false;
        }
    }

    @SubscribeEvent
    public static void addHPBloodOrange(CalculateHealthEvent e) {
        LifeExpansionManager thisInst = (LifeExpansionManager)e.data.data.getData(LifeExpansionManager.class);
        e.add((float)thisInst.hpByBloodOrange);
    }

    @SubscribeEvent
    public static void addHPDragonfruit(CalculateHealthEvent e) {
        LifeExpansionManager thisInst = (LifeExpansionManager)e.data.data.getData(LifeExpansionManager.class);
        e.add((float)thisInst.hpByDragonfruit);
    }

    @SubscribeEvent
    public static void addHPMiracleFruit(CalculateHealthEvent e) {
        LifeExpansionManager thisInst = (LifeExpansionManager)e.data.data.getData(LifeExpansionManager.class);
        e.add((float)thisInst.hpByMiracleFruit);
    }

    @SubscribeEvent
    public static void addHPElderberry(CalculateHealthEvent e) {
        LifeExpansionManager thisInst = (LifeExpansionManager)e.data.data.getData(LifeExpansionManager.class);
        e.add((float)thisInst.hpByElderberry);
    }

    public void writeToNBT(NBTTagCompound nbt) {
        nbt.setBoolean("AlreadyUsedBloodOrange", this.alreadyUsedBloodOrange);
        nbt.setInteger("BloodOrangeFruit", this.hpByBloodOrange);

        nbt.setBoolean("AlreadyUsedMiracleFruit", this.alreadyUsedMiracleFruit);
        nbt.setInteger("MiracleFruit", this.hpByMiracleFruit);

        nbt.setBoolean("AlreadyUsedDragonfruit", this.alreadyUsedDragonfruit);
        nbt.setInteger("Dragonfruit", this.hpByDragonfruit);

        nbt.setBoolean("AlreadyUsedElderberry", this.alreadyUsedElderberry);
        nbt.setInteger("Elderberry", this.hpByElderberry);
    }

    public void readFromNBT(NBTTagCompound nbt) {
        this.alreadyUsedBloodOrange = nbt.getBoolean("AlreadyUsedBloodOrange");
        this.hpByBloodOrange = nbt.getInteger("BloodOrangeFruit");

        this.alreadyUsedMiracleFruit = nbt.getBoolean("AlreadyUsedMiracleFruit");
        this.hpByMiracleFruit = nbt.getInteger("MiracleFruit");

        this.alreadyUsedDragonfruit = nbt.getBoolean("AlreadyUsedDragonfruit");
        this.hpByDragonfruit = nbt.getInteger("Dragonfruit");

        this.alreadyUsedElderberry = nbt.getBoolean("AlreadyUsedElderberry");
        this.hpByElderberry = nbt.getInteger("Elderberry");
    }
}
