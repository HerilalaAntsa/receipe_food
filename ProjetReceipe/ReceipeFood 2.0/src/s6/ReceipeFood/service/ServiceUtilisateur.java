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
	
	private BaseService base;
	
	public BaseService getBase() {
		return base;
	}

	public void setBase(BaseService baseService) {
		this.base = baseService;
	}

	public Utilisateur login(Utilisateur model) throws Exception{
		return this.getBase().getDao().login(model);
	}
	
	public void inscription(Utilisateur u)throws Exception{
		try {
			Utilisateur p = new Utilisateur();
			this.getBase().save(u);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new Exception("Veuillez remplir enti\u00e8rement le formulaire pour pouvoir vous inscrire !");
		} catch (NumberFormatException e){
			e.printStackTrace();
			throw new Exception("Veuillez s\u00e9lectionner une r\u00e9gion");
		}	
	}
}
