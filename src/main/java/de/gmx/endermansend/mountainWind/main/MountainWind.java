package de.gmx.endermansend.mountainWind.main;

import de.gmx.endermansend.mountainWind.config.ConfigHandler;
import de.gmx.endermansend.mountainWind.listeners.PlayerJoinListener;
import de.gmx.endermansend.mountainWind.listeners.PlayerQuitListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MountainWind extends JavaPlugin {

    private ConfigHandler config;

    @Override
    public void onEnable() {

        config = new ConfigHandler(this);

        SoundHandler sound = new SoundHandler(this);

        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(sound), this);
        pluginManager.registerEvents(new PlayerQuitListener(sound), this);

        sound.runTaskTimer(this, 0L, config.get.playInterval() * 20);
        this.getCommand("mountainWind").setExecutor(new MWCommandExecutor(sound));

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
