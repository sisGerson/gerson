package controller.logicas;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.interfaces.Logica;
import dao.PesquisaDAO;

public class BuscaPessoaFisica implements Logica {

	public BuscaPessoaFisica() {
        
    }

	public void executa(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		String nome, matricula, cargo, area, CPF;
		
		nome = request.getParameter("nome").toUpperCase();
		matricula = request.getParameter("matricula").toUpperCase();
		cargo = request.getParameter("cargo").toUpperCase();
		area = request.getParameter("area").toUpperCase();
		CPF = request.getParameter("cpf").toUpperCase();
		
		PesquisaDAO dao = new PesquisaDAO();
		dao.pesquisarPessoaFisica(nome, matricula, cargo, area, CPF);
		
		//Passando o objeto dao como parâmetro para a jsp
		request.getSession().setAttribute("pesquisa", dao);
		
		RequestDispatcher dispache = request.getRequestDispatcher("/resultado_busca_pessoafisica.jsp");
		dispache.forward(request, response);
	}

}