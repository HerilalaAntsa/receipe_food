/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2017-05-18 11:13:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.time.*;
import s6.ReceipeFood.modele.*;
import s6.ReceipeFood.service.*;
import java.util.List;
import org.json.*;
import java.sql.*;

public final class listeProduit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/D:/Dossier%20ANTSA/s6/Mr%20Naina/Projet_s6/ProjetReceipe/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ReceipeFood%202.0/WEB-INF/lib/struts2-core-2.5.10.1.jar!/META-INF/struts-tags.tld", Long.valueOf(1488788942000L));
    _jspx_dependants.put("/WEB-INF/lib/struts2-core-2.5.10.1.jar", Long.valueOf(1488788990000L));
    _jspx_dependants.put("/includes/footer.jsp", Long.valueOf(1494596765053L));
    _jspx_dependants.put("/includes/header.jsp", Long.valueOf(1494596794999L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.time");
    _jspx_imports_packages.add("s6.ReceipeFood.modele");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("org.json");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("s6.ReceipeFood.service");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"57x57\" href=\"images/apple-icon-57x57.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"60x60\" href=\"images/apple-icon-60x60.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"images/apple-icon-72x72.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"images/apple-icon-76x76.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"images/apple-icon-114x114.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"120x120\" href=\"images/apple-icon-120x120.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"144x144\" href=\"images/apple-icon-144x144.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"images/apple-icon-152x152.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"images/apple-icon-180x180.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"192x192\"  href=\"images/android-icon-192x192.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"images/favicon-32x32.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"images/favicon-96x96.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"images/favicon-16x16.png\">\r\n");
      out.write("    <link rel=\"manifest\" href=\"images/manifest.json\">\r\n");
      out.write("    <meta name=\"msapplication-TileColor\" content=\"#ffffff\">\r\n");
      out.write("    <meta name=\"msapplication-TileImage\" content=\"images/ms-icon-144x144.png\">\r\n");
      out.write("    <meta name=\"theme-color\" content=\"#ffffff\">\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/ReceipeFood_2.0/css/style.css\" charset=\"utf-8\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/ReceipeFood_2.0/css/mobile.css\">\r\n");
      out.write("    <link href=\"/ReceipeFood_2.0/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/ReceipeFood_2.0/css/bootstrap.min.css\">\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"page\" class=\"container\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-sm-offset-10 col-sm-3\">\r\n");
      out.write("\t\t\t\t<a href=\"logOut\"><span class=\"glyphicon glyphicon-log-out\"></span> Deconnexion</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"header\" class=\"row\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<a href=\"accueil\" class=\"logo\"><img src=\"images/logo.png\" alt=\"\"></a>\r\n");
      out.write("\t\t\t\t<ul id=\"navigation\">\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"accueil\">Accueil</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("<!-- \t\t\t\t\t<li class=\"menu\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"about.html\">About</a>\r\n");
      out.write("\t\t\t\t\t\t<ul id=\"selected\" class=\"primary\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"product.html\">Product</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li> -->\r\n");
      out.write("\t\t\t\t\t<li class=\"menu\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"listeRecette\">Les recettes</a>\r\n");
      out.write("<!-- \t\t\t\t\t\t<ul class=\"secondary\">\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"singlepost.html\">Single post</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul> -->\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"menu\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"ajoutRecette\">nouvelle recette</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>");
      out.write('\r');
      out.write('\n');

	BaseModelePagination baseModele = (BaseModelePagination)request.getAttribute("baseModele");
	int numeroPage = (int)request.getAttribute("page");

      out.write("\r\n");
      out.write("\t\t<div id=\"body\">\r\n");
      out.write("\t\t\t<div class=\"header\">\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<h1>Liste des recettes</h1>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<hr>\r\n");
      out.write("\t\t\t<div class=\"blog\">\r\n");
      out.write("\t\t\t\t<div class=\"featured\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-offset-sm-4 col-sm-8\">\r\n");
      out.write("\t\t\t\t\t<form action=\"listeRecette\" class=\"form-horizontal\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<select class=\"icons\" name=\"idCategorie\"  required>\r\n");
      out.write("\t\t\t\t\t\t        <option value=\"TOUS\" disabled selected>Trier par categorie</option>\r\n");
      out.write("\t\t\t\t\t\t      ");
 for(Categorie c : (List<Categorie>)request.getAttribute("ltCategorie")) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t        <option value=\"");
 out.print(c.getId()); 
      out.write('"');
      out.write('>');
 out.print(c.getNom()); 
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t      ");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t        <option value=\"TOUS\">Tous</option>\r\n");
      out.write("\t\t\t\t\t    </select>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t    <input type=\"submit\" value=\"Valider\" id=\"submit\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t");
 for(ProduitVue p : (List<ProduitVue>)baseModele.getListe()){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<img style=\"width:200px;\" src=\"images/");
 out.print(p.getPhoto()); 
      out.write("\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h1>");
 out.print(p.getNom()); 
      out.write("\t\t\t<span class=\"badge\">");
 out.print(p.getNomCategorie()); 
      out.write("</span></h1> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>Par ");
 out.print(p.getNomCreateur()); 
      out.write(' ');
      out.write('-');
      out.write(' ');
 out.print(p.getDateAjoutString()); 
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
 for(Composition c : (List<Composition>)p.getLtComposition()){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"label label-success\">");
 out.print(c.getComposant().getNom()); 
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<br><br>\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"detailRecette?idProduit=");
 out.print(p.getId()); 
      out.write("\" class=\"more\">Read More</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t<ul class=\"pagination\">\r\n");
      out.write("\t\t\t\t\t");
 if(request.getAttribute("listeRecherche")!=null){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
 for(int i = 0; i<baseModele.getNombrePage();i++){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
 if(i == numeroPage) out.print("active"); 
      out.write("\"><a href=\"Recherche?page=");
 out.print(i+1); 
      out.write("&listeRecherche=");
 out.print(request.getAttribute("listeRecherche")); 
      out.write('"');
      out.write('>');
 out.print(i+1); 
      out.write("</a></li>\r\n");
      out.write("\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
 for(int i = 0; i<baseModele.getNombrePage();i++){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"");
 if(i == numeroPage) out.print("active"); 
      out.write("\"><a href=\"listeRecette?page=");
 out.print(i+1); 
      out.write('"');
      out.write('>');
 out.print(i+1); 
      out.write("</a></li>\r\n");
      out.write("\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"sidebar\">\r\n");
      out.write("\t\t\t\t\t<h1>Recent Posts</h1>\r\n");
      out.write("\t\t\t\t\t<img src=\"images/on-diet.png\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t<h2>ON THE DIET</h2>\r\n");
      out.write("\t\t\t\t\t<span>By Admin on November 28, 2023</span>\r\n");
      out.write("\t\t\t\t\t<p>You can replace all this text with your own text. You can remove any link to our website from this website template.</p>\r\n");
      out.write("\t\t\t\t\t<a href=\"singlepost.html\" class=\"more\">Read More</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("    <div>\r\n");
      out.write("        <div class=\"connect\">\r\n");
      out.write("            <a href=\"http://facebook.com\" class=\"facebook\">facebook</a>\r\n");
      out.write("            <a href=\"http://twitter.com\" class=\"twitter\">twitter</a>\r\n");
      out.write("            <a href=\"http://googleplus.com\" class=\"googleplus\">googleplus</a>\r\n");
      out.write("            <a href=\"http://pinterest.com\" class=\"pinterest\">pinterest</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <p>&copy; 2017 Freezeedera. All Rights Reserved.<br>\r\n");
      out.write("        Rakotomananjo Antsa Herilala H24 - Promo 8 A</p>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"js/jquery.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/mobile.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    $('.textarea').wysihtml5();\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}