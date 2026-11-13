package me.yas.btw.jumppads;

import me.yas.btw.jumppads.Commands.JumpPadCommand;
import me.yas.btw.jumppads.Listeners.JumpPadListener;
import me.yas.btw.jumppads.Utils.EffectSpawner;
import me.yas.btw.jumppads.Utils.SoundPlayer;
import org.bukkit.plugin.java.JavaPlugin;

public final class JumpPads extends JavaPlugin {

    private static JumpPads plugin;
    public Config config = new Config();
    public final EffectSpawner effectSpawner = new EffectSpawner();
    public final SoundPlayer soundPlayer = new SoundPlayer();
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
