package me.praquenome.storage;

import java.sql.SQLException;
import java.util.UUID;

import com.mysql.jdbc.Statement;

public class MYSQLAPIKills {

	  public static Integer getKills(UUID player) {
		     Integer retval = null;
		     if (MySQLAPIKills.playerExists(player)) {
		        try {
		          String sql = "SELECT * FROM "+Main.plugin.getConfig().getString("database.table_players")+" WHERE UUID = '" + player.toString() + "';";
		          Statement s = Main.c.createStatement();
		         ResultSet res = s.executeQuery(sql);
		         if ((!res.next()) ||
		        (Integer.valueOf(res.getInt("kills")) == null)) return retval;
		         retval = Integer.valueOf(res.getInt("kills"));
		        }
		        catch (SQLException e) {
		         e.printStackTrace();
		        }
		      } else {
		       MySQLAPI.createPlayer(player);
		       getKills(player);
		      }
		     return retval;
		    }
		   
		    public static void addKills(UUID player, Integer amount) {
		     if (MySQLAPI.playerExists(player)) {
		       setKills(player, Integer.valueOf(getKills(player).intValue() + amount.intValue()));
		      } else {
		       MySQLAPI.createPlayer(player);
		       addKills(player, amount);
		      }
		    }
		   
		    public static void setKills(UUID player, Integer amount) {
		     if (MySQLAPI.playerExists(player)) {
		        try {
		          Statement s = Main.c.createStatement();
		          String sql = "UPDATE "+Main.plugin.getConfig().getString("database.table_players")+" SET kills=" + amount + " WHERE UUID='" + player.toString() + "';";
		         s.executeUpdate(sql);
		        } catch (SQLException e) {
		         e.printStackTrace();
		        }
		      } else {
		       MySQLAPI.createPlayer(player);
		       setKills(player, amount);
		      }
		    }
}
