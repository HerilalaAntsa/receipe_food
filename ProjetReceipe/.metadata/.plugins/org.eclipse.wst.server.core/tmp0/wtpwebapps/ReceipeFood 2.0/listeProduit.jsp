<%@ include file="includes/header.jsp" %>
<%
	BaseModelePagination baseModele = (BaseModelePagination)request.getAttribute("baseModele");
	int numeroPage = (int)request.getAttribute("page");
%>
		<div id="body">
			<div class="header">
				<div>
					<h1>Liste des recettes</h1>
				</div>
			</div>
			<hr>
			<div class="blog">
				<div class="featured">
				
			<div class="row">
				<div class="col-offset-sm-4 col-sm-8">
					<form action="listeRecette" class="form-horizontal" method="post">
						<select class="icons" name="idCategorie"  required>
						        <option value="TOUS" disabled selected>Trier par categorie</option>
						      <% for(Categorie c : (List<Categorie>)request.getAttribute("ltCategorie")) { %>
						        <option value="<% out.print(c.getId()); %>"><% out.print(c.getNom()); %></option>
						      <% } %>
						        <option value="TOUS">Tous</option>
					    </select>						
					    <input type="submit" value="Valider" id="submit">
					</form>
				</div>
			</div>
					<ul>
						<% for(ProduitVue p : (List<ProduitVue>)baseModele.getListe()){ %>
							<li>
								<img style="width:200px;" src="images/<% out.print(p.getPhoto()); %>" alt="">
								<div>
									<h1><% out.print(p.getNom()); %>			<span class="badge"><% out.print(p.getNomCategorie()); %></span></h1> 
									<span>Par <% out.print(p.getNomCreateur()); %> - <% out.print(p.getDateAjoutString()); %></span>
									<br>
									<% for(Composition c : (List<Composition>)p.getLtComposition()){ %>
										<span class="label label-success"><% out.print(c.getComposant().getNom()); %></span>
									<% } %>
									<br><br>									
									<%-- <s:url action="detailRecette" var="urlTag" >
									<s:param name="idProduit"><% out.print(p.getId()); %></s:param>
										</s:url>
									<a href="<s:property value="#urlTag" />" class="more">Read More</a> --%>
									
									<a href="detailRecette?idProduit=<% out.print(p.getId()); %>" class="more">Read More</a>
								</div>
							</li>
						<% } %>
					</ul>
					<ul class="pagination">
					<% if(request.getAttribute("listeRecherche")!=null){ %>
						<% for(int i = 0; i<baseModele.getNombrePage();i++){ %>
							<li class="<% if(i == numeroPage) out.print("active"); %>"><a href="Recherche?page=<% out.print(i+1); %>&listeRecherche=<% out.print(request.getAttribute("listeRecherche")); %>"><% out.print(i+1); %></a></li>
						<% } %>
					<% }else{ %>
						<% for(int i = 0; i<baseModele.getNombrePage();i++){ %>
							<li class="<% if(i == numeroPage) out.print("active"); %>"><a href="listeRecette?page=<% out.print(i+1); %>"><% out.print(i+1); %></a></li>
						<% } %>
					<% } %>
					</ul>
				</div>
				<div class="sidebar">
					<h1>Recent Posts</h1>
					<img src="images/on-diet.png" alt="">
					<h2>ON THE DIET</h2>
					<span>By Admin on November 28, 2023</span>
					<p>You can replace all this text with your own text. You can remove any link to our website from this website template.</p>
					<a href="singlepost.html" class="more">Read More</a>
				</div>
			</div>
		</div>
		
<%@ include file="includes/footer.jsp" %>
