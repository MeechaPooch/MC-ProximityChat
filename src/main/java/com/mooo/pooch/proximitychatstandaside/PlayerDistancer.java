package com.mooo.pooch.proximitychatstandaside;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.LinkedList;

public class PlayerDistancer {
    public static Collection<DistancedPlayer> getPlayersInAudioRange(VoicePlayer player) {
        LinkedList<DistancedPlayer> ret = new LinkedList<>();
        Bukkit.getOnlinePlayers().forEach((p)->{
            double distance = p.getLocation().distance(player.player.getLocation());
            if(!p.equals(player.player) && distance < Consts.maxHearingRange && p.getLocation().getWorld().equals(player.player.getLocation().getWorld())) ret.add(new DistancedPlayer(p,distance));
        });
        return ret;
    };

    //TODO should the actually be static?
    // i think it should....
    public static class DistancedPlayer {
        Player player;
        double blocksDistance;
        double volume;

        public DistancedPlayer(Player player, double blocksDistance) {
            this.player = player;
            this.blocksDistance = blocksDistance;
        }
    }
}
