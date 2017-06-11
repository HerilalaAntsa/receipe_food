package s6.ReceipeFood.service;

import s6.ReceipeFood.modele.Administrateur;
import s6.ReceipeFood.modele.Utilisateur;

public class ServiceAdministrateur {
	public ServiceAdministrateur() {}
	
	private static class SingletonHolder
	{		
		private final static ServiceAdministrateur instance = new ServiceAdministrateur();
	}
 
	public static ServiceAdministrateur getInstance()
	{
		return SingletonHolder.instance;
	}
	
	private BaseService base;
	
	public BaseService getBase() {
		return base;
	}

	public void setBase(BaseService baseService) {
		this.base = baseService;
	}
	
	public Administrateur login(Administrateur model) throws Exception{
		return this.getBase().getDao().loginAdmin(model);
	}
}
