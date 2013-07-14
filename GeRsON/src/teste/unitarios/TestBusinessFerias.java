package teste.unitarios;

import static org.junit.Assert.*;

import java.util.Calendar;

import model.funcionarios.pf.Ferias;
import model.funcionarios.pf.PessoaFisica;

import org.junit.Before;
import org.junit.Test;

import controller.business.BusinessFerias;

public class TestBusinessFerias {
	Ferias f1 = new Ferias();
	Ferias f2 = new Ferias();
	
	PessoaFisica p1 = new PessoaFisica();
	PessoaFisica p2 = new PessoaFisica();
	
	@Before
	public void testBusinessFerias() {
		assertNotNull(p1);
		assertNotNull(p2);
		
		Calendar dataAdmissao = Calendar.getInstance();
		
		dataAdmissao.set(2010, 0, 1);
		p1.setDataAdmissao(dataAdmissao.getTime());

		dataAdmissao.set(2011, 0, 1);
		p2.setDataAdmissao(dataAdmissao.getTime());
	}

	@Test
	public void testPedidoFeriasPermitido() {
		Calendar data = Calendar.getInstance();
		data.set(2013, 9, 1);
		
		Calendar dataFim = Calendar.getInstance();
		data.set(2013, 10, 1);
		
		double periodoTrabalhado;
		
		//Pedido de férias para p1
		BusinessFerias business1 = new BusinessFerias();
		business1.pedidoFeriasPermitido(p1, data.getTime());
		
		assertTrue(business1.isPedidoFerias());
		periodoTrabalhado = (data.getTime().getTime() - p1.getDataAdmissao().getTime())/3600000;
		periodoTrabalhado/=8640;
		
		assertEquals(String.valueOf(periodoTrabalhado), String.valueOf(business1.getPeriodoTrabalhado()));
		
		f1.setResultado("Aguarde");
		f1.setDataPedido(data.getTime());
		f1.setDataRetorno(dataFim.getTime());
		f1.setPeriodoTrabalhado(periodoTrabalhado);
		
		//Pedido de férias para p2
		BusinessFerias business2 = new BusinessFerias();
		business2.pedidoFeriasPermitido(p2, data.getTime());
		
		assertTrue(business2.isPedidoFerias());
		periodoTrabalhado = (data.getTime().getTime() - p2.getDataAdmissao().getTime())/3600000;
		periodoTrabalhado/=8640;
		
		assertEquals(String.valueOf(periodoTrabalhado), String.valueOf(business2.getPeriodoTrabalhado()));
		
		f2.setResultado("Aguarde");
		f2.setDataPedido(data.getTime());
		f2.setDataRetorno(dataFim.getTime());
		f2.setPeriodoTrabalhado(periodoTrabalhado);
	}

	@Test
	public void testPedidoFeriasPermitido2() {
		Calendar data = Calendar.getInstance();
		data.set(2013, 0, 1);
		
		BusinessFerias business1 = new BusinessFerias();
		business1.pedidoFeriasPermitido(p1, data.getTime());
		
		assertFalse(business1.isPedidoFerias());

		assertEquals("0.0", String.valueOf(business1.getPeriodoTrabalhado()));
		
		Calendar ultimasFerias = Calendar.getInstance();
		ultimasFerias.set(2012, 0, 1);
		
		p2.setUltimasFerias(ultimasFerias.getTime());
		data.set(2013, 9, 1);
		
		BusinessFerias business2 = new BusinessFerias();
		business2.pedidoFeriasPermitido(p2, data.getTime());
		
		assertTrue(business2.isPedidoFerias());
	}
}
