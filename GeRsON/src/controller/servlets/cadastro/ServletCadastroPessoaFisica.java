package controller.servlets.cadastro;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pf.PessoaFisica;
import dao.cadastros.GerenteDAO;

/**
 * Servlet implementation class ServletCadastroPessoaFisica
 */
public class ServletCadastroPessoaFisica extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletCadastroPessoaFisica() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PessoaFisica pessoaFisica = new PessoaFisica();

		//Recebendo os dados da área e validando se o campo está fazio
		String area = request.getParameter("area");
		if ((area == null) || (area.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setArea(request.getParameter("area"));
		}
		
		pessoaFisica.setMatricula(request.getParameter("matricula"));
		
		String dataAdmissaoTexto = request.getParameter("dataAdmissao");
		Date dataAdmissao;
		//validando a data de Admissão
		try {
			dataAdmissao = new SimpleDateFormat("dd/MM/yyyy").parse(dataAdmissaoTexto);
			pessoaFisica.setDataAdmissao(dataAdmissao);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		String dataDesligamentoTexto = request.getParameter("dataDesligamento");
		Date dataDesligamento;
		try {
			dataDesligamento = new SimpleDateFormat("dd/MM/yyyy").parse(dataDesligamentoTexto);
			pessoaFisica.setDataDesligamento(dataDesligamento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pessoaFisica.setStatus_2(Boolean.parseBoolean(request.getParameter("status_2")));
		pessoaFisica.setSalario(Double.parseDouble(request.getParameter("salario")));
		pessoaFisica.setEnderecoFuncional(request.getParameter("enderecoFuncional"));	
		pessoaFisica.setTelefoneComercial(request.getParameter("telefoneComercial"));
		pessoaFisica.setTipoFuncionario("Pessoa Física");
		//Recebendo os dados no nome e validando se o campo está preenchido
		String nome = request.getParameter("nome");
		if ((nome == null) || (nome.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setNome(request.getParameter("nome"));	
		}
		pessoaFisica.setCPF_CNPJ(request.getParameter("CPF_CNPJ"));
		pessoaFisica.setEmail(request.getParameter("email"));
		pessoaFisica.setSenha(request.getParameter("senha"));
		pessoaFisica.setCEPFuncional(request.getParameter("CEPFuncional"));
		pessoaFisica.setCidadeFuncional(request.getParameter("cidadeFuncional"));
		pessoaFisica.setUFCidadeFuncional(request.getParameter("UFCidadeFuncional"));
		//Recebendo os dados do cargo e validando se o campo está preenchido
		String cargo = request.getParameter("cargo");
		if ((cargo == null) || (cargo.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setCargo(request.getParameter("cargo"));	
		}
		pessoaFisica.setTotalHoraSemanal(Integer.parseInt(request.getParameter("totalHoraSemanal")));
		pessoaFisica.setRG(request.getParameter("RG"));
		//Recebendo os dados do órgão emissor e validando se o campo está preenchido
		String orgaoEmissor = request.getParameter("orgaoEmissor");
		if ((orgaoEmissor == null) || (orgaoEmissor.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setOrgaoEmissor(request.getParameter("orgaoEmissor"));	
		}
		//validando data de expedição
		String dataExpedicaoTexto = request.getParameter("dataExpedicao");
		Date dataExpedicao;
		try{
			dataExpedicao = new SimpleDateFormat("dd/MM/yyyy").parse(dataExpedicaoTexto);
			pessoaFisica.setDataExpedicao(dataExpedicao);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		pessoaFisica.setCTPS(request.getParameter("CTPS"));
		pessoaFisica.setPIS(request.getParameter("PIS"));
		//Validando data de Nascimento
		String dataNascimentoTexto = request.getParameter("dataNascimento");
		Date dataNascimento;
		try{
			dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoTexto);
			pessoaFisica.setDataNascimento(dataNascimento);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		pessoaFisica.setTelefoneCelular(request.getParameter("telefoneCelular"));
		pessoaFisica.setTelefoneResidencial(request.getParameter("telefoneResidencial"));
		//Recebendo os dados do estado civil e validando se o campo está preenchido
		String estadoCivil = request.getParameter("estadoCivil");
		if ((estadoCivil == null) || (estadoCivil.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setEstadoCivil(request.getParameter("estadoCivil"));
		}
		//Recebendo os dados da nacionalidade e verificando se o campo foi preenchido
		String nacionalidade = request.getParameter("nacionalidade");
		if ((nacionalidade == null) || (nacionalidade.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setNacionalidade(request.getParameter("nacionalidade"));
		}
		//Recebendo os dados da naturalidade e verificando se o campo foi preenchido
		String naturalidade = request.getParameter("naturalidade");
		if ((naturalidade == null) || (naturalidade.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setNaturalidade(request.getParameter("naturalidade"));
		}		
		pessoaFisica.setAltura(Double.parseDouble(request.getParameter("altura")));
		pessoaFisica.setPeso(Double.parseDouble(request.getParameter("peso")));
		//Recebendo os dados da cor do cabelo e verificando se o campo foi preenchido
		String corCabelo = request.getParameter("corCabelo");
		if ((corCabelo == null) || (corCabelo.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setCorCabelo(request.getParameter("corCabelo"));
		}			
		//Recebendo os dados da cor dos olhos e verificando se o campo foi preenchido
		String corOlhos = request.getParameter("corOlhos");
		if ((corOlhos == null) || (corOlhos.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setCorOlhos(request.getParameter("corOlhos"));
		}		
		//Recebendo os dados da cor dos olhos e verificando se o campo foi preenchido
		String racaCor = request.getParameter("racaCor");
		if ((racaCor == null) || (racaCor.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setRacaCor(request.getParameter("racaCor"));
		}		
		
		pessoaFisica.setDeficienteFisico(Boolean.parseBoolean(request.getParameter("deficienteFisico")));
		pessoaFisica.setSinaisParticulares(request.getParameter("sinaisParticulares"));
		pessoaFisica.setNomeMae(request.getParameter("nomeMae"));
		pessoaFisica.setNomePai(request.getParameter("nomePai"));
		pessoaFisica.setNacionalidadeMae(request.getParameter("nacionalidadeMae"));
		pessoaFisica.setNacionalidadePai(request.getParameter("nacionalidadePai"));
		pessoaFisica.setSerieCTPS(request.getParameter("serieCTPS"));
		
		String emissaoCTPSTexto= request.getParameter("emissaoCTPS");
		Date emissaoCTPS;
		try{
			emissaoCTPS = new SimpleDateFormat("dd/MM/yyyy").parse(emissaoCTPSTexto);
			pessoaFisica.setEmissaoCTPS(emissaoCTPS);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		pessoaFisica.setUFCTPS(request.getParameter("UFCTPS"));
		pessoaFisica.setTituloEleitoral(request.getParameter("tituloEleitoral"));
		pessoaFisica.setZonaTitulo(request.getParameter("zonaTitulo"));
		pessoaFisica.setSecaoTitulo(request.getParameter("secaoTitulo"));
		pessoaFisica.setCNH(request.getParameter("CNH"));
		pessoaFisica.setReservista(request.getParameter("reservista"));
		pessoaFisica.setGrauInstrucao(request.getParameter("grauInstrucao"));
		pessoaFisica.setNomeConjuge(request.getParameter("nomeConjuge"));
		pessoaFisica.setNacionalidadeConjuge(request.getParameter("nacionalidadeConjuge"));
		//dependentes
		//Recebendo os dados do horário de trabalho e verificando se o campo foi preenchido
		String horarioTrabalho = request.getParameter("horarioTrabalho");
		if ((horarioTrabalho == null) || (horarioTrabalho.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setHorarioTrabalho(request.getParameter("horarioTrabalho"));
		}
		//Recebendo os dados do endereço residencial e verificando se o campo foi preenchido
		String enderecoResidencial = request.getParameter("enderecoResidencial");
		if ((enderecoResidencial == null) || (enderecoResidencial.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setEnderecoResidencial(request.getParameter("enderecoResidencial"));
		}
		//Recebendo os dados da cidade residencial e verificando se o campo foi preenchido
		String cidadeResidencial = request.getParameter("cidadeResidencial");
		if ((cidadeResidencial == null) || (cidadeResidencial.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setCidadeResidencial(request.getParameter("cidadeResidencial"));
		}		
		
		//Recebendo os dados da cidade residencial e verificando se o campo foi preenchido
		String UFResidencial = request.getParameter("UFResidencial");
		if ((UFResidencial == null) || (UFResidencial.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaFisica.setUFResidencial(request.getParameter("UFResidencial"));
		}	
		
		pessoaFisica.setCEPResidencial(request.getParameter("CEPResidencial"));
		
		GerenteDAO gerente = new GerenteDAO();
		gerente.cadastrarAlterarPessoaFisica(pessoaFisica);
		
		PrintWriter out = response.getWriter();
		out.println("Funcionário: " + pessoaFisica.getNome() + " Cadastrado com sucesso.");
	}

}
