package controller.servlets.atualizacoes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pj.PessoaJuridica;
import dao.cadastros.GerenteDAO;

/**
 * Servlet implementation class ServletAtualizaPessoaJuridica
 */
public class ServletAtualizaPessoaJuridica extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAtualizaPessoaJuridica() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		PessoaJuridica pessoaJuridica = this.entityManager.find(PessoaJuridica.class, id);
		
		pessoaJuridica.setArea(request.getParameter("area"));
		pessoaJuridica.setMatricula(request.getParameter("matricula"));

		String dataAdmissaoTexto = request.getParameter("dataAdmissao");
		Date dataAdmissao;
		try {
			dataAdmissao = new SimpleDateFormat("dd/MM/yyyy").parse(dataAdmissaoTexto);
			pessoaJuridica.setDataAdmissao(dataAdmissao);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		String dataDesligamentoTexto = request.getParameter("dataDesligamento");
		Date dataDesligamento;
		try {
			dataDesligamento = new SimpleDateFormat("dd/MM/yyyy").parse(dataDesligamentoTexto);
			pessoaJuridica.setDataDesligamento(dataDesligamento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		pessoaJuridica.setStatus_2(Boolean.parseBoolean(request.getParameter("status_2")));
		pessoaJuridica.setSalario(Double.parseDouble(request.getParameter("salario")));
		pessoaJuridica.setEnderecoFuncional(request.getParameter("enderecoFuncional"));
		pessoaJuridica.setTelefoneComercial(request.getParameter("telefoneComercial"));
		pessoaJuridica.setTipoFuncionario("Pessoa Jurídica");
		pessoaJuridica.setNome(request.getParameter("nome"));
		pessoaJuridica.setCPF_CNPJ(request.getParameter("CPF_CNPJ"));
		pessoaJuridica.setEmail(request.getParameter("email"));
		pessoaJuridica.setSenha(request.getParameter("senha"));
		pessoaJuridica.setCEPFuncional(request.getParameter("CEPFuncional"));
		pessoaJuridica.setCidadeFuncional(request.getParameter("cidadeFuncional"));
		pessoaJuridica.setUFCidadeFuncional(request.getParameter("UFCidadeFuncional"));
		pessoaJuridica.setResponsavel(request.getParameter("responsavel"));
		pessoaJuridica.setTelefoneResponsavel(request.getParameter("telefoneResponsavel"));
		pessoaJuridica.setDescricaoServico(request.getParameter("descricaoServico"));
		
		GerenteDAO gerente = new GerenteDAO();
		gerente.cadastrarAlterarPessoaJuridica(pessoaJuridica);
		
		request.setAttribute("pessoaJuridica", pessoaJuridica);
		RequestDispatcher dispache = request.getRequestDispatcher("/alteracao_pessoajuridica.jsp");
		dispache.forward(request, response);
	}

}