package com.iamkaf.gentlehurtcam.mixin;

import com.iamkaf.gentlehurtcam.GentleHurtCamConstants;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class HurtCamMixin {

    @Inject(method = "bobHurt", at = @At("HEAD"), cancellable = true)
    private void onCancelZeroDamageHurtCam(PoseStack poseStack, float partialTick, CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        Entity cameraEntity = ((MinecraftAccessor) mc).getCameraEntity();

        if (cameraEntity instanceof LivingEntity living) {
            float lastHurt = ((LivingEntityAccessor) living).getLastHurt();
            if (living.hurtTime > 0) {
                GentleHurtCamConstants.LOG.info("Living entity - hurtTime: {}, lastHurt: {}", living.hurtTime, lastHurt);
            }

            if (living.hurtTime <= 10 && lastHurt < 0.5F) {
                GentleHurtCamConstants.LOG.info("Cancelling hurt cam - zero damage detected!");
                ci.cancel();
            }
        }
    }
}
