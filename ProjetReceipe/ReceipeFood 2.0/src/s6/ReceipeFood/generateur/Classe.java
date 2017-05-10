package s6.ReceipeFood.generateur;

import java.util.List;
import java.util.Vector;

public class Classe {
	String nom;
	String nomDao;
	String nomFichier;
	List<String[]> ltAttribut = new Vector<String[]>();
	String nomPackage;
	List<String> ltMethode = new Vector<String>();
	
	public Classe() {}
	
	public Classe(String nom, String nomDao, String nomFichier, List<String[]> ltAttribut, String nomPackage) {
		super();
		this.setNom(nomDao);
		this.setNomDao(nomDao);
		this.setNomFichier(nomFichier);
		this.setLtAttribut(ltAttribut);
		this.setNomPackage(nomPackage);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNomDao() {
		return nomDao;
	}
	public void setNomDao(String nomDao) {
		this.nomDao = nomDao;
	}
	public List<String[]> getLtAttribut() {
		return ltAttribut;
	}
	public void setLtAttribut(List<String[]> ltAttribut) {
		this.ltAttribut = ltAttribut;
	}
	
	public void addAttribut(String type, String valeur){
    	String[] tab = new String[2];
    	tab[0] = type;
    	tab[1] = valeur;
    	this.getLtAttribut().add(tab);
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}

	public String getNomPackage() {
		return nomPackage;
	}

	public void setNomPackage(String nomPackage) {
		this.nomPackage = nomPackage;
	}

	public List<String> getLtMethode() {
		return ltMethode;
	}

	public void setLtMethode(List<String> ltMethode) {
		this.ltMethode = ltMethode;
	}
	public void addMethode(String valeur){
    	this.getLtMethode().add(valeur);
	}
	
}
