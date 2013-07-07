<%@page import="model.funcionarios.pf.PessoaFisica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<%
	if (session.getAttribute("funcionario") == null)
		response.sendRedirect("index.jsp?item=0");
	else {
		
		PessoaFisica pessoaFisica = (PessoaFisica) session.getAttribute("funcionario");
		
		if(!pessoaFisica.getCargo().equalsIgnoreCase("gerente")){
			response.sendRedirect("index.jsp?situacao=2");
		}
	%>
	
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
<meta http-equiv="content-language" content="pt-br" />
<meta name="description" content="GeRsON - Gerência de Recursos On-line" />
<meta name="keywords"
	content="cadastro de cliente, controle de almoxarifado" />
<link rel="stylesheet" type="text/css" href="css/formulario.css">

<title>GeRsON</title>
</head>
<body>

	<div id="layout">
		<div id="main">
			<!-- Itens associados a pessoa Pessoa fisica -->
			<h2>Relatórios: <%=pessoaFisica.getNome() %></h2>
			<p>&nbsp;</p>
			<ul>
				<li><a href="index.jsp?item=24&situacao=2">Visualizar pedidos de férias</a></li>
				<li><a href="index.jsp?item=26&situacao=2">Visualizar funcionários de férias</a></li>
				<li><a href="index.jsp?item=27&situacao=2">Visualizar funcionários que irão tirar férias</a></li>
			</ul>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</div>
	</div>
</body>
	<%
	}
	%>
</html>