package s6.ReceipeFood.action;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import s6.ReceipeFood.modele.Produit;
import s6.ReceipeFood.modele.Utilisateur;
import s6.ReceipeFood.service.ServiceUtilisateur;

public class UtilisateurAction extends ActionSupport  implements SessionAware{
	private Utilisateur user;
	private String dateNaissance;
	private String error;
	
	Map<String,Object> session = ActionContext.getContext().getSession();

	public String login()throws Exception{
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("list-beans.xml");
			ServiceUtilisateur utilisateurService = (ServiceUtilisateur) context.getBean("utilisateurService");
			Utilisateur u = (Utilisateur) utilisateurService.login(user);
			if(u!=null){
				session.put("user", u);
				return SUCCESS;
			}else{
				return LOGIN;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(context!=null)
				context.close();
		}
	}
	
	public String inscription()throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("list-beans.xml");
		ServiceUtilisateur utilisateurService = (ServiceUtilisateur) context.getBean("utilisateurService");
		try{
			user.setDateNaissance(this.getDateNaissance());
			utilisateurService.inscription(user);
			return "success";
		}catch(Exception e){
			this.setError(e.getMessage());
			this.setUser(user);
			return "error";
		}
	}
	
	public String deconnexion()throws Exception{
        session.remove("user");
        addActionMessage("You have been Successfully Logged Out");
        return SUCCESS;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	
}