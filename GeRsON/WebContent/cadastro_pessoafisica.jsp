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
        <form name="cadastrar_pessoafisica" action="ServletCadastroPessoaFisica" method="post" >
		<h2>Cadastro de Funcionário - Pessoa Física</h2>
		<p>Status do Funcionário: 
		<select name="status_2">
			<option value="True">Ativo</option>
			<option value="False">Inativo</option>
		</select>
		</p>
		<h3>Dados Pessoais</h3>
		<table>
		<tr>
		<td>
		* Nome: <input type="text" name="nome" value="" size="50" maxlength="60" required />
		* Data Nascimento: <input type="date" name="dataNascimento" value="" size="10" maxlength="10" required />
		</td>
		</tr>
		
		<tr>
		<td>
		* Email: <input type="E-mail" name="email" value="" size="20" maxlength="30" required/>
		* Senha: <input type="password" name="senha" value="" size="15" maxlength="10" required/>
		</td>
		</tr>
		<tr>
		<td>
		* Nacionalidade: <input type="text" name="nacionalidade" value="" size="20" maxlength="30" required/>
		* Naturalidade: <input type="text" name="naturalidade" value="" size="20" maxlength="30" required/>
		</td>
		</tr>
		<tr>
		<td>
		* Estado Civil: <input type="text" name="estadoCivil" value="" size="25" maxlength="25" required/>
		Conjuge: <input type="text" name="nomeConjuge" value="" size="50" maxlength="60"/>
		<br>
		Nacionalidade do Conjuge: <input type="text" name="nacionalidadeConjuge" value="" size="20" maxlength="30"/>
		</td>
		</tr>
		<tr>
		<tr>
		<td>
		Nome da mãe: <input type="text" name="nomeMae" value="" size="45" maxlength="60"/>
		Nacionalidade da mãe: <input type="text" name="nacionalidadeMae" value="" size="20" maxlength="30"/>
		</td>
		</tr>
		<tr>
		<tr>
		<td>
		Nome do pai: <input type="text" name="nomePai" value="" size="50" maxlength="60"/>
		Nacionalidade do pai: <input type="text" name="nacionalidadePai" value="" size="20" maxlength="30"/>
		</td>
		</tr>
		<tr>
		<td>
		* Cor: <input type="text" name="racaCor" value="" size="20" maxlength="30" required/>
		* Peso: <input type="text" name="peso" value="" size="20" maxlength="30" required/>
		* Altura: <input type="text" name="altura" value="" size="20" maxlength="30" required/>
		</td>
		</tr>
		<tr>
		<td>
		* Cor dos olhos: <input type="text" name="corOlhos" value="" size="20" maxlength="30" required/>
		* Cor dos cabelos: <input type="text" name="corCabelo" value="" size="20" maxlength="30" required/>
		</td>
		</tr>
		<tr>
		<td>
		* Grau de Instrução: <input type="text" name="grauInstrucao" value="" size="30" maxlength="40" required/>
		</td>
		</tr>
		<tr>
		<td>
		Deficiente físico? 
		<select name="deficienteFisico">
			<option value="False">Não</option>
			<option value="True">Sim</option>
		</select>
		<br>
		Sinais Particulares: <br>
		<textarea name="sinaisParticulares" style="overflow: auto; width: 750px; height: 40px;"></textarea>
		</td>
		</tr>
		<tr>
		<td>
		* CPF: <input type="text" name="CPF_CNPJ" onkeypress="return mascaraCPF(event,this);return false;" value="" size="15" maxlength="14" required />
		CNH: <input type="text" name="CNH" value="" size="15" maxlength="15"/>
		Reservista: <input type="text" name="reservista" value="" size="14" maxlength="15"/>
		</td>
		</tr>
		<tr>
		<td>
		* RG: <input type="text" name="RG" value="" size="10" maxlength="15" required/>
		* Órgão Emissor: <input type="text" name="orgaoEmissor" value="" size="10" maxlength="15" required/>
		* Data Expedição: <input type="date" name="dataExpedicao" value="" size="10" maxlength="10"/>
		</td>
		</tr>
		<tr>
		<td>
		* Nº CTPS: <input type="text" name="CTPS" value="" size="15" maxlength="15" required/>
		* Série CTPS: <input type="text" name="serieCTPS" value="" size="10" maxlength="10" required/>
		* UF CTPS: <select name="UFCTPS">
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
		<td>
		* Data emissão CTPS: <input type="date" name="emissaoCTPS" value="" size="10" maxlength="10" required/>
		PIS:<input type="text" name="PIS" value="" size="10" maxlength="10"/>
		</td>
		</tr>
		<tr>
		<td>
		* Nº Título Eleitoral: <input type="text" name="tituloEleitoral" value="" size="15" maxlength="15" required/>
		* Zona Título Eleitoral: <input type="text" name="zonaTitulo" value="" size="10" maxlength="10" required/>
		* Seção Título Eleitoral: <input type="text" name="secaoTitulo" value="" size="10" maxlength="10" required/>
		</td>
		</tr>
		<tr>
		<td>
		* Endereço Residencial: <input type="text" name="enderecoResidencial" value="" size="100" maxlength="100" required/>
		</td>
		</tr>
		<tr>
		<td>
		* Cidade Residencial: <input type="text" name="cidadeResidencial" value="" size="25" maxlength="50" required/>
		* Estado Residencial: 
		<select name="UFResidencial">
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
		* CEP Residencial: <input type="text" name="CEPResidencial" onkeypress="return mascaraCEP(event,this); return false;" value="" size="15" maxlength="13" required/>
		</td>
		</tr>
		<tr>
		<td>
		Telefone Residencial: <input type="text" onkeypress="return mascaraTelefone(event,this); return false;" name="telefoneResidencial" value="" size="15" maxlength="13"/>
		Telefone Celular: <input type="text" name="telefoneCelular" onkeypress="return mascaraTelefone(event,this); return false;" value="" size="15" maxlength="13"/>
		</td>
		</tr>		
		</table>
		<h3>Dados Funcionais</h3>
		<p ></p>
		<table>
		<tr>
		<td>
		* Matrícula: <input type="text" name="matricula" value="" size="20" maxlength="15" required/>
		* Área: <input type="text" name="area" value="" size="30" maxlength="40" required/>
		</td>
		</tr>
		<tr>
		<td>
		* Data de Admissão: <input type="date" name="dataAdmissao" value="" size="20" maxlength="10" required/>
		Data de Desligamento: <input type="date" name="dataDesligamento" value="" size="20" maxlength="10"/>
		</td>
		</tr>
		<tr>
		<td>
		* Salario: <input type="text" name="salario" value="" size="20" maxlength="10" required/>
		* Cargo: <input type="text" name="cargo" value="" size="20" maxlength="20" required/>
		</td>
		</tr>
		<tr>
		<td>
		* Horário de Trabalho: <input type="text" name="horarioTrabalho" value="" size="20" maxlength="10" required/>
		* Total de Horas Semanais: <input type="text" name="totalHoraSemanal" value="" size="20" maxlength="10" required/>
		</td>
		</tr>
		<tr>
		<td>
		Endereço Funcional: <input type="text" name="enderecoFuncional" value="" size="100" maxlength="100"/>
		</td>
		</tr>
		<tr>
		<td>
		Cidade Funcional: <input type="text" name="cidadeFuncional" value="" size="25" maxlength="50"/>
		Estado Funcional: 
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
		CEP Funcional: <input type="text" name="CEPFuncional" onkeypress="return mascaraCEP(event,this); return false;" value="" size="15" maxlength="9"/>
		</td>
		</tr>
		<tr>
		<td>
		Telefone Comercial: <input type="text" name="telefoneComercial" onkeypress="return mascaraTelefone(event,this); return false;" value="" size="15" maxlength="13"/>
		</td>
		</tr>		
		</table>
		<input type="submit" value="Cadastrar">
		</form>
