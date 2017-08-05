package me.praquenome.achivements;

import me.praquenome.storage.MySQLAPI;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ReceiveLCYTAchivement implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (!MySQLAPI.playerExists(player.getUniqueId())) {
			MySQLAPI.createPlayer(player.getUniqueId());
		}
		if (MySQLAPI.getAchivement(player.getUniqueId(), "lcyt").equals("Nao")) {
			for (Player target : Bukkit.getOnlinePlayers()) {
				PermissionUser user = PermissionsEx.getUser(target);
				if (user.inGroup("youtuber")) {
					player.sendMessage("§k!!! §r§6Você adquiriu a conquista §a§lLOBBY COM YOUTUBER§6! Parabéns! §f§k!!!");
					player.sendMessage("§7§l> §bDigite §6/conquistas §bpara ver suas conquistas.");
					player.playSound(player.getLocation(), Sound.NOTE_PLING,
							5.0f, 2.0f);
					MySQLAPI.giveAchivement(player.getUniqueId(), "lcyt");
					break;
				}
			}
		}
	}
}
