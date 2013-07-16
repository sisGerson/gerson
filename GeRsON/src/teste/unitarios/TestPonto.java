package teste.unitarios;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import model.funcionarios.pf.Ponto;

import org.junit.Before;
import org.junit.Test;

public class TestPonto {
	Ponto ponto = new Ponto();
	GregorianCalendar data = new GregorianCalendar();

	@Before
	public void testPonto() {
		assertNotNull(ponto);
	}

	@Test
	public void testSetData() {
		ponto.setData(data.getTime());
		assertEquals(data.getTime(), ponto.getData());
	}

	@Test
	public void testSetHoraEntrada() {
		ponto.setHoraEntrada(data.getTime());
		assertEquals(data.getTime(), ponto.getHoraEntrada());
	}

	@Test
	public void testSetHoraSaida() {
		ponto.setHoraSaida(data.getTime());
		assertEquals(data.getTime(), ponto.getHoraSaida());
	}

	@Test
	public void testSetHoraInicioAlmoco() {
		ponto.setHoraInicioAlmoco(data.getTime());
		assertEquals(data.getTime(), ponto.getHoraInicioAlmoco());
	}

	@Test
	public void testSetHoraFimAlmoco() {
		ponto.setHoraFimAlmoco(data.getTime());
		assertEquals(data.getTime(), ponto.getHoraFimAlmoco());
	}

	@Test
	public void testSetOpcao() {
		ponto.setOpcao("Entrada");
		assertEquals("Entrada", ponto.getOpcao());
	}

	@Test
	public void testGetIdPonto() {
		assertEquals(0, ponto.getIdPonto());
	}

	@Test
	public void testSetIdFuncionario() {
		ponto.setIdFuncionario(1);
		assertEquals(1, ponto.getIdFuncionario());
	}

}
