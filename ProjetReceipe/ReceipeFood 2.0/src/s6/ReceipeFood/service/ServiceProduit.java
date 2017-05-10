package s6.ReceipeFood.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Vector;

import org.hibernate.Session;
import org.hibernate.Transaction;

import s6.ReceipeFood.dao.CategorieDAO;
import s6.ReceipeFood.dao.HibernateDao;
import s6.ReceipeFood.dao.ProduitDAO;
import s6.ReceipeFood.modele.BaseModel;
import s6.ReceipeFood.modele.Categorie;
import s6.ReceipeFood.modele.Composant;
import s6.ReceipeFood.modele.Composition;
import s6.ReceipeFood.modele.Produit;
import s6.ReceipeFood.modele.Unite;
import s6.ReceipeFood.modele.Utilisateur;

public class ServiceProduit {
	public ServiceProduit() {}
	
	private static class SingletonHolder
	{		
		private final static ServiceProduit instance = new ServiceProduit();
	}
 
	public static ServiceProduit getInstance()
	{
		return SingletonHolder.instance;
	}
	
	ProduitDAO produitDAO = new ProduitDAO();
	
	public List<BaseModel> find() throws Exception{
		HibernateDao hibernateDao = new HibernateDao();
		return hibernateDao.findAll(new Produit());
	}
	
	public Produit findById(int i) throws Exception{
		return produitDAO.findById(i);
	}
	
	public Produit nouveauProduit(int idCategorie,Utilisateur utilisateur,String nomProduit,String etape){
		Produit p = new Produit();
		p.setCategorie(new Categorie(idCategorie,""));
		p.setCreateur(utilisateur);
		p.setNom(nomProduit);
		p.setEtape(etape);
		return p;
	}
	
	public void saveProduit(List<Composant> ltComposant, float[] quantite, Unite[] unite, Produit produit){
		List<Composition> ltComposition = new Vector<Composition>();
		
		for(int i=0;i<ltComposant.size();i++){
			ltComposition.add(new Composition(produit, ltComposant.get(i), quantite[i], unite [i]));
		}
		produit.setLtComposition(ltComposition);
		try{
			BaseService.getInstance().save(produit);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
