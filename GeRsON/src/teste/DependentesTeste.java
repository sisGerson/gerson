package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.funcionarios.pf.dependentes.*;

import model.funcionarios.pf.*;

public class DependentesTeste {

	@Test
	public void testDependentes() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNomeDependente() {
		PessoaFisica p1 = new PessoaFisica();
		Dependentes dp = new Dependentes(p1);
		dp.setNomeDependente("Joaozinho da Silva");
		assertEquals("Joaozinho da Silva", dp.getNomeDependente());
		
	}

	@Test
	public void testSetParentesco() {
		PessoaFisica p1 = new PessoaFisica();
		Dependentes dp = new Dependentes(p1);
		dp.setParentesco(p1.getNome());
		assertEquals(p1.getNome(), dp.getParentesco());
	}

	@Test
	public void testSetDataNascimentoDependente() {
		PessoaFisica p1 = new PessoaFisica();
		Dependentes dp = new Dependentes(p1);
		dp.setDataNascimentoDependente("12 de março de 2012");
		assertEquals("12 de março de 2012", dp.getDataNascimentoDependente());
	}

	@Test
	public void testSetIRRF() {
		PessoaFisica p1 = new PessoaFisica();
		Dependentes dp = new Dependentes(p1);
		dp.setIRRF(true);
		assertEquals(true, dp.isIRRF());
	}

	@Test
	public void testSetSalarioFamilia() {
		PessoaFisica p1 = new PessoaFisica();
		Dependentes dp = new Dependentes(p1);
		dp.setSalarioFamilia(false);
		assertEquals(false, dp.isSalarioFamilia());
	}

}
