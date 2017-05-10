package s6.ReceipeFood.dao; 

import java.lang.reflect.*;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.Date; 
import java.util.List; 
import java.util.Vector;

import s6.ReceipeFood.generateur.Classe;
import s6.ReceipeFood.generateur.GenererDAO;
import s6.ReceipeFood.generateur.Utilitaire;
import s6.ReceipeFood.modele.*; 


public class ModelDAO {
    private String save = "INSERT INTO %s (%s) VALUES (%s);";
    private String findAll = "SELECT * FROM %s;";
    private String findAllModifie = "SELECT * FROM %s %s";
    private String findAllById = "SELECT * FROM %s WHERE ID%s = ?;";
    private String findById = "SELECT * FROM %s WHERE ID%s = ?;";
    private String update = "UPDATE %s SET %s WHERE ID%s = ?;";
    private String delete = "DELETE FROM %s WHERE ID%s = ?;";
    
    private String setter = "statement.set%s(%s, objet.get%s());";
    
    
    
	public void save(BaseModel objet) throws Exception {
		Classe classe = new Classe();
		
		classe.setNom(objet.getClass().getSimpleName());
		
		Field[] listAttribut = objet.getClass().getDeclaredFields();
//		int i = 0;
		for(Field field : listAttribut){
            if(field.getType().getSimpleName().startsWith("List")) continue;
			classe.addAttribut(field.getType().getSimpleName(), field.getName());
//			System.out.println(classe.getLtAttribut().get(i)[0]+" "+classe.getLtAttribut().get(i)[1]);
//			i++;
		}
       
//		Generation query 
    	String[] list = {"",""};
        	for(String[] s : classe.getLtAttribut()){
        		if(s[1].compareToIgnoreCase("id")==0)continue;
            	if(!GenererDAO.isAttribut(s[0])){
            		list[0] += "ID"+s[1].toUpperCase();
            		list[0] += ", ";
            		list[1] += "?, ";
            	}else{
            		if(s[1].compareToIgnoreCase("nom")==0){
                		list[0] += s[1]+classe.getNom();
                		list[0] = list[0].toUpperCase();
                		list[0] += ", ";
                		list[1] += "?, ";
            		}else{
                		list[0] += s[1].toUpperCase();
                		list[0] += ", ";
                		list[1] += "?, ";
            		}
            	}
        	}
        list[0] = list[0].substring(0, list[0].lastIndexOf(","));
        list[1] = list[1].substring(0, list[1].lastIndexOf(","));
        
        String query = String.format(this.save, classe.getNom().toUpperCase(), list[0], list[1]);
        
        Connection conn = null;
        PreparedStatement statement=null;
        try{
        	conn = UtilDB.getConnPostgre();
        	statement = conn.prepareStatement(query);

//        	Execution statement.set...(...)
            int j = 1;    
            for(String[] s : classe.getLtAttribut()){
        		if(s[1].compareToIgnoreCase("id")==0) continue;
        			
            	Object get = Utilitaire.executerMethode(objet, "get"+s[1].replaceFirst(String.valueOf(s[1].charAt(0)), String.valueOf(s[1].charAt(0)).toUpperCase()), null);

            	if(GenererDAO.isAttribut(s[0])){
        			if(get instanceof java.util.Date){
        				statement.setDate(j++, new java.sql.Date(((java.util.Date)get).getTime()));
        			}else{
        				statement.setObject(j++, get);
        			}
            	}else{
            		get = Utilitaire.executerMethode(objet, "get"+s[1].replaceFirst(String.valueOf(s[1].charAt(0)), String.valueOf(s[1].charAt(0)).toUpperCase()), null);
        			
        			BaseModel base = (BaseModel) get;
            		get = Utilitaire.executerMethode(base, "getId", null);
        			
        			statement.setInt(j++, (int) get);
            	}
            }
        	
			statement.execute();
			conn.commit();
		}catch(Exception e){ 
			conn.rollback(); 
			e.printStackTrace(); 
			throw new Exception(classe.getNom()+" contenant des erreurs, création échouée."); 
		}finally { 
			if(statement != null) statement.close(); 
			if(conn != null) conn.close(); 
		} 

	}
	
