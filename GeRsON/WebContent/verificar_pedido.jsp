<%@page import="controller.business.BusinessFerias"%>
<%@page import="model.funcionarios.pf.PessoaFisica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<%
	if (session.getAttribute("funcionario") == null)
		response.sendRedirect("index.jsp?item=0");
	else {
		
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
			<!-- Itens associados a pessoa Pessoa fisica -->
			<h2>Resultado do último pedido de férias: <%=pessoaFisica.getNome() %></h2>
			<p>&nbsp;</p>
			
			<%
			BusinessFerias ferias1 = new BusinessFerias();
			ferias1.verificarPedido(pessoaFisica);
			
			if(ferias1.getResultadoPedido().equals("Aguarde")) {
			%>
				<h3>Aguarde seu pedido ainda não foi processado!</h3><br>
			<%
			}
			else if(ferias1.getResultadoPedido().equals("Rejeitado")) {
			%>
				<h3>Seu pedido de férias foi rejeitado!</h3><br>
			<%
			}
			else {
			%>
				<h3>Seu pedido de férias foi aprovado!</h3><br>
			<%
			}
			%>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</div>
	</div>
</body>
	<%
	}
	%>
</html>