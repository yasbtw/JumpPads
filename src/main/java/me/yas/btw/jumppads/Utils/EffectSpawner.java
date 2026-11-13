package me.yas.btw.jumppads.Utils;

import me.yas.btw.jumppads.Config;
import org.bukkit.Effect;
import org.bukkit.entity.Player;

public class EffectSpawner {
    public void spawnEffect(Player player, Config conf){
        if (!conf.launchEffectEnabled){return;}
        player.getWorld().spigot().playEffect(
                player.getLocation(),                   // Location
                Effect.valueOf(conf.launchEffect.toUpperCase()),    // Effect type
                0,                     // ID (usually 0)
                0,                     // Data (usually 0)
                (float) 0.5,           // Offset X
                (float) 0.5,           // Offset Y
                (float) 0.5,           // Offset Z
                (float) 0.01,          // Speed
                5,                    // Particle count
                50                     // View radius
        );
    }
}
