package s6.ReceipeFood.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Vector;

import org.hibernate.exception.ConstraintViolationException;

import s6.ReceipeFood.dao.ComposantDAO;
import s6.ReceipeFood.dao.HibernateDao;
import s6.ReceipeFood.modele.Composant;
import s6.ReceipeFood.modele.Composition;

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
	
	ComposantDAO composantDAO = new ComposantDAO();
	
	public List<Composant> find() throws Exception{
		return this.composantDAO.findAll();
	}
	
	public Composant findById(int i) throws Exception{
		return this.composantDAO.findById(i);
	}  
	
	public List<Composant> creerListeComposant(String liste) throws Exception{
		List<Composant> ltComposant = new Vector<Composant>();
		String [] lt = liste.split(";");
		for(String s : lt){
			Composant c = new Composant();
			try{
				c = BaseService.getInstance().getDao().findComposant(c, s);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(c.getId() == 0){
				c.setNom(s);
				BaseService.getInstance().save(c);
			}
			ltComposant.add(c);
		}
		return ltComposant;
	}
	
	public void save(Composant composant) throws Exception{
		try{
			BaseService.getInstance().save(composant);
		}catch(ConstraintViolationException e){
			return;
		}
	}
}