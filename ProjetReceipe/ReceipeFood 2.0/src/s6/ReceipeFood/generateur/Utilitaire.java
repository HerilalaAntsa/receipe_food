package s6.ReceipeFood.generateur;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import s6.ReceipeFood.modele.BaseModel;

public class Utilitaire {
	public static String getCatch(Classe classe){
		return "\t\t}catch(Exception e){ \n"
				+"\t\t\tconn.rollback(); \n"
				+"\t\t\te.printStackTrace(); \n"
				+"\t\t\tthrow new Exception(\""+classe.getNom()+" contenant des erreurs, cr\u00e9ation \u00e9chou\u00e9e.\"); \n"
				+"\t\t}finally { \n"
				+"\t\t	if(statement != null) statement.close(); \n"
				+"\t\t	if(conn != null) conn.close(); \n"
				+"\t\t} \n";
	}
	
	public static String getImport(Classe classe){
		return "import java.sql.Connection; \n"
				+"import java.sql.PreparedStatement; \n"
				+"import java.sql.ResultSet; \n"
				+"import java.sql.Date; \n"
				+"import java.util.List; \n"
				+"import java.util.Vector; \n"
				+"import "+classe.getNomPackage()+".*; \n";
	}
	
	public static Object executerMethode(Object objet, String nomMethode, Object[] parametres) throws Exception {
		Object retour;
		Class[] typeParametres = null;
		
		if (parametres != null) {
			typeParametres = new Class[parametres.length];
			for (int i = 0; i < parametres.length; ++i) {
				typeParametres[i] = parametres[i].getClass();
			}
		}
		
		Method m = objet.getClass().getMethod(nomMethode, typeParametres);
		if (Modifier.isStatic(m.getModifiers())) {
			retour = m.invoke(null, parametres);
		} else {
			retour = m.invoke(objet, parametres);
		}
		return retour;
	}
}
