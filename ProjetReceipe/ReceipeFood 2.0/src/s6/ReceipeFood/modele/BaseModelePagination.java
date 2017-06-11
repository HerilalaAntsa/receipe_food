package s6.ReceipeFood.modele;

import java.util.List;

public class BaseModelePagination {
	List<? extends BaseModel> liste;
	Class<? extends BaseModel> classe;
	int maxResult;
	int page;
	long totalResult;
	
	public BaseModelePagination(Class<? extends BaseModel> model, int maxResult, int page){
		setClasse(model);
		setMaxResult(maxResult);
		setPage(page);
	}
	
	public List<? extends BaseModel> getListe() {
		return liste;
	}
	public void setListe(List<? extends BaseModel> liste) {
		this.liste = liste;
	}
	public Class<? extends BaseModel> getClasse() {
		return classe;
	}
	public void setClasse(Class<? extends BaseModel> classe) {
		this.classe = classe;
	}
	public int getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public long getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(long total) {
		this.totalResult = total;
	}
	
	public int getNombrePage(){
		return (int) ((getTotalResult()/getMaxResult()) + 1);
	}
	public boolean isMoreThanOne(){
		return getNombrePage() > 1;
	}
	public int getFirstResult() {
		return (getPage()*getMaxResult());
	}
}
