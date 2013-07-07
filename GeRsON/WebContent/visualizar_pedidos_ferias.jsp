<%@page import="controller.business.BusinessController"%>
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

				<h2>Pedidos de Férias</h2>
				<h3>Dados para pesquisa</h3>
				<table>
					<tr>
						<td>Matrícula</td>
						<td>Nome</td>
						<td>Cargo</td>
						<td>Area</td>
						<td>Período Trabalhado</td>
						<td>Férias para</td>
						<td>Permitir</td>
					</tr>
						<%
						BusinessFerias ferias = new BusinessFerias();
						BusinessController controller = new BusinessController();
						PessoaFisica funcionario = new PessoaFisica();
						
						ferias.buscarPedidos();
						
						for(int i=0;i<ferias.getPedidosAtivos().length;i++){ 
							
							funcionario = controller.idPessoaFisica(ferias.getPedidosAtivos()[i].getIdFuncionario());
							
							int anos = (int)ferias.getPedidosAtivos()[i].getPeriodoTrabalhado();
							int meses = (int)((ferias.getPedidosAtivos()[i].getPeriodoTrabalhado()-(double)anos)*12);
							
						%>
							<tr>
							<td><%=funcionario.getMatricula() %></td>
							<td><%=funcionario.getNome() %></td>
							<td><%=funcionario.getCargo() %></td>
							<td><%=funcionario.getArea() %></td>
							<td><%=anos %> ano(s) e <%=meses %> mes(es) </td>
							<td><%=ferias.getPedidosAtivos()[i].getDataPedido() %></td>
							<td>
							
							<form name="resultado_ferias"
								action="ServletController" method="post">
								
							<select name="resultado">
								<option value="Sim">Sim</option>
								<option value="Não">Não</option>
							</select> 
							
							<input type="hidden" name="idFerias" value="<%=ferias.getPedidosAtivos()[i].getIdFerias() %>"/>
							<input type="hidden" name="logica" value="ResultadoFerias"/>
							
							<input type="submit" value="Enviar" />
							</form>
							</td>
							</tr>
						<%} %>
						
				</table>
				<p>&nbsp;</p>
		</div>
	</div>
</body>
</html>
