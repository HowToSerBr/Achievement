package me.praquenome.commands;

import java.util.ArrayList;

import me.praquenome.main.OtherGui;
import me.praquenome.storage.MYSQLAPIKills;
import me.praquenome.storage.MySQLAPI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Commands implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getLogger().info("..");
			return false;
		}
		MYSQLAPIKills m = new MYSQLAPIKills();
		Player player = (Player) sender;
		@SuppressWarnings("static-access")
		int kills = 100 - m.getKills(player.getUniqueId());
		if (label.equalsIgnoreCase("conquistas")) {
			
			OtherGui.ach = Bukkit.createInventory(null, 9, "Conquistas");
			player.updateInventory();

			ItemStack yt = new ItemStack(Material.REDSTONE_BLOCK);
			ItemMeta ytm = yt.getItemMeta();
			ytm.setDisplayName("§7Ficar em um §6§lLOBBY com um §c§lYouTuber");
			ArrayList<String> loreyt = new ArrayList<String>();
			String achiviment = MySQLAPI.getAchivement(player.getUniqueId(),
					"lcyt");
			if (achiviment == null) {
				player.sendMessage("§cOcorreu um problema ao processar o comando.");
				return false;
			}

			if (achiviment.equals("Sim")) {
				loreyt.add("§aVocê possui esta conquista!");
				ytm.setLore(loreyt);
			} else {
				yt.setType(Material.COAL_BLOCK);
				loreyt.add("§cVocê não possui esta conquista!");
				ytm.setLore(loreyt);
			}
			yt.setItemMeta(ytm);

			OtherGui.ach.addItem(yt);

			// player.getPlayer().openInventory(other.ach);

			ItemStack fl = new ItemStack(Material.MAP);
			ItemMeta flm = fl.getItemMeta();
			flm.setDisplayName("§7Entre pela §6§lPRIMEIRA §7vez.");
			ArrayList<String> lorefl = new ArrayList<String>();
			if (MySQLAPI.getAchivement(player.getUniqueId(), "fl")
					.equals("Sim")) {
				lorefl.add("§aVocê possui esta conquista!");
				flm.setLore(lorefl);
			} else {
				fl.setType(Material.COAL_BLOCK);
				lorefl.add("§cVocê não possui esta conquista!");
				flm.setLore(lorefl);
			}
			fl.setItemMeta(flm);
			OtherGui.ach.addItem(fl);
			
			ItemStack tv = new ItemStack(Material.DIAMOND_BLOCK);
			ItemMeta tvm = tv.getItemMeta();
			tvm.setDisplayName("§7Torne-se §6§lVIP.");
			ArrayList<String> loretv = new ArrayList<String>();
			if (MySQLAPI.getAchivement(player.getUniqueId(), "tv")
					.equals("Sim")) {
				loretv.add("§aVocê possui esta conquista!");
				tvm.setLore(loretv);
			} else {
				tv.setType(Material.COAL_BLOCK);
				loretv.add("§cVocê não possui esta conquista!");
				tvm.setLore(loretv);
			}
			tv.setItemMeta(tvm);
			OtherGui.ach.addItem(tv);
		
			ItemStack ss = new ItemStack(Material.EMERALD_BLOCK);
			ItemMeta ssm = ss.getItemMeta();
			ssm.setDisplayName("§7Torne-se §6§lSTAFF.");
			ArrayList<String> loress = new ArrayList<String>();
			if (MySQLAPI.getAchivement(player.getUniqueId(), "ss")
					.equals("Sim")) {
				loress.add("§aVocê possui esta conquista!");
				ssm.setLore(loress);
			} else {
				ss.setType(Material.COAL_BLOCK);
				loress.add("§cVocê não possui esta conquista!");
				ssm.setLore(loress);
			}
			ss.setItemMeta(ssm);
			OtherGui.ach.addItem(ss);
			
			ItemStack fb = new ItemStack(Material.REDSTONE);
			ItemMeta fbm = fb.getItemMeta();
			fbm.setDisplayName("§7Extraia o §6§lPRIMEIRO SANGUE.");
			ArrayList<String> lorefb = new ArrayList<String>();
			if (MySQLAPI.getAchivement(player.getUniqueId(), "fb")
					.equals("Sim")) {
				lorefb.add("§aVocê possui esta conquista!");
				fbm.setLore(lorefb);
			} else {
				fb.setType(Material.COAL_BLOCK);
				fbm.setDisplayName("§7Extraia o §6§lPRIMEIRO SANGUE.");
				
				lorefb.add("§cVocê não possui esta conquista!");
				fbm.setLore(lorefb);
			}
			fb.setItemMeta(fbm);
			OtherGui.ach.addItem(fb);
			
			ItemStack k1 = new ItemStack(Material.IRON_SWORD);
			ItemMeta k1m = k1.getItemMeta();
			k1m.setDisplayName("§7Extraia §6§l100 SANGUES.");
			ArrayList<String> lorek1 = new ArrayList<String>();
			if (MySQLAPI.getAchivement(player.getUniqueId(), "k1")
					.equals("Sim")) {
				lorek1.add("§aVocê possui esta conquista!");
				k1m.setLore(lorek1);
			} else {
				k1.setType(Material.COAL_BLOCK);
				lorek1.add("§cVocê não possui esta conquista!");
				lorek1.add("§cRestam §a"+kills+" §ckills para adquirir esta conquista.");
				k1m.setLore(lorek1);
			}
			k1.setItemMeta(k1m);
			OtherGui.ach.addItem(k1);
			
			player.getPlayer().openInventory(OtherGui.ach);

			return true;
	}
	
	return true;		
}
}

