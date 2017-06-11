package s6.ReceipeFood.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import s6.ReceipeFood.modele.Categorie;
import s6.ReceipeFood.modele.Composant;
import s6.ReceipeFood.modele.Produit;
import s6.ReceipeFood.modele.Utilisateur;
import s6.ReceipeFood.service.BaseService;
import s6.ReceipeFood.service.ServiceCategorie;
import s6.ReceipeFood.service.ServiceComposant;
import s6.ReceipeFood.service.ServiceProduit;

public class AjoutProduitAction extends ActionSupport implements SessionAware{
	private Produit produit;
	private List<Categorie> ltCategorie;
	private String idCategorie;
	private String listeComposant;

	private List<Composant> ltComposant;
	private List<String> quantite;
	private List<String> unite;
	
	private String error;
	
	private Utilisateur user;
	
	public String ajoutProduit()throws Exception{
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			BaseService baseService = (BaseService) context.getBean("baseService");
			ServiceCategorie categorieService = (ServiceCategorie) context.getBean("categorieService");
			this.setLtCategorie(categorieService.find());
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			this.setError(e.getMessage());
			return "error";
		}finally{
			if(context!=null)
				context.close();
		}
	}
	
	public String ajoutComposant()throws Exception{
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			BaseService baseService = (BaseService) context.getBean("baseService");
			ServiceCategorie categorieService = (ServiceCategorie) context.getBean("categorieService");
			ServiceComposant composantService = (ServiceComposant) context.getBean("composantService");
			
			Map<String,Object> session = ActionContext.getContext().getSession();

			this.getProduit().setCategorie((Categorie) baseService.get(this.getIdCategorie(), new Categorie()));
			this.getProduit().setCreateur(this.getUser());
			this.setLtComposant(composantService.creerListeComposant(this.getListeComposant()));

			session.put("produit", this.getProduit());
			session.put("ltComposant", this.getLtComposant());
			
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			this.setError(e.getMessage());
			return "error";
		}finally{
			if(context!=null)
				context.close();
		}
	}
	
	public String save()throws Exception{
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			BaseService baseService = (BaseService) context.getBean("baseService");
			ServiceCategorie categorieService = (ServiceCategorie) context.getBean("categorieService");
			ServiceComposant composantService = (ServiceComposant) context.getBean("composantService");
			ServiceProduit produitService = (ServiceProduit) context.getBean("produitService");
			
			produitService.saveProduit(this.getLtComposant(), this.getQuantite(), this.getUnite(), this.getProduit());
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			this.setError(e.getMessage());
			return "error";
		}finally{
			if(context!=null)
				context.close();
		}
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<Categorie> getLtCategorie() {
		return ltCategorie;
	}

	public void setLtCategorie(List<Categorie> ltCategorie) {
		this.ltCategorie = ltCategorie;
	}

	public String getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getListeComposant() {
		return listeComposant;
	}

	public void setListeComposant(String listeComposant) {
		this.listeComposant = listeComposant;
	}

	public List<Composant> getLtComposant() {
		return ltComposant;
	}

	public void setLtComposant(List<Composant> ltComposant) {
		this.ltComposant = ltComposant;
	}

	public List<String> getQuantite() {
		return quantite;
	}

	public void setQuantite(List<String> quantite) {
		this.quantite = quantite;
	}

	public List<String> getUnite() {
		return unite;
	}

	public void setUnite(List<String> unite) {
		this.unite = unite;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	@Override
    public void setSession(Map<String, Object> map) {
        this.setUser((Utilisateur) map.get("user"));
        if(map.containsKey("ltComposant")){
            this.setProduit((Produit) map.get("produit"));
            this.setLtComposant((List<Composant>) map.get("ltComposant"));
        }
	}
}
