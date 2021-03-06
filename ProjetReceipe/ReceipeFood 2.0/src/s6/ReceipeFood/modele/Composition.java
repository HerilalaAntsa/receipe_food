package s6.ReceipeFood.modele;

public class Composition extends BaseModel{
	Produit produit;
	Composant composant;
	float quantite;
	Unite unite;
	
	public Composition() {
		
	}
	public Composition(Produit produit, Composant composant, float quantite,Unite unite) {
		super();
		this.setProduit(produit);
		this.setComposant(composant);
		this.setQuantite(quantite);
		this.setUnite(unite);
	}
	
	public Composition(int id, float quantite,Unite unite) {
		super(id);
		this.setId(id);
		this.setQuantite(quantite);
		this.setUnite(unite);
	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Composant getComposant() {
		return composant;
	}
	public void setComposant(Composant composant) {
		this.composant = composant;
	}
	public float getQuantite() {
		return quantite;
	}
	public void setQuantite(float quantite) {
		this.quantite = quantite;
	}
	public Unite getUnite() {
		return unite;
	}
	public void setUnite(Unite unite) {
		this.unite = unite;
	}
	public void setUnite(String unite) {
		this.unite = Unite.valueOf(unite);
	}
	
}
