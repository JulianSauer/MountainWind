package de.gmx.endermansend.mountainWind.main;

import org.bukkit.plugin.java.JavaPlugin;

public class MountainWind extends JavaPlugin {

    @Override
    public void onEnable() {

        (new SoundHandler()).runTaskTimer(this, 0L, 100L);

        getLogger().info("Enabled");

    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled");
    }

}
