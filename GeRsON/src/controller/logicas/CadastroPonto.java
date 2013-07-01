package controller.logicas;

import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		Ponto ponto = new Ponto();
		ponto.setData(calendario.getTime());
		ponto.setHora(calendario.getTime());
		
		ponto.setOpcao(request.getParameter("opcao"));
		
		CadastroDAO cadastro = new CadastroDAO();
		cadastro.cadastrarPonto(ponto);
	}
	
	

}
