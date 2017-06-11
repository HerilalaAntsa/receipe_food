package s6.ReceipeFood.modele;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import s6.ReceipeFood.utilitaire.StringUtil;

public class Produit extends BaseModel{
	String nom;
	Categorie categorie;
	Utilisateur createur;
	String etape;
	String photo;
	Date dateAjout;
	
	List<Composition> ltComposition;
	
	public Produit() {
		this.setPhoto("default.jpg");
	}

	public Produit(int id, String nom, Categorie categorie,Utilisateur utilisateur,String etape, List<Composition> ltComposition) {
		super(id);
		this.setNom(nom);
		this.setCategorie(categorie);
		this.setCreateur(utilisateur);
		this.setEtape(etape);
		this.setLtComposition(ltComposition);
		this.setPhoto("default.jpg");
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}
	
	public String getDateAjoutString() {
		return StringUtil.formatDateSimple(this.getDateAjout());
	}
	
}
