package controller.logicas;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pf.Ferias;
import model.funcionarios.pf.PessoaFisica;

import controller.interfaces.Logica;
import dao.PesquisaDAO;

public class ResultadoFerias implements Logica{

	public ResultadoFerias() {

	}

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String resultado = request.getParameter("resultado");
		int idFerias = Integer.parseInt(request.getParameter("idFerias"));
		
		PesquisaDAO pesquisa = new PesquisaDAO();
		
		Ferias ferias = pesquisa.getIdFerias(idFerias);
		
		PessoaFisica pessoaFisica = pesquisa.getIdPessoaFisica(ferias.getIdFuncionario());

		if(resultado.equals("Sim")){
			ferias.setResultado("Aprovado");
			pessoaFisica.setUltimasFerias(ferias.getDataPedido());
		}
		else {
			ferias.setResultado("Rejeitado");
		}
		
		pesquisa.alterarFerias(ferias);
		pesquisa.alterarPessoaFisica(pessoaFisica);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?item=24&situacao=2");
		dispatcher.forward(request, response); 
	}

}
