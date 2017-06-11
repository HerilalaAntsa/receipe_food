package s6.ReceipeFood.service;
import java.util.List;

import s6.ReceipeFood.dao.HibernateDao;
import s6.ReceipeFood.modele.BaseModel;
import s6.ReceipeFood.modele.BaseModelePagination;

public class BaseService {
	private HibernateDao dao; // = new HibernateDao();
	private BaseService(){
		if(dao == null) dao = new HibernateDao();
	}
	private static class Holder
	{		
		private final static BaseService instance = new BaseService();
	}
	public static BaseService getInstance(){
		return Holder.instance;
	}
	
	public HibernateDao getDao() {
		return dao;
	}

	public void setDao(HibernateDao dao) {
		this.dao = dao;
	}

	public void save(BaseModel model) throws Exception{;
		this.getDao().save(model);
	}
	public List<BaseModel> getAll(BaseModel model) throws Exception{
		try{
			return this.getDao().findAll(model);
		}catch(Exception e){
			throw new Exception("Element introuvable, valeur incorrecte");
		}
	}	
	public void getAll(BaseModelePagination model) throws Exception{
		try{
			this.getDao().findAll(model);
		}catch(Exception e){
			throw new Exception("Element introuvable, valeur incorrecte");
		}
	}	
	public BaseModel get(String idBase, BaseModel model) throws Exception{
		try{
			int id = Integer.parseInt(idBase.trim());
			model.setId(id);
			this.getDao().findById(model);
			return model;
		}catch(NumberFormatException e){
			throw new Exception("Element introuvable, valeur incorrecte");
		}
	}	
	public void delete(BaseModel base) throws Exception{
		this.getDao().findById(base);
		this.getDao().delete(base);
	}
	public void update(BaseModel model) throws Exception{
		this.getDao().update(model);
	}
}
