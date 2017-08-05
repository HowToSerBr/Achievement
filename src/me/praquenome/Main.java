package me.praquenome;


import me.praquenome.achivements.GiveKills;
import me.praquenome.achivements.Receive100KillsAchivement;
import me.praquenome.achivements.ReceiveFBAchivement;
import me.praquenome.achivements.ReceiveFLAhivements;
import me.praquenome.achivements.ReceiveLCYTAchivement;
import me.praquenome.achivements.ReceiveTVAchivement;
import me.praquenome.achivements.ReveiveSSAchivement;
import me.praquenome.commands.Commands;
import me.praquenome.main.OtherGui;
import me.praquenome.storage.Conexao;
import me.praquenome.storage.MYSQLAPIKills;
import me.praquenome.storage.MySQLAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main plugin;

	public void onEnable() {
		plugin = this;
		System.out.println("Ativado com sucesso.");
		Conexao.getConnection();
		MySQLAPI.createTables();
		MYSQLAPIKills.createTables();
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		Bukkit.getPluginManager().registerEvents(new OtherGui(), this);
		Bukkit.getPluginManager().registerEvents(new ReceiveLCYTAchivement(),this);
		Bukkit.getPluginManager().registerEvents(new ReceiveFLAhivements(),this);
		Bukkit.getPluginManager().registerEvents(new ReceiveTVAchivement(),this);
		Bukkit.getPluginManager().registerEvents(new ReveiveSSAchivement(),this);
		Bukkit.getPluginManager().registerEvents(new ReceiveFBAchivement(),this);
		Bukkit.getPluginManager().registerEvents(new GiveKills(),this);
		Bukkit.getPluginManager().registerEvents(new Receive100KillsAchivement(),this);
		getCommand("conquistas").setExecutor(new Commands());
	}

	public void onDisable() {
		System.out.println("Desativado com sucesso");
	}
}
