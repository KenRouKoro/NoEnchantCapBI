package xyz.amymialee.noenchantcap.platform;

import lombok.Setter;
import xyz.amymialee.noenchantcap.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public class Services {
    @Setter
    public static IPlatformHelper PLATFORM;
    /*
    public static <T> T load(Class<T> clazz) {
        return ServiceLoader.load(clazz).findFirst().orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
    }
    */
}