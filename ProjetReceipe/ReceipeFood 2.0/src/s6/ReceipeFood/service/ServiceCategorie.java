package s6.ReceipeFood.service;

import java.util.List;
import java.util.Vector;

import s6.ReceipeFood.dao.CategorieDAO;
import s6.ReceipeFood.modele.BaseModel;
import s6.ReceipeFood.modele.Categorie;
import s6.ReceipeFood.modele.Produit;

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
	
	private BaseService base;
	
	public BaseService getBase() {
		return base;
	}

	public void setBase(BaseService baseService) {
		this.base = baseService;
	}
	
	public List<Categorie> find() throws Exception{
		List<Categorie> ltProduit = new Vector<Categorie>();
		List<BaseModel> liste = this.getBase().getAll(new Categorie());
		for(BaseModel b : liste){
			ltProduit.add((Categorie) b);
		}
		return ltProduit;
	}
}
