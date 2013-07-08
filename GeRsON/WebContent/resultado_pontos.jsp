<%@page import="java.text.SimpleDateFormat"%>
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
	
	<h3>Relatório de Ponto - <%=pessoaFisica.getNome() %></h3>
	
	<table>
	<%if(pessoaFisica.getTotalHoraSemanal() == 40){ %>
		<tr>
		<td>Data</td>
		<td>Entrada</td>
		<td>Início do Almoço</td>
		<td>Fim do Almoço</td>
		<td>Saída</td>
		</tr>
		<%
		SimpleDateFormat formataData4 = new SimpleDateFormat("dd/MM/yyyy");
		
		for(int i=0;i<business.getPontos().length;i++){ 
		%>
			<tr>
			<%
			String data = "";
			if(business.getPontos()[i].getData() != null)
				data = formataData4.format(business.getPontos()[i].getData());
			%>
			<td><%=data %></td>
			<td><%=business.getPontos()[i].getHoraEntrada() %></td>
			<td><%=business.getPontos()[i].getHoraInicioAlmoco() %></td>
			<td><%=business.getPontos()[i].getHoraFimAlmoco() %></td>
			<td><%=business.getPontos()[i].getHoraSaida() %></td>
			</tr>
		<%
		}
	} 
	else { %>
		<tr>
		<td>Data</td>
		<td>Entrada</td>
		<td>Saída</td>
		</tr>
		<%
		for(int i=0;i<business.getPontos().length;i++){ 
		%>
			<tr>
			<td><%=business.getPontos()[i].getData() %></td>
			<td><%=business.getPontos()[i].getHoraEntrada() %></td>
			<td><%=business.getPontos()[i].getHoraSaida() %></td>
			</tr>
		<%
		}
	}%>
	</table>
	<br><br><br>
	</div>
	</div>
</body>
	<%
	}
	%>
</html>