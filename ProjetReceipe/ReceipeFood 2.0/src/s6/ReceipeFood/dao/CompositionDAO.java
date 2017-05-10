package s6.ReceipeFood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import s6.ReceipeFood.modele.Composition;

public class CompositionDAO {

	
	
//	public  void update(Composition p) throws Exception {
//    	String query = "UPDATE COMPOSITION SET NOMCOMPOSANT = ?,"
//    			+ " WHERE IDCOMPOSANT = ?";
//		Connection conn = null;
//		PreparedStatement statement = null;
//		try {
//			conn = UtilDB.getConnPostgre();
//			statement = conn.prepareStatement(query);
//			statement.setString(1, p.getNom());
//			statement.setInt(2, p.getId());
//			statement.execute();
//			conn.commit();
//		}
//		catch(Exception e){
//			conn.rollback();
//			e.printStackTrace();
//			throw e;
//		}finally {
//			conn.close();
//		}
//	}
	
	public  void save(Composition p) throws Exception{
    	String query = "INSERT INTO COMPOSITION (IDPRODUIT,IDCOMPOSANT) "
    			+ "VALUES (?,?)";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			statement.setInt(1, p.getProduit().getId());
			statement.setInt(2, p.getComposant().getId());
			statement.execute();
			conn.commit();
		}
		catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw new Exception("Composition contenant des erreurs, cr\u00e9ation \u00e9chou\u00e9e.");
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}
	
	public  void delete(Composition p) throws Exception{
    	String query = "DELETE FROM COMPOSITION WHERE IDCOMPOSANT = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			statement.setInt(1, p.getComposant().getId());
			statement.execute();
			conn.commit();
		}
		catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw new Exception("Composition contenant des erreurs, cr\u00e9ation \u00e9chou\u00e9e.");
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}
	
	
public  List<Composition> findAll() throws Exception {
		String query = "SELECT * FROM COMPOSITION";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			return DBToComposition(statement.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}

	public  List<Composition> findById(int id) throws Exception {
		String query = "SELECT * FROM COMPOSITION WHERE IDPRODUIT = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			return DBToComposition(statement.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}

	//	=================================================================================================================
	 List<Composition> DBToComposition(ResultSet res)throws Exception{
		try{
			List<Composition> model = new Vector<Composition>();
			while(res.next()){
				model.add(Creation.creerComposition(res));
			}
			return model;
		}catch(Exception e){
			throw e;
		}finally {
			if(res != null) res.close();
		}
	}
}
