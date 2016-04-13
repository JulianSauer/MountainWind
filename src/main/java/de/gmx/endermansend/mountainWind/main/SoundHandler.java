package de.gmx.endermansend.mountainWind.main;

import de.gmx.endermansend.mountainWind.config.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;

public class SoundHandler extends BukkitRunnable {

    private Map<String, Boolean> allowedModes;

    private int blockLevel;

    public SoundHandler(MountainWind main) {
        ConfigHandler config = main.getConfigHandler();
        allowedModes = config.get.allowedGameModes();
        blockLevel = config.get.blockLevel();
    }

    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getLocation().getY() >= blockLevel) {
                if (allowedModes.get(player.getGameMode().toString()))
                    player.playSound(player.getLocation(), Sound.ITEM_ELYTRA_FLYING, 1, 1);
            }
        }
    }

}
