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
        <form name="pesquisar_pessoafisica" action="ServletBuscaPessoaJuridica" method="post" >
		<h2>Pesquisa Pessoa Jurídica</h2>
		<h3>Dados para pesquisa</h3>
		<table>
		<tr>
		<td>
		Matrícula: <input type="text" name="matricula" value="" size="20" maxlength="15"/>
		Área: <input type="text" name="area" value="" size="30" maxlength="40"/>
		</td>
		</tr>
		<tr>
		<td>
		Empresa: <input type="text" name="empresa" value="" size="50" maxlength="50"/>
		CNPJ: <input type="text" name="cnpj" value="" size="15" maxlength="14"/>		
		</td>
		</tr>
		<tr>
		<td>
		Responsavel: <input type="text" name="responsavel" value="" size="40" maxlength="50"/>
		</td>
		</tr>
		</table>
		
		<input type="submit" value="Pesquisar">
		</form>
		</div>
		</div>
	</body>
</html>