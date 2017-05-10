package s6.ReceipeFood.service;

import java.sql.Date;
import java.util.List;

import s6.ReceipeFood.dao.HibernateDao;
import s6.ReceipeFood.dao.ProduitDAO;
import s6.ReceipeFood.dao.UtilisateurDAO;
import s6.ReceipeFood.modele.Utilisateur;

public class ServiceUtilisateur {
	public ServiceUtilisateur() {}
	
	private static class SingletonHolder
	{		
		private final static ServiceUtilisateur instance = new ServiceUtilisateur();
	}
 
	public static ServiceUtilisateur getInstance()
	{
		return SingletonHolder.instance;
	}
	
	UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

	public  List<Utilisateur> find() throws Exception{
		return utilisateurDAO.findAll();
	}
	
	public  Utilisateur findById(int i) throws Exception{
		return utilisateurDAO.findById(i);
	}
	
	public Utilisateur login(Utilisateur model) throws Exception{
		HibernateDao hibernateDao = new HibernateDao();
		return hibernateDao.login(model);
	}
	
	public static void inscription(String nom, String prenom, String dateNaissance, String sexe, String email, String telephone, String password,String confirmpassword, String adresse)throws Exception{
		try {
			HibernateDao hibernateDao = new HibernateDao();
			Utilisateur p = new Utilisateur();
			p.setNom(nom);
			p.setPrenom(prenom);
			p.setDateNaissance(Date.valueOf(dateNaissance));
			p.setSexe(sexe);
			p.setEmail(email);
			p.setPassword(password, confirmpassword);
			p.setAdresse(adresse);
			p.setTelephone(telephone);
			hibernateDao.save(p);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new Exception("Veuillez remplir enti\u00e8rement le formulaire pour pouvoir vous inscrire !");
		} catch (NumberFormatException e){
			e.printStackTrace();
			throw new Exception("Veuillez s\u00e9lectionner une r\u00e9gion");
		}	
	}
}