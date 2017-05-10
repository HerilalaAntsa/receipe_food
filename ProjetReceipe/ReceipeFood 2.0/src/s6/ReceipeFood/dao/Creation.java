package s6.ReceipeFood.dao;

import java.sql.ResultSet;

import s6.ReceipeFood.modele.Categorie;
import s6.ReceipeFood.modele.Composant;
import s6.ReceipeFood.modele.Composition;
import s6.ReceipeFood.modele.Produit;
import s6.ReceipeFood.modele.Utilisateur;

public class Creation {

	public static Produit creerProduit(ResultSet res) throws Exception{
		Produit model = new Produit(
				res.getInt("IDPRODUIT"), 
				res.getString("NOMPRODUIT"),
				res.getString("ETAPE"));
		return model;
	}
	
	public static Composant creerComposant(ResultSet res) throws Exception{
		Composant model = new Composant(
				res.getInt("IDCOMPOSANT"), 
				res.getString("NOMCOMPOSANT"));
		return model;
	}
	
	public static Categorie creerCategorie(ResultSet res) throws Exception{
		Categorie model = new Categorie(
				res.getInt("IDCATEGORIE"), 
				res.getString("NOMCATEGORIE"));
		return model;
	}
	
	public static Utilisateur creerUtilisateur(ResultSet res) throws Exception{
		Utilisateur model = new Utilisateur(
				res.getInt("IDUTILISATEUR"), 
				res.getString("NOM"), 
				res.getString("PRENOM"), 
				res.getDate("DATENAISSANCE"),
				res.getString("SEXE"),
				res.getString("TELEPHONE"), 
				res.getString("ADRESSE"), 
				res.getString("EMAIL"),
				res.getString("PASSWORD"));
		return model;
	}
	
	public static Composition creerComposition(ResultSet res) throws Exception{
		Composition model = new Composition(
				creerProduit(res), 
				creerComposant(res), 
				res.getInt("QUANTITE"));
		return model;
	}
}
