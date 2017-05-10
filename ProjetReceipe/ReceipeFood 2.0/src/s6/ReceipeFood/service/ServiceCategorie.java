package s6.ReceipeFood.service;

import java.util.List;

import s6.ReceipeFood.dao.CategorieDAO;
import s6.ReceipeFood.modele.Categorie;

public class ServiceCategorie {
	public ServiceCategorie() {}
	
	private static class SingletonHolder
	{		
		private final static ServiceCategorie instance = new ServiceCategorie();
	}
 
	public static ServiceCategorie getInstance()
	{
		return SingletonHolder.instance;
	}
	
	CategorieDAO categorieDAO = new CategorieDAO();
	
	public List<Categorie> find() throws Exception{
		return this.categorieDAO.findAll();
	}
	
	public Categorie findById(int i) throws Exception{
		return this.categorieDAO.findById(i);
	}
}
