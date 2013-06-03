<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

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

			<form name="pesquisar_pessoafisica"
				action="ServletBuscaPessoaJuridica" method="post" onsubmit="window.open('','pop_up','width=1000, height=800, resizeable=yes');" target="pop_up">
				<h2>Pesquisa Pessoa Jurídica</h2>
				<h3>Dados para pesquisa</h3>
				<table>
					<tr>
						<td>Matrícula: <input type="number" step="1" min="1"
							max="99999999" name="matricula" value="" size="20" maxlength="8" />
							Área: <input type="text" name="area" value="" size="30"
							maxlength="40" />
						</td>
					</tr>
					<tr>
						<td>Empresa: <input type="text" name="empresa" value=""
							size="50" maxlength="50" /> CNPJ: <input type="text" name="cnpj"
							onkeypress="return mascaraCNPJ(event,this);return false;"
							value="" size="20" maxlength="18" />
						</td>
					</tr>
					<tr>
						<td>Responsavel: <input type="text" name="responsavel"
							value="" size="40" maxlength="50" />
						</td>
					</tr>
				</table>

				<input type="submit" value="Pesquisar">
				<h3><a href="javascript:window.history.go(-1)">Voltar para a página anterior</a></h3>
				<p>&nbsp;</p>
			</form>
		</div>
	</div>
</body>
</html>