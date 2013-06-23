package controller.logicas;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.business.BusinessController;
import controller.interfaces.Logica;

public class Login implements Logica {

	private RequestDispatcher dispache;
	public Login() {

	}

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String matricula = request.getParameter("matricula");
		String senha = request.getParameter("senha");
		
		BusinessController business = new BusinessController();
		
		switch (business.verificarLogin(matricula, senha)) {
		case -1:
			request.setAttribute("Mensagem", "senha incorreta");
			this.dispache = request.getRequestDispatcher("/index.jsp?item=5");//colocar página de login Keli e Carlos
			this.dispache.forward(request, response);
			break;
		case -2:
			request.setAttribute("Mensagem", "usuário incorreto");
			this.dispache = request.getRequestDispatcher("/index.jsp?item=5");//colocar página de login Keli e Carlos
			this.dispache.forward(request, response);
			break;
		case 0:
			if (business.getCargo().toLowerCase().equals("gerente")){
				this.dispache = request.getRequestDispatcher("/index.jsp?item=5");//colocar página de login Keli e Carlos
				this.dispache.forward(request, response);
			}
			else {
				this.dispache = request.getRequestDispatcher("/index.jsp?item=5");//colocar página de login Keli e Carlos
				this.dispache.forward(request, response);
			} 
			break;
		}
	}

}
