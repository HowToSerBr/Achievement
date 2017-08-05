package me.praquenome.achivements;
 
import me.praquenome.storage.MySQLAPI;
 
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
 
public class ReceiveFBAchivement implements Listener {
 
@EventHandler
public void PlayerKill(PlayerDeathEvent event){
if(event.getEntity().getKiller() instanceof Player && event.getEntity() instanceof Player) {
Player player = event.getEntity().getKiller();
    if (!MySQLAPI.playerExists(player.getUniqueId())) {    
        MySQLAPI.createPlayer(player.getUniqueId());
    }
            if (MySQLAPI.getAchivement(event.getEntity().getKiller().getUniqueId(), "fb").equals("Nao")) {
                player.playSound(player.getLocation(), Sound.NOTE_PLING,5.0f, 2.0f);
                player.sendMessage("§k!!! §r§6Você adquiriu a conquista §a§lEXTRAIR O PRIMEIRO SANGUE§6! Parabéns! §f§k!!!");
                player.sendMessage("§7§l> §bDigite §6/conquistas §bpara ver suas conquistas.");
                MySQLAPI.giveAchivement(player.getUniqueId(), "fb");   
            }
    }
}
}
