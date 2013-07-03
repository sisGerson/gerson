package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.funcionarios.pj.*;

public class PessoaJuridicaTest {

	@Test
	public void testPessoaJuridica() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetResponsavel() {
		PessoaJuridica pj1 = new PessoaJuridica();
		pj1.setResponsavel("Gerson");
		assertEquals("Gerson", pj1.getResponsavel());
	}

	@Test
	public void testSetTelefoneResponsavel() {
		PessoaJuridica pj1 = new PessoaJuridica();
		pj1.setTelefoneResponsavel("3333-4456");
		assertEquals("3333-4456", pj1.getTelefoneResponsavel());
	}

	@Test
	public void testSetDescricaoServico() {
		PessoaJuridica pj1 = new PessoaJuridica();
		pj1.setDescricaoServico("Gerencia o sistema de recursos humanos de outra empresa.");
		assertEquals("Gerencia o sistema de recursos humanos de outra empresa.", pj1.getDescricaoServico());
	}

}
