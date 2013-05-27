package controller.servlets.pesquisa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cadastros.GerenteDAO;

/**
 * Servlet implementation class ServletBuscaPessoaFisica
 */
public class ServletBuscaPessoaFisica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBuscaPessoaFisica() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String nome, matricula, cargo, area, CPF;
		
		nome = request.getParameter("nome").toUpperCase();
		matricula = request.getParameter("matricula").toUpperCase();
		cargo = request.getParameter("cargo").toUpperCase();
		area = request.getParameter("area").toUpperCase();
		CPF = request.getParameter("cpf").toUpperCase();
		
		GerenteDAO dao = new GerenteDAO();
		dao.pesquisarPessoaFisica(nome, matricula, cargo, area, CPF);
	}

}
