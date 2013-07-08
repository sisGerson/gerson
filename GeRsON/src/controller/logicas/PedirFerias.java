package controller.logicas;

import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pf.Ferias;
import model.funcionarios.pf.PessoaFisica;
import controller.business.BusinessFerias;
import controller.interfaces.Logica;
import dao.CadastroDAO;
import dao.PesquisaDAO;

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
		Calendar dataFim = Calendar.getInstance();
		
		data.set(ano, (mes-1), 1);
		
		if(mes-1==12){
			dataFim.set(ano+1, 1, 1);
		}
		else{
			dataFim.set(ano, mes, 1);
		}
		
		Ferias ferias = new Ferias();
		
		ferias.setResultado("Aguarde");
		ferias.setDataPedido(data.getTime());
		ferias.setDataRetorno(dataFim.getTime());
		ferias.setIdFuncionario(pessoaFisica.getId());
		
		BusinessFerias business = new BusinessFerias();
		business.pedidoFeriasPermitido(pessoaFisica, data.getTime());
		
		ferias.setPeriodoTrabalhado(business.getPeriodoTrabalhado());
		
		//Verificar se este funcionário já tem pedido de férias com status Aguarde
		boolean existe = false;
		
		PesquisaDAO pesquisa = new PesquisaDAO();
		
		List<Ferias> pedidos = pesquisa.buscarTodosPedidosFerias();
		int id=0;
		
		//For que passa por todos os pedidos verificando se já existe um pedido em aberto
		for (Ferias pedidoFerias : pedidos) {
			if(pedidoFerias.getIdFuncionario() == pessoaFisica.getId() && pedidoFerias.getResultado().equals("Aguarde")) {
				existe = true;
				id = pedidoFerias.getIdFerias();
				break;
			}
		}
		
		if(business.isPedidoFerias() == true && existe == false) {
			CadastroDAO cadastro = new CadastroDAO();
			cadastro.cadastrarFerias(ferias);
		}
		else if(business.isPedidoFerias() == true && existe == true){
			Ferias feriasExistentes = pesquisa.getIdFerias(id);
			
			feriasExistentes.setDataPedido(ferias.getDataPedido());
			feriasExistentes.setPeriodoTrabalhado(ferias.getPeriodoTrabalhado());
			
			pesquisa.alterarFerias(feriasExistentes);
		}
		
		request.getSession().setAttribute("permitirFerias", business);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?item=22&situacao=2");
		dispatcher.forward(request, response);
	}

}
