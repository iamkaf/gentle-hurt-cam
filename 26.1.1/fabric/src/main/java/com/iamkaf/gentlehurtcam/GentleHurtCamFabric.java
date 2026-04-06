package com.iamkaf.gentlehurtcam;

import net.fabricmc.api.ModInitializer;

/**
 * Fabric entry point.
 */
public class GentleHurtCamFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        GentleHurtCamMod.init();
    }
}
