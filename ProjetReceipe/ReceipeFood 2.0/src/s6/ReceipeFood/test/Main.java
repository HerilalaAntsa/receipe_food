package s6.ReceipeFood.test;

import javax.xml.ws.Endpoint;

import s6.ReceipeFood.service.WebServiceCategorie;

public class Main {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:5858/Categorie", new WebServiceCategorie());
	}
}
