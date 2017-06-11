package s6.ReceipeFood.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Vector;

import org.hibernate.exception.ConstraintViolationException;

import s6.ReceipeFood.dao.ComposantDAO;
import s6.ReceipeFood.dao.HibernateDao;
import s6.ReceipeFood.modele.BaseModel;
import s6.ReceipeFood.modele.Composant;
import s6.ReceipeFood.modele.Composition;
import s6.ReceipeFood.modele.Produit;

public class ServiceComposant {
	public ServiceComposant() {}
	
	private static class SingletonHolder
	{		
		private final static ServiceComposant instance = new ServiceComposant();
	}
 
	public static ServiceComposant getInstance()
	{
		return SingletonHolder.instance;
	}
	
	private BaseService base; // = BaseService.getInstance();
	
	public BaseService getBase() {
		return base;
	}

	public void setBase(BaseService baseService) {
		this.base = baseService;
	}
	
	public List<Composant> find() throws Exception{
		List<Composant> ltModel = new Vector<Composant>();
		List<BaseModel> liste = this.getBase().getAll(new Composant());
		for(BaseModel b : liste){
			ltModel.add((Composant) b);
		}
		return ltModel;
	}
	
	public Composant findById(int i) throws Exception{
		return (Composant) this.getBase().get(String.valueOf(i), new Composant());
	}  
	
	public List<Composant> creerListeComposant(String liste) throws Exception{
		List<Composant> ltComposant = new Vector<Composant>();
		String [] lt = liste.split(";");
		for(String s : lt){
			s = s.trim();
			Composant c = new Composant();
			try{
				List<Composant> ltC = this.getBase().getDao().findComposant(c, s, false);
				c = ltC.get(0);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(c.getId()==0){
				c.setNom(s);
				this.getBase().save(c);
			}
			ltComposant.add(c);
		}
		return ltComposant;
	}
	
	public void save(Composant composant) throws Exception{
		try{
			this.getBase().save(composant);
		}catch(ConstraintViolationException e){
			return;
		}
	}
	
}
