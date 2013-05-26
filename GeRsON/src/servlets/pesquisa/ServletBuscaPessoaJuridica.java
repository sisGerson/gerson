package servlets.pesquisa;

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
		
		empresa = request.getParameter("empresa");
		matricula = request.getParameter("matricula");
		area = request.getParameter("area");
		CNPJ = request.getParameter("cnpj");
		responsavel = request.getParameter("responsavel");
		
		GerenteDAO dao = new GerenteDAO();
		dao.pesquisarPessoaJuridica(empresa, matricula, area, CNPJ, responsavel);
	}

}
