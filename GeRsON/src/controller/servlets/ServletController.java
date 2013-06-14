package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.interfaces.Logica;

public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String parametro = request.getParameter("logica");
		String nomeClasse = "controller.logicas." + parametro;
		
		try{
			Class<?> classe = Class.forName(nomeClasse);
			
			Logica logica = (Logica) classe.newInstance();
			logica.executa(request, response);
			
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

}
