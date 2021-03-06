package s6.ReceipeFood.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;

import junit.framework.TestCase;
import s6.ReceipeFood.dao.HibernateDao;
import s6.ReceipeFood.modele.BaseModel;
import s6.ReceipeFood.modele.Categorie;
import s6.ReceipeFood.modele.Composant;
import s6.ReceipeFood.modele.Composition;
import s6.ReceipeFood.modele.Produit;
import s6.ReceipeFood.modele.ProduitVue;
import s6.ReceipeFood.modele.Unite;
import s6.ReceipeFood.modele.Utilisateur;
import s6.ReceipeFood.service.ServiceCategorie;
import s6.ReceipeFood.service.ServiceComposant;
import s6.ReceipeFood.service.ServiceProduit;

public class TestProduit extends TestCase{

	public TestProduit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestProduit(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void setUp() throws Exception {}

	public void tearDown() throws Exception {}
	
//	public void testFindAll() throws Exception {
//		List<Produit> ltproduit = ServiceProduit.getInstance().find();
//		System.out.println(((Produit) ltproduit.get(0)).getCreateur().getNom());
//		assertEquals("fromage",((Produit) ltproduit.get(0)).getLtComposition().get(0).getComposant().getNom());
//	}
	
	
//	public void testSaveProduit() throws Exception {
//		List<Composant> ltComposant = ServiceComposant.getInstance().creerListeComposant("fromage;lait;oeuf;");
//		Utilisateur user = new Utilisateur(1, "Rakotomananjo", "Antsa", Date.valueOf(LocalDate.now()), "", "", "", "herilala.antsa@gmail.com", "Antsa");
//		Produit p = ServiceProduit.getInstance().nouveauProduit(4, user, "oeuf mimoza", "Aucun");
//		List<String> q = new Vector<String>();
//		List<String> u = new Vector<String>();
//		for(int i=0;i<ltComposant.size();i++){
//			q.add("30");
//			u.add(Unite.gramme.toString());
//		}
//
//		System.out.println(p.getCategorie());
//		ServiceProduit.getInstance().saveProduit(ltComposant, q, u, p);
//		
//		System.out.println(p.getLtComposition().get(0).getComposant().getNom());
//		assertEquals("fromage",p.getLtComposition().get(0).getComposant().getNom());
//	}
	
//	public void testFindById() throws Exception {
//		ServiceProduit traitementCategorie = new ServiceProduit();
//		Produit model = traitementCategorie.findById(1);
//		System.out.println(model.getNom());
//		assertEquals("cheese cake",model.getNom());
//	}
	
	public void testRechercheByProduit() throws Exception {
		List<ProduitVue> ltproduit = ServiceProduit.getInstance().rechercheByCategorie("crabe;fromage;lait;sel;oeuf");
		System.out.println((((ProduitVue) ltproduit.get(0)).getNom()));
		assertEquals("oeuf mimoza",((Produit) ltproduit.get(0)).getNom());
	}
	public static void main(String[] args) {
		TestCase tc = new TestProduit("testFindAll");
		tc.run();
	}
}