    public void update(BaseModel objet) throws Exception {
		Classe classe = new Classe();
		
		classe.setNom(objet.getClass().getSimpleName());
		
		Field[] listAttribut = objet.getClass().getDeclaredFields();
//		int i = 0;
		for(Field field : listAttribut){
            if(field.getType().getSimpleName().startsWith("List")) continue;
			classe.addAttribut(field.getType().getSimpleName(), field.getName());
//			System.out.println(classe.getLtAttribut().get(i)[0]+" "+classe.getLtAttribut().get(i)[1]);
//			i++;
		}
		
    	String list = "";
        	for(String[] s : classe.getLtAttribut()){
        		if(s[1].compareToIgnoreCase("id")==0) continue;
            	if(!GenererDAO.isAttribut(s[0])){
            		list += "ID"+s[1].toUpperCase();
            		list += " = ?, ";
            	}else{
            		list += s[1].toUpperCase();
            		list += " = ?, ";
            	}
        	}
        list = list.substring(0, list.lastIndexOf(","));
        String query = String.format(this.update, classe.getNom().toUpperCase(), list, classe.getNom().toUpperCase());

        Connection conn = null;
        PreparedStatement statement=null;
        try{
        	conn = UtilDB.getConnPostgre();
        	statement = conn.prepareStatement(query);
        	
//        	Execution statement.set...(...)
            int j = 1;    
            for(String[] s : classe.getLtAttribut()){
        		if(s[1].compareToIgnoreCase("id")==0) continue;
        			
            	Object get = Utilitaire.executerMethode(objet, "get"+s[1].replaceFirst(String.valueOf(s[1].charAt(0)), String.valueOf(s[1].charAt(0)).toUpperCase()), null);
            	
            	if(GenererDAO.isAttribut(s[0])){
        			if(get instanceof java.util.Date){
        				statement.setDate(j++, new java.sql.Date(((java.util.Date)get).getTime()));
        			}else{
        				statement.setObject(j++, get);
        			}
            	}else{
            		get = Utilitaire.executerMethode(objet, "get"+s[1].replaceFirst(String.valueOf(s[1].charAt(0)), String.valueOf(s[1].charAt(0)).toUpperCase()), null);
        			
        			BaseModel base = (BaseModel) get;
            		get = Utilitaire.executerMethode(base, "getId", null);
        			
        			statement.setInt(j++, (int) get);
            	}
            }
            Object get = Utilitaire.executerMethode(objet, "getId", null);
            statement.setObject(j++, get);
        	
			statement.execute();
			conn.commit();
		}catch(Exception e){ 
			conn.rollback(); 
			e.printStackTrace(); 
			throw new Exception(classe.getNom()+" contenant des erreurs, création échouée."); 
		}finally { 
			if(statement != null) statement.close(); 
			if(conn != null) conn.close(); 
		} 
	}
    
