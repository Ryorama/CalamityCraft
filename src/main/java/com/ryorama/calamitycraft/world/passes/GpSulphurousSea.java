package com.ryorama.calamitycraft.world.passes;

import lombok.Getter;
import org.zeith.terraria.world.api.passes.*;

@GenPass(name = "sulphurous_sea", priority = 99)
public class GpSulphurousSea extends CubeGenPass {
    @Getter
    private static GpSulphurousSea instance;
    
    public GpSulphurousSea()
    {
        instance = this;
    }
    
    @Override
    public void populate(PassData data) {
        // NO-OP
    }
}
