package me.praquenome.achivements;

import me.praquenome.storage.MySQLAPI;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ReceiveFLAhivements implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		if (!MySQLAPI.playerExists(event.getPlayer().getUniqueId())) {
			MySQLAPI.createPlayer(event.getPlayer().getUniqueId());

		}
		if (MySQLAPI.getAchivement(event.getPlayer().getUniqueId(), "fl")
				.equals("Nao")) {
			event.getPlayer()
					.sendMessage(
							"§k!!! §r§6Você adquiriu a conquista §a§lPRIMEIRO LOGIN§6! Parabéns! §f§k!!!");
			event.getPlayer().sendMessage(
					"§7§l> §bDigite §6/conquistas §bpara ver suas conquistas.");
			MySQLAPI.giveAchivement(event.getPlayer().getUniqueId(), "fl");
		}
	}
}
