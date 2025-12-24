package com.iamkaf.gentlehurtcam;

import com.iamkaf.gentlehurtcam.GentleHurtCamConstants;
import com.iamkaf.gentlehurtcam.GentleHurtCamMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(GentleHurtCamConstants.MOD_ID)
public class GentleHurtCamNeoForge {
    public GentleHurtCamNeoForge(IEventBus eventBus) {
        GentleHurtCamMod.init();
    }
}