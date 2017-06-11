package s6.ReceipeFood.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import s6.ReceipeFood.modele.Administrateur;
import s6.ReceipeFood.modele.Categorie;
import s6.ReceipeFood.modele.Composant;
import s6.ReceipeFood.modele.Produit;
import s6.ReceipeFood.modele.ProduitVue;
import s6.ReceipeFood.modele.Utilisateur;
import s6.ReceipeFood.service.BaseService;
import s6.ReceipeFood.service.ServiceCategorie;
import s6.ReceipeFood.service.ServiceProduit;

public class CategorieAction  extends ActionSupport implements SessionAware{
	private List<Categorie> ltCategorie;
	private Administrateur admin;
	
	private String idCategorie;
	
	private Categorie categorie;

	public String listerCategorie()throws Exception{
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			ServiceProduit baseService = (ServiceProduit) context.getBean("produitService");
			ServiceCategorie categorieService = (ServiceCategorie) context.getBean("categorieService");
			this.setLtCategorie(categorieService.find());
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}finally{
			if(context!=null)
				context.close();
		}
	}
	
	public String detailCategorie()throws Exception{
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			BaseService baseService = (BaseService) context.getBean("baseService");
			this.setCategorie((Categorie) baseService.get(this.getIdCategorie(),new Categorie()));
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}finally{
			if(context!=null)
				context.close();
		}
	}
	
	public String updateCategorie()throws Exception{
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			BaseService baseService = (BaseService) context.getBean("baseService");
			baseService.update(this.getCategorie());
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}finally{
			if(context!=null)
				context.close();
		}
	}
	
	public String addCategorie()throws Exception{
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			BaseService baseService = (BaseService) context.getBean("baseService");
			baseService.save(this.getCategorie());
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}finally{
			if(context!=null)
				context.close();
		}
	}

	public List<Categorie> getLtCategorie() {
		return ltCategorie;
	}

	public void setLtCategorie(List<Categorie> ltCategorie) {
		this.ltCategorie = ltCategorie;
	}

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}
	
	public String getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
    public void setSession(Map<String, Object> map) {
        this.setAdmin((Administrateur) map.get("admin"));
	}
}
