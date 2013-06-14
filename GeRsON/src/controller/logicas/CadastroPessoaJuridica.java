package controller.logicas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pj.PessoaJuridica;
import controller.interfaces.Logica;
import dao.CadastroDAO;


public class CadastroPessoaJuridica implements Logica {

	public CadastroPessoaJuridica() {
		
	}

	public void executa(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		
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
		
		CadastroDAO cadastro = new CadastroDAO();
		cadastro.cadastrarPessoaJuridica(pessoaJuridica);
		
		request.setAttribute("pessoaJuridica", pessoaJuridica);
		RequestDispatcher dispache = request.getRequestDispatcher("/index.jsp?item=9");
		dispache.forward(request, response);
	}

}