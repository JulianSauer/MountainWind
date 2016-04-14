package de.gmx.endermansend.mountainWind.listeners;

import de.gmx.endermansend.mountainWind.main.MountainWind;
import de.gmx.endermansend.mountainWind.main.SoundHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private SoundHandler sound;

    public PlayerQuitListener(MountainWind main) {
        this.sound = main.getSoundHandler();
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        sound.removePlayer(e.getPlayer());
    }

}
