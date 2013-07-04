package controller.logicas;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pf.PessoaFisica;

import controller.business.BusinessController;
import controller.interfaces.Logica;
import dao.PesquisaDAO;

public class SolicitarContraCheque implements Logica{

	public SolicitarContraCheque() {
	}

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ano = request.getParameter("ano");
		String mes = request.getParameter("mes");
		
		PessoaFisica pessoaFisica = (PessoaFisica) request.getSession().getAttribute("funcionario");
		
		PesquisaDAO pesquisa = new PesquisaDAO();
		
		pesquisa.solicitarFolhaPonto(ano, mes, pessoaFisica.getId(), pessoaFisica.getTotalHoraSemanal());
		
		BusinessController business = new BusinessController();
		
		business.setPontos(pesquisa);
		
		request.getSession().setAttribute("pesquisa", business);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?item=18&situacao=2");
		dispatcher.forward(request, response);
	}
	
}