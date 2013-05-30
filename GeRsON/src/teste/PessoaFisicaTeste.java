package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.funcionarios.pf.*;

import java.util.Date;

public class PessoaFisicaTeste {

	@Test
	public void testPessoaFisica() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCargo() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setCargo("Gerente");
		assertEquals("Gerente", p1.getCargo());
	}

	@Test
	public void testSetTotalHoraSemanal() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setTotalHoraSemanal(40);
		assertEquals(40, p1.getTotalHoraSemanal());
	}

	@Test
	public void testSetRG() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setRG("4578962-DF");
		assertEquals("4578962-DF", p1.getRG());
	}

	@Test
	public void testSetOrgaoEmissor() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setOrgaoEmissor("SSP-DF");
		assertEquals("SSP-DF", p1.getOrgaoEmissor());
	}

	@Test
	public void testSetDataExpedicao() {
		PessoaFisica p1 = new PessoaFisica();
		Date d = new Date();
		p1.setDataExpedicao(d);
		assertEquals(d, p1.getDataExpedicao());
	}

	@Test
	public void testSetCTPS() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setCTPS("M456789");
		assertEquals("M456789", p1.getCTPS());
	}

	@Test
	public void testSetPIS() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setPIS("456789-45");
		assertEquals("456789-45", p1.getPIS());
	}

	@Test
	public void testSetDataNascimento() {
		PessoaFisica p1 = new PessoaFisica();
		Date d = new Date();
		p1.setDataNascimento(d);
		assertEquals(d, p1.getDataNascimento());
	}

	@Test
	public void testSetTelefoneCelular() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setTelefoneCelular("8178-9546");
		assertEquals("8178-9546", p1.getTelefoneCelular());
	}

	@Test
	public void testSetTelefoneResidencial() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setTelefoneResidencial("3645-1278");
		assertEquals("3645-1278", p1.getTelefoneResidencial());
	}

	@Test
	public void testSetEstadoCivil() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setEstadoCivil("Casado");
		assertEquals("Casado", p1.getEstadoCivil());
	}

	@Test
	public void testSetNacionalidade() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setNacionalidade("Brasileiro");
		assertEquals("Brasileiro", p1.getNacionalidade());
	}

	@Test
	public void testSetNaturalidade() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setNaturalidade("Sao Paulo");
		assertEquals("Sao Paulo", p1.getNaturalidade());
	}

	@Test
	public void testSetAltura() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setAltura(1.70);
		assertEquals(170, (int)(p1.getAltura()*100));
	}

	@Test
	public void testSetPeso() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setPeso(62.70);
		assertEquals(6270, (int)(p1.getPeso()*100));
	}

	@Test
	public void testSetCorCabelo() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setCorCabelo("Preto");
		assertEquals("Preto", p1.getCorCabelo());
	}

	@Test
	public void testSetCorOlhos() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setCorOlhos("Castanhos");
		assertEquals("Castanhos", p1.getCorOlhos());
	}

	@Test
	public void testSetRacaCor() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setRacaCor("Mulato");
		assertEquals("Mulato", p1.getRacaCor());
	}

	@Test
	public void testSetDeficienteFisico() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setDeficienteFisico(false);
		assertEquals(false, p1.isDeficienteFisico());
	}

	@Test
	public void testSetSinaisParticulares() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setSinaisParticulares("Tatuagem no ombro direito");
		assertEquals("Tatuagem no ombro direito", p1.getSinaisParticulares());
	}

	@Test
	public void testSetNomeMae() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setNomeMae("Maria Joao da Silva Santos");
		assertEquals("Maria Joao da Silva Santos", p1.getNomeMae());
	}

	@Test
	public void testSetNomePai() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setNomePai("Joao Paulo Souza Santos");
		assertEquals("Joao Paulo Souza Santos", p1.getNomePai());
	}

	@Test
	public void testSetNacionalidadeMae() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setNacionalidadeMae("Portuguesa");
		assertEquals("Portuguesa", p1.getNacionalidadeMae());
	}

	@Test
	public void testSetNacionalidadePai() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setNacionalidadePai("Brasileiro");
		assertEquals("Brasileiro", p1.getNacionalidadePai());
	}

	@Test
	public void testSetSerieCTPS() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setSerieCTPS("J45-8");
		assertEquals("J45-8", p1.getSerieCTPS());
	}

	@Test
	public void testSetEmissaoCTPS() {
		PessoaFisica p1 = new PessoaFisica();
		Date d = new Date();
		p1.setEmissaoCTPS(d);
		assertEquals(d, p1.getEmissaoCTPS());
	}

	@Test
	public void testSetUFCTPS() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setUFCTPS("GO");
		assertEquals("GO", p1.getUFCTPS());
	}

	@Test
	public void testSetTituloEleitoral() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setTituloEleitoral("123.456.789-78");
		assertEquals("123.456.789-78", p1.getTituloEleitoral());
	}

	@Test
	public void testSetZonaTitulo() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setZonaTitulo("182");
		assertEquals("182", p1.getZonaTitulo());
	}

	@Test
	public void testSetSecaoTitulo() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setSecaoTitulo("2345");
		assertEquals("2345", p1.getSecaoTitulo());
	}

	@Test
	public void testSetCNH() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setCNH("234578965");
		assertEquals("234578965", p1.getCNH());
	}

	@Test
	public void testSetReservista() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setReservista("987456DF");
		assertEquals("987456DF", p1.getReservista());
	}

	@Test
	public void testSetGrauInstrucao() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setGrauInstrucao("Ensino Medio");
		assertEquals("Ensino Medio", p1.getGrauInstrucao());
	}

	@Test
	public void testSetNomeConjuge() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setNomeConjuge("Fulano de Tal");
		assertEquals("Fulano de Tal", p1.getNomeConjuge());
	}

	@Test
	public void testSetNacionalidadeConjuge() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setNacionalidadeConjuge("Argentina");
		assertEquals("Argentina", p1.getNacionalidadeConjuge());
	}

	@Test
	public void testSetHorarioTrabalho() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setHorarioTrabalho("Diurno");
		assertEquals("Diurno", p1.getHorarioTrabalho());
	}

	@Test
	public void testSetEnderecoResidencial() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setEnderecoResidencial("Quadra 116 bloco C ap 13 andar 3 Asa Sul-DF");
		assertEquals("Quadra 116 bloco C ap 13 andar 3 Asa Sul-DF", p1.getEnderecoResidencial());
	}

	@Test
	public void testSetCidadeResidencial() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setCidadeResidencial("Brasilia");
		assertEquals("Brasilia", p1.getCidadeResidencial());
	}

	@Test
	public void testSetUFResidencial() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setUFResidencial("DF");
		assertEquals("DF", p1.getUFResidencial());
	}

	@Test
	public void testSetCEPResidencial() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setCEPResidencial("24567-845");
		assertEquals("24567-845", p1.getCEPResidencial());
	}

	@Test
	public void testCriarDependentes() {
		fail("Not yet implemented");
	}

}
