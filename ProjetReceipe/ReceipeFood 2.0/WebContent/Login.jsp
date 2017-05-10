<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.*,
				s6.ReceipeFood.modele.*,
				s6.ReceipeFood.service.*,
				java.util.List,
				org.json.*,
				java.sql.*" 
%>
<title>Back Office - Connexion, Freezeedera</title>
		<div id="header">
			<div>
				<a href="index.php" class="logo"><img src="../images/logo-bo.png" title="Sweety, site web recelant tous les bons desserts qui existent" alt="Sweety, site web recelant tous les bons desserts qui existent"></a>
<!-- 				<ul id="navigation">
					<li>
						<a href="index.php">Accueil</a>
					</li>
					<li>
						<a href="Patisserie.php">Patisserie</a>
					</li>
					<li>
						<a href="Recettes.php">Recettes</a>
					</li>
					<li>
						<a href="Propositions.php">Propositions</a>
					</li>
				</ul> -->
			</div>
		</div>
		<div id="body" class="contact">
			<div class="header">
				<div>
					<h1>Connexion Free<strong>Z</strong>eedera</h1>
				</div>
			</div>
			<div class="footer">
				<div class="contact">
					<h2>VEUILLEZ RENTRER VOS IDENTIFIANTS POUR VOUS CONNECTER</h2>
					<form action="#" method="post">
						<input type="text" name="identifiant" placeholder="Votre identifiant" required>
						<input type="password" name="password" placeholder="Votre mot de passe" required>
						<input type="submit" value="Connexion" name="Adminlogin" id="submit">
					</form>
				</div>
			</div>
		</div>
		<%@ include file="includes/footer.jsp"  %>