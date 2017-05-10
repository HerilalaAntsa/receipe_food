package s6.ReceipeFood.service;
import s6.ReceipeFood.dao.HibernateDao;
import s6.ReceipeFood.modele.BaseModel;

public class BaseService {
	private HibernateDao dao;
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
	public void delete(String idBase, BaseModel base) throws Exception{
		this.getDao().delete(get(idBase, base));
	}
	public void update(BaseModel model) throws Exception{
		this.getDao().update(model);
	}
}
