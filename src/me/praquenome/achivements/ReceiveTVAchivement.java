package me.praquenome.achivements;

import me.praquenome.storage.MySQLAPI;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ReceiveTVAchivement implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e){

		Player player = e.getPlayer();
		if (!MySQLAPI.playerExists(player.getUniqueId())) {
			MySQLAPI.createPlayer(player.getUniqueId());
		}
		if (MySQLAPI.getAchivement(e.getPlayer().getUniqueId(), "tv")
				.equals("Nao")) {
			
		
			PermissionUser user = PermissionsEx.getUser(player);
			if (user.inGroup("vip")) {
				player.sendMessage("§k!!! §r§6Você adquiriu a conquista §a§lSER VIP§6! Parabéns! §f§k!!!");
				player.sendMessage("§7§l> §bDigite §6/conquistas §bpara ver suas conquistas.");
				player.playSound(player.getLocation(), Sound.NOTE_PLING,
						5.0f, 2.0f);
				MySQLAPI.giveAchivement(player.getUniqueId(), "tv");
				
	}

	

}
	}
}