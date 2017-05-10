package s6.ReceipeFood.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import s6.ReceipeFood.modele.Produit;
import s6.ReceipeFood.service.BaseService;

public class HelloWorldAction extends ActionSupport {
	private String name;
	public String execute()throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("list-beans.xml");
		BaseService baseService = (BaseService) context.getBean("baseService");
		Produit p = (Produit) baseService.get("1", new Produit());
		this.setName(p.getNom());
		return "success";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
