package s6.ReceipeFood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import s6.ReceipeFood.modele.Composant;

public class ComposantDAO {

	public  void save(Composant p) throws Exception{
    	String query = "INSERT INTO COMPOSANT (NOMCOMPOSANT) "
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
			throw new Exception("Composant contenant des erreurs, cr\u00e9ation \u00e9chou\u00e9e.");
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}
	
	public  void update(Composant p) throws Exception {
		String query = "UPDATE COMPOSANT SET NOMCOMPOSANT = ?,"
				+ " WHERE IDCOMPOSANT = ?";
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
    	String query = "DELETE FROM COMPOSANT WHERE IDCOMPOSANT = ?";
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
			throw new Exception("Composant contenant des erreurs, cr\u00e9ation \u00e9chou\u00e9e.");
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}
	
	
public  List<Composant> findAll() throws Exception {
		String query = "SELECT * FROM COMPOSANT";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			return DBToComposant(statement.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}

	public  Composant findById(int id) throws Exception {
		String query = "SELECT * FROM COMPOSANT WHERE IDCOMPOSANT = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet res = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			res = statement.executeQuery();
			if(res.next()){
				return Creation.creerComposant(statement.executeQuery());
			}
			throw new Exception("Composant introuvable");
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
	public List<Composant> DBToComposant(ResultSet res)throws Exception{
		try{
			List<Composant> model = new Vector<Composant>();
			while(res.next()){
				model.add(Creation.creerComposant(res));
			}
			return model;
		}catch(Exception e){
			throw e;
		}finally {
			if(res != null) res.close();
		}
	}
}
