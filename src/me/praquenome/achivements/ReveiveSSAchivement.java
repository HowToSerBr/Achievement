package me.praquenome.achivements;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import me.praquenome.Main;
import me.praquenome.storage.MySQLAPI;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ReveiveSSAchivement implements Listener {
@EventHandler
	public void PlayerJoin (PlayerJoinEvent event){
		
		Player player = event.getPlayer();
		if (!MySQLAPI.playerExists(player.getUniqueId())) {
			MySQLAPI.createPlayer(player.getUniqueId());
	
	}
		if (MySQLAPI.getAchivement(event.getPlayer().getUniqueId(), "SS")
				.equals("Nao")) {
			PermissionUser user = PermissionsEx.getUser(player);
			if (user.inGroup("mod")) {
				
				player.playSound(player.getLocation(), Sound.NOTE_PLING,5.0f, 2.0f);
				player.sendMessage("§k!!! §r§6Você adquiriu a conquista §a§lSER STAFF§6! Parabéns! §f§k!!!");
				player.sendMessage("§7§l> §bDigite §6/conquistas §bpara ver suas conquistas.");
				MySQLAPI.giveAchivement(player.getUniqueId(), "ss");
				ByteArrayOutputStream b = new ByteArrayOutputStream();
				DataOutputStream out = new DataOutputStream(b);
				try {
				String data = "§6§lCONQUISTA» §a"+player.getName() + " §aadquiriu a conquista §2§lTORNA-SE STAFF!";
				out.writeUTF("Forward");
				out.writeUTF("ALL");
				out.writeUTF("PraAchivements");
				out.writeShort(data.length());
				out.writeUTF(data); 
				player.sendPluginMessage(Main.plugin, "BungeeCord", b.toByteArray());
				
			} catch (IOException event1) {}
			
		
	}
			}
		}
		
}

