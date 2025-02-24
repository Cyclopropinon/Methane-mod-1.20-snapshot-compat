package me.wolfie.methane.mixin;

import me.wolfie.methane.Methane;

import net.minecraft.world.chunk.light.LightingProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = GameRenderer.class, priority = 400) //exordium kludge
public abstract class GameRendererMixin {
    @Redirect(method = "renderWorld", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/LightmapTextureManager;update(F)V"))
    private void update(LightmapTextureManager instance, float delta) {
        if (Methane.ModActive) return;
        instance.update(delta);
    }
}
