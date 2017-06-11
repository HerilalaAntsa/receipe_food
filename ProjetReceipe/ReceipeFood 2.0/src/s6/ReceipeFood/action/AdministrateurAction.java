package s6.ReceipeFood.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import s6.ReceipeFood.modele.Administrateur;
import s6.ReceipeFood.modele.Utilisateur;
import s6.ReceipeFood.service.ServiceAdministrateur;
import s6.ReceipeFood.service.ServiceUtilisateur;

public class AdministrateurAction  extends ActionSupport{
	private Administrateur admin;
	private String error;

	Map<String,Object> session = ActionContext.getContext().getSession();

	public String login() throws Exception{
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			ServiceAdministrateur adminService = (ServiceAdministrateur) context.getBean("adminService");
			System.out.println(this.getAdmin());
			Administrateur u = (Administrateur) adminService.login(this.getAdmin());
			if(u!=null){
				session.put("admin", u);
				return SUCCESS;
			}else{
				this.setError("Votre identifiant ou mot de passe est incorrect.");
				return LOGIN;
			}
		}catch(Exception e){
			e.printStackTrace();
			this.setError(e.getMessage());
			return LOGIN;
		}finally{
			if(context!=null)
				context.close();
		}
	}
	
	public String deconnexion()throws Exception{
        session.remove("user");
        addActionMessage("You have been Successfully Logged Out");
        return SUCCESS;
	}

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
