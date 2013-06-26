<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
    <meta http-equiv="content-language" content="pt-br" />
    <meta name="description" content="GeRsON - Gerência de Recursos On-line" />
    <meta name="keywords" content="cadastro de cliente, controle de almoxarifado" />
    <link rel="stylesheet" type="text/css" href="css/formulario.css">
 
    <title>GeRsON</title>
  </head>
  <body>

	<div id="layout">
		<div id="main">
		<form name="login"	action="ServletController" method="post">
		<p align="right">
			Matrícula: <input type="number" step="1" min="1" max="99999999" name="matricula" value="" size="20"	maxlength="8" required />
			<br>
			Senha: <input type="password" step="1" min="1" max="99999999" name="senha"	value="" size="12" maxlength="8" required />
			<br>
			<input type="hidden" name="logica" value="Login"/>			
			<input type="submit" value="Acessar"> 
		</p>
		</form>
	<!-- Fim formulário de login e Senha -->
</div>
</div>
  </body>
</html>