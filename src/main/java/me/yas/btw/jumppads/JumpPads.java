package me.yas.btw.jumppads;

import me.yas.btw.jumppads.Commands.JumpPadCommand;
import me.yas.btw.jumppads.Listeners.JumpPadListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JumpPads extends JavaPlugin {

    private static JumpPads plugin;
    public Config config = new Config();

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        config.reloadconfig();
        getServer().getPluginManager().registerEvents(new JumpPadListener(), this);
        getCommand("jumppad").setExecutor(new JumpPadCommand());
    }

    public static JumpPads getplugin(){return plugin;}
}
