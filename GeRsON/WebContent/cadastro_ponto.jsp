<%@page import="model.funcionarios.pf.PessoaFisica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html><%
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
<link rel="stylesheet" type="text/css" href="css/formulario.css">


<title>GeRsON</title>
</head>
<body>


	<div id="layout">
		<div id="main">

			<form name="cadastrar_pessoafisica"
				action="ServletController" method="post">
				<h2>Folha de Ponto - <%=pessoaFisica.getNome() %> </h2>

				
				<table>
					<tr>
						<td> Data:  27/06/2013 09:55:00
						</td>
					</tr>
					<tr>
						<td> Opção: <select name="opcao">
								
								<option value="Entrada">Entrada</option>
								<option value="Saida">Saída</option>
								<option value="Início Almoço">Início Almoço</option>
								<option value="Fim Almoço">Fim Almoço</option>
						</select>
						</td>
					</tr>

				</table>
				
				<input type="hidden" name="logica" value="CadastroPonto"/>
				<input type="submit" value="Bater Ponto" />
				<hr>
				
			</form>
		</div>
	</div>
</body>
	<%
	}
	%>
</html>
