package de.gmx.endermansend.mountainWind.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MWCommandExecutor implements CommandExecutor {

    private SoundHandler sound;

    public MWCommandExecutor(SoundHandler sound) {
        this.sound = sound;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (command.getName().equalsIgnoreCase("mountainWind")) {

            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("Command can only be used by players");
                return false;
            } else if (args.length != 1) {
                return false;
            } else if (args[0].equalsIgnoreCase("enable")) {
                sound.addPlayer((Player) commandSender);
                return true;
            } else if (args[0].equalsIgnoreCase("disable")) {
                sound.removePlayer((Player) commandSender);
                return true;
            }
        }

        return false;
    }

}
