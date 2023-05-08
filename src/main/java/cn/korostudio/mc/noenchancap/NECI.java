package cn.korostudio.mc.noenchancap;
import cn.korostudio.mc.hutoolcore.common.config.ConfigUtil;
import cn.korostudio.mc.noenchancap.config.NECIConfig;
import com.google.inject.Inject;
import com.llamalad7.mixinextras.MixinExtrasBootstrap;
import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.Server;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.configurate.CommentedConfigurationNode;
import space.vectrix.ignite.api.Platform;
import space.vectrix.ignite.api.event.Subscribe;
import space.vectrix.ignite.api.event.platform.PlatformInitializeEvent;
import xyz.amymialee.noenchantcap.NoEnchantCap;

public class NECI {
    private final Logger logger;
    private final Platform platform;
    @Getter
    private static Server server;

    @Inject
    public NECI(final Logger logger,
                      final Platform platform) {
        this.logger = logger;
        this.platform = platform;
    }

    @Subscribe
    public void onInitialize(final @NonNull PlatformInitializeEvent event) {
        MixinExtrasBootstrap.init();
    }

    public static void onBukkitInit(){


        server = Bukkit.getServer();

        NoEnchantCap.init();
    }
}
