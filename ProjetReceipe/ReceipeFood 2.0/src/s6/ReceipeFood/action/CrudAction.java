package s6.ReceipeFood.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import s6.ReceipeFood.modele.*;
import s6.ReceipeFood.service.BaseService;

public class CrudAction extends ActionSupport implements SessionAware{
	private Administrateur admin;
	private String erreur;
	private String classe;
	private int id;
	private BaseModelePagination liste;
	private int page;
	private SessionMap<String, Object> session;
	
	public String start()throws Exception{
//		if(getAdmin() != null) return ERROR;
		return SUCCESS;
	}

	public String list()throws Exception{
		ConfigurableApplicationContext context = null;
		try{
			System.out.println(classe);
			Class<? extends BaseModel> classe = (Class<? extends BaseModel>) Class.forName(getClasse()); 
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			BaseService service = (BaseService)context.getBean("baseService");
			setListe(new BaseModelePagination(classe, 10, getPage()));
			service.getAll(getListe());
			if(getListe().getNombrePage()<= getPage()) return NONE;
			return SUCCESS;
		}catch(Exception e){
			setErreur(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}finally{
			if(context != null){
				context.close();
			}
		}
	}
	public String delete()throws Exception{
		ConfigurableApplicationContext context = null;
		try{
			Class<? extends BaseModel> classe = (Class<? extends BaseModel>) Class.forName(getClasse());
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			BaseService service = (BaseService)context.getBean("baseService");
			BaseModel base = classe.newInstance();
			base.setId(this.getId());
			service.delete(base);
			return SUCCESS;
		}catch(Exception e){
			setErreur(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}finally{
			if(context != null){
				context.close();
			}
		}
	}
	
	public Administrateur getAdmin() {
		return admin;
	}
	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}
	
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public BaseModelePagination getListe() {
		return liste;
	}
	public void setListe(BaseModelePagination liste) {
		this.liste = liste;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page - 1;
	}
	
	public String getErreur() {
		return erreur;
	}
	public void setErreur(String erreur) {
		this.erreur = erreur;
	}

	public SessionMap<String, Object> getSession() {
		return session;
	}
	public void setSession(SessionMap<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		setSession((SessionMap<String, Object>)session);
		setAdmin((Administrateur)session.get("admin"));
	}

}
