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
		if(!pessoaFisica.getCargo().equals("Gerente")){
			response.sendRedirect("index.jsp?situacao=2");
		}
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

int id = Integer.parseInt(request.getParameter("id"));

PessoaFisica funcionario = business.idPessoaFisica(id);
%>

<body>
	<div id="layout">
	<div id="main">
	
	<h3>Relatório de Ponto do funcionário - <%=funcionario.getNome() %></h3>
	
	<% 
	SimpleDateFormat formataData4 = new SimpleDateFormat("dd/MM/yyyy"); 
	SimpleDateFormat formataHora2 = new SimpleDateFormat("HH:mm:ss");
	%>
	
	<%if(funcionario.getTotalHoraSemanal() == 40){ %>
		<table>
			<tr>
			<td>Data</td>
			<td>Entrada</td>
			<td>Início do Almoço</td>
			<td>Fim do Almoço</td>
			<td>Saída</td>
			</tr>
		</table>
		
		<%
		for(int i=0;i<business.getPontos().length;i++){ 
		%>
			<%
			String data = "", horaEntrada = "", horaInicioAlmoco = "", horaFimAlmoco = "", horaSaida = "";
			
			if(business.getPontos()[i].getData() != null)
				data = formataData4.format(business.getPontos()[i].getData());
			
			if(business.getPontos()[i].getHoraEntrada() != null)
				horaEntrada = formataHora2.format(business.getPontos()[i].getHoraEntrada());
			
			if(business.getPontos()[i].getHoraInicioAlmoco() != null)
				horaInicioAlmoco = formataHora2.format(business.getPontos()[i].getHoraInicioAlmoco());
			
			if(business.getPontos()[i].getHoraFimAlmoco() != null)
				horaFimAlmoco = formataHora2.format(business.getPontos()[i].getHoraFimAlmoco());
			
			if(business.getPontos()[i].getHoraSaida() != null)
				horaSaida = formataHora2.format(business.getPontos()[i].getHoraSaida());
			%>
			<form name="alterar_folha_ponto_gerente" action="ServletController" method="post">

				<input type="text" name="data" value="<%=data %>"/>
				<input type="text" name="horaEntrada" value="<%=horaEntrada %>"/>
				<input type="text" name="horaInicioAlmoco" value="<%=horaInicioAlmoco %>"/>
				<input type="text" name="horaFimAlmoco" value="<%=horaFimAlmoco %>"/>
				<input type="text" name="horaSaida" value="<%=horaSaida %>"/>
				
				<input type="hidden" name="idPonto" value="<%=business.getPontos()[i].getIdPonto() %>" />
				<input type="hidden" name="logica" value="AlterarPonto" />
				<input type="submit" value="Alterar">
			</form> <br>
		<%
		}
	} 
	else { %>
		<table>
			<tr>
			<td>Data</td>
			<td>Entrada</td>
			<td>Saída</td>
			</tr>
		</table>
		<%
		for(int i=0;i<business.getPontos().length;i++){ 
		%>
			<%
			String data = "", horaEntrada = "", horaSaida = "";
			
			if(business.getPontos()[i].getData() != null)
				data = formataData4.format(business.getPontos()[i].getData());
			
			if(business.getPontos()[i].getHoraEntrada() != null)
				horaEntrada = formataHora2.format(business.getPontos()[i].getHoraEntrada());
			
			if(business.getPontos()[i].getHoraSaida() != null)
				horaSaida = formataHora2.format(business.getPontos()[i].getHoraSaida());
			%>
			<form name="alterar_folha_ponto_gerente" action="ServletController" method="post">
			
				<input type="text" name="data" value="<%=data %>"/>
				<input type="text" name="horaEntrada" value="<%=horaEntrada %>"/>
				<input type="text" name="horaSaida" value="<%=horaSaida %>"/>
				
				<input type="hidden" name="idPonto" value="<%=business.getPontos()[i].getIdPonto() %>" />
				<input type="hidden" name="logica" value="AlterarPonto" />
				<input type="submit" value="Alterar">
				
			</form> <br>
		<%
		}
		
	}%>
	
	<br><br><br>
	</div>
	</div>
</body>
	<%
	}
	%>
</html>