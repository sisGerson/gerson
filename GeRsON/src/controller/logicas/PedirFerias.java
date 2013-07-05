package controller.logicas;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pf.Ferias;
import model.funcionarios.pf.PessoaFisica;
import controller.business.BusinessFerias;
import controller.interfaces.Logica;
import dao.CadastroDAO;

public class PedirFerias implements Logica{

	public PedirFerias() {
	}

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int ano = Integer.parseInt(request.getParameter("ano"));
		int mes = Integer.parseInt(request.getParameter("mes"));
		
		PessoaFisica pessoaFisica = (PessoaFisica)request.getSession().getAttribute("funcionario");
		
		Calendar data = Calendar.getInstance();
		data.set(ano, (mes-1), 1);
		
		Ferias ferias = new Ferias();
		
		ferias.setResultado("Aguarde");
		ferias.setDataPedido(data.getTime());
		ferias.setIdFuncionario(pessoaFisica.getId());
		
		BusinessFerias business = new BusinessFerias();
		boolean permitirFerias = business.pedidoFeriasPermitido(pessoaFisica, data.getTime());
		
		if(permitirFerias == true) {
			CadastroDAO cadastro = new CadastroDAO();
			cadastro.cadastrarFerias(ferias);
		}
		
		request.getSession().setAttribute("permitirFerias", permitirFerias);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?item=22&situacao=2");
		dispatcher.forward(request, response);
	}

}
