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
 * Servlet implementation class ServletBuscaPessoaJuridica
 */
public class ServletBuscaPessoaJuridica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBuscaPessoaJuridica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empresa, matricula, area, CNPJ, responsavel;
		Date dataAdmissao;
		
		empresa = request.getParameter("empresa");
		matricula = request.getParameter("matricula");
		responsavel = request.getParameter("responsavel");
		area = request.getParameter("area");
		CNPJ = request.getParameter("cnpj");
		String dataAdmissaoTexto = request.getParameter("dataAdmissao");
		try {
			dataAdmissao = new SimpleDateFormat("dd/MM/yyyy").parse(dataAdmissaoTexto);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}

}
