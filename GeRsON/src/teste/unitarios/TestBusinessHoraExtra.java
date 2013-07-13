package teste.unitarios;

import static org.junit.Assert.*;

import java.util.Calendar;

import model.funcionarios.pf.PessoaFisica;
import model.funcionarios.pf.Ponto;

import org.junit.Before;
import org.junit.Test;

import controller.business.BusinessHoraExtra;

public class TestBusinessHoraExtra {
	BusinessHoraExtra business = new BusinessHoraExtra();
	
	@Before
	public void testBusinessHoraExtra() {
		assertNotNull(business);
		
		business.setHoraExtra(business);
		assertNotNull(BusinessHoraExtra.getHoraExtra());
		
		//Verificar a quantidade de horas Trabalhadas sem pontos
		assertEquals("0.0", String.valueOf(business.getTotalHorasTrabalhadas()));
	}

	@Test
	public void testTotalHorasTrabalhadas() {
		Calendar data = Calendar.getInstance();
		Calendar horaEntrada = Calendar.getInstance();
		Calendar horaSaida = Calendar.getInstance();
		
		int dia = 1;
		
		Ponto ponto = new Ponto();
		assertNotNull(ponto);

		//Esse for irá rodar cadastrando 20 pontos de um funcionário de 20 hs semanais
		for(int i=0;i<20;i++) {
			data.set(2013, 0, dia);
			horaEntrada.set(2013, 0, dia, 8, 0, 0);
			horaSaida.set(2013, 0, dia, 12, 30, 0); //Trabalhando 30 minutos a mais todo dia
			
			dia++;
			
			ponto.setData(data.getTime());
			ponto.setHoraEntrada(horaEntrada.getTime());
			ponto.setHoraSaida(horaSaida.getTime());
			
			business.totalHorasTrabalhadas(ponto);
		}
		
		//Verificar a quantidade de horas Trabalhadas no mês
		assertEquals("90.0", String.valueOf(business.getTotalHorasTrabalhadas()));
		
		PessoaFisica p = new PessoaFisica();
		p.setTotalHoraSemanal(20);
		
		//Verificar a quantidade de horas extras no mês
		assertEquals("10.0", String.valueOf(business.getHorasExtras(p)));
	}
	
	@Test
	public void testTotalHorasTrabalhadas1() {
		Calendar data = Calendar.getInstance();
		Calendar horaEntrada = Calendar.getInstance();
		Calendar horaSaida = Calendar.getInstance();
		
		int dia = 1;
		
		Ponto ponto = new Ponto();
		assertNotNull(ponto);

		//Esse for irá rodar cadastrando 20 pontos de um funcionário de 30 hs semanais
		for(int i=0;i<20;i++) {
			data.set(2013, 0, dia);
			horaEntrada.set(2013, 0, dia, 8, 0, 0);
			horaSaida.set(2013, 0, dia, 15, 0, 0); //Trabalhando 1h a mais todo dia
			
			dia++;
			
			ponto.setData(data.getTime());
			ponto.setHoraEntrada(horaEntrada.getTime());
			ponto.setHoraSaida(horaSaida.getTime());
			
			business.totalHorasTrabalhadas(ponto);
		}
		
		//Verificar a quantidade de horas Trabalhadas no mês
		assertEquals("140.0", String.valueOf(business.getTotalHorasTrabalhadas()));
		
		PessoaFisica p = new PessoaFisica();
		p.setTotalHoraSemanal(30);
		
		//Verificar a quantidade de horas extras no mês
		assertEquals("20.0", String.valueOf(business.getHorasExtras(p)));
	}
	
	@Test
	public void testTotalHorasTrabalhadas2() {
		Calendar data = Calendar.getInstance();
		Calendar horaEntrada = Calendar.getInstance();
		Calendar horaInicioAlmoco = Calendar.getInstance();
		Calendar horaFimAlmoco = Calendar.getInstance();
		Calendar horaSaida = Calendar.getInstance();
		
		int dia = 1;
		
		Ponto ponto = new Ponto();
		assertNotNull(ponto);

		//Esse for irá rodar cadastrando 20 pontos de um funcionário de 40 hs semanais
		for(int i=0;i<20;i++) {
			data.set(2013, 0, dia);
			horaEntrada.set(2013, 0, dia, 8, 0, 0);
			horaInicioAlmoco.set(2013, 0, dia, 12, 0, 0);
			horaFimAlmoco.set(2013, 0, dia, 14, 0, 0);
			horaSaida.set(2013, 0, dia, 18, 0, 0);
			
			dia++;
			
			ponto.setData(data.getTime());
			ponto.setHoraEntrada(horaEntrada.getTime());
			ponto.setHoraInicioAlmoco(horaInicioAlmoco.getTime());
			ponto.setHoraFimAlmoco(horaFimAlmoco.getTime());
			ponto.setHoraSaida(horaSaida.getTime());
			
			business.totalHorasTrabalhadas(ponto);
		}
		//Verificar a quantidade de horas Trabalhadas no mês
		assertEquals("160.0", String.valueOf(business.getTotalHorasTrabalhadas()));
		
		PessoaFisica p = new PessoaFisica();
		p.setTotalHoraSemanal(40);
		
		//Verificar a quantidade de horas extras no mês
		assertEquals("0.0", String.valueOf(business.getHorasExtras(p)));
	}
}
