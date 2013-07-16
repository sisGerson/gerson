package teste.unitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.funcionarios.pf.*;

import java.util.Date;

public class TestPessoaFisica {
	PessoaFisica p1 = new PessoaFisica();
	
	@Before
	public void testPessoaFisica() {
		assertNotNull(p1);
		p1.criarDependentes();
		p1.criarDependentes();
		
		assertNotNull(p1.getDependentes()[0]);
		assertNotNull(p1.getDependentes()[1]);
	}
	
	@Test
	public void testSetCargo() {
		p1.setCargo("Gerente");
		assertEquals("Gerente", p1.getCargo());
	}

	@Test
	public void testSetTotalHoraSemanal() {
		p1.setTotalHoraSemanal(40);
		assertEquals(40, p1.getTotalHoraSemanal());
	}

	@Test
	public void testSetRG() {
		p1.setRG("4578962-DF");
		assertEquals("4578962-DF", p1.getRG());
	}

	@Test
	public void testSetOrgaoEmissor() {
		p1.setOrgaoEmissor("SSP-DF");
		assertEquals("SSP-DF", p1.getOrgaoEmissor());
	}

	@Test
	public void testSetDataExpedicao() {
		Date d = new Date();
		p1.setDataExpedicao(d);
		assertEquals(d, p1.getDataExpedicao());
	}
	@Test
	public void testSetCTPS() {
		p1.setCTPS("M456789");
		assertEquals("M456789", p1.getCTPS());
	}

	@Test
	public void testSetPIS() {
		p1.setPIS("456789-45");
		assertEquals("456789-45", p1.getPIS());
	}

	@Test
	public void testSetDataNascimento() {
		Date d = new Date();
		p1.setDataNascimento(d);
		assertEquals(d, p1.getDataNascimento());
	}

	@Test
	public void testSetTelefoneCelular() {
		p1.setTelefoneCelular("8178-9546");
		assertEquals("8178-9546", p1.getTelefoneCelular());
	}

	@Test
	public void testSetTelefoneResidencial() {
		p1.setTelefoneResidencial("3645-1278");
		assertEquals("3645-1278", p1.getTelefoneResidencial());
	}

	@Test
	public void testSetEstadoCivil() {
		p1.setEstadoCivil("Casado");
		assertEquals("Casado", p1.getEstadoCivil());
	}

	@Test
	public void testSetNacionalidade() {
		p1.setNacionalidade("Brasileiro");
		assertEquals("Brasileiro", p1.getNacionalidade());
	}

	@Test
	public void testSetNaturalidade() {
		p1.setNaturalidade("Sao Paulo");
		assertEquals("Sao Paulo", p1.getNaturalidade());
	}

	@Test
	public void testSetAltura() {
		p1.setAltura(1.70);
		assertEquals(170, (int)(p1.getAltura()*100));
	}

	@Test
	public void testSetPeso() {
		p1.setPeso(62.70);
		assertEquals(6270, (int)(p1.getPeso()*100));
	}

	@Test
	public void testSetCorCabelo() {
		p1.setCorCabelo("Preto");
		assertEquals("Preto", p1.getCorCabelo());
	}

	@Test
	public void testSetCorOlhos() {
		p1.setCorOlhos("Castanhos");
		assertEquals("Castanhos", p1.getCorOlhos());
	}

	@Test
	public void testSetRacaCor() {
		p1.setRacaCor("Mulato");
		assertEquals("Mulato", p1.getRacaCor());
	}

	@Test
	public void testSetDeficienteFisico() {
		p1.setDeficienteFisico(false);
		assertEquals(false, p1.isDeficienteFisico());
	}

	@Test
	public void testSetSinaisParticulares() {
		p1.setSinaisParticulares("Tatuagem no ombro direito");
		assertEquals("Tatuagem no ombro direito", p1.getSinaisParticulares());
	}

	@Test
	public void testSetNomeMae() {
		p1.setNomeMae("Maria Joao da Silva Santos");
		assertEquals("Maria Joao da Silva Santos", p1.getNomeMae());
	}

