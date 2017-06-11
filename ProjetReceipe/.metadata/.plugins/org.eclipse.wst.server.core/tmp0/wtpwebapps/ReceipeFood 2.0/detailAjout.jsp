<%@ include file="includes/header.jsp" %>
<%
	Produit produit = (Produit)request.getAttribute("produit");
%>	
		<div id="body" class="contact">
			<div class="header">
				<div>
					<h1>Ajouter une nouvelle recette</h1>
				</div>
			</div>
			<div class="body">
				<div>
					<div>
						<img src="images/check-in.png" alt="">
						<h1>UNIT 0123 , ABC BUILDING, BUSSINESS PARK</h1>
						<p>If you're having problems editing this website template, then don't hesitate to ask for help on the Forums.</p>
					</div>
				</div>
			</div>
			<div class="footer">
				<div class="contact">
					<h1>Repartissez les différents composants</h1>
					<a href="ajoutRecette" class="load">Précédent</a>
					
					<div class="featured">
						<h4>Nom de votre recette :</h4>
						<h1><% out.println(produit.getNom()); %></h1>
						<h4>Categorie :</h4>
						<span><% out.println(produit.getCategorie().getNom()); %></span>
						<h4>Etapes à suivre :</h4>
						<p><% out.println(produit.getEtape()); %></p>
					</div>
					
					<form action="saveRecette" class="form-horizontal" method="post">
					      <% 
					      	int i = 0;
					      for(Composant c : (List<Composant>)request.getAttribute("ltComposant")) { %>
							<div class="form-group row">
								<input class="col-sm-6" disabled="disabled" type="text" value="<% out.println(c.getNom()); %>" onblur="this.value=!this.value?'Name':this.value;" onfocus="this.select()" onclick="this.value='';">
								<input class="col-sm-2" type="number" name="quantite[<% out.print(i); %>]" placeholder="quantite" onblur="this.value=!this.value?'Name':this.value;" onfocus="this.select()" onclick="this.value='';">
								
								<select class="col-sm-4" class="icons" name="unite[<% out.print(i); %>]"  required>
							        <option value="gramme">Choisissez une unite</option>
							        <option value="gramme">gramme</option>
							        <option value="kilogramme">kilogramme</option>
							        <option value="litre">litre</option>
							        <option value="millilitre">millilitre</option>
							        <option value="piece">piece</option>
							        <option value="cuillere">cuillere</option>
							        <option value="gousse">gousse</option>
							        <option value="">Aucun</option>
							    </select>
							</div>
					      <% i++; } %>
					      
						<input type="submit" value="Ajouter recette" id="submit">
					</form>
				</div>
				<div class="section">
					<h1>ON AIMERAIT QUE VOUS PARTAGIEZ VOS RECETTES!</h1>
					<p>If you're having problems editing this website template, then don't hesitate to ask for help on the Forums.</p>
				</div>
			</div>
		</div>
<%@ include file="includes/footer.jsp" %>