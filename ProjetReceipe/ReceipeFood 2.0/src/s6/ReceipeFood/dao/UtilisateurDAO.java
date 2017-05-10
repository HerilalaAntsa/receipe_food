package s6.ReceipeFood.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import s6.ReceipeFood.modele.Utilisateur;

public class UtilisateurDAO {
	
	public  void save(Utilisateur p) throws Exception{
    	String query = "INSERT INTO UTILISATEUR (NOM,PRENOM,DATENAISSANCE,SEXE,"
    			+ "TELEPHONE,ADRESSE,EMAIL) "
    			+ "VALUES (?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);

			statement.setString(1, p.getNom());
			statement.setString(2, p.getPrenom());
			statement.setDate(3, Date.valueOf(p.getDateNaissance().toString()));
			statement.setString(4, p.getSexe());
			statement.setString(5, p.getTelephone());
			statement.setString(6, p.getAdresse());
			statement.setString(7, p.getEmail());
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
	
	public  void update(Utilisateur p) throws Exception {
		String query = "UPDATE UTILISATEUR SET NOM = ?,"
				+ "PRENOM = ?,"
				+ "DATENAISSANCE = ?,"
				+ "SEXE = ?,"
				+ "TELEPHONE = ?,"
				+ "ADRESSE = ?,"
				+ "EMAIL = ?,"
				+ " WHERE IDMEMBRE = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
	
			statement.setString(1, p.getNom());
			statement.setString(2, p.getPrenom());
			statement.setDate(3, Date.valueOf(p.getDateNaissance().toString()));
			statement.setString(4, p.getSexe());
			statement.setString(5, p.getTelephone());
			statement.setString(6, p.getAdresse());
			statement.setString(7, p.getEmail());
			statement.setInt(8, p.getId());
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

	public  void delete(Utilisateur p) throws Exception{
    	String query = "DELETE FROM UTILISATEUR WHERE IDUTILISATEUR = ?";
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
			throw new Exception("Utilisateur contenant des erreurs, cr\u00e9ation \u00e9chou\u00e9e.");
		}finally {
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}
	
	
public  List<Utilisateur> findAll() throws Exception {
		String query = "SELECT * FROM UTILISATEUR";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			return DBToUtilisateur(statement.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			statement.close();
			conn.close();
		}
	}

	public  Utilisateur findById(int id) throws Exception {
		String query = "SELECT * FROM UTILISATEUR WHERE IDUTILISATEUR = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet res = null;
		try {
			conn = UtilDB.getConnPostgre();
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			res = statement.executeQuery();
			if(res.next()){
				return Creation.creerUtilisateur(res);
			}
			throw new Exception("Utilisateur introuvable");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(res != null) res.close();
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}
	
	public  Utilisateur connexion(String email, String password) throws Exception {
		Connection conn = UtilDB.getConnPostgre();
		String req = "SELECT * FROM UTILISATEUR WHERE EMAIL = ? AND PASSWORD = ?";
		PreparedStatement statement = conn.prepareStatement(req);
		ResultSet res = null;
		try {
			statement.setString(1, email);
			statement.setString(2, password);
			res = statement.executeQuery();
			if(res.next()){
				return Creation.creerUtilisateur(res);
			}
			throw new Exception("Vos identifiants sont incorrects ou nous ne vous connaissons pas encore");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(res != null){
				res.close();
			}
			if(statement != null) statement.close();
			if(conn != null) conn.close();
		}
	}

	//	=================================================================================================================
	public List<Utilisateur> DBToUtilisateur(ResultSet res)throws Exception{
		try{
			List<Utilisateur> model = new Vector<Utilisateur>();
			while(res.next()){
				model.add(Creation.creerUtilisateur(res));
			}
			return model;
		}catch(Exception e){
			throw e;
		}finally {
			if(res != null) res.close();
		}
	}
}
