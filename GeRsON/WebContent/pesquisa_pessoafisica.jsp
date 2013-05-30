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


			<p align="right">
				<b>Usuário logado: Gerente</b>
			</p>
			<form name="pesquisar_pessoafisica" action="ServletBuscaPessoaFisica"
				method="post">
				<h2>Pesquisa Pessoa Física</h2>
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
						<td>Nome: <input type="text" name="nome" value="" size="50"
							maxlength="50" /> CPF: <input type="text" name="cpf"
							onkeypress="return mascaraCPF(event,this);return false;" value=""
							size="20" maxlength="14" />
						</td>
					</tr>
					<tr>
						<td>Cargo: <input type="text" name="cargo" value="" size="20"
							maxlength="20" />
						</td>
					</tr>
				</table>

				<input type="submit" value="Pesquisar">
			</form>
		</div>
	</div>
</body>
</html>