package s6.ReceipeFood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import s6.ReceipeFood.modele.Categorie;
import s6.ReceipeFood.modele.Composant;

public class CategorieDAO {

	public  void save(Composant p) throws Exception{
    	String query = "INSERT INTO CATEGORIE (NOMCATEGORIE) "
    			+ "VALUES (?)";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			statement.setString(1, p.getNom());
			statement.execute();
			conn.commit();
		}
		catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw new Exception("Categorie contenant des erreurs, cr\u00e9ation \u00e9chou\u00e9e.");
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}
	
	public  void update(Categorie p) throws Exception {
		String query = "UPDATE CATEGORIE SET NOMCATEGORIE = ?,"
				+ " WHERE IDCATEGORIE = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			statement.setString(1, p.getNom());
			statement.setInt(2, p.getId());
			statement.execute();
			conn.commit();
		}
		catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}

	public  void delete(Composant p) throws Exception{
    	String query = "DELETE FROM CATEGORIE WHERE IDCATEGORIE = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			statement.setInt(1, p.getId());
			statement.execute();
			conn.commit();
		}
		catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw new Exception("Categorie contenant des erreurs, cr\u00e9ation \u00e9chou\u00e9e.");
		}finally {
			statement.close();
			conn.close();
		}
	}
	
	
public  List<Categorie> findAll() throws Exception {
		String query = "SELECT * FROM CATEGORIE";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			return DBToCategorie(statement.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}

	public  Categorie findById(int id) throws Exception {
		String query = "SELECT * FROM CATEGORIE WHERE IDCATEGORIE = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet res = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			res = statement.executeQuery();
			if(res.next()){
				return Creation.creerCategorie(statement.executeQuery());
			}
			throw new Exception("Categorie introuvable");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(res != null) res.close();
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}

	//	=================================================================================================================
	public List<Categorie> DBToCategorie(ResultSet res)throws Exception{
		try{
			List<Categorie> model = new Vector<Categorie>();
			while(res.next()){
				model.add(Creation.creerCategorie(res));
			}
			return model;
		}catch(Exception e){
			throw e;
		}finally {
			if(res != null) res.close();
		}
	}
}
