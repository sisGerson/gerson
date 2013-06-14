package controller.logicas;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		PesquisaDAO dao = new PesquisaDAO();
		dao.pesquisarPessoaJuridica(empresa, matricula, area, CNPJ, responsavel);
		
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
		out.println("<h3>Resultado da Pesquisa - Funcionário: Pessoa Jurídica </h3>");
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
		out.println("</table>" +
				"<p>&nbsp;</p><input type='button' value='Fechar Janela' onclick='window.close() ' />" +
				"</div></body></html>");
	}

}