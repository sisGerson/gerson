package servlets.cadastro;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.cadastros.GerenteDAO;
import funcionarios.pf.PessoaFisica;

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

		pessoaFisica.setArea(request.getParameter("area"));
		pessoaFisica.setMatricula(request.getParameter("matricula"));
		
		String dataAdmissaoTexto = request.getParameter("dataAdmissao");
		Date dataAdmissao;
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
		//pessoaFisica.setSalario(Double.parseDouble(request.getParameter("salario")));
		pessoaFisica.setEnderecoFuncional(request.getParameter("enderecoFuncional"));
		pessoaFisica.setTelefoneComercial(request.getParameter("telefoneComercial"));
		pessoaFisica.setTipoFuncionario(request.getParameter("tipoFuncionario"));
		pessoaFisica.setNome(request.getParameter("nome"));
		pessoaFisica.setCPF_CNPJ(request.getParameter("CPF_CNPJ"));
		pessoaFisica.setEmail(request.getParameter("email"));
		pessoaFisica.setSenha(request.getParameter("senha"));
		pessoaFisica.setCEPFuncional(request.getParameter("CEPFuncional"));
		pessoaFisica.setCidadeFuncional(request.getParameter("cidadeFuncional"));
		pessoaFisica.setUFCidadeFuncional(request.getParameter("UFCidadeFuncional"));
		pessoaFisica.setCargo(request.getParameter("cargo"));
		//pessoaFisica.setTotalHoraSemanal(Integer.parseInt(request.getParameter("totalHoraSemanal")));
		pessoaFisica.setRG(request.getParameter("RG"));
		pessoaFisica.setOrgaoEmissor(request.getParameter("orgaoEmissor"));
		
		
		String dataExpedicaoTexto = request.getParameter("dataExpedicao");
		Date dataExpedicao;
		try{
			dataExpedicao = new SimpleDateFormat("dd/MM/yyyy").parse(dataExpedicaoTexto);
			pessoaFisica.setDataNascimento(dataExpedicao);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		pessoaFisica.setCTPS(request.getParameter("CTPS"));
		pessoaFisica.setPIS(request.getParameter("PIS"));
		
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
		pessoaFisica.setEstadoCivil(request.getParameter("estadoCivil"));
		pessoaFisica.setNacionalidade(request.getParameter("nacionalidade"));
		pessoaFisica.setNaturalidade(request.getParameter("naturalidade"));
		pessoaFisica.setAltura(Double.parseDouble(request.getParameter("altura")));
		pessoaFisica.setPeso(Double.parseDouble(request.getParameter("peso")));
		pessoaFisica.setCorCabelo(request.getParameter("corCabelo"));
		pessoaFisica.setCorOlhos(request.getParameter("corOlhos"));
		pessoaFisica.setRacaCor(request.getParameter("racaCor"));
		pessoaFisica.setDeficienteFisico(Boolean.parseBoolean(request.getParameter("deficienteFisico")));
		pessoaFisica.setSinaisParticulares(request.getParameter("sinaisParticulares"));
		pessoaFisica.setNomeMae(request.getParameter("nomeMae"));
		pessoaFisica.setNomePai(request.getParameter("nomePai"));
		pessoaFisica.setNacionalidadeMae(request.getParameter("acionalidadeMae"));
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
		pessoaFisica.setHorarioTrabalho(request.getParameter("horarioTrabalho"));
		pessoaFisica.setEnderecoResidencial(request.getParameter("enderecoResidencial"));
		pessoaFisica.setCidadeResidencial(request.getParameter("cidadeResidencial"));
		pessoaFisica.setUFResidencial(request.getParameter("UFResidencial"));
		pessoaFisica.setCEPResidencial(request.getParameter("CEPResidencial"));
		
		GerenteDAO gerente = new GerenteDAO();
		gerente.cadastrarPessoaFisica(pessoaFisica);
		PrintWriter out = response.getWriter();
		out.println("Funcionário: " + pessoaFisica.getNome() + " Cadastrado com sucesso.");
	}

}
