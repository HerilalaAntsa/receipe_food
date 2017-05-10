package s6.ReceipeFood.modele;

import java.util.List;
import java.util.Vector;

public class Composant extends BaseModel{
	String nom;
	List<Composition> ltComposition;
	
	public Composant() {}

	public Composant(int id, String nom, List<Composition> ltComposition) {
		super(id);
		this.setNom(nom);
		this.setLtComposition(ltComposition);
	}
	
	public Composant(int id, String nom) {
		super(id);
		this.setNom(nom);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Composition> getLtComposition() {
		return ltComposition;
	}

	public void setLtComposition(List<Composition> ltComposition) {
		this.ltComposition = ltComposition;
	}
}
