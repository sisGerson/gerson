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

SimpleDateFormat formataData4 = new SimpleDateFormat("dd/MM/yyyy");
SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm:ss");
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
		for(int i=0;i<business.getPontos().length;i++){ 
		%>
			<tr>
			<%
			String data = "", horaEntrada = "", horaInicioAlmoco = "", horaFimAlmoco = "", horaSaida = "";
			
			if(business.getPontos()[i].getData() != null)
				data = formataData4.format(business.getPontos()[i].getData());
			
			if(business.getPontos()[i].getHoraEntrada() != null)
				horaEntrada = formataHora.format(business.getPontos()[i].getHoraEntrada());
			
			if(business.getPontos()[i].getHoraInicioAlmoco() != null)
				horaInicioAlmoco = formataHora.format(business.getPontos()[i].getHoraInicioAlmoco());
			
			if(business.getPontos()[i].getHoraFimAlmoco() != null)
				horaFimAlmoco = formataHora.format(business.getPontos()[i].getHoraFimAlmoco());
			
			if(business.getPontos()[i].getHoraSaida() != null)
				horaSaida = formataHora.format(business.getPontos()[i].getHoraSaida());
			%>
			<td><%=data %></td>
			<td><%=horaEntrada %></td>
			<td><%=horaInicioAlmoco %></td>
			<td><%=horaFimAlmoco %></td>
			<td><%=horaSaida %></td>
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
		
			String data = "", horaEntrada = "", horaSaida = "";
			
			if(business.getPontos()[i].getData() != null)
				data = formataData4.format(business.getPontos()[i].getData());
			
			if(business.getPontos()[i].getHoraEntrada() != null)
				horaEntrada = formataHora.format(business.getPontos()[i].getHoraEntrada());
			
			if(business.getPontos()[i].getHoraSaida() != null)
				horaSaida = formataHora.format(business.getPontos()[i].getHoraSaida());
		%>
			<tr>
			<td><%=data %></td>
			<td><%=horaEntrada %></td>
			<td><%=horaSaida %></td>
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