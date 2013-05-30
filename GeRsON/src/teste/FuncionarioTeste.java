package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.funcionarios.*;

import java.util.Date;

public class FuncionarioTeste {

	@Test
	public void testFuncionario() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetArea() {
		Funcionario f1 = new Funcionario();
		f1.setArea("protocolo");
		assertEquals("protocolo",f1.getArea());
	}

	@Test
	public void testSetMatricula() {
		Funcionario f1 = new Funcionario();
		f1.setMatricula("06_80818");
		assertEquals("06_80818",f1.getMatricula());
	}

	@Test
	public void testSetDataAdmissao() {
		Funcionario f1 = new Funcionario();
		Date d = new Date();
		f1.setDataAdmissao(d);
		assertEquals(d,f1.getDataAdmissao());
	}

	@Test
	public void testSetDataDesligamento() {
		Funcionario f1 = new Funcionario();
		Date d = new Date();
		f1.setDataDesligamento(d);
		assertEquals(d,f1.getDataDesligamento());
	}

	@Test
	public void testSetStatus_2() {
		Funcionario f1 = new Funcionario();
		f1.setStatus_2(true);
		assertEquals(true,f1.isStatus_2());
	}

	@Test
	public void testSetSalario() {
		Funcionario f1 = new Funcionario();
		f1.setSalario(1289.45);
		assertEquals(1289,45,f1.getSalario());
	}

	@Test
	public void testSetEnderecoFuncional() {
		Funcionario f1 = new Funcionario();
		f1.setEnderecoFuncional("sala i5 terceiro andar");
		assertEquals("sala i5 terceiro andar",f1.getEnderecoFuncional());
	}

	@Test
	public void testSetTelefoneComercial() {
		Funcionario f1 = new Funcionario();
		f1.setTelefoneComercial("3555-4879");
		assertEquals("3555-4879",f1.getTelefoneComercial());
	}

	@Test
	public void testSetTipoFuncionario() {
		Funcionario f1 = new Funcionario();
		f1.setTipoFuncionario("secretária");
		assertEquals("secretária",f1.getTipoFuncionario());
	}

	@Test
	public void testSetNome() {
		Funcionario f1 = new Funcionario();
		f1.setNome("Maria da Silva");
		assertEquals("Maria da Silva",f1.getNome());
	}

	@Test
	public void testSetCPF_CNPJ() {
		Funcionario f1 = new Funcionario();
		f1.setCPF_CNPJ("789456123-11");
		assertEquals("789456123-11",f1.getCPF_CNPJ());
	}

	@Test
	public void testSetEmail() {
		Funcionario f1 = new Funcionario();
		f1.setEmail("maria_silva@gmail.com");
		assertEquals("maria_silva@gmail.com",f1.getEmail());
	}

	@Test
	public void testSetSenha() {
		Funcionario f1 = new Funcionario();
		f1.setSenha("minhaSenha789!");
		assertEquals("minhaSenha789!",f1.getSenha());
	}

	@Test
	public void testSetCEPFuncional() {
		Funcionario f1 = new Funcionario();
		f1.setCEPFuncional("72548-780");
		assertEquals("72548-780",f1.getCEPFuncional());
	}

	@Test
	public void testSetCidadeFuncional() {
		Funcionario f1 = new Funcionario();
		f1.setCidadeFuncional("Brasília");
		assertEquals("Brasília",f1.getCidadeFuncional());
	}

	@Test
	public void testSetUFCidadeFuncional() {
		Funcionario f1 = new Funcionario();
		f1.setUFCidadeFuncional("DF");
		assertEquals("DF",f1.getUFCidadeFuncional());
	}

}
