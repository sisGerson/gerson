package controller.logicas;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pf.PessoaFisica;

import controller.business.BusinessController;
import controller.interfaces.Logica;
import dao.LoginDAO;

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
			this.dispache = request.getRequestDispatcher("/index.jsp?situacao=0");//Retorna para a p�gina principal como mensagem de erro: senha incorreta
			this.dispache.forward(request, response);
			break;
		case -2:
			this.dispache = request.getRequestDispatcher("/index.jsp?situacao=1");//Retorna para a p�gina principal como mensagem de erro: usu�rio incorreto
			this.dispache.forward(request, response);
			break;
		case 0:
			LoginDAO login = new LoginDAO();
			PessoaFisica pessoaFisica = login.pesquisaFuncionario(matricula, senha);
			request.getSession().setAttribute("pessoaFisica", pessoaFisica);
			
			if (business.getCargo().toLowerCase().equals("gerente")){
				this.dispache = request.getRequestDispatcher("/index.jsp?situacao=2");//Retorna para a p�gina principal com menu ativo para gerente
				this.dispache.forward(request, response);
			}
			else {
				this.dispache = request.getRequestDispatcher("/index.jsp?situacao=3");//Retorna para a p�gina principal com menu ativo para funcionario
				this.dispache.forward(request, response);
			} 
			break;
		}
	}

}
