package cn.korostudio.mc.noenchancap.mixin;

import cn.korostudio.mc.noenchancap.NECI;
import org.bukkit.craftbukkit.v1_19_R2.CraftServer;
import org.bukkit.plugin.PluginLoadOrder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CraftServer.class ,remap = false)
public class MixinCraftServer {
    @Inject(method = "enablePlugins",at = @At("HEAD"))
    private void mixinBukkitPluginsInit(PluginLoadOrder type, CallbackInfo ci){
        NECI.onBukkitInit();
    }
}
