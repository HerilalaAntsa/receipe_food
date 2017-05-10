package s6.ReceipeFood.generateur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import s6.ReceipeFood.dao.Creation;
import s6.ReceipeFood.modele.Categorie;
import s6.ReceipeFood.modele.Utilisateur;

public class GenererDAO {
    private String path = "src/s6/ReceipeFood/modele";
    private String newPath = "src/s6/ReceipeFood/newdao/";
    
    private String save = "INSERT INTO %s (%s) VALUES (%s);";
    private String findAll = "SELECT * FROM %s;";
    private String findById = "SELECT * FROM %s WHERE ID%s = ?;";
    private String update = "UPDATE %s SET %s WHERE ID%s = ?;";
    private String delete = "DELETE FROM %s WHERE ID%s = ?;";
    
    public GenererDAO() {}

    public GenererDAO(String path, String newPath) {
        this.setPath(path);
        this.setNewPath(newPath);
    }

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNewPath() {
		return newPath;
	}

	public void setNewPath(String newPath) {
		this.newPath = newPath;
	}

	public static boolean isAttribut(String s)
    {
        boolean result = false;
        String[] listeJava = {"byte","short","float","char","boolean","String","int","double","Date","long"};
        for(int i=0;i<listeJava.length;i++)
        {
            if(s.compareTo(listeJava[i])==0)
            {
                result = true;
                break;
            }
        }
        return result;
    }
    
    public void generate(File path, String newPackage) throws IOException
    {
        BufferedReader br = null;
        FileReader filereader = null;
        File [] ltFile = path.listFiles();
        try{ 
        	for(File file : ltFile){
        		filereader = new FileReader(file);
                br = new BufferedReader(filereader); 
        		Classe classe = new Classe();
                classe.setNom(file.getName().replace(".java", ""));
                classe.setNomDao(file.getName().replace(".java", "DAO"));
                classe.setNomFichier(file.getName().replace(".java", "DAO.java"));
                List<String[]> ltAttribut = new Vector<String[]>(); 
//                System.out.println(nomClasse);
                String line;
                File newFile = new File(this.getNewPath()+classe.getNomFichier());
                int accolade = 0;
                while ((line = br.readLine()) != null) {
                	if(line.trim().startsWith("package")){
                		line = line.replace(";", "");
                		line = line.replace("package", "");
	                    classe.setNomPackage(line.trim());
//	                    System.out.println(classe.getNomPackage());
	                }
                	if(line.contains("{")){
                		accolade++;
                		continue;
                	}
                	if(line.contains("}")){
                		accolade--;
                		continue;
                	}
                	
//                	if(line.trim().startsWith("public class")){
//	                    nomClasse = line.substring(line.indexOf("public class"));
//	                    String[] re = nomClasse.split(" ");
//	                    nomClasse = re[0];
//	                    nomClasse += nomClasse+"DAO";
//	                }

                	if((accolade - 1) ==0 && line.contains(";")){
                		line = line.replace(";", "");
                		line = line.replace("private", "");
                		line = line.replace("public", "");
                            String[] re = line.trim().split(" ");
                            if(re[0].startsWith("List")) continue;
                            	String[] tab = new String[2];
                            	tab[0] = re[0];
                            	tab[1] = re[1];
                            	ltAttribut.add(tab);
                	}
                }
                classe.setLtAttribut(ltAttribut);
                
                newFile.createNewFile();
                

                PrintWriter writer = new PrintWriter(newFile, "UTF-8");
                writer.println("package "+newPackage+"; \n");
                writer.println(Utilitaire.getImport(classe));
                writer.println("\n");
                writer.println("public class "+classe.getNomDao()+" {");

                this.genererSave(classe, newFile, writer);
                this.genererUpdate(classe, newFile, writer);
                this.genererDelete(classe, newFile, writer);
                this.genererFindAll(classe, newFile, writer);
                this.genererFindById(classe, newFile, writer);
                this.genererVectorToDB(classe, newFile, writer);
                this.genererCreer(classe, newFile, writer);
                
                writer.println("}");

                writer.close();
        	}
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(filereader!=null) filereader.close();
            if(br!=null) br.close();
		}
//        return res;
    }
    
