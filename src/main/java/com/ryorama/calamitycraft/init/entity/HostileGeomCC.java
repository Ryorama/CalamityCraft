package com.ryorama.calamitycraft.init.entity;

import com.zeitheron.hammercore.annotations.RegistryName;
import com.zeitheron.hammercore.annotations.SimplyRegister;
import org.zeith.hammeranims.api.geometry.IGeometryContainer;

@SimplyRegister(prefix = "entity/hostile/")
public interface HostileGeomCC {
    @RegistryName("wulfrum_rover")
    IGeometryContainer WULFRUM_ROVER = IGeometryContainer.create();
}
