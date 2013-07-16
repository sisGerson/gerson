package teste.unitarios;

import static org.junit.Assert.*;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import model.funcionarios.pf.*;

public class TestDependentes {
	PessoaFisica p1 = new PessoaFisica();
	
	@Before
	public void testDependentes() {
		assertNotNull(p1);
		p1.criarDependentes();
		assertNotNull(p1.getDependentes());
	}
	@Test
	public void testSetNomeDependente() {
		p1.getDependentes()[0].setNomeDependente("Joaozinho da Silva");
		assertEquals("Joaozinho da Silva", p1.getDependentes()[0].getNomeDependente());
		
	}

	@Test
	public void testSetParentesco() {
		p1.getDependentes()[0].setParentesco("Primo");
		assertEquals("Primo", p1.getDependentes()[0].getParentesco());
	}

	@Test
	public void testSetDataNascimentoDependente() {
		Date d = new Date();
		p1.getDependentes()[0].setDataNascimentoDependente(d);
		assertEquals(d, p1.getDependentes()[0].getDataNascimentoDependente());
	}

	@Test
	public void testSetIRRF() {
		p1.getDependentes()[0].setIRRF(true);
		assertTrue(p1.getDependentes()[0].isIRRF());
	}

	@Test
	public void testSetSalarioFamilia() {
		p1.getDependentes()[0].setSalarioFamilia(true);
		assertTrue(p1.getDependentes()[0].isSalarioFamilia());
	}
	
	@Test
	public void testGetPessoaFisica() {
		assertEquals(p1, p1.getDependentes()[0].getPessoaFisica());
	}

}
