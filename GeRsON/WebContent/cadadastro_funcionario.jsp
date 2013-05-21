<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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


        <p align="right"><b>Usuário logado: Gerente</b></p>
        <form name="cadastrar_funcionario" action="cadastrar_funcionario.jsp" method="post" enctype="text/plain">
		<h2>Cadastro de Funcionário</h2>
		<h3>Dados Pessoais</h3>
		<table>
		<tr>
		<td>
		Nome: 
		</td>
		<td><input type="text" name="nome" value="" size="60"/>
		</td>
		</tr>
		<tr>
		<td>
		Data de Nascimento:
		</td>
		<td><input type="text" name="nome" value="" size="60"/></td>
		</tr>
		<tr>
		<td>
		Endereço: </td><td><input type="text" name="nome" value="" size="60"/></td>
		</tr>
		<tr>
		<td>
		Cidade: </td><td><input type="text" name="nome" value="" size="60"/> 
		</td>
		</tr>
		<tr>
		<td>
		Estado:</td><td><input type="text" name="nome" value="" size="10"/>  
		</td>
		</tr>
		</table>
		<h3>Dados Funcionais</h3>
		<p >Data Regi</p>
		</form>
</div>
</div>
  </body>
</html>