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

			<form name="solicitar_folha_ponto"
				action="ServletController" method="post">
				<h2>Solicitar Folha de Ponto - <%=pessoaFisica.getNome() %> </h2>
				
				<table>
					<tr>
						<td> Ano de Referência: 
						   <select name="referência">
								
								<option value="2013">2013</option>
							</select> 
						</td>
					</tr>
					<tr>
						<td> Mês: <select name="mes">
								
								<option value="Janeiro">Janeiro</option>
								<option value="Fevereiro">Fevereiro</option>
								<option value="Março">Março</option>
								<option value="Abril">Abril</option>
								<option value="Maio">Maio</option>
								<option value="Junho">Junho</option>
								<option value="Julho">Julho</option>
								<option value="Agosto">Agosto</option>
								<option value="Setembro">Setembro</option>
								<option value="FOutubro">Outubro</option>
								<option value="Novembro">Novembro</option>
								<option value="Dezembro">Dezembro</option>
						</select>
						</td>
					</tr>

				</table>
				
				<input type="hidden" name="logica" value="SolicitarFolhaPonto"/>
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
