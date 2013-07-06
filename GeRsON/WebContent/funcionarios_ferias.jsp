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

				<h2>Funcionários de Férias</h2>
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
						BusinessFerias ferias2 = new BusinessFerias();
						ferias2.buscarPedidos();
						
						for(int i=0;i<ferias2.getPedidosAceitos().length;i++){ 
						%>
							<tr>
							<td><%=ferias2.getPedidosAceitos()[i].getMatricula() %></td>
							<td><%=ferias2.getPedidosAceitos()[i].getNome() %></td>
							<td><%=ferias2.getPedidosAceitos()[i].getCargo() %></td>
							<td><%=ferias2.getPedidosAceitos()[i].getArea() %></td>
							<td><%=ferias2.getPedidosAceitos()[i].getUltimasFerias() %></td>
							</tr>
						<%} %>
						
				</table>
				<p>&nbsp;</p>
		</div>
	</div>
</body>
</html>
