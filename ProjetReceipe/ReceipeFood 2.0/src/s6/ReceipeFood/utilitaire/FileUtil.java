package s6.ReceipeFood.utilitaire;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

public class FileUtil {
	public static String insererImage(HttpServletRequest request) throws Exception{
		String directory = request.getServletContext().getRealPath("IMG/Produit");
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024;

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		factory.setSizeThreshold(maxMemSize);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFileSize);
		if(ServletFileUpload.isMultipartContent(request)){
			try{
				List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
				File file = new File("");
				for(FileItem i : items){
					if(i.isFormField()){
						String fileName = i.getName();
						file = new File(directory+fileName);
						i.write(file);
						System.out.println(file.exists());
					}
				}
				return file.getPath();
			}catch(Exception e){
				throw new Exception("Fichier non téléchargé !");
			}
		}
		else{
			throw new Exception("Aucun fichier à télécharger !");
		}
	}
}