</div>
</div>
  </body>
</html>

<!-- Java Script utilizado para validação dos campos do formulário -->

<script type="text/javascript">

/*Campo CPF - permite somente valores numericos e monta a máscara*/
function mascaraCPF(e,campo){
 
    var tecla=(window.event)?event.keyCode:e.which;
    if((tecla > 47 && tecla < 58 )){
           mascara(campo, '###.###.###-##');
           return true;
         }
    else{
    if (tecla != 8 ) return false;
    else return true;
    }
}

/*Campos de Telefones - permite somente valores numericos */
function mascaraTelefone(e,campo){
    var tecla=(window.event)?event.keyCode:e.which;
    if((tecla > 47 && tecla < 58 )){
           mascara(campo, '(##)####-####');
           return true;
         }
    else{
    if (tecla != 8 ) return false;
    else return true;
    }
}
/*Campo CEP - permite somente valores numericos e coloca a máscara*/
function mascaraCEP(e,campo){
    var tecla=(window.event)?event.keyCode:e.which;
    if((tecla > 47 && tecla < 58 )){
           mascara(campo, '#####-###');
           return true;
         }
    else{
    if (tecla != 8 ) return false;
    else return true;
    }
}
 
/*cria a mascara*/
function mascara(src, mask){
   var i = src.value.length;
   var saida = mask.substring(1,2);
   var texto = mask.substring(i);
   if (texto.substring(0,1) != saida)
   {
      src.value += texto.substring(0,1);
   }
}
 

</script> 