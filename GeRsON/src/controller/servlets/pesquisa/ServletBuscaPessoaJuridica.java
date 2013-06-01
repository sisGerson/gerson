package controller.servlets.pesquisa;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		PrintWriter out = response.getWriter();
		
		out.println("<table>");
		out.println("<td>Matricula</td>");
		out.println("<td>Nome</td>");
		out.println("<td>Responsável</td>");
		
		for(int i=0;i<dao.getPessoasJuridicas().length;i++){
			out.println("<tr>");
			out.println("<td>"+dao.getPessoasJuridicas()[i].getMatricula()+"</td>");
			out.println("<td>"+dao.getPessoasJuridicas()[i].getNome()+"</td>");
			out.println("<td>"+dao.getPessoasJuridicas()[i].getResponsavel()+"</td>");
			out.println("<td><a href='atualiza_pessoajuridica.jsp?id="+dao.getPessoasJuridicas()[i].getId()+"'>Editar</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}

}