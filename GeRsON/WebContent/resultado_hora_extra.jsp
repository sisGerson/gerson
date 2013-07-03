<%@page import="model.funcionarios.pf.PessoaFisica"%>
<%@page import="controller.business.BusinessController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<%
	if(session.getAttribute("funcionario") == null)
		response.sendRedirect("index.jsp?item=0");
	else{
		
	
		PessoaFisica pessoaFisica = (PessoaFisica) session.getAttribute("funcionario");
		
	%>
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
<meta http-equiv="content-language" content="pt-br" />
<meta name="description" content="GeRsON - Gerência de Recursos On-line" />
<meta name="keywords"
	content="cadastro de cliente, controle de almoxarifado" />
<link rel="stylesheet" type="text/css" href="css/screen.css">

<title>GeRsON</title>

<!-- Pegando o parâmetro da servlet -->
<%
BusinessController business = (BusinessController)session.getAttribute("pesquisa");
%>

<body>
	<div id="layout">
	<div id="main">
	
	<h3>Relatório de Horas Extras - <%=pessoaFisica.getNome() %></h3>
	
	<p>Mês/Ano Solicitado: (incluir o mes e o ano pesquisado) </p>
	<p>Total de Horas Extras: (incluir o total de horas extras do mês solicitado)</p>
	</div>
	</div>
</body>
	<%
	}
	%>
</html>