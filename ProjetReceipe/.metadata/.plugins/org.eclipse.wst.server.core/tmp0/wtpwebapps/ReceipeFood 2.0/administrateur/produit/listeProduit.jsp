
<%@ include file="../template/header.jsp" %>

<%@ include file="../template/sidebar.jsp" %>
<%
BaseModelePagination base = (BaseModelePagination)request.getAttribute("liste");
int numeroPage = (int)request.getAttribute("page"); 
%>
<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-9">
        <div class="row">

                    <div class="row well">
                        <h2>LISTE DES PRODUIT</h2><hr>
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>Numéro</th>
                                <th>Nom</th>
                                <th>Catégorie</th>
                                <th>Créateur</th>
                                <th>Etape</th>
                                <th>Date d'ajout</th>
                                <th>Les ingrédients</th>
                            </tr>
                            </thead>
                            <tbody>
                            <% for(ProduitVue p : (List<ProduitVue>)base.getListe()){ %>
                                <tr>
                                    <td><% out.print(p.getId()); %></td>
                                    <td><% out.print(p.getNom()); %></td>
                                    <td><% out.print(p.getNomCategorie()); %></td>
                                    <td><% out.print(p.getNomCreateur()); %></td>
                                    <td><% out.print(p.getEtape()); %></td>
                                    <td><% out.print(p.getDateAjout()); %></td>
                                    <td>
                            			<% for(Composition c : p.getLtComposition()){ %>
                                    		<% out.print(c.getComposant().getNom()); %>;
                            			<% } %>
                                    </td>

                                    <td class="btn-group">
                                     <%--    <a href="Categorie/Modifier?idCategorie=<% out.print(c.getId()); %>" class="btn btn-primary" data-toggle="modal" data-target="#modifier">
                                            <span class="glyphicon glyphicon-edit"></span>
                                        </a>
                                         --%>
                                        <a href="/ReceipeFood_2.0/administrateur/Produit/Supprimer?id=<% out.print(p.getId()); %>" class="btn btn-primary" data-toggle="modal" data-target="#supprimer">
                                            <span class="glyphicon glyphicon-trash"></span>
                                        </a>
                                    </td>
                                </tr>
                            <% } %>
                            </tbody>
                        </table>
					<ul class="pagination">
						<% for(int i = 0; i<base.getNombrePage();i++){ %>
							<li class="<% if(i == numeroPage) out.print("active"); %>"><a href="listeRecette?page=<% out.print(i+1); %>"><% out.print(i+1); %></a></li>
						<% } %>
					</ul>
                    </div>
            </div>
  
    </div>
</div>

<%@ include file="../template/footer.jsp" %>