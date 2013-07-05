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

			<form name="visualizar_pedidos_ferias"
				action="ServletController" method="post" onsubmit="window.open('','pop_up','width=1000, height=800, resizeable=yes');" target="pop_up">
				<h2>Pedidos de Férias</h2>
				<h3>Dados para pesquisa</h3>
				<table>
					<tr>
						<td>Matrícula</td>
						<td>Nome</td>
						<td>Cargo</td>
						<td>Area</td>
						<td>Período Trabalhado</td>
						<td>Ação</td>
					</tr>
					
				</table>
				
				<input type="hidden" name="logica" value="BuscaPessoaJuridica"/>
				
				<input type="submit" value="Pesquisar">
				<h3><a href="javascript:window.history.go(-1)">Voltar para a página anterior</a></h3>
				<p>&nbsp;</p>
			</form>
		</div>
	</div>
</body>
</html>
