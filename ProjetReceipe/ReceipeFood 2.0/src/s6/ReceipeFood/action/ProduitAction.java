package s6.ReceipeFood.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import s6.ReceipeFood.modele.BaseModelePagination;
import s6.ReceipeFood.modele.Categorie;
import s6.ReceipeFood.modele.Produit;
import s6.ReceipeFood.modele.ProduitVue;
import s6.ReceipeFood.service.BaseService;
import s6.ReceipeFood.service.ServiceCategorie;
import s6.ReceipeFood.service.ServiceProduit;

public class ProduitAction  extends ActionSupport implements SessionAware{
	BaseModelePagination baseModele;
	private String classe;
	private String idProduit;
	private ProduitVue produit;
	private List<Categorie> ltCategorie;
	private String idCategorie = "TOUS";
	private int page;
	private String listeRecherche;
	private String error;

	Map<String,Object> session = ActionContext.getContext().getSession();
	
	public String listerProduit()throws Exception{
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			ServiceProduit baseService = (ServiceProduit) context.getBean("produitService");
			ServiceCategorie categorieService = (ServiceCategorie) context.getBean("categorieService");
			this.setLtCategorie(categorieService.find());
			this.setBaseModele(baseService.findByCategorie(this.getIdCategorie(),this.getPage()));
			if(getBaseModele().getNombrePage()<= getPage()) return NONE;
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}finally{
			if(context!=null)
				context.close();
		}
	}
	
	public String detailProduit()throws Exception{
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			BaseService baseService = (BaseService) context.getBean("baseService");
			this.setProduit((ProduitVue) baseService.get(this.getIdProduit(),new ProduitVue()));
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}finally{
			if(context!=null)
				context.close();
		}
	}
	
	public String rechercher()throws Exception{
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			ServiceProduit baseService = (ServiceProduit) context.getBean("produitService");
			ServiceCategorie categorieService = (ServiceCategorie) context.getBean("categorieService");
			this.setLtCategorie(categorieService.find());
			this.setBaseModele(baseService.rechercheByComposant(this.getListeRecherche(),this.getPage()));
			if(getBaseModele().getNombrePage()<= getPage()) return NONE;
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
	
	public String aucunResultat()throws Exception{
		this.setError("Désolé, aucun resultat n'a ete trouvé");
		return SUCCESS;
	}

	public BaseModelePagination getBaseModele() {
		return baseModele;
	}

	public void setBaseModele(BaseModelePagination baseModele) {
		this.baseModele = baseModele;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}

	public ProduitVue getProduit() {
		return produit;
	}

	public void setProduit(ProduitVue produit) {
		this.produit = produit;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page - 1;
	}

	public String getListeRecherche() {
		return listeRecherche;
	}

	public void setListeRecherche(String listeRecherche) {
		this.listeRecherche = listeRecherche;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
