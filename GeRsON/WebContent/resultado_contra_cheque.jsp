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
	
	<h3>Contra-Cheque - <%=pessoaFisica.getNome() %></h3>
	<p>Referencia:</p>
	<table>
	<tr>
	<td colspan="2">Empresa: Fields Comunicação</td>
	</tr>
	
	<tr>
	<td>Funcionário: <%=pessoaFisica.getNome() %></td>
	<td>Matricula: <%=pessoaFisica.getMatricula() %></td>
	</tr>
	
	<tr>
	<td>RG: <%=pessoaFisica.getRG() %></td>
	<td>CPF: <%=pessoaFisica.getCPF_CNPJ() %></td>
	</tr>
	</table>
	
	<table>
	<tr>
	<td>Descrição</td>
	<td>Valores</td>
	</tr>
	
	<tr>
	<td>Salário Bruto: </td>
	<td>R$ <%=pessoaFisica.getSalario() %>
	</td>
	</tr>
	
	<tr>
	<td>INSS: </td>
	<td>R$<%=pessoaFisica.getSalario()*0.11	%>
	<%double descontoINSS = pessoaFisica.getSalario()*0.11;
	double somaDescontos = descontoINSS;%>
	</td>
	</tr>
	
	<tr>
	<td>Impostos: </td>
	<td>R$ <%=pessoaFisica.getSalario()*0.08%>
	<%double Impostos = pessoaFisica.getSalario()*0.11;
	somaDescontos = somaDescontos + Impostos ;%>
	
	</td>
	</tr>
	
	<tr>
	<td>Plano de Saúde: </td>
	<td>R$ 99,00
	<% somaDescontos = somaDescontos + 99;%>
	</td>
	</tr>
	</table>
	
	<table>
	<tr>
	<td>Total Descontos: </td>
	<td>R$ <%= somaDescontos %></td>
	</tr>
	
	<tr>
	<td>Salário Líquido: </td>
	<td>R$ <%= pessoaFisica.getSalario() - somaDescontos %></td>
	</tr>
	</table>
	
	<br><br><br>
	</div>
	</div>
</body>
	<%
	}
	%>
</html>