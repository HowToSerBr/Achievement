package me.praquenome.main;

import java.util.ArrayList;

import me.praquenome.storage.MYSQLAPIKills;
import me.praquenome.storage.MySQLAPI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OtherGui implements Listener {

	Server sv = Bukkit.getServer();
	public static Inventory ach = null;
	
	@EventHandler
	public void playerClick(InventoryClickEvent event){
		if(event.getInventory().getName().equalsIgnoreCase("Conquistas")){
			event.setCancelled(true);
		}
	}//pronto
	
	@SuppressWarnings({ "deprecation" })
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (event.getClickedBlock() != null) {
			if (event.getClickedBlock().getTypeId() == 54) {
				ach = Bukkit.createInventory(null, 9, "Conquistas");
				MYSQLAPIKills m = new MYSQLAPIKills();
                @SuppressWarnings("static-access")
				int kills = 100 - m.getKills(player.getUniqueId());
				ItemStack yt = new ItemStack(Material.REDSTONE_BLOCK);
				ItemMeta ytm = yt.getItemMeta();
				ytm.setDisplayName("§7Ficar em um §6§lLOBBY &7com um §c§lYouTuber");
				ArrayList<String> loreyt = new ArrayList<String>();
				if (MySQLAPI.getAchivement(player.getUniqueId(), "lcyt")
						.equals("Sim")) {
					loreyt.add("§aVocê possui está conquista!");
					
					ytm.setLore(loreyt);
				} else {
					loreyt.add("§cVocê não possui está conquista!");
					ytm.setLore(loreyt);
					yt.setType(Material.COAL_BLOCK);
				}
				yt.setItemMeta(ytm);

				ach.addItem(yt);
				if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					player.openInventory(ach);
				}
				if (event.getClickedBlock() != null) {
					if (event.getClickedBlock().getTypeId() == 54) {
						ach = Bukkit.createInventory(null, 9, "Conquistas");

						ItemStack fl = new ItemStack(Material.MAP);
						ItemMeta flm = fl.getItemMeta();
						ytm.setDisplayName("§7Entre pela §6§lPRIMEIRA §7vez.");
						ArrayList<String> lorefl = new ArrayList<String>();
						if (MySQLAPI
								.getAchivement(player.getUniqueId(), "lcyt")
								.equals("Sim")) {
							lorefl.add("§aVocê possui está conquista!");
							flm.setLore(lorefl);
						} else {
							lorefl.add("§cVocê não possui está conquista!");
							flm.setLore(lorefl);
							fl.setType(Material.COAL_BLOCK);
						}
						fl.setItemMeta(flm);

						ach.addItem(fl);

						if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
							player.openInventory(ach);
						}
						if (event.getClickedBlock() != null) {
							if (event.getClickedBlock().getTypeId() == 54) {
								
							}
						ItemStack tv = new ItemStack(Material.DIAMOND_BLOCK);
						ItemMeta tvm = tv.getItemMeta();
						ytm.setDisplayName("§7Torne-se §6§lVIP.");
						ArrayList<String> loretv = new ArrayList<String>();
						if (MySQLAPI
								.getAchivement(player.getUniqueId(), "tv")
								.equals("Sim")) {
							loretv.add("§aVocê possui está conquista!");
							tvm.setLore(loretv);
						} else {
							loretv.add("§cVocê não possui está conquista!");
							tvm.setLore(loretv);
							tv.setType(Material.COAL_BLOCK);
						}
						tv.setItemMeta(tvm);

						ach.addItem(tv);
						if (event.getClickedBlock() != null) {
							if (event.getClickedBlock().getTypeId() == 54) {
								
							}
						ItemStack ss = new ItemStack(Material.EMERALD_BLOCK);
						ItemMeta ssm = ss.getItemMeta();
						ssm.setDisplayName("§7Torne-se §6§lSTAFF.");
						ArrayList<String> loress = new ArrayList<String>();
						if (MySQLAPI
								.getAchivement(player.getUniqueId(), "ss")
								.equals("Sim")) {
							loretv.add("§aVocê possui está conquista!");
							ssm.setLore(loress);
						} else {
							ss.setType(Material.COAL_BLOCK);
							loress.add("§cVocê não possui está conquista!");
							ssm.setLore(loress);
							
						}
						ss.setItemMeta(ssm);
						ach.addItem(ss);
						
						if (event.getClickedBlock() != null) {
							if (event.getClickedBlock().getTypeId() == 54) {
								
							}
						       ItemStack fb = new ItemStack(Material.REDSTONE);
						       ItemMeta fbm = fb.getItemMeta();
						       fbm.setDisplayName("§7Extraia o §6§lPRIMEIRO SANGUE.");
						       ArrayList<String> lorefb = new ArrayList<String>();
						       if (MySQLAPI.getAchivement(player.getUniqueId(), "fb").equals("Sim")) {
						       lorefb.add("§aVocê possui esta conquista!");
						       fbm.setLore(lorefb);
						       } else {
						       fb.setType(Material.COAL_BLOCK);
						       lorefb.add("§cVocê não possui esta conquista!");
						       fbm.setLore(lorefb);
						       }
						       fb.setItemMeta(fbm);
						       ach.addItem(fb);
						       
								if (event.getClickedBlock() != null) {
									if (event.getClickedBlock().getTypeId() == 54) {
										
									}
								       ItemStack k1 = new ItemStack(Material.IRON_SWORD);
								       ItemMeta k1m = k1.getItemMeta();
								       k1m.setDisplayName("§7Extraia §6§l100 SANGUES.");
								       ArrayList<String> lorek1 = new ArrayList<String>();
								       if (MySQLAPI.getAchivement(player.getUniqueId(), "k1").equals("Sim")) {
								       lorek1.add("§aVocê possui esta conquista!");
								       
								       k1m.setLore(lorek1);
								       } else {
								       k1.setType(Material.COAL_BLOCK);
								       lorek1.add("§cVocê não possui esta conquista!");
								       lorek1.add("§cRestam §a"+kills+" §ckills para adquirir esta conquista.");
								       k1m.setLore(lorek1);
								       }
								       k1.setItemMeta(k1m);
								       ach.addItem(k1);
				}
			}
		}
//vo mostra in-game
	}
}

	}

	}
}
	}
}

