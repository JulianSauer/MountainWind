package de.gmx.endermansend.mountainWind.main;

import de.gmx.endermansend.mountainWind.config.ConfigHandler;
import de.gmx.endermansend.mountainWind.listeners.PlayerChangedWorldListener;
import de.gmx.endermansend.mountainWind.listeners.PlayerJoinListener;
import de.gmx.endermansend.mountainWind.listeners.PlayerQuitListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MountainWind extends JavaPlugin {

    private ConfigHandler config;

    private SoundHandler sound;

    @Override
    public void onEnable() {

        config = new ConfigHandler(this);

        sound = new SoundHandler(this);

        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(this), this);
        pluginManager.registerEvents(new PlayerQuitListener(this), this);
        pluginManager.registerEvents(new PlayerChangedWorldListener(this), this);

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

    public SoundHandler getSoundHandler() {
        return sound;
    }

}
