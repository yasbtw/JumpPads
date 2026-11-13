package me.yas.btw.jumppads.Utils;

import me.yas.btw.jumppads.Config;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundPlayer {
    public void playsound(Player player, Config conf){
        if (!conf.sound_enabled){return;}
            player.playSound(
                player.getLocation(), // Location
                Sound.valueOf(conf.sound.toUpperCase()),       // Sound enum (1.8 naming)
                1.0f,                 // Volume (1.0f is normal)
                1.0f                  // Pitch (1.0f is normal, 0.5f is deep, 2.0f is high)
        );
    }
}
