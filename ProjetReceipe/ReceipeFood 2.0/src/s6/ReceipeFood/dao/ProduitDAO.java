package s6.ReceipeFood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import s6.ReceipeFood.modele.Produit;

public class ProduitDAO {
	
	public  void save(Produit p) throws Exception{
    	String query = "INSERT INTO PRODUIT (NOM,IDCATEGORIE) "
    			+ "VALUES (?,?)";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			statement.setString(1, p.getNom());
			statement.setInt(2, p.getCategorie().getId());
			statement.execute();
			conn.commit();
		}
		catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw new Exception("Produit contenant des erreurs, cr\u00e9ation \u00e9chou\u00e9e.");
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}
	
	public  void update(Produit p) throws Exception {
		String query = "UPDATE PRODUIT SET NOM = ?,"
				+ " WHERE IDPRODUIT = ?";
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

	public  void delete(Produit p) throws Exception{
    	String query = "DELETE FROM PRODUIT WHERE IDPRODUIT = ?";
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
			throw new Exception("Produit contenant des erreurs, cr\u00e9ation \u00e9chou\u00e9e.");
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}
	
	
public  List<Produit> findAll() throws Exception {
		String query = "SELECT * FROM PRODUIT";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			return DBToProduit(statement.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}

	public  Produit findById(int id) throws Exception {
		String query = "SELECT * FROM PRODUIT WHERE IDPRODUIT = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet res = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			res = statement.executeQuery();
			if(res.next()){
				return Creation.creerProduit(statement.executeQuery());
			}
			throw new Exception("Produit introuvable");
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
	public List<Produit> DBToProduit(ResultSet res)throws Exception{
		try{
			List<Produit> model = new Vector<Produit>();
			while(res.next()){
				model.add(Creation.creerProduit(res));
			}
			return model;
		}catch(Exception e){
			throw e;
		}finally {
			if(res != null) res.close();
		}
	}
}
