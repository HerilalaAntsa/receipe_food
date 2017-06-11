<%@ include file="includes/header.jsp" %> 
<%
ProduitVue produit = (ProduitVue)request.getAttribute("produit");
%>		
		<div id="body">
			<div class="header">
				<div>
					<h1><% out.println(produit.getNom()); %></h1>
				</div>
			</div>
			<div class="singlepost">
				<div class="featured">
					<img class="img img-thumbnail" src="images/<s:property value="produit.photo" />" alt="">
					<h1><% out.println(produit.getNom()); %> 		<span class="badge"><% out.print(produit.getNomCategorie()); %></h1>
					<span>Par <% out.println(produit.getNomCreateur()); %> - <% out.print(produit.getDateAjoutString()); %></span>
					
					<h2>Etapes à suivre :</h2>
					<p><% out.println(produit.getEtape()); %></p>
					<a href="listeRecette" class="load">Retour à la liste</a>
				</div>
				 
				<div class="sidebar">
					<h1>Recent Posts</h1>
					<img src="images/on-diet.png" alt="">
					<h2>ON THE DIET</h2>
					<span>By Admin on November 28, 2023</span>
					<p>You can replace all this text with your own text. You can remove any link to our website from this website template.</p>
					<a href="listeRecette" class="more">Read More</a>
				</div>
			</div>
		</div>
<%@ include file="includes/footer.jsp" %>