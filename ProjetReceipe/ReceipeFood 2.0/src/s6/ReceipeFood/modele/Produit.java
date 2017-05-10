package s6.ReceipeFood.modele;

import java.util.List;

public class Produit extends BaseModel{
	String nom;
	Categorie categorie;
	Utilisateur createur;
	String etape;
	
	List<Composition> ltComposition;
	
	public Produit() {}

	public Produit(int id, String nom, Categorie categorie,Utilisateur utilisateur,String etape, List<Composition> ltComposition) {
		super(id);
		this.setNom(nom);
		this.setCategorie(categorie);
		this.setCreateur(utilisateur);
		this.setEtape(etape);
		this.setLtComposition(ltComposition);
	}

	public Produit(int id, String nom,String etape) {
		super(id);
		this.setNom(nom);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Composition> getLtComposition() {
		return ltComposition;
	}

	public void setLtComposition(List<Composition> ltComposition) {
		this.ltComposition = ltComposition;
	}

	public Utilisateur getCreateur() {
		return createur;
	}

	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}

	public String getEtape() {
		return etape;
	}

	public void setEtape(String etape) {
		this.etape = etape;
	}
	
}