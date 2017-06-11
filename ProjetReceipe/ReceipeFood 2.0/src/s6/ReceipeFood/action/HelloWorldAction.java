package s6.ReceipeFood.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import s6.ReceipeFood.modele.Produit;
import s6.ReceipeFood.service.BaseService;

public class HelloWorldAction extends ActionSupport implements SessionAware{
	private String name;

	Map<String,Object> session = ActionContext.getContext().getSession();
	
	public String execute(String id)throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("list-beans.xml");
		BaseService baseService = (BaseService) context.getBean("baseService");
		return "success";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
	}
}
