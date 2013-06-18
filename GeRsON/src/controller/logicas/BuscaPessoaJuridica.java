package controller.logicas;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.business.BusinessController;
import controller.interfaces.Logica;
import dao.PesquisaDAO;

public class BuscaPessoaJuridica implements Logica {
       
    public BuscaPessoaJuridica() {
        
    }

	public void executa(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		String empresa, matricula, area, CNPJ, responsavel;
		
		empresa = request.getParameter("empresa").toUpperCase();
		matricula = request.getParameter("matricula").toUpperCase();
		area = request.getParameter("area").toUpperCase();
		CNPJ = request.getParameter("cnpj").toUpperCase();
		responsavel = request.getParameter("responsavel").toUpperCase();
		
		PesquisaDAO pesquisa = new PesquisaDAO();
		pesquisa.pesquisarPessoaJuridica(empresa, matricula, area, CNPJ, responsavel);
		
		BusinessController business = new BusinessController();
		business.setPessoasJuridicas(pesquisa);
		
		//Passando o objeto dao como parâmetro para a jsp
		request.getSession().setAttribute("pesquisa", business);
		
		RequestDispatcher dispache = request.getRequestDispatcher("/resultado_busca_pessoajuridica.jsp");
		dispache.forward(request, response);
	}

}