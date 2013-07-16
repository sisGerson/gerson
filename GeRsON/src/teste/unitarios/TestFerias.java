package teste.unitarios;

import static org.junit.Assert.*;

import java.util.Date;

import model.funcionarios.pf.Ferias;

import org.junit.Test;

public class TestFerias {
	Ferias f = new Ferias();
	Date d = new Date();
	
	@Test
	public void testFerias() {
		assertNotNull(f);
	}

	@Test
	public void testSetDataPedido() {
		f.setDataPedido(d);
		assertEquals(d, f.getDataPedido());
	}

	@Test
	public void testSetResultado() {
		f.setResultado("Aguarde");
		assertEquals("Aguarde", f.getResultado());
	}

	@Test
	public void testGetIdFerias() {
		assertEquals(0, f.getIdFerias());
	}

	@Test
	public void testSetIdFuncionario() {
		f.setIdFuncionario(1);
		assertEquals(1, f.getIdFuncionario());
	}

	@Test
	public void testSetPeriodoTrabalhado() {
		f.setPeriodoTrabalhado(3.5);
		assertEquals(3,5, f.getPeriodoTrabalhado());
	}

	@Test
	public void testSetDataRetorno() {
		f.setDataRetorno(d);
		assertEquals(d, f.getDataRetorno());
	}

}
