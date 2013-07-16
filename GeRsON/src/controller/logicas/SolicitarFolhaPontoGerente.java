package controller.logicas;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pf.PessoaFisica;

import controller.business.BusinessController;
import controller.interfaces.Logica;
import dao.PesquisaDAO;

public class SolicitarFolhaPontoGerente implements Logica{

	public SolicitarFolhaPontoGerente() {
	}

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ano = request.getParameter("ano");
		String mes = request.getParameter("mes");
		int id = Integer.parseInt(request.getParameter("id"));
		
		BusinessController business = new BusinessController();
		
		PessoaFisica pessoaFisica = business.idPessoaFisica(id);
		
		PesquisaDAO pesquisa = new PesquisaDAO();
		
		pesquisa.solicitarFolhaPonto(ano, mes, pessoaFisica.getId(), pessoaFisica.getTotalHoraSemanal());
		
		business.setPontos(pesquisa);
		
		request.getSession().setAttribute("pesquisa", business);
		request.setAttribute("id", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/resultado_pontos_gerente.jsp");
		dispatcher.forward(request, response);
		
	}

}
