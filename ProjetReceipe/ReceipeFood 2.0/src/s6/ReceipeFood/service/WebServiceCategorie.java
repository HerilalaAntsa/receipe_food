package s6.ReceipeFood.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import s6.ReceipeFood.modele.Categorie;


@WebService(name="WebServiceCategorie")
public class WebServiceCategorie {
	ServiceCategorie service;
	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("list-beans.xml");

	public WebServiceCategorie(){
		this.service = (ServiceCategorie) context.getBean("categorieService");
	}
	@WebMethod(operationName="findAll")
	public List<Categorie> findAll() throws Exception{
		return service.find();		
	}
	@WebMethod(operationName="findById")
	public Categorie findById(String id) throws Exception{
		return (Categorie)service.getBase().get(id,new Categorie());
	}
	@WebMethod(operationName="update")
	public void update(Categorie categorie) throws Exception{
		BaseService.getInstance().update(categorie);
	}
	@WebMethod(operationName="save")
	public void save(Categorie categorie) throws Exception{
		service.getBase().save(categorie);
	}
}
