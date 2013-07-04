package controller.logicas;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pf.PessoaFisica;

import controller.business.BusinessHoraExtra;
import controller.interfaces.Logica;
import dao.PesquisaDAO;

public class VisualizarHoraExtra implements Logica{
	
	public VisualizarHoraExtra() {
	
	}

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ano = request.getParameter("ano");
		String mes = request.getParameter("mes");
		
		PessoaFisica pessoaFisica = (PessoaFisica) request.getSession().getAttribute("funcionario");
		
		PesquisaDAO pesquisa = new PesquisaDAO();
		
		pesquisa.solicitarFolhaPonto(ano, mes, pessoaFisica.getId(), pessoaFisica.getTotalHoraSemanal());
		
		BusinessHoraExtra horaExtra = BusinessHoraExtra.getHoraExtra();
		
		double horasExtras = horaExtra.getHorasExtras(pessoaFisica);
		System.out.println(horasExtras);
		String horaExtraTotal = "00:00";
		
		int totalHoras = (int) horasExtras;
		int totalMinutos = (int) ((horasExtras - (double)totalHoras)*60);
		
		String horas = String.valueOf(totalHoras);
		String minutos = String.valueOf(totalMinutos);
		
		if(totalHoras<10)
			horas = "0"+String.valueOf(totalHoras);
		if(totalMinutos<10)
			minutos = "0"+String.valueOf(totalMinutos);
		
		if(horasExtras>0)
		{
			horaExtraTotal = horas+":"+minutos;
		}
		
		request.getSession().setAttribute("horaExtra", horaExtraTotal);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?item=16&situacao=2");
		dispatcher.forward(request, response);
	}

}
