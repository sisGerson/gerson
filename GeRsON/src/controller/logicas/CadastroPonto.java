package controller.logicas;

import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pf.Ponto;

import controller.interfaces.Logica;

public class CadastroPonto implements Logica{

	public CadastroPonto() {
		
	}

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GregorianCalendar calendario = new GregorianCalendar();
		
		Ponto ponto = new Ponto();
		ponto.setData(calendario.getTime());
		ponto.setHora(calendario.getTime());
		
		ponto.setOpcao(request.getParameter("opcao"));
	}
	
	

}
