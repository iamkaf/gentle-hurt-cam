package com.iamkaf.gentlehurtcam;

import com.iamkaf.amber.api.core.v2.AmberInitializer;
import com.iamkaf.gentlehurtcam.platform.Services;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * Common entry point for the mod.
 * Replace the contents with your own implementation.
 */
public class GentleHurtCamMod {

    /**
     * Called during mod initialization for all loaders.
     */
    public static void init() {
        GentleHurtCamConstants.LOG.info("Initializing {} on {}...", GentleHurtCamConstants.MOD_NAME, Services.PLATFORM.getPlatformName());
        AmberInitializer.initialize(GentleHurtCamConstants.MOD_ID);
    }

    /**
     * Example interaction handler demonstrating how shared logic can be used
     * across loaders. Replace or remove it as needed.
     */
    public static InteractionResult onPlayerEntityInteract(Player player, Level level, InteractionHand hand, Entity entity) {
        GentleHurtCamConstants.LOG.info(
                "{} interacted with {} using hand {} in level {}",
                player.getName().getString(),
                entity.getName().getString(),
                hand,
                level.dimension().location()
        );
        return InteractionResult.PASS;
    }
}
