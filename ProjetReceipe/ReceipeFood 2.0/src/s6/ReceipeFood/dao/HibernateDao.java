package s6.ReceipeFood.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.type.LongType;

import s6.ReceipeFood.modele.Administrateur;
import s6.ReceipeFood.modele.BaseModel;
import s6.ReceipeFood.modele.BaseModelePagination;
import s6.ReceipeFood.modele.Categorie;
import s6.ReceipeFood.modele.Composant;
import s6.ReceipeFood.modele.Composition;
import s6.ReceipeFood.modele.Produit;
import s6.ReceipeFood.modele.ProduitVue;
import s6.ReceipeFood.modele.Utilisateur;
import s6.ReceipeFood.service.ServiceProduit;

import java.util.List;
import java.util.Vector;


public class HibernateDao {
	public HibernateDao() {}
	
	private static class SingletonHolder
	{		
		private final static HibernateDao instance = new HibernateDao();
	}
 
	public static HibernateDao getInstance()
	{
		return SingletonHolder.instance;
	}
	
    private SessionFactory sessionFactory; // = HibernateUtil.getSessionFactory();

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(BaseModel obj) throws Exception{
        Session session = null;
        Transaction tr=null;
        try{
            session = getSessionFactory().openSession();
            tr=session.beginTransaction();
            session.saveOrUpdate(obj);
            tr.commit();
        }catch (Exception ex){
        	ex.printStackTrace();
            if(tr!=null)
                tr.rollback();
            throw ex;
        }finally {
            if(session!=null)
                session.close();
        }
    }
    
    public void update(BaseModel obj) throws Exception{
        Session session = null;
        Transaction tr=null;
        try{
            session = getSessionFactory().openSession();
            tr=session.beginTransaction();
            session.update(obj);
            tr.commit();
        }catch (Exception ex){
        	ex.printStackTrace();
            if(tr!=null)
                tr.rollback();
            throw ex;
        }finally {
            if(session!=null)
                session.close();
        }
    }
    
    public void delete(BaseModel obj) throws Exception{
        Session session = null;
        Transaction tr=null;
        try{
            session = getSessionFactory().openSession();
            tr=session.beginTransaction();
            session.delete(obj);
            tr.commit();
        }catch (Exception ex){
        	ex.printStackTrace();
            if(tr!=null)
                tr.rollback();
            throw ex;
        }finally {
            if(session!=null)
                session.close();
        }
    }
    
    public void save(BaseModel obj, Session session) throws Exception{
        try{
            session.saveOrUpdate(obj);
        }catch (Exception ex){
        	ex.printStackTrace();
            throw ex;
        }finally {
            if(session!=null)
                session.close();
        }
    }

    public void findById(BaseModel obj) throws Exception{
        Session session = null;
        try{
            session = getSessionFactory().openSession();
            session.load(obj,obj.getId());
        }catch (Exception ex){
        	ex.printStackTrace();
            throw ex;
        }finally {
            if(session!=null)
                session.close();
        }
    }

    public List<BaseModel> findAll(BaseModel obj)  throws Exception{
        Session session = null;
        try{
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(obj.getClass());
            return criteria.list();
        }catch (Exception ex){
        	ex.printStackTrace();
            throw ex;
        }finally {
            if(session!=null)
                session.close();
        }
    }
    
    public Utilisateur login(Utilisateur model)  throws Exception{
        Session session = null;
        try{
            session = getSessionFactory().openSession();
            Utilisateur user = session.createQuery("FROM Utilisateur "
            		+ "WHERE email = :emailutilisateur AND password = :passwordutilisateur", model.getClass())
            		.setParameter("emailutilisateur", model.getEmail())
            		.setParameter("passwordutilisateur", model.getPassword()).uniqueResult();
            return (Utilisateur)user;
        }catch (Exception ex){
            throw ex;
        }finally {
            if(session!=null)
                session.close();
        }
    }
    
    public Administrateur loginAdmin(Administrateur model)  throws Exception{
        Session session = null;
        try{
            session = getSessionFactory().openSession();
            Administrateur user = session.createQuery("FROM Administrateur "
            		+ "WHERE nomadmin = :nom AND password = :pass", model.getClass())
            		.setParameter("nom", model.getNom())
            		.setParameter("pass", model.getPassword()).uniqueResult();
            return (Administrateur)user;
        }catch (Exception ex){
            throw ex;
        }finally {
            if(session!=null)
                session.close();
        }
    }
    
    public List<Composant> findComposant(Composant model, String critere, boolean like)  throws Exception{
        Session session = null;
        try{
        	String value = "=";
        	String percent = "";
        	if(like){
        		value = "LIKE";
        		percent = "%";
        	}
            session = getSessionFactory().openSession();
            List<Composant> composant = new Vector<Composant>();
            composant = (List<Composant>) session.createQuery("FROM Composant "
            		+ "WHERE nomcomposant "+value+" :nomcomposant ORDER BY idcomposant DESC", model.getClass())
            		.setParameter("nomcomposant", percent+critere+percent)
            		.list();
            if(composant.isEmpty()){
                composant.add(model);
            }
            return composant;
        }catch (Exception ex){
            throw ex;
        }finally {
            if(session!=null)
                session.close();
        }
    }
    
