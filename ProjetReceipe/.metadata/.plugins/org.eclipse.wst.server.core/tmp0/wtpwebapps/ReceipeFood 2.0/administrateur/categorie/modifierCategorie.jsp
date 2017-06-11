
<%@ include file="../template/header.jsp" %>

<%@ include file="../template/sidebar.jsp" %>
<%
Categorie categorie = (Categorie)request.getAttribute("categorie"); 
%>
<div class="row">
    <div class="col-sm-2"></div>

        <div class="row">
            <div class="well col-offset-sm-3 col-sm-9">
                <h2>Ajouter categorie</h2><hr>
                 <% if(request.getAttribute("error")!=null){ %>
					<div class="alert alert-danger tab-group">
					  <strong>Erreur!</strong>   <% out.println(request.getAttribute("error")); %>
					</div>
				  <% } %>

                <form action="/ReceipeFood_2.0/administrateur/modifierCategorie" method="post" id="formulaire">
					<input type="hidden"  name="categorie.id" value="<% out.print(categorie.getId()); %>">
                    <div class="form-group">
                        <label for="titre">Nom de la categorie :</label>
                        <input class="form-control"  name="categorie.nom" value="<% out.print(categorie.getNom()); %>"><p>
                    </div>

                    <button id="ajoutCategorie" class="button" type="submit" value="ajoutCategorie" name="ajoutCategorie" style="vertical-align:middle"><span>Enregistrer </span></button>
                </form>

        </div>
    </div>
</div>

<%@ include file="../template/footer.jsp" %>