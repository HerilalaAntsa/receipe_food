
<%@ include file="../template/header.jsp" %>

<%@ include file="../template/sidebar.jsp" %>

<section class="content">
<div class="row">
    <div class="col-sm-2"></div>

        <div class="row pull-right">
            <div class="well">
                <h2>Ajouter categorie</h2><hr>
                 <% if(request.getAttribute("error")!=null){ %>
					<div class="alert alert-danger tab-group">
					  <strong>Erreur!</strong>   <% out.println(request.getAttribute("error")); %>
					</div>
				  <% } %>

                <form action="Ajouter" method="post" id="formulaire">

                    <div class="form-group">
                        <label for="titre">Nom de la categorie :</label>
                        <input class="form-control"  name="categorie.nom"><p>
                    </div>

                    <button id="ajoutCategorie" class="button" type="submit" value="ajoutCategorie" name="ajoutCategorie" style="vertical-align:middle"><span>Enregistrer </span></button>
                </form>

        </div>
    </div>
</div>
</section>

<%@ include file="../template/footer.jsp" %>