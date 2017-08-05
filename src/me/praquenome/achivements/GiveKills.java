package me.praquenome.achivements;

import me.praquenome.storage.MYSQLAPIKills;
import me.praquenome.storage.MySQLAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class GiveKills implements Listener {

	 
	@EventHandler
	public void PlayerKill(PlayerDeathEvent event){
	if(event.getEntity().getKiller() instanceof Player && event.getEntity() instanceof Player) {
	Player player = event.getEntity().getKiller();
	    if (!MySQLAPI.playerExists(player.getUniqueId())) {    
	        MySQLAPI.createPlayer(player.getUniqueId());
	    }
	    MYSQLAPIKills.addKills(player.getUniqueId(), 1);
}
	
}
}