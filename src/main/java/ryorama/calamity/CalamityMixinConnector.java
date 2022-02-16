package ryorama.calamity;

import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

public class CalamityMixinConnector implements IMixinConnector {
    @Override
    public void connect() {
        System.out.println("Invoking Mixin Connector");
        Mixins.addConfiguration(
                "assets/calamity/mixins.calamity.json"
        );
    }
}