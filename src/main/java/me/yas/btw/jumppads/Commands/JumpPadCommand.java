package me.yas.btw.jumppads.Commands;

import me.yas.btw.jumppads.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.yas.btw.jumppads.JumpPads.getplugin;

public class JumpPadCommand implements CommandExecutor {
    private final Config conf = getplugin().config;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length > 0){
            if (args[0].equals("reload")){
                conf.reloadconfig();
                sender.sendMessage("Plugin has been reloaded");
            }
        }else{
            sender.sendMessage("JumpPad plugin made by @yasbtw on github");
        }

        return true;
    }
}
