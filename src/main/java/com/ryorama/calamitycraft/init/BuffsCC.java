package com.ryorama.calamitycraft.init;

import com.ryorama.calamitycraft.common.buffs.IrradiatedDebuff;
import com.ryorama.calamitycraft.common.buffs.SulphurskinBuff;
import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.terraria.api.buffs.BuffBase;

@SimplyRegister
public interface BuffsCC {
    @RegistryName("irradiated")
    BuffBase IRRADIATED = new IrradiatedDebuff();
    @RegistryName("sulphurskin")
    BuffBase SULPHURSKIN = new SulphurskinBuff();
}
