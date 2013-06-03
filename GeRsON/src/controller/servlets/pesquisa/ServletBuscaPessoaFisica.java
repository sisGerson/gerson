package controller.servlets.pesquisa;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		PrintWriter out = response.getWriter();
		//montando o cabe�alho
		out.println("<html><head><meta http-equiv='content-type' content='text/html; charset=iso-8859-1'>" +
				"<meta http-equiv='content-language' content='pt-br' />" +
				"<meta name='description' content='GeRsON - Gerência de Recursos On-line' /> " +
				"<meta name='keywords' content='cadastro de cliente, controle de almoxarifado' /> " +
				"<link rel='stylesheet' type='text/css' href='css/screen.css'>" +
				"<title>GeRsON</title>" +
				"</head>" +
				"<body>" +
				"<div id='layout'>" +
				"<div id='header'>" +
				"<h1 id='logo'><a href='#' title='#'>GeRs<span>ON</span></a></h1>" +
				" <hr class='noscreen' />  " +
				"<div id='navigation'>" +
				"</div></div>" +
				"<div id='main'>"); 
		out.println("<h3>Resultado da Pesquisa - Funcionário: Pessoa Física </h3>");
		out.println("<table>");
		out.println("<td>Matricula</td>");
		out.println("<td>Nome</td>");
		out.println("<td>Cargo</td>");
		
		for (int i=0;i<dao.getPessoasFisicas().length;i++) {
			out.println("<tr>");
			out.println("<td>"+dao.getPessoasFisicas()[i].getMatricula()+"</td>");
			out.println("<td>"+dao.getPessoasFisicas()[i].getNome()+"</td>");
			out.println("<td>"+dao.getPessoasFisicas()[i].getCargo()+"</td>");
			out.println("<td><a href='atualiza_pessoafisica.jsp?id="+dao.getPessoasFisicas()[i].getId()+"'>Editar</a></td>");
			out.println("</tr>");
		}
		out.println("</table>" +
				"<p>&nbsp;</p><input type='button' value='Fechar Janela' onclick='window.close() ' />" +
				"</div></body></html>");
	}

}