
<%@ include file="includes/header.jsp" %>
		<div id="body" class="contact">
				<div class="footer">
					<div class="contact">
							<h1>RECHERCHER DES RECETTES ICI!</h1>
						<form action="Recherche" method="post" class="formulaire"  enctype="multipart/form-data">
							<input name="listeRecherche" cols="50" rows="2" class="ckeditor" required/>
							<input type="submit" value="Envoyer" name="proposition" id="submit">
						<% if(request.getAttribute("error")!=null){ %>
							<div class="alert alert-warning"><p><b> <% out.print(request.getAttribute("error")); %> </b></p></div>
						<% } %>
						</form>
					</div>
					<div class="section">
						<h1>NOUVEAU !</h1>
						<p>Saisissez les ingredients que vous avez dans votre frigo et on vous trouveras les recettes que vous
						pourriez préparer ! :)</p>
						<div class="alert alert-warning"><p><b> ex: fromage;lait;oeuf;tomate </b></p></div>
					</div>
				</div>
			</div>
		<div id="body" class="home">
			<div class="header">
				<img src="images/bg-home.jpg" alt="">
				<div>
					<a href="product.html">Freeze Delight</a>
				</div>
			</div>
			<div class="body">
				<div>
					<div>
						<h1>NEW PRODUCT</h1>
						<h2>The Twist of Healthy Yogurt</h2>
						<p>This website template has been designed by freewebsitetemplates.com for you, for free. You can replace all this text with your own text.</p>
					</div>
					<img src="images/yogurt.jpg" alt="">
				</div>
			</div>
			<div class="footer">
				<div>
					<ul>
						<li>
							<a href="product.html" class="product"></a>
							<h1>PRODUCTS</h1>
						</li>
						<li>
							<a href="about.html" class="about"></a>
							<h1>OUR STORY</h1>
						</li>
						<li>
							<a href="product.html" class="flavor"></a>
							<h1>FLAVORS</h1>
						</li>
						<li>
							<a href="contact.html" class="contact"></a>
							<h1>OUR LOCATION</h1>
						</li>
					</ul>
				</div>
			</div>
		</div>
		
<%@ include file="includes/footer.jsp" %>
