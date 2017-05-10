package s6.ReceipeFood.modele;

public class BaseModel {
	int id;
	
	public BaseModel() {}

	public BaseModel(int id) {
		super();
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
