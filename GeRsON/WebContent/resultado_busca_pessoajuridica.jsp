<%@page import="controller.business.BusinessController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
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
		<div id="header">
			<h1 id="logo">
				<a href="#" title="#">GeRs<span>ON</span></a>
			</h1>
			<hr class="noscreen" />
			<div id="navigation"></div>
			<hr class="noscreen" />
		</div>
	</div>
	<div id="main">
	
	<h3>Resultado da Pesquisa - Funcionário: Pessoa Física </h3>
	
	<table>
	<tr>
	<td>Matricula</td>
	<td>Nome</td>
	<td>Responsável</td>
	</tr>
	<%
	for(int i=0;i<business.getPessoasJuridicas().length;i++){ 
	%>
		<tr>
		<td><%=business.getPessoasJuridicas()[i].getMatricula() %></td>
		<td><%=business.getPessoasJuridicas()[i].getNome() %></td>
		<td><%=business.getPessoasJuridicas()[i].getResponsavel() %></td>
		<td><a href="atualiza_pessoajuridica.jsp?id=<%=business.getPessoasJuridicas()[i].getId() %>">Editar</a></td>
		</tr>
	<%} %>
	</table>
	<p>&nbsp;</p><input type='button' value='Fechar Janela' onclick='window.close() ' />
	</div>
</body>
</html>