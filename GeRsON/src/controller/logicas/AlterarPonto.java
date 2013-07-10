package controller.logicas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pf.Ponto;

import controller.interfaces.Logica;
import dao.PesquisaDAO;

public class AlterarPonto implements Logica{

	public AlterarPonto() {

	}

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int id = Integer.parseInt(request.getParameter("idPonto"));
		PesquisaDAO pesquisa = new PesquisaDAO();
		
		Ponto ponto = pesquisa.getIdPonto(id);
		
		Date data, horaEntrada, horaInicioAlmoco, horaFimAlmoco, horaSaida;
		
		String dataTexto = request.getParameter("data");
		try {
			data = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
			ponto.setData(data);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		String horaEntradaTexto = request.getParameter("horaEntrada");
		try {
			horaEntrada = new SimpleDateFormat("HH:mm:ss").parse(horaEntradaTexto);
			ponto.setHoraEntrada(horaEntrada);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		String horaInicioAlmocoTexto = request.getParameter("horaInicioAlmoco");
		
		if(horaInicioAlmocoTexto != null) {
			try {
				horaInicioAlmoco = new SimpleDateFormat("HH:mm:ss").parse(horaInicioAlmocoTexto);
				ponto.setHoraInicioAlmoco(horaInicioAlmoco);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		
		String horaFimAlmocoTexto = request.getParameter("horaFimAlmoco");
		
		if(horaFimAlmocoTexto != null) {
			try {
				horaFimAlmoco = new SimpleDateFormat("HH:mm:ss").parse(horaFimAlmocoTexto);
				ponto.setHoraFimAlmoco(horaFimAlmoco);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		
		String horaSaidaTexto = request.getParameter("horaSaida");
		try {
			horaSaida = new SimpleDateFormat("HH:mm:ss").parse(horaSaidaTexto);
			ponto.setHoraSaida(horaSaida);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		pesquisa.alterarPonto(ponto);
	}

}
