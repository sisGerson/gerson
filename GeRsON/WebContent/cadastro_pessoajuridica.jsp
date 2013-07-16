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

	<!-- Java Script utilizado para validação dos campos do formulário -->
	<script type="text/javascript">
		/*Campo CNPJ - permite somente valores numericos e monta a máscara*/
		function mascaraCNPJ(e, campo) {

			var tecla = (window.event) ? event.keyCode : e.which;
			if ((tecla > 47 && tecla < 58)) {
				mascara(campo, '##.###.###/####-##');
				return true;
			} else {
				if (tecla != 8)
					return false;
				else
					return true;
			}
		}

		/*Campo DATA - permite somente valores numericos e coloca a máscara*/
		function mascaraDATA(e, campo) {
			var tecla = (window.event) ? event.keyCode : e.which;
			if ((tecla > 47 && tecla < 58)) {
				mascara(campo, '##/##/####');
				return true;
			} else {
				if (tecla != 8)
					return false;
				else
					return true;
			}
		}

		/*Campos de Telefones - permite somente valores numericos */
		function mascaraTelefone(e, campo) {
			var tecla = (window.event) ? event.keyCode : e.which;
			if ((tecla > 47 && tecla < 58)) {
				mascara(campo, '(##)####-####');
				return true;
			} else {
				if (tecla != 8)
					return false;
				else
					return true;
			}
		}

		/*Campo CEP - permite somente valores numericos e coloca a máscara*/
		function mascaraCEP(e, campo) {
			var tecla = (window.event) ? event.keyCode : e.which;
			if ((tecla > 47 && tecla < 58)) {
				mascara(campo, '#####-###');
				return true;
			} else {
				if (tecla != 8)
					return false;
				else
					return true;
			}
		}

		/*cria a mascara*/
		function mascara(src, mask) {
			var i = src.value.length;
			var saida = mask.substring(1, 2);
			var texto = mask.substring(i);
			if (texto.substring(0, 1) != saida) {
				src.value += texto.substring(0, 1);
			}
		}
	</script>
	<div id="layout">
		<div id="main">

			<form name="cadastrar_pessoajuridica"
				action="ServletController" method="post">
				<h2>Cadastro de Funcionário - Pessoa Jurídica</h2>
				
				<%
				if(session.getAttribute("erroMatricula") != null) {
				%>
				<h3><%=session.getAttribute("erroMatricula") %></h3>
				<%} %>
				
				<p>
					Status do Funcionário: <select name="status_2">
						<option value="True">Ativo</option>
						<option value="False">Inativo</option>
					</select>
				</p>

				<h3>Dados da Empresa</h3>
				<table>
					<tr>
						<td><br> * Empresa: <input type="text" name="nome"
							value="" size="65" maxlength="60" required />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							* CNPJ: <input type="text" name="CPF_CNPJ"
							onkeypress="return mascaraCNPJ(event,this);return false;"
							value="" size="30" maxlength="18" required /></td>
					</tr>
					<tr>
						<td>* Email: <input type="Email" name="email" value=""
							size="40" maxlength="35" required />
						</td>
					</tr>
					<tr>
						<td>Descrição dos Serviços Prestados: <br> <textarea
								name="descricaoServico"
								style="overflow: auto; width: 745px; height: 40px;"></textarea>
						</td>
					</tr>
					<tr>
						<td>* Endereço: <input type="text"
							name="enderecoFuncional" value="" size="101" maxlength="100"
							required />
						</td>
					</tr>
					<tr>
						<td>* Cidade: <input type="text"
							name="cidadeFuncional" value="" size="25" maxlength="50" required />
							&nbsp;&nbsp; Estado: <select name="UFCidadeFuncional">
								<option value="AC">AC</option>
								<option value="AL">AL</option>
								<option value="AP">AP</option>
								<option value="AM">AM</option>
								<option value="BA">BA</option>
								<option value="CE">CE</option>
								<option value="DF">DF</option>
								<option value="ES">ES</option>
								<option value="GO">GO</option>
								<option value="MA">MA</option>
								<option value="MT">MT</option>
								<option value="MS">MS</option>
								<option value="MG">MG</option>
								<option value="PA">PA</option>
								<option value="PB">PB</option>
								<option value="PR">PR</option>
								<option value="PE">PE</option>
								<option value="PI">PI</option>
								<option value="RJ">RJ</option>
								<option value="RN">RN</option>
								<option value="RS">RS</option>
								<option value="RO">RO</option>
								<option value="RR">RR</option>
								<option value="SC">SC</option>
								<option value="SP">SP</option>
								<option value="SE">SE</option>
								<option value="TO">TO</option>
						</select> &nbsp;&nbsp; * CEP: <input type="text"
							name="CEPFuncional"
							onkeypress="return mascaraCEP(event,this); return false;"
							value="" size="15" maxlength="9" required />
						</td>
					</tr>
					<tr>
						<td>Telefone: <input type="text"
							onkeypress="return mascaraTelefone(event,this); return false;"
							name="telefoneComercial" value="" size="15" maxlength="13" />
						</td>
					</tr>
				</table>

				<h3>Dados Funcionais</h3>
				<p></p>
				<table>
					<tr>
						<td><br> * Matrícula: <input type="number" step="1"
							min="1" max="99999999" name="matricula" value="" size="20"
							maxlength="8" required />
					</tr>
					<tr>
						<td>* Área: <input type="text" name="area" value="" size="40"
							maxlength="40" required /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *
							Valor do Contrato: <input type="number" step="0.01" min="678.00"
							max="150000.00" name="salario" value="" size="20" maxlength="8"
							required />
						</td>
					</tr>
					<tr>
						<td>* Data de Admissão: <input type="text"
							onkeypress="return mascaraDATA(event,this); return false;"
							name="dataAdmissao" value="" size="10" maxlength="10" required />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Data
							de Desligamento: <input type="text"
							onkeypress="return mascaraDATA(event,this); return false;"
							name="dataDesligamento" value="" size="10" maxlength="10" />
						</td>
					</tr>
					<tr>
						<td>* Responsável: <input type="text" name="responsavel"
							value="" size="65" maxlength="60" required />
						</td>
					</tr>
					<tr>
						<td>Telefone Responsável: <input type="text"
							onkeypress="return mascaraTelefone(event,this); return false;"
							name="telefoneResponsavel" value="" size="15" maxlength="13" />
							<br>&nbsp;
						</td>
					</tr>
				</table>
				
				<input type="hidden" name="logica" value="CadastroPessoaJuridica"/>
				
				<input type="submit" value="Cadastrar">
				<p>&nbsp;</p>
			</form>
		</div>
	</div>
</body>
</html>
