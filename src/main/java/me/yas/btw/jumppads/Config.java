package me.yas.btw.jumppads;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import static me.yas.btw.jumppads.JumpPads.getplugin;

public class Config {
    public boolean launchInWalkingDirection,launchEffectEnabled,sound_enabled;
    public Integer maxPower;
    public String launchEffect,sound;
    public final Set<Material> launchBlocks = EnumSet.noneOf(Material.class);
    public void loadBlocks(List<String> blockNames) {
        launchBlocks.clear();
        for (String name : blockNames) {
            Material mat = Material.matchMaterial(name);
            if (mat != null) {
                launchBlocks.add(mat);
            }
        }
    }
    public void reloadconfig(){
        FileConfiguration config = getplugin().getConfig();
        getplugin().reloadConfig();
        loadBlocks(config.getStringList("Blocks"));
        launchInWalkingDirection = config.getBoolean("launchInWalkingDirection", true);
        launchEffectEnabled = config.getBoolean("launchEffectEnabled",true);
        launchEffect = config.getString("launchEffect");
        sound_enabled = config.getBoolean("sound_enabled");
        sound = config.getString("sound");
        maxPower = config.getInt("maxPower");
    }
}
