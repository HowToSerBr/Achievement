package me.praquenome.achivements;

import me.praquenome.storage.MYSQLAPIKills;
import me.praquenome.storage.MySQLAPI;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;




public class Receive100KillsAchivement implements Listener {
	@SuppressWarnings("unused")
	@EventHandler
	public void onPlayerKill(PlayerDeathEvent event){
		Player player = event.getEntity().getKiller();
		MYSQLAPIKills m = new MYSQLAPIKills();
	Player player1 = event.getEntity().getKiller();
			if(event.getEntity().getKiller() instanceof Player && event.getEntity() instanceof Player) {
			if(MYSQLAPIKills.getKills(player1.getUniqueId()) >= 100) {
				 if (MySQLAPI.getAchivement(event.getEntity().getKiller().getUniqueId(), "kills1").equals("Nao")) {
				     player1.sendMessage("§k!!! §r§6Você adquiriu a conquista §a§l100 KILLS§6! Parabéns! §f§k!!!");
		                player1.sendMessage("§7§l> §bDigite §6/conquistas §bpara ver suas conquistas.");
				 }
				
			}
		}

	}
	
	
	
}
