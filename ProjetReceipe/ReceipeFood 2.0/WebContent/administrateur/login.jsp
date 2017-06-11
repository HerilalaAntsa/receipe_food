<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Freeze | Tableau de bord</title>
  <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
  <link href="/ReceipeFood_2.0/administrateur/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
  <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />
  <link href="/ReceipeFood_2.0/administrateur/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
  <link href="/ReceipeFood_2.0/administrateur/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
  <link href="/ReceipeFood_2.0/administrateur/plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css" />
  <link href="/ReceipeFood_2.0/administrateur/plugins/morris/morris.css" rel="stylesheet" type="text/css" />
  <link href="/ReceipeFood_2.0/administrateur/plugins/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
  <link href="/ReceipeFood_2.0/administrateur/plugins/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
  <link href="/ReceipeFood_2.0/administrateur/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
  <link href="/ReceipeFood_2.0/administrateur/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />

  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>

</head>
  <body class="login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href=""><b>Admin</b> Freeze</a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">

        <% if(request.getAttribute("error")!=null){ %>
			<div class="alert alert-danger tab-group">
			  <strong>Erreur!</strong>   <% out.println(request.getAttribute("error")); %>
			</div>
		+<% } %>

          <form action="/ReceipeFood_2.0/administrateur/accueilAdmin" method="post">
	          <div class="form-group has-feedback">
	            <input type="text" name="admin.nom" class="form-control" placeholder="identifiant" required>
	            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
	          </div>
	          <div class="form-group has-feedback">
	            <input type="password" name="admin.password" class="form-control" placeholder="Mot de Passe" required>
	            <span class="glyphicon glyphicon-lock form-control-feedback"></span> 
	          </div>
	          <div class="row">
	            <div class="col-xs-8">
	            </div><!-- /.col -->
	            <div class="col-xs-4">
	              <button type="submit" class="btn btn-primary btn-block btn-flat">Connexion</button>
	            </div><!-- /.col -->
	          </div>
        </form>

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <!-- jQuery 2.1.3 -->
    <script src="/ReceipeFood_2.0/administrateur/plugins/jQuery/jQuery-2.1.3.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="/ReceipeFood_2.0/administrateur/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="/ReceipeFood_2.0/administrateur/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
  </body>
</html>