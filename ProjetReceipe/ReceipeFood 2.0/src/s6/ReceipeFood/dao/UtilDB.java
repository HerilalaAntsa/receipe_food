package s6.ReceipeFood.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilDB {
	public static Connection conn;

	public static Connection getConnPostgre()throws Exception{
		try{
			Class.forName("org.postgresql.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipe","postgres", "Antsalol");
			conn.setAutoCommit(false);
			if(conn == null){
				throw new Exception("Aucune connexion �tablie");
			}
		}
		catch(Exception e){
			throw e;
		}
		return conn;
	}
}
