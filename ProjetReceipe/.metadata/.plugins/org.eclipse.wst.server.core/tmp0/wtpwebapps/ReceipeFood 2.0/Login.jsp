<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.*,
				s6.ReceipeFood.modele.*,
				s6.ReceipeFood.service.*,
				java.util.List,
				org.json.*,
				java.sql.*" 
%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Inscription/Connexion</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    
    <link rel="stylesheet" href="css/normalize.css">

        <link rel="stylesheet" href="css/login.css">

  </head>

  <body>

    <div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Inscription</a></li>
        <li class="tab"><a href="#login">Connexion</a></li>
      </ul>
      
        <% if(request.getAttribute("error")!=null){ %>
			<div class="alert alert-danger tab-group">
			  <strong>Erreur!</strong>   <% out.println(request.getAttribute("error")); %>
			</div>
		  <% } %>
      
      <div class="tab-content">
        <div id="signup">   
          <h1>Inscrivez-vous gratuitement</h1>
          
          <form action="signUp" method="post">
          
          <div class="top-row">
            <div class="field-wrap">
              <label>
                Nom<span class="req">*</span>
              </label>
              <input name="user.nom" type="text" required autocomplete="off" />
            </div>
        
            <div class="field-wrap">
              <label>
                Prenom<span class="req">*</span>
              </label>
              <input name="user.prenom" type="text"required autocomplete="off"/>
            </div>
          
          <div class="field-wrap">
              <label>
                Date de naissance<span class="req">*</span>
              </label>
              <input name="dateNaissance" type="date"required autocomplete="off"/>
            </div>
          
          <div class="field-wrap">
               <label for="homme">Homme</label>
               <input class="" name="user.sexe" type="radio" value="homme" id="homme" />
          </div>          
          <div class="field-wrap">
               <label for="femme">Femme</label>
               <input class="" name="user.sexe" type="radio" value="femme" id="femme" />
          </div>
          
          <div class="field-wrap">
            <label>
              Adresse email<span class="req">*</span>
            </label>
            <input name="user.email" type="email"required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Mot de passe<span class="req">*</span>
            </label>
            <input name="user.password" type="password"required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Confirmer votre mot de passe<span class="req">*</span>
            </label>
            <input name="user.confirmPassword" type="password"required autocomplete="off"/>
          </div>
          
            <div class="field-wrap">
              <label>
                Adresse<span class="req">*</span>
              </label>
              <input name="user.adresse" type="text"required autocomplete="off"/>
            </div>
            
            <div class="field-wrap">
              <label>
                Telephone<span class="req">*</span>
              </label>
              <input name="user.telephone" type="text"required autocomplete="off"/>
            </div>
          
          </div>

          <button type="submit" class="button button-block"/>Inscription</button>
          
          </form>

        </div>
        
        <div id="login">   
          <h1>Connectez-vous!</h1>
          
          <form action="login" method="post">
          
            <div class="field-wrap">
            <label>
              Adresse email<span class="req">*</span>
            </label>
            <input name="user.email" type="email"required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Mot de passe<span class="req">*</span>
            </label>
            <input name="user.password" type="password"required autocomplete="off"/>
          </div>
          
          <button class="button button-block"/>Connexion</button>
          
          </form>

        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>
  </body>
</html>
