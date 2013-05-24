<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
    <meta http-equiv="content-language" content="pt-br" />
    <meta name="description" content="GeRsON - Gerência de Recursos On-line" />
    <meta name="keywords" content="cadastro de cliente, controle de almoxarifado" />
    <link rel="stylesheet" type="text/css" href="css/formulario.css">
    

    <title>GeRsON</title>
  </head>
  <body>
  	<div id="layout">
    <div id="main">
     
     <p align="right"><b>Usuário logado: Gerente</b></p>
        <form name="cadastrar_funcionario" action="ServletCadastroPessoaJuridica" method="post" >
		<h2>Cadastro de Funcionário - Pessoa Jurídica</h2>
		<p>Status do Funcionário: 
		<select name="status_2">
			<option value="True">Ativo</option>
			<option value="False">Inativo</option>
		</select>
		</p>
		
		<h3>Dados da Empresa</h3>
		<table>
		<tr>
		<td>
		Nome: <input type="text" name="nome" value="" size="40" maxlength="60"/>
		CNPJ: <input type="text" name="CPF_CNPJ" value="" size="15" maxlength="14"/>
		</td>
		</tr>
		<tr>
		<td>
		Email: <input type="text" name="email" value="" size="20" maxlength="30"/>
		Senha: <input type="text" name="senha" value="" size="15" maxlength="10"/>
		</td>
		</tr>
		<tr>
		<td>
		Serviços prestados 
		<br>
		Descrição: <br>
		<textarea name="descricaoServico" style="overflow: auto; width: 700px; height: 40px;"></textarea>
		</td>
		</tr>
		<tr>
		<td>
		Endereço Comercial: <input type="text" name="enderecoFuncional" value="" size="80" maxlength="100"/>
		</td>
		</tr>
		<tr>
		<td>
		Cidade Comercial: <input type="text" name="cidadeFuncional" value="" size="25" maxlength="50"/>
		Estado Comercial: 
		<select name="UFCidadeFuncional">
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
		CEP Comercial: <input type="text" name="CEPFuncional" value="" size="15" maxlength="8"/>
		</td>
		</tr>
		<tr>
		<td>
		Telefone Comercial: <input type="text" name="telefoneComercial" value="" size="15" maxlength="10"/>
		</td>
		</tr>
		</table>
		
		<h3>Dados Funcionais</h3>
		<p ></p>
		<table>
		<tr>
		<td>
		Matrícula: <input type="text" name="matricula" value="" size="20" maxlength="15"/>
		Área: <input type="text" name="area" value="" size="20" maxlength="40"/>
		Salario: <input type="text" name="salario" value="" size="20" maxlength="10"/>
		</td>
		</tr>
		<tr>
		<td>
		Data de Admissão: <input type="text" name="dataAdmissao" value="" size="20" maxlength="10"/>
		Data de Desligamento: <input type="text" name="dataDesligamento" value="" size="20" maxlength="10"/>
		</td>
		</tr>
		<tr>
		<td>
		Responsável: <input type="text" name="responsavel" value="" size="40" maxlength="60"/>
		Telefone Responsável: <input type="text" name="telefoneResponsavel" value="" size="15" maxlength="10"/>
		</td>
		</table>
		
		<input type="submit" value="Cadastrar">
		</form>
	</div>
	</div>
</body>
</html>