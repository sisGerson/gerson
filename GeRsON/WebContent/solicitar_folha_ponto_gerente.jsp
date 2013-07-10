<%@page import="controller.business.BusinessController"%>
<%@page import="model.funcionarios.pf.PessoaFisica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html><%
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
<link rel="stylesheet" type="text/css" href="css/formulario.css">


<title>GeRsON</title>
</head>
<body>

	<div id="layout">
		<div id="main">

			<form name="solicitar_folha_ponto_gerente"
				action="ServletController" method="post">
				<% 	BusinessController business = new BusinessController(); 
					int id=Integer.parseInt(request.getParameter("id"));
					
					PessoaFisica funcionario = business.idPessoaFisica(id);
				
				%>
				<h2>Solicitar Folha de Ponto do Funcionário - <%=funcionario.getNome() %> </h2>
				
				<table>
					<tr>
						<td> Ano de Referência: 
						   <select name="ano">
								<option value="2013">2000</option>
								<option value="2013">2001</option>
								<option value="2013">2002</option>
								<option value="2013">2003</option>
								<option value="2013">2004</option>
								<option value="2013">2005</option>
								<option value="2013">2006</option>
								<option value="2013">2007</option>
								<option value="2013">2008</option>
								<option value="2013">2009</option>
								<option value="2013">2010</option>
								<option value="2013">2011</option>
								<option value="2013">2012</option>
								<option value="2013">2013</option>
							</select> 
						</td>
					</tr>
					<tr>
						<td> Mês: <select name="mes">
								
								<option value="01">Janeiro</option>
								<option value="02">Fevereiro</option>
								<option value="03">Março</option>
								<option value="04">Abril</option>
								<option value="05">Maio</option>
								<option value="06">Junho</option>
								<option value="07">Julho</option>
								<option value="08">Agosto</option>
								<option value="09">Setembro</option>
								<option value="10">Outubro</option>
								<option value="11">Novembro</option>
								<option value="12">Dezembro</option>
						</select>
						</td>
					</tr>

				</table>
				
				<input type="hidden" name="logica" value="SolicitarFolhaPontoGerente"/>
				<input type="hidden" name="id" value="<%=request.getParameter("id") %>" />
				<input type="submit" value="Solicitar" />
				<hr>
				
			</form>
		</div>
	</div>
</body>
	<%
	}
	%>
</html>
