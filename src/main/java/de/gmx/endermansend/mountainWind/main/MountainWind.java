package de.gmx.endermansend.mountainWind.main;

import de.gmx.endermansend.mountainWind.config.ConfigHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class MountainWind extends JavaPlugin {

    private ConfigHandler config;

    @Override
    public void onEnable() {

        config = new ConfigHandler(this);

        (new SoundHandler(this)).runTaskTimer(this, 0L, config.get.playInterval() * 20);

        getLogger().info("Enabled");

    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled");
    }

    public ConfigHandler getConfigHandler() {
        return config;
    }

}
