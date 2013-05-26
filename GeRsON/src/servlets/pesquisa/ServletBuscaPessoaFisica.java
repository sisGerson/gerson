package servlets.pesquisa;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome, matricula, cargo, area, CPF;
		Date dataAdmissao;
		
		nome = request.getParameter("nome");
		matricula = request.getParameter("matricula");
		cargo = request.getParameter("cargo");
		area = request.getParameter("area");
		CPF = request.getParameter("cpf");
		String dataAdmissaoTexto = request.getParameter("dataAdmissao");
		try {
			dataAdmissao = new SimpleDateFormat("dd/MM/yyyy").parse(dataAdmissaoTexto);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
	}

}
