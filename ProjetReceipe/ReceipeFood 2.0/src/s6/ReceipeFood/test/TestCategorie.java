package s6.ReceipeFood.test;

import java.util.List;

import junit.framework.TestCase;
import s6.ReceipeFood.modele.Categorie;
import s6.ReceipeFood.modele.Utilisateur;
import s6.ReceipeFood.service.ServiceCategorie;
import s6.ReceipeFood.service.ServiceUtilisateur;

public class TestCategorie extends TestCase{
	public TestCategorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestCategorie(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void setUp() throws Exception {}

	public void tearDown() throws Exception {}
	
	public void testFind() throws Exception {
		ServiceCategorie traitementCategorie = new ServiceCategorie();
		List<Categorie> ltcategorie = traitementCategorie.find();
		System.out.println(ltcategorie.get(0).getNom());
		assertEquals("Rakotomananjo",ltcategorie.get(0).getNom());
	}
	
	public void testFindById() throws Exception {
		ServiceCategorie traitementCategorie = new ServiceCategorie();
		Categorie categorie = traitementCategorie.findById(1);
		System.out.println(categorie.getNom());
		assertEquals("Rakotomananjo",categorie.getNom());
	}
	
	public static void main(String[] args) {
		TestCase tc = new TestUtilisateur("testGetUtilisateur");
		tc.run();
	}

}