	@Test
	public void testSetNomePai() {
		p1.setNomePai("Joao Paulo Souza Santos");
		assertEquals("Joao Paulo Souza Santos", p1.getNomePai());
	}

	@Test
	public void testSetNacionalidadeMae() {
		p1.setNacionalidadeMae("Portuguesa");
		assertEquals("Portuguesa", p1.getNacionalidadeMae());
	}

	@Test
	public void testSetNacionalidadePai() {
		p1.setNacionalidadePai("Brasileiro");
		assertEquals("Brasileiro", p1.getNacionalidadePai());
	}

	@Test
	public void testSetSerieCTPS() {
		p1.setSerieCTPS("J45-8");
		assertEquals("J45-8", p1.getSerieCTPS());
	}

	@Test
	public void testSetEmissaoCTPS() {
		Date d = new Date();
		p1.setEmissaoCTPS(d);
		assertEquals(d, p1.getEmissaoCTPS());
	}

	@Test
	public void testSetUFCTPS() {
		p1.setUFCTPS("GO");
		assertEquals("GO", p1.getUFCTPS());
	}

	@Test
	public void testSetTituloEleitoral() {
		p1.setTituloEleitoral("123.456.789-78");
		assertEquals("123.456.789-78", p1.getTituloEleitoral());
	}

	@Test
	public void testSetZonaTitulo() {
		p1.setZonaTitulo("182");
		assertEquals("182", p1.getZonaTitulo());
	}

	@Test
	public void testSetSecaoTitulo() {
		p1.setSecaoTitulo("2345");
		assertEquals("2345", p1.getSecaoTitulo());
	}

	@Test
	public void testSetCNH() {
		p1.setCNH("234578965");
		assertEquals("234578965", p1.getCNH());
	}

	@Test
	public void testSetReservista() {
		p1.setReservista("987456DF");
		assertEquals("987456DF", p1.getReservista());
	}

	@Test
	public void testSetGrauInstrucao() {
		p1.setGrauInstrucao("Ensino Medio");
		assertEquals("Ensino Medio", p1.getGrauInstrucao());
	}

	@Test
	public void testSetNomeConjuge() {
		p1.setNomeConjuge("Fulano de Tal");
		assertEquals("Fulano de Tal", p1.getNomeConjuge());
	}

	@Test
	public void testSetNacionalidadeConjuge() {
		p1.setNacionalidadeConjuge("Argentina");
		assertEquals("Argentina", p1.getNacionalidadeConjuge());
	}

	@Test
	public void testSetHorarioTrabalho() {
		p1.setHorarioTrabalho("Diurno");
		assertEquals("Diurno", p1.getHorarioTrabalho());
	}

	@Test
	public void testSetEnderecoResidencial() {
		p1.setEnderecoResidencial("Quadra 116 bloco C ap 13 andar 3 Asa Sul-DF");
		assertEquals("Quadra 116 bloco C ap 13 andar 3 Asa Sul-DF", p1.getEnderecoResidencial());
	}

	@Test
	public void testSetCidadeResidencial() {
		p1.setCidadeResidencial("Brasilia");
		assertEquals("Brasilia", p1.getCidadeResidencial());
	}

	@Test
	public void testSetUFResidencial() {
		p1.setUFResidencial("DF");
		assertEquals("DF", p1.getUFResidencial());
	}

	@Test
	public void testSetCEPResidencial() {
		p1.setCEPResidencial("24567-845");
		assertEquals("24567-845", p1.getCEPResidencial());
	}
	
	@Test
	public void testGetDependentes() {
		assertNotNull(p1.getDependentes());
	}

	@Test
	public void testSetSenha() {
		p1.setSenha("123");
		assertEquals("123", p1.getSenha());
	}
	
	@Test
	public void testSetUltimasFerias() {
		Date data = new Date();
		p1.setUltimasFerias(data);
		assertEquals(data, p1.getUltimasFerias());
	}
}
