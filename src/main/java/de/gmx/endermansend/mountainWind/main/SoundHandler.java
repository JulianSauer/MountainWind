package de.gmx.endermansend.mountainWind.main;

import de.gmx.endermansend.mountainWind.config.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class SoundHandler extends BukkitRunnable {

    private Map<String, Boolean> allowedModes;

    private Collection<Player> registeredPlayers;

    private int blockLevel;

    public SoundHandler(MountainWind main) {
        ConfigHandler config = main.getConfigHandler();
        allowedModes = config.get.allowedGameModes();
        blockLevel = config.get.blockLevel();
        registeredPlayers = new ArrayList<Player>((Collection<Player>) Bukkit.getOnlinePlayers());
    }

    public void run() {
        for (Player player : registeredPlayers) {
            if (player.getLocation().getY() >= blockLevel) {
                if (allowedModes.get(player.getGameMode().toString()))
                    player.playSound(player.getLocation(), Sound.ITEM_ELYTRA_FLYING, 1, 1);
            }
        }
    }

    public void addPlayer(Player player) {
        registeredPlayers.add(player);
    }

    public void removePlayer(Player player) {
        registeredPlayers.remove(player);
    }

}
