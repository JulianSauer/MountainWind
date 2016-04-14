package de.gmx.endermansend.mountainWind.main;

import de.gmx.endermansend.mountainWind.config.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
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

    private int roofHeight;

    private Logger logger;

    public SoundHandler(MountainWind main) {

        this.logger = main.getLogger();
        ConfigHandler config = main.getConfigHandler();
        allowedModes = config.get.allowedGameModes();
        blockLevel = config.get.blockLevel();
        roofHeight = config.get.roofHeight();

        registeredPlayers = new ArrayList<Player>((Collection<Player>) Bukkit.getOnlinePlayers());
        checkWorlds(config.get.allowedWorlds());

    }

    public void run() {
        try {
            for (Player player : registeredPlayers) {
                if (player.getLocation().getY() >= blockLevel) {
                    if (allowedModes.get(player.getGameMode().toString()) && isRoofAbovePlayer(player))
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

    /**
     * Checks the allowed worlds on startup
     *
     * @param allowedWorlds
     */
    private void checkWorlds(Map<String, Boolean> allowedWorlds) {

        for (Player player : registeredPlayers) {
            if (!allowedWorlds.get(player.getWorld().getName()))
                removePlayer(player);
        }
    }

    /**
     * Checks if a non empty block is above the player's head.
     *
     * @param player
     * @return True if a roof is above the player
     */
    private boolean isRoofAbovePlayer(Player player) {
        Location location = player.getLocation();
        Block block = player.getWorld().getHighestBlockAt(location);
        if (block != null)
            return block.getLocation().getY() > (location.getY() + roofHeight);
        return false;
    }

}