    public void delete(BaseModel objet) throws Exception {
		Classe classe = new Classe();
		
		classe.setNom(objet.getClass().getSimpleName());
		
		Field[] listAttribut = objet.getClass().getDeclaredFields();
//		int i = 0;
		for(Field field : listAttribut){
            if(field.getType().getSimpleName().startsWith("List")) continue;
			classe.addAttribut(field.getType().getSimpleName(), field.getName());
//			System.out.println(classe.getLtAttribut().get(i)[0]+" "+classe.getLtAttribut().get(i)[1]);
//			i++;
		}
		
		String query = String.format(this.delete, classe.getNom().toUpperCase(), classe.getNom().toUpperCase());
		
        Connection conn = null;
        PreparedStatement statement=null;
        try{
        	conn = UtilDB.getConnPostgre();
        	statement = conn.prepareStatement(query);
        	
//        	Execution statement.set...(...)
            int j = 1;  
            Object get = Utilitaire.executerMethode(objet, "getId", null);
            
			statement.setInt(j++, (int) get);
        	
			statement.execute();
			conn.commit();
		}catch(Exception e){ 
			conn.rollback(); 
			e.printStackTrace(); 
			throw new Exception(classe.getNom()+" contenant des erreurs, création échouée.");  
		}finally { 
			if(statement != null) statement.close(); 
			if(conn != null) conn.close(); 
		} 

	}
    public List<BaseModel> findAll(BaseModel objet,Boolean check) throws Exception {
		Classe classe = new Classe();
		
		classe.setNom(objet.getClass().getSimpleName());
		
		Field[] listAttribut = objet.getClass().getDeclaredFields();
		List<Field> newAttribut = new Vector<Field>();
		
//		Generation query 
    	String list = "";
    	int i=0;
        	for(Field field : listAttribut){
        		field.setAccessible(true);
        		Object value = field.get(objet);
        		if(value!=null){
        			if(field.getType()==int.class && (int)value<1)
        				continue;
        			if(field.getType().isPrimitive()||field.getType() == Date.class||field.getType() == String.class ){
            			if(i<1)
            				list += " WHERE ";
            			if(!list.isEmpty())
            				list += " AND ";
                    	if(field.getName().equalsIgnoreCase("id")){
                    		list += "ID"+classe.getNom().toUpperCase();
                    		list += " = ";
                    		list += "?";
                    	}else{
                    		if(field.getName().equalsIgnoreCase("nom")){
                        		list += field.getName().toUpperCase()+classe.getNom().toUpperCase();
                        		list += " = ";
                        		list += "?";
                    		}else{
                        		list += field.getName().toUpperCase();
                        		list += " = ";
                        		list += "?";
                    		}
                    	}
                    	newAttribut.add(field);
                		i++;
            		}else continue;
        		}else continue;
        	}
        list += ";";
        
		String query = String.format(this.findAllModifie, classe.getNom().toUpperCase(), list);
		System.out.println(query);
		
        Connection conn = null;
        PreparedStatement statement=null;
        try{
        	conn = UtilDB.getConnPostgre();
        	statement = conn.prepareStatement(query);
        	
//        	Execution statement.set...(...)
            int j = 1;    
            for(Field field : newAttribut){
            	Object get = Utilitaire.executerMethode(objet, "get"+field.getName().replaceFirst(String.valueOf(field.getName().charAt(0)), String.valueOf(field.getName().charAt(0)).toUpperCase()), null);

            	if(get instanceof java.util.Date){
    				statement.setDate(j++, new java.sql.Date(((java.util.Date)get).getTime()));
    			}else{
    				statement.setObject(j++, get);
    			}
            }
			return DBToBaseModel(statement.executeQuery(),objet,classe,check);
		}catch(Exception e){ 
			conn.rollback(); 
			e.printStackTrace(); 
			throw new Exception(classe.getNom()+" contenant des erreurs, création échouée."); 
		}finally { 
			if(statement != null) statement.close(); 
			if(conn != null) conn.close(); 
		} 
	}
    
    public List<BaseModel> findAllById(BaseModel objet,Class<?> type,BaseModel parent, Boolean check) throws Exception {
		Classe classe = new Classe();
		
		classe.setNom(objet.getClass().getSimpleName());
		
		String query = String.format(this.findAllById, type.getSimpleName().toUpperCase(), parent.getClass().getSimpleName().toUpperCase());
		
        Connection conn = null;
        PreparedStatement statement=null;
        try{
        	conn = UtilDB.getConnPostgre();
        	statement = conn.prepareStatement(query);
			statement.setInt(1, parent.getId());
			return DBToBaseModel(statement.executeQuery(),objet,classe,check);
		}catch(Exception e){ 
			conn.rollback(); 
			e.printStackTrace(); 
			throw new Exception(classe.getNom()+" contenant des erreurs, création échouée."); 
		}finally { 
			if(statement != null) statement.close(); 
			if(conn != null) conn.close(); 
		} 
	}
    
    public List<BaseModel> findAllById(BaseModel objet,Class<?> type,BaseModel parent) throws Exception {
    	return this.findAllById(objet,type,parent, false);
    }
    
    public BaseModel findById(BaseModel objet) throws Exception {
    	return this.findById(objet, false);
    }
    