    public List<ProduitVue> rechercheByProduit(Produit model,String nomProduit)  throws Exception{
        Session session = null;
        try{
            session = getSessionFactory().openSession();
            return (List<ProduitVue>) session.createQuery("FROM Produit "
            		+ "WHERE nomproduit LIKE :nom", model.getClass())
            		.setParameter("nom", "%"+nomProduit+"%").list();
        }catch (Exception ex){
            throw ex;
        }finally {
            if(session!=null)
                session.close();
        }
    }
    
    public List<ProduitVue> findByCategorie(Produit model,int idCategorie)  throws Exception{
        Session session = null;
        try{
            session = getSessionFactory().openSession();
            return (List<ProduitVue>) session.createQuery("FROM ProduitVue "
            		+ "WHERE idcategorie = :id", model.getClass())
            		.setParameter("id", idCategorie).list();
        }catch (Exception ex){
            throw ex;
        }finally {
            if(session!=null)
                session.close();
        }
    }
    
    public List<ProduitVue> rechercheByComposant(List<Composant> listeComposant)  throws Exception{
        Session session = null;
        try{
        	String list = "";
        	if(listeComposant.size() < 3){
        		throw new Exception("Veuillez inserer trois composants au moins.");
        	}
        	for(Composant c : listeComposant){
        		list += c.getId();
        		list += ", ";
        	}
            list = list.substring(0, list.lastIndexOf(","));
            session = getSessionFactory().openSession();
            return (List<ProduitVue>) session.createNativeQuery("SELECT p.* FROM composition comp"
            		+ " JOIN produitview as p ON comp.idproduit = p.idproduit"
            		+ " WHERE comp.idcomposant IN ("+list+")"
            		+ " GROUP BY p.idproduit, p.idcategorie, p.idutilisateur, p.nomproduit, p.etape, p.photo, p.dateajout, p.nomcategorie, p.nomcreateur HAVING count(*) = 3",ProduitVue.class)
                    .list();
        }catch (Exception ex){
            throw ex;
        }finally {
            if(session!=null)
                session.close();
        }
    }
//    SELECT p.*
//    FROM composition as comp
//    JOIN produit as p
//        ON comp.idproduit = p.idproduit
//       WHERE comp.idcomposant IN (1, 2, 25, 4)
//    GROUP BY p.idproduit
//      HAVING count(*) = 200
    
    public void findAll(BaseModelePagination pagination) {
		Session session = null;
	    try{
	    	session = getSessionFactory().openSession();
	    	
	    	String fromClause = "FROM " + pagination.getClasse().getName();
	    	
	    	pagination.setListe(session.createQuery(fromClause , pagination.getClasse())
	        		.setFirstResult(pagination.getFirstResult())
	        		.setMaxResults(pagination.getMaxResult())
	        		.list());
	    	long total = (long)session.createQuery("SELECT COUNT(id) " + fromClause)
	    				.uniqueResult();
	    	pagination.setTotalResult(total);
	    }catch (Exception ex){
	        throw ex;
	    }finally {
	        if(session!=null)
	            session.close();
	    }
	}
    
    public void findAllByCategorie(Categorie categorie,BaseModelePagination pagination) {
		Session session = null;
	    try{
	    	session = getSessionFactory().openSession();
	    	
	    	String fromClause = "FROM " + pagination.getClasse().getName() + 
	    			" WHERE idcategorie = :idcategorie";
	    	
	    	pagination.setListe(session.createQuery(fromClause , pagination.getClasse())
	    			.setParameter("idcategorie", categorie.getId())
	        		.setFirstResult(pagination.getFirstResult())
	        		.setMaxResults(pagination.getMaxResult())
	        		.list());
	    	long total = (long)session.createQuery("SELECT COUNT(id) " + fromClause)
	    			.setParameter("idcategorie", categorie.getId())	
	    			.uniqueResult();
	    	pagination.setTotalResult(total);
	    }catch (Exception ex){
	        throw ex;
	    }finally {
	        if(session!=null)
	            session.close();
	    }
	}
    
    public void rechercheByComposant(List<Composant> listeComposant,BaseModelePagination pagination) throws Exception {
 		Session session = null;
 	    try{
         	String list = "";
         	if(listeComposant.size() < 3){
         		throw new Exception("Veuillez inserer trois composants au moins.");
         	}
         	for(Composant c : listeComposant){
         		list += c.getId();
         		list += ", ";
         	}
             list = list.substring(0, list.lastIndexOf(","));
             
 	    	session = getSessionFactory().openSession();
 	    	
 	    	String fromClause = "SELECT p.* FROM composition comp"
             		+ " JOIN produitview as p ON comp.idproduit = p.idproduit"
             		+ " WHERE comp.idcomposant IN ("+list+")"
             		+ " GROUP BY p.idproduit, p.idcategorie, p.idutilisateur, p.nomproduit, "
             		+ "p.etape, p.photo, p.dateajout, p.nomcategorie, p.nomcreateur HAVING count(*) > 2";
 	    	
 	    	pagination.setListe(session.createNativeQuery(fromClause,ProduitVue.class)
	        		.setFirstResult(pagination.getFirstResult())
	        		.setMaxResults(pagination.getMaxResult())
	        		.list());
 	    	
	    	List<ProduitVue> liste = (List<ProduitVue>)session.createNativeQuery(fromClause,ProduitVue.class)
	        		.list();
	    	pagination.setTotalResult(liste.size());
 	    }catch (Exception ex){
 	        throw ex;
 	    }finally {
 	        if(session!=null)
 	            session.close();
 	    }
 	}
}
