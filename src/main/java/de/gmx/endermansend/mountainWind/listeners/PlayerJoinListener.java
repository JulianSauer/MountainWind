package de.gmx.endermansend.mountainWind.listeners;

import de.gmx.endermansend.mountainWind.main.MountainWind;
import de.gmx.endermansend.mountainWind.main.SoundHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private SoundHandler sound;

    public PlayerJoinListener(MountainWind main) {
        this.sound = main.getSoundHandler();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        sound.addPlayer(e.getPlayer());
    }

}