    public BaseModel findById(BaseModel objet, Boolean check) throws Exception {
		Classe classe = new Classe();
		classe.setNom(objet.getClass().getSimpleName());
		
		String query = String.format(this.findById, classe.getNom().toUpperCase(), classe.getNom().toUpperCase());
		
        Connection conn = null;
        PreparedStatement statement=null;
        try{
        	conn = UtilDB.getConnPostgre();
        	statement = conn.prepareStatement(query);
			statement.setInt(1, objet.getId());
			ResultSet res = statement.executeQuery();
			if(res.next()){ 
				return this.creer(res,objet,classe,check);
			} 
			throw new Exception(classe.getNom()+" introuvable");
		}catch(Exception e){ 
			conn.rollback(); 
			e.printStackTrace(); 
			throw new Exception(classe.getNom()+" contenant des erreurs, création échouée."); 
		}finally { 
			if(statement != null) statement.close(); 
			if(conn != null) conn.close(); 
		} 

	}
	public List<BaseModel> DBToBaseModel(ResultSet res,BaseModel base,Classe classe,Boolean check)throws Exception{ 
		try{ 
			List<BaseModel> model = new Vector<BaseModel>(); 
			while(res.next()){ 
				model.add(this.creer(res,base,classe,check)); 
			} 
			return model; 
		}catch(Exception e){ 
			throw e; 
		}finally { 
			if(res != null) res.close(); 
		} 
	} 

	public BaseModel creer(ResultSet res,BaseModel objet, Classe classe,Boolean check) throws Exception{ 
		BaseModel base = objet.getClass().newInstance();
		Field[] listAttribut = objet.getClass().getDeclaredFields();
		try {
			for(Field field : listAttribut){
				String list = "";
	        	if(field.getName().equalsIgnoreCase("nom") || field.getName().equalsIgnoreCase("id")){
	        		list += field.getName()+classe.getNom();
	        		list = list.toUpperCase();
	        	}
	        	else if(field.getType().isPrimitive()||field.getType() == Date.class||field.getType() == String.class ){

	        		if(field.getType()==Date.class){
	        			Method m = objet.getClass().getMethod(
	    						"setDate", 
	    						field.getType());
	    				Method r = res.getClass().getMethod(
	    						"getDate", 
	    						String.class);
	    					m.invoke(base, r.invoke(res, list));
	    			}else{
	    				Method m = objet.getClass().getMethod(
	    						"set"+field.getName().replaceFirst(String.valueOf(field.getName().charAt(0)), String.valueOf(field.getName().charAt(0)).toUpperCase()), 
	    						field.getType());
	    				Method r = res.getClass().getMethod(
	    						"get"+field.getType().getSimpleName().replaceFirst(String.valueOf(field.getType().getSimpleName().charAt(0)), String.valueOf(field.getType().getSimpleName().charAt(0)).toUpperCase()), 
	    						String.class);
	    					m.invoke(base, r.invoke(res, list));
	    			}
	        	}else {
	        		if(field.getType().isInterface()){
	        			BaseModel child = (BaseModel)this.getListType(field).newInstance();
	    				Method m = objet.getClass().getMethod(
	    						"set"+field.getName().replaceFirst(String.valueOf(field.getName().charAt(0)), String.valueOf(field.getName().charAt(0)).toUpperCase()), 
	    						field.getType());
	            		if(check){
	            			m.invoke(base, this.findAllById(child,this.getListType(field),objet));
	                	}
	        		}else{
	        			BaseModel child = (BaseModel)field.getType().newInstance();
	    				child.setId(res.getInt("ID"+classe.getNom().toUpperCase()));
	    				Method m = objet.getClass().getMethod(
	    						"set"+field.getName().replaceFirst(String.valueOf(field.getName().charAt(0)), String.valueOf(field.getName().charAt(0)).toUpperCase()), 
	    						field.getType());
	            		if(check){
	        					m.invoke(base, this.findById(child));
	            		}else{
	            			m.invoke(base, child);
	            		}
	        		}
	        	}
	        }
			
			return base;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Class<?> getListType(Field field) throws Exception{
		ParameterizedType param = (ParameterizedType) field.getGenericType();
		Type[] args = param.getActualTypeArguments();
		for(Type t : args){
			return (Class<?>) t;
		}
		throw new Exception("Type list introuvable");
	}
	
	public static void main(String[] args) throws Exception {
		ModelDAO modeldao = new ModelDAO();
		Produit model = new Produit();
//		model.setCategorie(new Categorie(1, ""));
//		modeldao.save(model);
		List<BaseModel> ltproduit = modeldao.findAll(model,true);
		System.out.println(((Produit)ltproduit.get(0)).getNom());
	}
}
