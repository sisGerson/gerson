package controller.servlets.pesquisa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cadastros.GerenteDAO;

/**
 * Servlet implementation class ServletBuscaPessoaJuridica
 */
public class ServletBuscaPessoaJuridica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBuscaPessoaJuridica() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empresa, matricula, area, CNPJ, responsavel;
		
		empresa = request.getParameter("empresa").toUpperCase();
		matricula = request.getParameter("matricula").toUpperCase();
		area = request.getParameter("area").toUpperCase();
		CNPJ = request.getParameter("cnpj").toUpperCase();
		responsavel = request.getParameter("responsavel").toUpperCase();
		
		GerenteDAO dao = new GerenteDAO();
		dao.pesquisarPessoaJuridica(empresa, matricula, area, CNPJ, responsavel);
	}

}
