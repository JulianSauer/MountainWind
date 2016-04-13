package de.gmx.endermansend.mountainWind.main;

import de.gmx.endermansend.mountainWind.config.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Logger;

public class SoundHandler extends BukkitRunnable {

    private Map<String, Boolean> allowedModes;

    private Collection<Player> registeredPlayers;

    private int blockLevel;

    private Logger logger;

    public SoundHandler(MountainWind main) {
        this.logger = main.getLogger();
        ConfigHandler config = main.getConfigHandler();
        allowedModes = config.get.allowedGameModes();
        blockLevel = config.get.blockLevel();
        registeredPlayers = new ArrayList<Player>((Collection<Player>) Bukkit.getOnlinePlayers());
    }

    public void run() {
        try {
            for (Player player : registeredPlayers) {
                if (player.getLocation().getY() >= blockLevel) {
                    if (allowedModes.get(player.getGameMode().toString()))
                        player.playSound(player.getLocation(), Sound.ITEM_ELYTRA_FLYING, 1, 1);
                }
            }
        } catch (NoSuchFieldError e) {
            logger.severe("This plugin only works with 1.9.2 or above. Please update.");
        }
    }

    public void addPlayer(Player player) {
        registeredPlayers.add(player);
    }

    public void removePlayer(Player player) {
        registeredPlayers.remove(player);
    }

}
