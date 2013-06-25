<% 
//Busca a sessão aberta
//Se existir uma sessão e esta sessão for do gerente mostra o conteúdo da página, senão retorna para a página principal
//String gerente = (String) session.getAttribute("gerente");

if (session.getAttribute("gerente") == null ) {
	response.sendRedirect("index.jsp?item=0");
}else{
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.funcionarios.pj.*" %>
<!DOCTYPE html >

<html>
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
      <div id="header">
        <h1 id="logo"><a href="#" title="#">GeRs<span>ON</span></a></h1>
        <hr class="noscreen" />            
        <div id="navigation">
        </div>
        <hr class="noscreen" />  
        </div>
<div id="main">
	<jsp:useBean id="business" class="controller.business.BusinessController"></jsp:useBean>
	<% 
	int id = Integer.parseInt(request.getParameter("id"));
	PessoaJuridica pessoaJuridica = business.idPessoaJuridica(id);
	%>

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

			<form name="atualiza_pessoajuridica"
				action="ServletController" method="post">
				<h2>Dados da Empresa escolhida</h2>
				<p>
					Status do Funcionário: <select name="status_2">
					<%if(pessoaJuridica.isStatus_2()){ %>
						<option value="True">Ativo</option>
						<option value="False">Inativo</option>
					<%} %>
					<%if(!pessoaJuridica.isStatus_2()){ %>
						<option value="False">Inativo</option>
						<option value="True">Ativo</option>
					<%} %>
					</select>
				</p>
				
				<input type="hidden" name="id" value="<%= pessoaJuridica.getId() %>" />
				
				<h3>Dados da Empresa</h3>
				<table>
					<tr>
						<td><br> * Empresa: <input type="text" name="nome"
							value="<%= pessoaJuridica.getNome() %>" size="65" maxlength="60" required />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; * CNPJ: <input
							type="text" name="CPF_CNPJ"
							onkeypress="return mascaraCNPJ(event,this);return false;"
							value="<%= pessoaJuridica.getCPF_CNPJ() %>" size="30" maxlength="18" required /></td>
					</tr>
					<tr>
						<td>* Email: <input type="Email" name="email" value="<%= pessoaJuridica.getEmail() %>"
							size="40" maxlength="35" required />
						</td>
					</tr>
					<tr>
						<td>Serviços prestados <br> Descrição: <br> <textarea
								name="descricaoServico"
								style="overflow: auto; width: 745px; height: 40px;">
								<%= pessoaJuridica.getDescricaoServico() %></textarea>
						</td>
					</tr>
					<tr>
						<td>* Endereço Comercial: <input type="text"
							name="enderecoFuncional" value="<%= pessoaJuridica.getEnderecoFuncional() %>" size="101" maxlength="100"
							required />
						</td>
					</tr>
					<tr>
						<td>* Cidade Comercial: <input type="text"
							name="cidadeFuncional" value="<%= pessoaJuridica.getCidadeFuncional() %>" size="25" maxlength="50" required />
							&nbsp;&nbsp; Estado Comercial: <select name="UFCidadeFuncional">
								<option value="<%=pessoaJuridica.getUFCidadeFuncional() %>">
								<%=pessoaJuridica.getUFCidadeFuncional() %></option>
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
						</select> &nbsp;&nbsp; * CEP Comercial: <input type="text"
							name="CEPFuncional"
							onkeypress="return mascaraCEP(event,this); return false;"
							value="<%= pessoaJuridica.getCEPFuncional() %>" size="15" maxlength="9" required />
						</td>
					</tr>
					<tr>
						<td>Telefone Comercial: <input type="text"
							onkeypress="return mascaraTelefone(event,this); return false;"
							name="telefoneComercial" value="<%= pessoaJuridica.getTelefoneComercial() %>" size="15" maxlength="13" />
						</td>
					</tr>
				</table>

				<h3>Dados Funcionais</h3>
				<p></p>
				<table>
					<tr>
						<td><br> * Matrícula: <input type="number" step="1"
							min="1" max="99999999" name="matricula" value="<%= pessoaJuridica.getMatricula() %>" size="20"
							maxlength="8" required /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *
							Senha: <input type="text" name="senha" 
							value="<%= pessoaJuridica.getSenha() %>" size="15" maxlength="8" required /></td>
					</tr>
					<tr>
						<td>* Área: <input type="text" name="area" value="<%= pessoaJuridica.getArea() %>" size="40"
							maxlength="40" required /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *
							Salario: <input type="number" step="0.01" min="678.00"
							max="15000.00" name="salario" value="<%= pessoaJuridica.getSalario() %>" size="20" maxlength="8"
							required />
						</td>
					</tr>
					<tr>
						<td>* Data de Admissão: <input type="text"
							onkeypress="return mascaraDATA(event,this); return false;"
							name="dataAdmissao" value="<%= pessoaJuridica.getDataAdmissao() %>" size="10" maxlength="10" required />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Data
							de Desligamento: <input type="text"
							onkeypress="return mascaraDATA(event,this); return false;"
							name="dataDesligamento" value="<%= pessoaJuridica.getDataDesligamento() %>" size="10" maxlength="10" />
						</td>
					</tr>
					<tr>
						<td>* Responsável: <input type="text" name="responsavel"
							value="<%= pessoaJuridica.getResponsavel() %>" size="65" maxlength="60" required />
						</td>
					</tr>
					<tr>
						<td>Telefone Responsável: <input type="text"
							onkeypress="return mascaraTelefone(event,this); return false;"
							name="telefoneResponsavel" value="<%= pessoaJuridica.getTelefoneResponsavel() %>" size="15" maxlength="13" />
							<br>&nbsp;
						</td>
					</tr>
				</table>
				
				<input type="hidden" name="logica" value="AtualizaPessoaJuridica"/>
				
				<input type="submit" value="Atualizar dados">
				<h3><a href="javascript:window.history.go(-1)">Voltar para a página anterior e escolher outra Empresa</a></h3>
				<input type="button" value="Fechar Janela" onclick="window.close()" />
			</form>
		</div>
	</div>
	</div>
	</div>
</body>
</html>
<% } %>