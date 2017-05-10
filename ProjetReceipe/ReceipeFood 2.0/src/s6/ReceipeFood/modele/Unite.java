package s6.ReceipeFood.modele;

public enum Unite {
    kilogramme("kilogramme","kg"),
    gramme("gramme","g"),
    litre("litre","l"),
    piece("piece","pc."),
	cuillere("cuillere","c");
	
    String nom;
    String symbole;

	private Unite(String nom,String symbole) {
		this.setNom(nom);
		this.setSymbole(symbole);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
}
