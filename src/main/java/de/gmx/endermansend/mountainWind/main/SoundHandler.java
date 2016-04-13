package de.gmx.endermansend.mountainWind.main;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SoundHandler extends BukkitRunnable {

    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(player.getLocation().getY() >= 128)
                player.playSound(player.getLocation(), Sound.ITEM_ELYTRA_FLYING, 1, 1);
        }
    }

}
