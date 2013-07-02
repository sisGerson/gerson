package controller.logicas;

import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pf.PessoaFisica;
import model.funcionarios.pf.Ponto;

import controller.interfaces.Logica;
import dao.CadastroDAO;

public class CadastroPonto implements Logica{
	
	public CadastroPonto() {
		
	}

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GregorianCalendar calendario = new GregorianCalendar();
		
		//Pegando a sessão
		PessoaFisica pessoaFisica = (PessoaFisica)request.getSession().getAttribute("funcionario");
		
		Ponto ponto = new Ponto();
		ponto.setData(calendario.getTime());
		ponto.setHora(calendario.getTime());
		
		ponto.setOpcao(request.getParameter("opcao"));
		
		//Passando o id do funcionario logado
		ponto.setIdFuncionario(pessoaFisica.getId());
		
		CadastroDAO cadastro = new CadastroDAO();
		cadastro.cadastrarPonto(ponto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?situacao=2");
		dispatcher.forward(request, response);
	}
}
