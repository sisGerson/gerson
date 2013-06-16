<%@page import="dao.PesquisaDAO"%>
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
PesquisaDAO pesquisa = (PesquisaDAO)session.getAttribute("pesquisa");
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
	<td>Cargo</td>
	</tr>
	<%
	for(int i=0;i<pesquisa.getPessoasFisicas().length;i++){ 
	%>
		<tr>
		<td><%=pesquisa.getPessoasFisicas()[i].getMatricula() %></td>
		<td><%=pesquisa.getPessoasFisicas()[i].getNome() %></td>
		<td><%=pesquisa.getPessoasFisicas()[i].getCargo() %></td>
		<td><a href="atualiza_pessoafisica.jsp?id=<%=pesquisa.getPessoasFisicas()[i].getId() %>">Editar</a></td>
		</tr>
	<%} %>
	</table>
	<p>&nbsp;</p><input type='button' value='Fechar Janela' onclick='window.close() ' />
	</div>
</body>
</html>