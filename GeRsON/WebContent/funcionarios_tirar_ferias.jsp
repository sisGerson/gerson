<!-- mudei o método q a BusinessFerias chama -->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controller.business.BusinessFerias"%>
<%@page import="model.funcionarios.pf.PessoaFisica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<%
	if(session.getAttribute("funcionario") == null)
		response.sendRedirect("index.jsp?item=0");
	else{
		
	
		PessoaFisica pessoaFisica = (PessoaFisica) session.getAttribute("funcionario");
		
		if(!pessoaFisica.getCargo().equalsIgnoreCase("gerente")){
			response.sendRedirect("index.jsp?situacao=2");
		}
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

				<h2>Funcionários que irão tirar Férias</h2>
				<h3>Dados para pesquisa</h3>
				<table>
					<tr>
						<td>Matrícula</td>
						<td>Nome</td>
						<td>Cargo</td>
						<td>Area</td>
						<td>Data das Férias</td>
					</tr>
						<%
						BusinessFerias ferias3 = new BusinessFerias();
						ferias3.buscarTirarFuncionariosFerias();
						
						SimpleDateFormat formataData5 = new SimpleDateFormat("dd/MM/yyyy");
						
						for(int i=0;i<ferias3.getFuncionariosTirarFerias().length;i++){ 
						%>
							<tr>
							<td><%=ferias3.getFuncionariosTirarFerias()[i].getMatricula() %></td>
							<td><%=ferias3.getFuncionariosTirarFerias()[i].getNome() %></td>
							<td><%=ferias3.getFuncionariosTirarFerias()[i].getCargo() %></td>
							<td><%=ferias3.getFuncionariosTirarFerias()[i].getArea() %></td>
							<%
							String ultimasFerias = "";
							if(ferias3.getFuncionariosTirarFerias()[i].getUltimasFerias() != null)
								ultimasFerias = formataData5.format(ferias3.getFuncionariosTirarFerias()[i].getUltimasFerias());
							%>
							<td><%=ultimasFerias %></td>
							</tr>
						<%} %>
						
				</table>
				<p>&nbsp;</p>
		</div>
	</div>
</body>
</html>