    public void genererSave(Classe classe,File newFile, PrintWriter writer)
    {
    	String[] list = {"",""};
        try{
        	for(String[] s : classe.getLtAttribut()){
        		if(s[1].compareToIgnoreCase("id")==0)continue;
            	if(!GenererDAO.isAttribut(s[0])){
            		list[0] += "ID"+s[1].toUpperCase();
            		list[0] += ", ";
            		list[1] += "?, ";
            	}else{
            		list[0] += s[1].toUpperCase();
            		list[0] += ", ";
            		list[1] += "?, ";
            	}
        	}
        list[0] = list[0].substring(0, list[0].lastIndexOf(","));
        list[1] = list[1].substring(0, list[1].lastIndexOf(","));
        String query = String.format(this.save, classe.getNom().toUpperCase(), list[0], list[1]);
        
        String setter = "statement.set%s(%s, objet.get%s());";
        
            writer.println("    public void save("+classe.getNom()+" objet) throws Exception {");
            writer.println("        String query = \""+query+"\";");
            writer.println("        Connection conn = null;");
            writer.println("        PreparedStatement statement=null;");
            writer.println("        try{");
            writer.println("        	conn = UtilDB.getConnPostgre();");
            writer.println("        	statement = conn.prepareStatement(query);");
            
        int i = 1;    
        for(String[] s : classe.getLtAttribut()){
    		if(s[1].compareToIgnoreCase("id")==0) continue;
        	String set = "";
        	if(GenererDAO.isAttribut(s[0])){
            	set = String.format(setter, 
            			s[0].replaceFirst(String.valueOf(s[0].charAt(0)), String.valueOf(s[0].charAt(0)).toUpperCase()), 
            			i++, 
            			s[1].replaceFirst(String.valueOf(s[1].charAt(0)), String.valueOf(s[1].charAt(0)).toUpperCase()));
        	}else{
            	set = String.format(setter, 
            			"Int", 
            			i++, 
            			s[1].replaceFirst(String.valueOf(s[1].charAt(0)), String.valueOf(s[1].charAt(0)).toUpperCase())+"().getId");
        	}
        	
            writer.println("\t\t\t"+set);
        }
        
            writer.println("\t\t\tstatement.execute();");
            writer.println("\t\t\tconn.commit();");
            writer.println(Utilitaire.getCatch(classe));
            writer.println("\t}");
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    public void genererUpdate(Classe classe,File newFile, PrintWriter writer){
    	String list = "";
        try{
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
        
        
        writer.println("    public void update("+classe.getNom()+" objet) throws Exception {");
        writer.println("        String query = \""+query+"\";");
        writer.println("        Connection conn = null;");
        writer.println("        PreparedStatement statement=null;");
        writer.println("        try{");
        writer.println("        	conn = UtilDB.getConnPostgre();");
        writer.println("        	statement = conn.prepareStatement(query);");
        
    String setter = "statement.set%s(%s, objet.get%s());";
        
    int i = 1;    
    for(String[] s : classe.getLtAttribut()){
		if(s[1].compareToIgnoreCase("id")==0) continue;
    	String set = "";
    	if(GenererDAO.isAttribut(s[0])){
        	set = String.format(setter, 
        			s[0].replaceFirst(String.valueOf(s[0].charAt(0)), String.valueOf(s[0].charAt(0)).toUpperCase()), 
        			i++, 
        			s[1].replaceFirst(String.valueOf(s[1].charAt(0)), String.valueOf(s[1].charAt(0)).toUpperCase()));
    	}else{
        	set = String.format(setter, 
        			"Int", 
        			i++, 
        			s[1].replaceFirst(String.valueOf(s[1].charAt(0)), String.valueOf(s[1].charAt(0)).toUpperCase())+"().getId");
    	}
    	
        writer.println("\t\t\t"+set);
    }
	String set = String.format(setter, 
			classe.getLtAttribut().get(0)[0].replaceFirst(String.valueOf(classe.getLtAttribut().get(0)[0].charAt(0)), String.valueOf(classe.getLtAttribut().get(0)[0].charAt(0)).toUpperCase()), 
			i++, 
			classe.getLtAttribut().get(0)[1].replaceFirst(String.valueOf(classe.getLtAttribut().get(0)[1].charAt(0)), String.valueOf(classe.getLtAttribut().get(0)[1].charAt(0)).toUpperCase()));
		writer.println("\t\t\t"+set);
        writer.println("\t\t\tstatement.execute();");
        writer.println("\t\t\tconn.commit();");
        writer.println(Utilitaire.getCatch(classe));
        writer.println("\t}");
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
    public void genererDelete(Classe classe,File newFile, PrintWriter writer) {
	    try{	
    	String query = String.format(this.delete, classe.getNom().toUpperCase(), classe.getNom().toUpperCase());
	        
	    	writer.println("    public void delete("+classe.getNom()+" objet) throws Exception {");
	        writer.println("        String query = \""+query+"\";");
	        writer.println("        Connection conn = null;");
	        writer.println("        PreparedStatement statement=null;");
	        writer.println("        try{");
	        writer.println("        	conn = UtilDB.getConnPostgre();");
	        writer.println("        	statement = conn.prepareStatement(query);");
	        
	    String setter = "statement.set%s(%s, objet.get%s());";
	        
	    int i = 1;    
		String set = String.format(setter, 
				classe.getLtAttribut().get(0)[0].replaceFirst(String.valueOf(classe.getLtAttribut().get(0)[0].charAt(0)), String.valueOf(classe.getLtAttribut().get(0)[0].charAt(0)).toUpperCase()), 
				i, 
				classe.getLtAttribut().get(0)[1].replaceFirst(String.valueOf(classe.getLtAttribut().get(0)[1].charAt(0)), String.valueOf(classe.getLtAttribut().get(0)[1].charAt(0)).toUpperCase()));
			writer.println("\t\t\t"+set);
	        writer.println("\t\t\tstatement.execute();");
	        writer.println("\t\t\tconn.commit();");
            writer.println(Utilitaire.getCatch(classe));
	        writer.println("\t}");
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	}
    
    public void genererFindAll(Classe classe,File newFile, PrintWriter writer) {
	    try{	
	    	String query = String.format(this.findAll, classe.getNom().toUpperCase());
	        
	    	writer.println("    public List<"+classe.getNom()+"> findAll("+classe.getNom()+" objet) throws Exception {");
	        writer.println("        String query = \""+query+"\";");
	        writer.println("        Connection conn = null;");
	        writer.println("        PreparedStatement statement=null;");
	        writer.println("        try{");
	        writer.println("        	conn = UtilDB.getConnPostgre();");
	        writer.println("        	statement = conn.prepareStatement(query);");
	        
	        writer.println("\t\t\treturn DBTo"+classe.getNom()+"(statement.executeQuery());");
	        
            writer.println(Utilitaire.getCatch(classe));
	        writer.println("\t}");
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
    }
    
    public void genererFindById(Classe classe,File newFile, PrintWriter writer) {
    	try{
    		String query = String.format(this.findById, classe.getNom().toUpperCase(), classe.getNom().toUpperCase());
	    	
    		writer.println("    public "+classe.getNom()+" findById(int id) throws Exception {");
	        writer.println("        String query = \""+query+"\";");
	        writer.println("        Connection conn = null;");
	        writer.println("        PreparedStatement statement=null;");
	        writer.println("        try{");
	        writer.println("        	conn = UtilDB.getConnPostgre();");
	        writer.println("        	statement = conn.prepareStatement(query);");
	        
	    String setter = "statement.set%s(%s, id);";
	    
	    int i = 1;    
		String statement = String.format(setter, 
				"Int", 
				i);
	        
			writer.println("\t\t\t"+statement);
	        writer.println("\t\t\tResultSet res = statement.executeQuery();");
	        writer.println("\t\t\t"+classe.getNom()+" model = null;");
	        writer.println("\t\tif(res.next()){ \n");
        	writer.println("\treturn this.creer"+classe.getNom()+"(res);");
			
			writer.println("\t\t} \n"
							+"\tthrow new Exception(\""+classe.getNom()+" introuvable\");");
            writer.println(Utilitaire.getCatch(classe));
	        writer.println("\t}");
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
    }
    
    public void genererVectorToDB(Classe classe, File newFile, PrintWriter writer){
    	String string = 
    	"\tpublic List<"+classe.getNom()+"> DBTo"+classe.getNom()+"(ResultSet res)throws Exception{ \n"
			+"\t\ttry{ \n"
				+"\t\t\tList<"+classe.getNom()+"> model = new Vector<"+classe.getNom()+">(); \n"
				+"\t\t\twhile(res.next()){ \n"
					+"\t\t\t\tmodel.add(this.creer"+classe.getNom()+"(res)); \n"
				+"\t\t\t} \n"
				+"\t\t\treturn model; \n"
			+"\t\t}catch(Exception e){ \n"
				+"\t\t\tthrow e; \n"
			+"\t\t}finally { \n"
				+"\t\t\tif(res != null) res.close(); \n"
			+"\t\t} \n"
		+"\t} \n";
    	writer.println(string);
    }
    
    public void genererCreer(Classe classe, File newFile, PrintWriter writer){
        String resultset = "res.get%s(\"%s\")";
    	String list = "";
    	String set = "";
        	for(String[] s : classe.getLtAttribut()){
    	    	if(GenererDAO.isAttribut(s[0])){
    	    		if(s[1].compareToIgnoreCase("id")==0){
    	    			s[1] = "id"+classe.getNom();
    	    		}
    	        	set = String.format(resultset, 
    	        			s[0].replaceFirst(String.valueOf(s[0].charAt(0)), String.valueOf(s[0].charAt(0)).toUpperCase()), 
    	        			s[1].toUpperCase());
            		list += set;
            		list += ",";
    	    	}
        	}
        list = list.substring(0, list.lastIndexOf(","));
        
    	String string = 
    			"\tpublic "+classe.getNom()+" creer"+classe.getNom()+"(ResultSet res) throws Exception{ \n"
    			+"\t\t return new "+classe.getNom()+"( \n"
    			+"\t\t\t"+list+"  \n"
    			+"\t\t); \n"
    			+"\t}";
    	writer.println(string);
    }
    
    public static void main(String[] args) throws IOException {
        GenererDAO dao = new GenererDAO();
        dao.generate(new File("src/s6/ReceipeFood/modele"), "s6.ReceipeFood.newdao");
    }
}
