/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2017-05-17 14:12:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.administrateur.categorie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.time.*;
import s6.ReceipeFood.modele.*;
import s6.ReceipeFood.service.*;
import java.util.List;
import org.json.*;
import java.sql.*;

public final class modifierCategorie_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("jar:file:/D:/Dossier%20ANTSA/s6/Mr%20Naina/Projet_s6/ProjetReceipe/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ReceipeFood%202.0/WEB-INF/lib/struts2-core-2.5.10.1.jar!/META-INF/struts-tags.tld", Long.valueOf(1488788942000L));
    _jspx_dependants.put("/WEB-INF/lib/struts2-core-2.5.10.1.jar", Long.valueOf(1488788990000L));
    _jspx_dependants.put("/administrateur/categorie/../template/footer.jsp", Long.valueOf(1495025888878L));
    _jspx_dependants.put("/administrateur/categorie/../template/header.jsp", Long.valueOf(1495027161914L));
    _jspx_dependants.put("/administrateur/categorie/../template/sidebar.jsp", Long.valueOf(1495026573040L));
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

Administrateur admin = (Administrateur)request.getAttribute("admin");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Freezee | Administrateur</title>\r\n");
      out.write("    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>\r\n");
      out.write("    <link href=\"/ReceipeFood_2.0/administrateur/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"/ReceipeFood_2.0/administrateur/dist/css/AdminLTE.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"/ReceipeFood_2.0/administrateur/dist/css/skins/_all-skins.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"/ReceipeFood_2.0/administrateur/plugins/iCheck/flat/blue.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"/ReceipeFood_2.0/administrateur/plugins/morris/morris.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"/ReceipeFood_2.0/administrateur/plugins/jvectormap/jquery-jvectormap-1.2.2.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"/ReceipeFood_2.0/administrateur/plugins/datepicker/datepicker3.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"/ReceipeFood_2.0/administrateur/plugins/daterangepicker/daterangepicker-bs3.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"/ReceipeFood_2.0/administrateur/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("    <script src=\"https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"skin-blue\">\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("    <header class=\"main-header\">\r\n");
      out.write("        <a href=\"#\" class=\"logo\"><b>Freezee</a>\r\n");
      out.write("        <nav class=\"navbar navbar-static-top\" role=\"navigation\">\r\n");
      out.write("            <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"offcanvas\" role=\"button\">\r\n");
      out.write("                <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("            </a>\r\n");
      out.write("            <div class=\"navbar-custom-menu\">\r\n");
      out.write("                <ul class=\"nav navbar-nav\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- User Account: style can be found in dropdown.less -->\r\n");
      out.write("                    <li class=\"dropdown user user-menu\">\r\n");
      out.write("                        <div class=\"pull-right\">\r\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t                  <!-- <img src=\"dist/img/user2-160x160.jpg\" class=\"user-image\" alt=\"User Image\"/> -->\r\n");
      out.write("\t\t\t                  <span class=\"hidden-xs\">");
 out.print(admin.getNom()); 
      out.write("</span>\r\n");
      out.write("\t\t\t                </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("               <ul class=\"dropdown-menu\">\r\n");
      out.write("                  <!-- User image -->\r\n");
      out.write("                  <li class=\"user-header\">\r\n");
      out.write("                    <img src=\"dist/img/user2-160x160.jpg\" class=\"img-circle\" alt=\"User Image\" />\r\n");
      out.write("                    <p>\r\n");
      out.write("                      ");
 out.print(admin.getNom()); 
      out.write(" - Administrateur\r\n");
      out.write("                    </p>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <!-- Menu Footer-->\r\n");
      out.write("                  <li class=\"user-footer\">\r\n");
      out.write("                    <div class=\"pull-right\">\r\n");
      out.write("                      <a href=\"logOutAdmin\" class=\"btn btn-default btn-flat\">Deconnexion</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </header>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <!-- Left side column. contains the logo and sidebar -->\r\n");
      out.write("      <aside class=\"main-sidebar\">\r\n");
      out.write("        <!-- sidebar: style can be found in sidebar.less -->\r\n");
      out.write("        <section class=\"sidebar\">\r\n");
      out.write("          <!-- Sidebar user panel -->\r\n");
      out.write("          <div class=\"user-panel\">\r\n");
      out.write("            <div class=\"pull-left image\">\r\n");
      out.write("              <img src=\"dist/img/user2-160x160.jpg\" class=\"img-circle\" alt=\"User Image\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"pull-left info\">\r\n");
      out.write("              <p>");
 out.print(((Administrateur)request.getAttribute("admin")).getNom()); 
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("              <a href=\"#\"><i class=\"fa fa-circle text-success\"></i> Online</a>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- search form -->\r\n");
      out.write("          <form action=\"#\" method=\"get\" class=\"sidebar-form\">\r\n");
      out.write("            <div class=\"input-group\">\r\n");
      out.write("              <input type=\"text\" name=\"q\" class=\"form-control\" placeholder=\"Search...\"/>\r\n");
      out.write("              <span class=\"input-group-btn\">\r\n");
      out.write("                <button type='submit' name='search' id='search-btn' class=\"btn btn-flat\"><i class=\"fa fa-search\"></i></button>\r\n");
      out.write("              </span>\r\n");
      out.write("            </div>\r\n");
      out.write("          </form>\r\n");
      out.write("          <!-- /.search form -->\r\n");
      out.write("          <!-- sidebar menu: : style can be found in sidebar.less -->\r\n");
      out.write("          <ul class=\"sidebar-menu\">\r\n");
      out.write("            <li class=\"header\">MENU PRINCIPAL</li>\r\n");
      out.write("            <li class=\"active treeview\">\r\n");
      out.write("              <a href=\"#\">\r\n");
      out.write("                <i class=\"fa fa-dashboard\"></i> <span>Tableau de bord</span> <i class=\"fa fa-angle-left pull-right\"></i>\r\n");
      out.write("              </a>\r\n");
      out.write("              <ul class=\"treeview-menu\">\r\n");
      out.write("                <li class=\"active\"><a href=\"index.html\"><i class=\"fa fa-circle-o\"></i> Tableau de bord</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"treeview\">\r\n");
      out.write("              <a href=\"#\">\r\n");
      out.write("                <i class=\"fa fa-files-o\"></i>\r\n");
      out.write("                <span>Categorie</span>\r\n");
      out.write("                <span class=\"label label-primary pull-right\">4</span>\r\n");
      out.write("              </a>\r\n");
      out.write("              <ul class=\"treeview-menu\">\r\n");
      out.write("                <li><a href=\"/ReceipeFood_2.0/administrateur/Categorie\"><i class=\"fa fa-circle-o\"></i> Liste des categories</a></li>\r\n");
      out.write("                <li><a href=\"/ReceipeFood_2.0/administrateur/Categorie/Ajout\"><i class=\"fa fa-circle-o\"></i> Ajouter une categorie</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("              <a href=\"pages/widgets.html\">\r\n");
      out.write("                <i class=\"fa fa-th\"></i> <span>Widgets</span> <small class=\"label pull-right bg-green\">new</small>\r\n");
      out.write("              </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"treeview\">\r\n");
      out.write("              <a href=\"#\">\r\n");
      out.write("                <i class=\"fa fa-pie-chart\"></i>\r\n");
      out.write("                <span>Charts</span>\r\n");
      out.write("                <i class=\"fa fa-angle-left pull-right\"></i>\r\n");
      out.write("              </a>\r\n");
      out.write("              <ul class=\"treeview-menu\">\r\n");
      out.write("                <li><a href=\"pages/charts/morris.html\"><i class=\"fa fa-circle-o\"></i> Morris</a></li>\r\n");
      out.write("                <li><a href=\"pages/charts/flot.html\"><i class=\"fa fa-circle-o\"></i> Flot</a></li>\r\n");
      out.write("                <li><a href=\"pages/charts/inline.html\"><i class=\"fa fa-circle-o\"></i> Inline charts</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"treeview\">\r\n");
      out.write("              <a href=\"#\">\r\n");
      out.write("                <i class=\"fa fa-laptop\"></i>\r\n");
      out.write("                <span>UI Elements</span>\r\n");
      out.write("                <i class=\"fa fa-angle-left pull-right\"></i>\r\n");
      out.write("              </a>\r\n");
      out.write("              <ul class=\"treeview-menu\">\r\n");
      out.write("                <li><a href=\"pages/UI/general.html\"><i class=\"fa fa-circle-o\"></i> General</a></li>\r\n");
      out.write("                <li><a href=\"pages/UI/icons.html\"><i class=\"fa fa-circle-o\"></i> Icons</a></li>\r\n");
      out.write("                <li><a href=\"pages/UI/buttons.html\"><i class=\"fa fa-circle-o\"></i> Buttons</a></li>\r\n");
      out.write("                <li><a href=\"pages/UI/sliders.html\"><i class=\"fa fa-circle-o\"></i> Sliders</a></li>\r\n");
      out.write("                <li><a href=\"pages/UI/timeline.html\"><i class=\"fa fa-circle-o\"></i> Timeline</a></li>\r\n");
      out.write("                <li><a href=\"pages/UI/modals.html\"><i class=\"fa fa-circle-o\"></i> Modals</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"treeview\">\r\n");
      out.write("              <a href=\"#\">\r\n");
      out.write("                <i class=\"fa fa-edit\"></i> <span>Forms</span>\r\n");
      out.write("                <i class=\"fa fa-angle-left pull-right\"></i>\r\n");
      out.write("              </a>\r\n");
      out.write("              <ul class=\"treeview-menu\">\r\n");
      out.write("                <li><a href=\"pages/forms/general.html\"><i class=\"fa fa-circle-o\"></i> General Elements</a></li>\r\n");
      out.write("                <li><a href=\"pages/forms/advanced.html\"><i class=\"fa fa-circle-o\"></i> Advanced Elements</a></li>\r\n");
      out.write("                <li><a href=\"pages/forms/editors.html\"><i class=\"fa fa-circle-o\"></i> Editors</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"treeview\">\r\n");
      out.write("              <a href=\"#\">\r\n");
      out.write("                <i class=\"fa fa-table\"></i> <span>Tables</span>\r\n");
      out.write("                <i class=\"fa fa-angle-left pull-right\"></i>\r\n");
      out.write("              </a>\r\n");
      out.write("              <ul class=\"treeview-menu\">\r\n");
      out.write("                <li><a href=\"pages/tables/simple.html\"><i class=\"fa fa-circle-o\"></i> Simple tables</a></li>\r\n");
      out.write("                <li><a href=\"pages/tables/data.html\"><i class=\"fa fa-circle-o\"></i> Data tables</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("              <a href=\"pages/calendar.html\">\r\n");
      out.write("                <i class=\"fa fa-calendar\"></i> <span>Calendar</span>\r\n");
      out.write("                <small class=\"label pull-right bg-red\">3</small>\r\n");
      out.write("              </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("              <a href=\"pages/mailbox/mailbox.html\">\r\n");
      out.write("                <i class=\"fa fa-envelope\"></i> <span>Mailbox</span>\r\n");
      out.write("                <small class=\"label pull-right bg-yellow\">12</small>\r\n");
      out.write("              </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"treeview\">\r\n");
      out.write("              <a href=\"#\">\r\n");
      out.write("                <i class=\"fa fa-folder\"></i> <span>Examples</span>\r\n");
      out.write("                <i class=\"fa fa-angle-left pull-right\"></i>\r\n");
      out.write("              </a>\r\n");
      out.write("              <ul class=\"treeview-menu\">\r\n");
      out.write("                <li><a href=\"pages/examples/invoice.html\"><i class=\"fa fa-circle-o\"></i> Invoice</a></li>\r\n");
      out.write("                <li><a href=\"pages/examples/login.html\"><i class=\"fa fa-circle-o\"></i> Login</a></li>\r\n");
      out.write("                <li><a href=\"pages/examples/register.html\"><i class=\"fa fa-circle-o\"></i> Register</a></li>\r\n");
      out.write("                <li><a href=\"pages/examples/lockscreen.html\"><i class=\"fa fa-circle-o\"></i> Lockscreen</a></li>\r\n");
      out.write("                <li><a href=\"pages/examples/404.html\"><i class=\"fa fa-circle-o\"></i> 404 Error</a></li>\r\n");
      out.write("                <li><a href=\"pages/examples/500.html\"><i class=\"fa fa-circle-o\"></i> 500 Error</a></li>\r\n");
      out.write("                <li><a href=\"pages/examples/blank.html\"><i class=\"fa fa-circle-o\"></i> Blank Page</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"treeview\">\r\n");
      out.write("              <a href=\"#\">\r\n");
      out.write("                <i class=\"fa fa-share\"></i> <span>Multilevel</span>\r\n");
      out.write("                <i class=\"fa fa-angle-left pull-right\"></i>\r\n");
      out.write("              </a>\r\n");
      out.write("              <ul class=\"treeview-menu\">\r\n");
      out.write("                <li><a href=\"#\"><i class=\"fa fa-circle-o\"></i> Level One</a></li>\r\n");
      out.write("                <li>\r\n");
      out.write("                  <a href=\"#\"><i class=\"fa fa-circle-o\"></i> Level One <i class=\"fa fa-angle-left pull-right\"></i></a>\r\n");
      out.write("                  <ul class=\"treeview-menu\">\r\n");
      out.write("                    <li><a href=\"#\"><i class=\"fa fa-circle-o\"></i> Level Two</a></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                      <a href=\"#\"><i class=\"fa fa-circle-o\"></i> Level Two <i class=\"fa fa-angle-left pull-right\"></i></a>\r\n");
      out.write("                      <ul class=\"treeview-menu\">\r\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-circle-o\"></i> Level Three</a></li>\r\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-circle-o\"></i> Level Three</a></li>\r\n");
      out.write("                      </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                  </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"#\"><i class=\"fa fa-circle-o\"></i> Level One</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li><a href=\"documentation/index.html\"><i class=\"fa fa-book\"></i> Documentation</a></li>\r\n");
      out.write("            <li class=\"header\">LABELS</li>\r\n");
      out.write("            <li><a href=\"#\"><i class=\"fa fa-circle-o text-danger\"></i> Important</a></li>\r\n");
      out.write("            <li><a href=\"#\"><i class=\"fa fa-circle-o text-warning\"></i> Warning</a></li>\r\n");
      out.write("            <li><a href=\"#\"><i class=\"fa fa-circle-o text-info\"></i> Information</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </section>\r\n");
      out.write("        <!-- /.sidebar -->\r\n");
      out.write("      </aside>\r\n");
      out.write('\r');
      out.write('\n');

Categorie categorie = (Categorie)request.getAttribute("categorie"); 

      out.write("\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("    <div class=\"col-sm-2\"></div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"well col-offset-sm-3 col-sm-9\">\r\n");
      out.write("                <h2>Ajouter categorie</h2><hr>\r\n");
      out.write("                 ");
 if(request.getAttribute("error")!=null){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"alert alert-danger tab-group\">\r\n");
      out.write("\t\t\t\t\t  <strong>Erreur!</strong>   ");
 out.println(request.getAttribute("error")); 
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t  ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <form action=\"/ReceipeFood_2.0/administrateur/modifierCategorie\" method=\"post\" id=\"formulaire\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\"  name=\"categorie.id\" value=\"");
 out.print(categorie.getId()); 
      out.write("\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"titre\">Nom de la categorie :</label>\r\n");
      out.write("                        <input class=\"form-control\"  name=\"categorie.nom\" value=\"");
 out.print(categorie.getNom()); 
      out.write("\"><p>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <button id=\"ajoutCategorie\" class=\"button\" type=\"submit\" value=\"ajoutCategorie\" name=\"ajoutCategorie\" style=\"vertical-align:middle\"><span>Enregistrer </span></button>\r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<footer class=\"main-footer\">\r\n");
      out.write("    <div class=\"pull-right hidden-xs\">\r\n");
      out.write("        <b>Version</b> 2.0\r\n");
      out.write("    </div>\r\n");
      out.write("    <strong>Rakotomananjo Antsa Herilala - nÂ°24 - Prom 8 A</strong>\r\n");
      out.write("</footer>\r\n");
      out.write("</div><!-- ./wrapper -->\r\n");
      out.write("\r\n");
      out.write("<!--<script type=\"text/javascript\" src=\"-->\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/js/jscharts.js'\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/css/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery 2.1.3 -->\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/plugins/jQuery/jQuery-2.1.3.min.js\"></script>\r\n");
      out.write("<!-- jQuery UI 1.11.2 -->\r\n");
      out.write("<script src=\"http://code.jquery.com/ui/1.11.2/jquery-ui.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->\r\n");
      out.write("<script>\r\n");
      out.write("    $.widget.bridge('uibutton', $.ui.button);\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js\"></script>\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/plugins/morris/morris.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- Sparkline -->\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/plugins/sparkline/jquery.sparkline.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- jvectormap -->\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/plugins/jvectormap/jquery-jvectormap-world-mill-en.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- jQuery Knob Chart -->\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/plugins/knob/jquery.knob.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- daterangepicker -->\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/plugins/daterangepicker/daterangepicker.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- datepicker -->\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/plugins/datepicker/bootstrap-datepicker.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- Bootstrap WYSIHTML5 -->\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- iCheck -->\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/plugins/iCheck/icheck.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- Slimscroll -->\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/plugins/slimScroll/jquery.slimscroll.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- FastClick -->\r\n");
      out.write("<script src='/ReceipeFood_2.0/administrateur/plugins/fastclick/fastclick.min.js'></script>\r\n");
      out.write("<!-- AdminLTE App -->\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/dist/js/app.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- AdminLTE dashboard demo (This is only for demo purposes) -->\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/dist/js/pages/dashboard.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- AdminLTE for demo purposes -->\r\n");
      out.write("<script src=\"/ReceipeFood_2.0/administrateur/dist/js/demo.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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