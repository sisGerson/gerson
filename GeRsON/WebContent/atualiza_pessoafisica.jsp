<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.funcionarios.pf.*" %>
<!DOCTYPE html >

<html>
	<%
	if(session.getAttribute("funcionario") == null)
		response.sendRedirect("index.jsp?item=0");
	else{
		
	
		PessoaFisica pessoa = (PessoaFisica) session.getAttribute("funcionario");
		
		if(!pessoa.getCargo().equalsIgnoreCase("gerente")){
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
	PessoaFisica pessoaFisica = business.idPessoaFisica(id);
	
	SimpleDateFormat formataData2 = new SimpleDateFormat("dd/MM/yyyy");
	%>	
	
	<!-- Java Script utilizado para validação dos campos do formulário -->
	<script type="text/javascript">
		/*Campo CPF - permite somente valores numericos e monta a máscara*/
		function mascaraCPF(e, campo) {

			var tecla = (window.event) ? event.keyCode : e.which;
			if ((tecla > 47 && tecla < 58)) {
				mascara(campo, '###.###.###-##');
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
		
		/*funçao de adiciona uma linha na tabela dependentes*/
		function addRow(tableID) {
			 
            var table = document.getElementById(tableID);
 
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
 
            var colCount = table.rows[0].cells.length;
 
            for(var i=0; i<colCount; i++) {
 
                var newcell = row.insertCell(i);
 
                newcell.innerHTML = table.rows[0].cells[i].innerHTML;
                //alert(newcell.childNodes);
                switch(newcell.childNodes[0].type) {
                    case "text":
                            newcell.childNodes[0].value = "";
                            break;
                    case "checkbox":
                            newcell.childNodes[0].checked = false;
                            break;
                    case "select-one":
                            newcell.childNodes[0].selectedIndex = 0;
                            break;
                }
            }
        }
 		
		/*função que deleta uma linha da tabela dependentes*/
        function deleteRow(tableID) {
            try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
 
            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && true == chkbox.checked) {
                    if(rowCount <= 1) {
                        alert("Cannot delete all the rows.");
                        break;
                    }
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }
 
 
            }
            }catch(e) {
                alert(e);
            }
        }
	</script>

	<div id="layout">
		<div id="main">

			<form name="atualiza_pessoafisica"
				action="ServletController" method="post">
				<h2>Cadastro de Funcionário - Pessoa Física</h2>
				<p>
					Status do Funcionário: <select name="status_2">
					<%if(pessoaFisica.isStatus_2()){ %>
						<option value="True">Ativo</option>
						<option value="False">Inativo</option>
					<%} %>
					<%if(!pessoaFisica.isStatus_2()){ %>
						<option value="False">Inativo</option>
						<option value="True">Ativo</option>
					<%} %>
					</select>
				</p>
				
				<input type="hidden" name="id" value="<%= pessoaFisica.getId() %>" />
				
				<h3>Dados Pessoais</h3>
				<table>
					<tr>
						<td><br> * Nome: <input type="text" name="nome" value="<%= pessoaFisica.getNome() %>"
							size="65" maxlength="60" required/>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<%
							String dataNascimento = "";
							
							if(pessoaFisica.getDataNascimento() != null)
								dataNascimento = formataData2.format(pessoaFisica.getDataNascimento());
							%>
							* Data Nascimento: <input
							type="text"
							onkeypress="return mascaraDATA(event,this); return false;"
							name="dataNascimento" value="<%=dataNascimento %>" size="10" maxlength="10" required />
						</td>
					</tr>

					<tr>
						<td>* Email: <input type="Email" name="email" value="<%= pessoaFisica.getEmail() %>"
							size="40" maxlength="35" required />

						</td>
					</tr>
					<tr>
						<td>* Nacionalidade: <input type="text" name="nacionalidade"
							value="<%= pessoaFisica.getNacionalidade() %>" size="40" maxlength="40" required />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *
							Naturalidade: <input type="text" name="naturalidade" value="<%= pessoaFisica.getNaturalidade() %>"
							size="40" maxlength="40" required />
						</td>
					</tr>
					<tr>
						<td>* Estado Civil: &nbsp;&nbsp;&nbsp;&nbsp;<input
							type="text" name="estadoCivil" value="<%= pessoaFisica.getEstadoCivil() %>" size="40" maxlength="40"
							required />
						</td>
					</tr>
					<tr>
						<td>Conjuge: <input type="text" name="nomeConjuge" value="<%= pessoaFisica.getNomeConjuge() %>"
							size="50" maxlength="60" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							Nacionalidade do Conjuge: <input type="text"
							name="nacionalidadeConjuge" value="<%= pessoaFisica.getNacionalidadeConjuge() %>" size="27" maxlength="40" />
						</td>
					</tr>
					<tr>
						<td>Nome da mãe: <input type="text" name="nomeMae" value="<%= pessoaFisica.getNomeMae() %>"
							size="50" maxlength="60" /> &nbsp;&nbsp;&nbsp; Nacionalidade da
							mãe: <input type="text" name="nacionalidadeMae" value="<%= pessoaFisica.getNacionalidadeMae() %>"
							size="27" maxlength="40" />
						</td>
					</tr>
					<tr>
						<td>Nome do pai:&nbsp;&nbsp;&nbsp;<input type="text"
							name="nomePai" value="<%= pessoaFisica.getNomePai() %>" size="50" maxlength="60" />
							&nbsp;&nbsp;&nbsp; Nacionalidade do pai: &nbsp;&nbsp;<input
							type="text" name="nacionalidadePai" value="<%= pessoaFisica.getNacionalidadePai() %>" size="27"
							maxlength="40" />
						</td>
					</tr>
					<tr>
						<td>* Cor: <input type="text" name="racaCor" value="<%= pessoaFisica.getRacaCor() %>"
							size="30" maxlength="30" required /> &nbsp;&nbsp;&nbsp; * Peso: <input
							type="number" step="0.1" min="40" max="200" name="peso" value="<%= pessoaFisica.getPeso() %>"
							size="20" maxlength="30" required /> &nbsp;&nbsp;&nbsp; * Altura:
							<input type="number" step="0.1" min="1.4" max="2.30"
							name="altura" value="<%= pessoaFisica.getAltura() %>" size="20" maxlength="30" required />
						</td>
					</tr>
					<tr>
						<td>* Cor dos olhos: <input type="text" name="corOlhos"
							value="<%= pessoaFisica.getCorOlhos() %>" size="30" maxlength="30" required /> &nbsp;&nbsp;&nbsp;
							* Cor dos cabelos: <input type="text" name="corCabelo" value="<%= pessoaFisica.getCorCabelo() %>"
							size="20" maxlength="30" required />
						</td>
					</tr>
					<tr>
						<td>* Grau de Instrução: <input type="text"
							name="grauInstrucao" value="<%= pessoaFisica.getGrauInstrucao() %>" size="30" maxlength="40" required />
						</td>
					</tr>
					<tr>
						<td>Deficiente físico? <select name="deficienteFisico">
						
						<%if(pessoaFisica.isDeficienteFisico()){ %>
							<option value="True">Sim</option>
							<option value="False">Não</option>
						<%} %>
						
						<%if(!pessoaFisica.isDeficienteFisico()){ %>
							<option value="False">Não</option>
							<option value="True">Sim</option>
						<%} %>
						
						</select>
						</td>
					</tr>
					<tr>
						<td>Sinais Particulares: <textarea name="sinaisParticulares"
								style="overflow: auto; width: 755px; height: 40px;">
								<%= pessoaFisica.getSinaisParticulares() %></textarea>
						</td>
					</tr>
					<tr>
						<td>* CPF: <input type="text" name="CPF_CNPJ"
							onkeypress="return mascaraCPF(event,this);return false;" value="<%= pessoaFisica.getCPF_CNPJ() %>"
							size="20" maxlength="14" required /> &nbsp;&nbsp;&nbsp; CNH: <input
							type="number" step="1" min="1" max="999999999999999" name="CNH"
							value="<%= pessoaFisica.getCNH() %>" size="15" maxlength="15" /> &nbsp;&nbsp;&nbsp;
							Reservista: <input type="number" step="1" min="1"
							max="999999999999999" name="reservista" value="<%= pessoaFisica.getReservista() %>" size="15"
							maxlength="15" />
						</td>
					</tr>
					<tr>
						<td>* RG: &nbsp;&nbsp;<input type="number" step="1" min="1"
							max="99999999999" name="RG" value="<%= pessoaFisica.getRG() %>" size="10" maxlength="11"
							required /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; * Órgão Emissor: <input
							type="text" name="orgaoEmissor" value="<%= pessoaFisica.getOrgaoEmissor() %>" size="10" maxlength="15"
							required /> &nbsp;&nbsp;&nbsp; 
							
							<%
							String dataExpedicao = "";
							
							if(pessoaFisica.getDataExpedicao() != null)
								dataExpedicao = formataData2.format(pessoaFisica.getDataExpedicao());
							%>
							* Data Expedição: <input
							type="text"
							onkeypress="return mascaraDATA(event,this); return false;"
							name="dataExpedicao" value="<%=dataExpedicao %>" size="10" maxlength="10" required />
						</td>
					</tr>
					<tr>
						<td>* Nº CTPS: <input type="number" step="1" min="1"
							max="999999999999999" name="CTPS" value="<%= pessoaFisica.getCTPS() %>" size="15"
							maxlength="15" required /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; * Série
							CTPS: <input type="number" step="1" min="1" max="999999999999999"
							name="serieCTPS" value="<%= pessoaFisica.getSerieCTPS() %>" size="10" maxlength="15" required />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; * UF CTPS: <select name="UFCTPS">
								<option value="<%=pessoaFisica.getUFCTPS() %>">
								<%=pessoaFisica.getUFCTPS() %></option>
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
						</select>
						</td>
					</tr>
					<tr>
					
						<%
						String dataEmissao = "";
						
						if(pessoaFisica.getEmissaoCTPS() != null)
							dataEmissao = formataData2.format(pessoaFisica.getEmissaoCTPS());
						%>
						<td>* Data emissão CTPS: <input type="text"
							onkeypress="return mascaraDATA(event,this); return false;"
							name="emissaoCTPS" value="<%=dataEmissao %>" size="10" maxlength="10" required />
							&nbsp;&nbsp;&nbsp; PIS:<input type="number" step="1" min="1"
							max="999999999999999" name="PIS" value="<%= pessoaFisica.getPIS() %>" size="10"
							maxlength="10" />
						</td>
					</tr>
					<tr>
						<td>* Nº Título Eleitoral: <input type="number" step="1"
							min="1" max="999999999999999" name="tituloEleitoral" value="<%= pessoaFisica.getTituloEleitoral() %>"
							size="15" maxlength="15" required /> &nbsp;&nbsp; * Zona Título
							Eleitoral: <input type="number" step="1" min="1" max="9999999"
							name="zonaTitulo" value="<%= pessoaFisica.getZonaTitulo() %>" size="7" maxlength="15" required />
							&nbsp;&nbsp; * Seção Título Eleitoral: <input type="number"
							step="1" min="1" max="9999999" name="secaoTitulo" value="<%= pessoaFisica.getSecaoTitulo() %>"
							size="7" maxlength="15" required />
						</td>
					</tr>
					<tr>
						<td>* Endereço Residencial: <input type="text"
							name="enderecoResidencial" value="<%= pessoaFisica.getEnderecoResidencial() %>" size="101" maxlength="100"
							required />
						</td>
					</tr>
					<tr>
						<td>* Cidade Residencial: <input type="text"
							name="cidadeResidencial" value="<%= pessoaFisica.getCidadeResidencial() %>" size="25" maxlength="50"
							required /> &nbsp;&nbsp; * Estado Residencial: <select
							name="UFResidencial">
								<option value="<%=pessoaFisica.getUFResidencial() %>">
								<%=pessoaFisica.getUFResidencial() %></option>
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
						</select> &nbsp;&nbsp; * CEP Residencial: <input type="text"
							name="CEPResidencial"
							onkeypress="return mascaraCEP(event,this); return false;"
							value="<%= pessoaFisica.getCEPResidencial() %>" size="15" maxlength="9" required />
						</td>
					</tr>
					<tr>
						<td>Telefone Residencial: <input type="text"
							onkeypress="return mascaraTelefone(event,this); return false;"
							name="telefoneResidencial" value="<%= pessoaFisica.getTelefoneResidencial() %>" size="15" maxlength="13" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Telefone
							Celular: <input type="text" name="telefoneCelular"
							onkeypress="return mascaraTelefone(event,this); return false;"
							value="<%= pessoaFisica.getTelefoneCelular() %>" size="15" maxlength="13" /> <br>&nbsp;
						</td>
					</tr>
				</table>
				<h3>Dados Funcionais</h3>
				<p></p>
				<table>
					<tr>
						<td><br> * Matrícula: <input type="number" step="1"
							min="1" max="99999999" name="matricula" value="<%= pessoaFisica.getMatricula() %>" size="20"
							maxlength="8" required /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; * Senha:
							<input type="text" name="senha"
							value="<%= pessoaFisica.getSenha() %>" size="15" maxlength="8" required />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; * Área: <input type="text"
							name="area" value="<%= pessoaFisica.getArea() %>" size="40" maxlength="40" required /></td>
					</tr>
					<tr>
					
						<% 
						String dataAdmissao = "";
						
						if(pessoaFisica.getDataAdmissao() != null)
							dataAdmissao = formataData2.format(pessoaFisica.getDataAdmissao());
						%>
						<td>* Data de Admissão: <input type="text"
							onkeypress="return mascaraDATA(event,this); return false;"
							name="dataAdmissao" value="<%=dataAdmissao %>" size="10" maxlength="10" required />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							
						<% 
						String dataDeligamento = "";
						
						if(pessoaFisica.getDataDesligamento() != null)
							dataDeligamento = formataData2.format(pessoaFisica.getDataDesligamento());
						%>
							Data de Desligamento: <input type="text"
							onkeypress="return mascaraDATA(event,this); return false;"
							name="dataDesligamento" value="<%=dataDeligamento %>" size="10" maxlength="10" />
						</td>
					</tr>
					<tr>
						<td>* Salario: <input type="number" step="0.01" min="678.00"
							max="25000.00" name="salario" value="<%= pessoaFisica.getSalario() %>" size="20" maxlength="8"
							required />
							
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *
							Cargo: <select name="cargo">
							<option value="<%=pessoaFisica.getCargo() %>">
								<%=pessoaFisica.getCargo() %></option>
							<option value="Atendente">Atendente</option>
							<option value="Analista Administrativo">Analista Administrativo</option>
							<option value="Analista Financeiro">Analista Financeiro</option>
							<option value="Designer Gráfico">Designer Gráfico</option>
							<option value="Gerente">Gerente</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>* Horário de Trabalho: <input type="text"
							name="horarioTrabalho" value="<%= pessoaFisica.getHorarioTrabalho() %>" size="20" maxlength="10" required />
							&nbsp;&nbsp;&nbsp;&nbsp; * Total de Horas Semanais: <select
							name="totalHoraSemanal">
								<option value="<%=pessoaFisica.getTotalHoraSemanal() %>">
								<%=pessoaFisica.getTotalHoraSemanal() %></option>
								<option value="20">20</option>
								<option value="30">30</option>
								<option value="40">40</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>Endereço Funcional:&nbsp;&nbsp;&nbsp;<input type="text"
							name="enderecoFuncional" value="<%= pessoaFisica.getEnderecoFuncional() %>" size="103" maxlength="100" />
						</td>
					</tr>
					<tr>
						<td>Cidade Funcional: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="text" name="cidadeFuncional" value="<%= pessoaFisica.getCidadeFuncional() %>" size="25"
							maxlength="50" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							Estado Funcional: <select name="UFCidadeFuncional">
								<option value="<%=pessoaFisica.getUFCidadeFuncional() %>">
								<%=pessoaFisica.getUFCidadeFuncional() %></option>
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
						</select>
						</td>
					</tr>
					<tr>
						<td>CEP Funcional: <input type="text" name="CEPFuncional"
							onkeypress="return mascaraCEP(event,this); return false;"
							value="<%= pessoaFisica.getCEPFuncional() %>" size="15" maxlength="9" />
						</td>
					</tr>
					<tr>
						<td>Telefone Comercial: &nbsp;&nbsp;&nbsp;<input type="text"
							name="telefoneComercial"
							onkeypress="return mascaraTelefone(event,this); return false;"
							value="<%= pessoaFisica.getTelefoneComercial() %>" size="15" maxlength="13" /> <br>&nbsp;
						</td>
					</tr>
				</table>
	
		<!--
	<h3>Dependentes</h3>
	<p></p>
	tabela dependentes inicio		
	<INPUT type="button" value="Adicionar Dependente" onclick="addRow('Dependentes')" />
 
    <INPUT type="button" value="Retirar Dependente" onclick="deleteRow('Dependentes')" />
 
    <TABLE id="Dependentes" border="1">
        <TR>
            <TD><INPUT type="checkbox" name="seleciona"/></TD>
            
            <TD>Nome do Dependente<INPUT type="text" name="nomeDependente" value="" size="51" maxlength="50"/></TD>
        	
        	<TD> Data de Nascimento<INPUT type="text" 
        	onkeypress="return mascaraDATA(event,this); return false;"
			name="dataNascimento" value="" size="10" maxlength="10" /></TD>
			
			<TD>IRRF<select name="IRRF">
						<option value="True">Sim</option>
						<option value="False">Não</option>
					</select></TD>
			
			<TD>Salario Familia<select name="SalarioFamilia">
						<option value="True">Sim</option>
						<option value="False">Não</option>
					</select></TD>
        </TR>
    </TABLE>
 tabela dependentes fim -->
				
				<input type="hidden" name="logica" value="AtualizaPessoaFisica"/>
				
				<input type="submit" value="Atualizar dados">
				<h3><a href="javascript:window.history.go(-1)">Voltar para a página anterior e escolher outro Funcionário</a></h3>
				<input type="button" value="Fechar Janela" onclick="window.close()" />
				<hr>
			</form>
		</div>
	</div></div></div>
</body>
</html>
