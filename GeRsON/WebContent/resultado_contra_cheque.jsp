<%@page import="controller.business.BusinessSalario"%>
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
BusinessSalario salario = (BusinessSalario)session.getAttribute("salario");
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
	<td>Salário pelas horas trabalhadas: </td>
	<td>R$ <%=salario.getSalarioHorasTrabalhadas() %>
	</td>
	</tr>
	
	<tr>
	<td>INSS: </td>
	<td>R$<%=salario.getINSS()	%>
	</td>
	</tr>
	
	<tr>
	<td>Imposto de Renda: </td>
	<td>R$<%=salario.getImpostoRenda()	%>
	</td>
	</tr>
	
	<tr>
	<td>Outros Impostos: </td>
	<td>R$ <%=salario.getOutrosImpostos() %>
	
	</td>
	</tr>
	
	<tr>
	<td>Plano de Saúde: </td>
	<td>R$ <%=salario.getPlanoSaude() %>
	</td>
	</tr>
	</table>
	
	<table>
	<tr>
	<td>Total Descontos: </td>
	<td>R$ <%=salario.getDescontos() %></td>
	</tr>
	 
	<tr>
	<td>Salário Líquido: </td>
	<td>R$ <%=salario.getSalarioLiquido() %></td>
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