package s6.ReceipeFood.modele;

public class Administrateur extends BaseModel{
	private String nom;
	private String password;
	
	public Administrateur() {}
	
	public Administrateur(String nom, String password) {
		super();
		this.setNom(nom);
		this.setPassword(password);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
