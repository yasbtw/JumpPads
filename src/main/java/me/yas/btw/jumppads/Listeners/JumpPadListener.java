package me.yas.btw.jumppads.Listeners;

import me.yas.btw.jumppads.Config;
import me.yas.btw.jumppads.Utils.EffectSpawner;
import me.yas.btw.jumppads.Utils.SoundPlayer;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import static me.yas.btw.jumppads.JumpPads.getplugin;

public class JumpPadListener implements Listener {

    private final Config conf = getplugin().config;
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        if (event.getTo() == null ||
                (event.getFrom().getBlockX() == event.getTo().getBlockX() &&
                        event.getFrom().getBlockY() == event.getTo().getBlockY() &&
                        event.getFrom().getBlockZ() == event.getTo().getBlockZ())) {
            return;
        }
        Player player = event.getPlayer();
        Block block = event.getTo().getBlock();
        Block blockUnder = event.getTo().clone().subtract(0, 1, 0).getBlock();
        Vector moveDirection;
        if (conf.launchBlocks.contains(blockUnder.getType()) || conf.launchBlocks.contains(block.getType())) {
            getplugin().effectSpawner.spawnEffect(player,conf);
            getplugin().soundPlayer.playsound(player, conf);
            if (conf.launchInWalkingDirection){moveDirection = event.getTo().toVector().subtract(event.getFrom().toVector());}else{moveDirection = player.getLocation().getDirection();}
            moveDirection.setY(0).normalize();
            Vector velocity = moveDirection.multiply(conf.maxPower).setY(conf.maxPower/2.25);
            player.setVelocity(velocity);
        }

    }
}
