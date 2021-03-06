package s6.ReceipeFood.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import s6.ReceipeFood.modele.Utilisateur;
import s6.ReceipeFood.service.ServiceUtilisateur;

public class TestUtilisateur extends TestCase{

	public TestUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestUtilisateur(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void setUp() throws Exception {}

	public void tearDown() throws Exception {}
	
//	public void testFind() throws Exception {
//		ServiceUtilisateur traitementUtilisateur = new ServiceUtilisateur();
//		List<Utilisateur> ltutilisateur = traitementUtilisateur.find();
//		System.out.println(ltutilisateur.get(0).getNom());
//		assertEquals("Rakotomananjo",ltutilisateur.get(0).getNom());
//	}
	
	public void testGetFindById() throws Exception {
		ServiceUtilisateur traitementUtilisateur = new ServiceUtilisateur();
		Utilisateur user = new Utilisateur(1, "Rakotomananjo", "Antsa", Date.valueOf(LocalDate.now()), "", "", "", "herilala.antsa@gmail.com", "Antsa");
		user = traitementUtilisateur.login(user);
		System.out.println(user.getNom());
		assertEquals("Rakotomananjo",user.getNom());
	}
	
	public static void main(String[] args) {
		TestCase tc = new TestUtilisateur("testGetUtilisateur");
		tc.run();
	}

}
