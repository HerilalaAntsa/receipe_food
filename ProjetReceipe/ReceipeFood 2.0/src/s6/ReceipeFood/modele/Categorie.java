package s6.ReceipeFood.modele;

public class Categorie extends BaseModel{
	String nom;
	
	public Categorie() {}
	
	public Categorie(int id, String nom) {
		super(id);
		this.setNom(nom);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
