package controller.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pf.PessoaFisica;

import controller.interfaces.Logica;
import dao.PesquisaDAO;

public class SolicitarFolhaPonto implements Logica{

	public SolicitarFolhaPonto() {
	}

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ano = request.getParameter("ano");
		String mes = request.getParameter("mes");
		
		PessoaFisica pessoaFisica = (PessoaFisica) request.getSession().getAttribute("funcionario");
		
		PesquisaDAO pesquisa = new PesquisaDAO();
		
		pesquisa.solicitarFolhaPonto(ano, mes, pessoaFisica.getId());
		
	}
	
}