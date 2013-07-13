package teste.unitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.funcionarios.pj.*;

public class TestPessoaJuridica {
	PessoaJuridica pj1 = new PessoaJuridica();
	
	@Before
	public void testPessoaJuridica() {
		assertNotNull(pj1);
	}
	
	@Test
	public void testSetResponsavel() {
		pj1.setResponsavel("Gerson");
		assertEquals("Gerson", pj1.getResponsavel());
	}

	@Test
	public void testSetTelefoneResponsavel() {
		pj1.setTelefoneResponsavel("3333-4456");
		assertEquals("3333-4456", pj1.getTelefoneResponsavel());
	}

	@Test
	public void testSetDescricaoServico() {
		pj1.setDescricaoServico("Gerencia o sistema de recursos humanos de outra empresa.");
		assertEquals("Gerencia o sistema de recursos humanos de outra empresa.", pj1.getDescricaoServico());
	}

}
