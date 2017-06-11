<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.*,
				s6.ReceipeFood.modele.*,
				s6.ReceipeFood.service.*,
				java.util.List,
				org.json.*,
				java.sql.*" 
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="apple-touch-icon" sizes="57x57" href="images/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="images/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="images/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="images/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="images/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="images/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="images/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192"  href="images/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="images/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="images/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon-16x16.png">
    <link rel="manifest" href="images/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="images/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="/ReceipeFood_2.0/css/style_Add.css" charset="utf-8">
	<link rel="stylesheet" type="text/css" href="/ReceipeFood_2.0/css/mobile.css">
    <link href="/ReceipeFood_2.0/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="/ReceipeFood_2.0/css/bootstrap.min.css">
    <meta charset="utf-8">
</head>
<body>
<div id="page" class="container">
		<div class="row">
			<div class="col-sm-offset-10 col-sm-3">
				<a href="logOut"><span class="glyphicon glyphicon-log-out"></span> Deconnexion</a>
			</div>
		</div>
		<div id="header" class="row">
			<div>
				<a href="accueil" class="logo"><img src="images/logo.png" alt=""></a>
				<ul id="navigation">
					<li>
						<a href="accueil">Accueil</a>
					</li>
<!-- 					<li class="menu">
						<a href="about.html">About</a>
						<ul id="selected" class="primary">
							<li class="">
								<a href="product.html">Product</a>
							</li>
						</ul>
					</li> -->
					<li class="menu">
						<a href="listeRecette">Les recettes</a>
<!-- 						<ul class="secondary">
							<li>
								<a href="singlepost.html">Single post</a>
							</li>
						</ul> -->
					</li>
					<li class="menu">
						<a href="ajoutRecette">nouvelle recette</a>
					</li>
				</ul>
			</div>
		</div>
		
		<div id="body" class="contact">
			<div class="header">
				<div>
					<h1>Ajouter une nouvelle recette</h1>
				</div>
			</div>
		<% if(request.getAttribute("error")!=null){ %>
			<div class="alert alert-danger tab-group">
			  <strong>Produit non ajouté!</strong>   <% out.println(request.getAttribute("error")); %>
			</div>
		  <% } %>
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
					<h1>Ajouter votre nouvelle recette</h1>
					<form action="detailAjout" class="form-horizontal" method="post">
						<input type="text" name="produit.nom" placeholder="Nom du plat" onblur="this.value=!this.value?'Nom':this.value;" onfocus="this.select()" onclick="this.value='';">
						<select class="icons" name="idCategorie"  required>
					        <option value="1" disabled selected>Choisissez une categorie</option>
					      <% for(Categorie c : (List<Categorie>)request.getAttribute("ltCategorie")) { %>
					        <option value="<% out.print(c.getId()); %>"><% out.print(c.getNom()); %></option>
					      <% } %>
					      </select>
					<div>
                      <textarea name="produit.etape" class="textarea" placeholder="Etapes &agrave; suivre" style="width: 100%; height: 125px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                    </div>
						<!-- <textarea name="produit.etape" class="textarea" cols="50" rows="7">Decrire les étapes à suivre...</textarea> -->
						<label>Séparer chaque composant d'un point virgule (";")</label>
						<textarea name="listeComposant" cols="50" rows="7">fromage;lait;tomate</textarea>
						<input type="submit" value="Suivant" id="submit">
					</form>
				</div>
				<div class="section">
					<h1>ON AIMERIEZ QUE VOUS PARTAGIEZ VOS RECETTES!</h1>
					<p>If you're having problems editing this website template, then don't hesitate to ask for help on the Forums.</p>
				</div>
			</div>
		</div>
<%@ include file="includes/footer.jsp" %>