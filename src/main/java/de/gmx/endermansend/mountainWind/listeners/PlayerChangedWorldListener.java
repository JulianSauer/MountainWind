package de.gmx.endermansend.mountainWind.listeners;

import de.gmx.endermansend.mountainWind.main.MountainWind;
import de.gmx.endermansend.mountainWind.main.SoundHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import java.util.Map;

public class PlayerChangedWorldListener implements Listener {

    Map<String, Boolean> allowedWorlds;

    SoundHandler sound;

    public PlayerChangedWorldListener(MountainWind main) {
        allowedWorlds = main.getConfigHandler().get.allowedWorlds();
        sound = main.getSoundHandler();
    }

    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent e) {

        Player player = e.getPlayer();
        if (allowedWorlds.get(player.getWorld().getName()))
            sound.addPlayer(player);
        else
            sound.removePlayer(player);

    }

}
