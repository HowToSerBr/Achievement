package me.praquenome.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//conexão mysql q é um bagulho chato pra caralho
public class Conexao {

	    private static String usuario="root";
		private static String senha="pass";
		private static String banco="achivement";
		private static String ip="localhost";
	    private static String driver="com.mysql.jdbc.Driver";
	    private static Connection conexao = null;

	    public static Connection getConnection() {
	        try {
	            Class.forName(driver);
	            if(conexao==null || conexao.isClosed()){
	                conexao=DriverManager.getConnection("jdbc:mysql://"+ip+"/"+banco+"",usuario, senha);
	            }
	            return conexao; 
	        }catch (ClassNotFoundException e) {    
	            throw new RuntimeException(e);    
	        }catch (SQLException e) {

	            closeConnection();
	            throw new RuntimeException(e);
	        }

	    }

	    public static void closeConnection(){
	        try{
	            if(conexao!=null && !conexao.isClosed()){
	                conexao.close();
	            }
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
}
