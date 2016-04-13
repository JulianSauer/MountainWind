package de.gmx.endermansend.mountainWind.listeners;

import de.gmx.endermansend.mountainWind.main.SoundHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private SoundHandler sound;

    public PlayerJoinListener(SoundHandler sound) {
        this.sound = sound;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        sound.addPlayer(e.getPlayer());
    }

}
