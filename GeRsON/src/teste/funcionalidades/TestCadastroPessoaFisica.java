package teste.funcionalidades;

/**
 * Testes referentes a Cadastro pessoa fisica
 */

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebResponse;

public class TestCadastroPessoaFisica {
	private WebConversation wc;
	private WebResponse resp;
	private WebForm formulario;
	private WebLink link;
	private String urlPrincipal = "http://localhost:8080/GeRsON/";
	
	@Test
	//teste.unitarios para login do gerente
	public void testLoginGerente() throws IOException, SAXException{
		this.wc = new WebConversation();
		this.resp = this.wc.getResponse(this.urlPrincipal+ "login.jsp");
		this.formulario = this.resp.getForms()[0];	
		this.formulario.setParameter("matricula", "123");
		this.formulario.setParameter("senha", "123");
		this.formulario.submit();
		this.resp = this.wc.getCurrentPage();
	}
	
	@Test
	//teste.unitarios para verificar se existe o link para abrir op��es de pessoa f�sica
	public void testLinkPessoaFisica() throws IOException, SAXException {
		testLoginGerente();
		this.link = this.resp.getLinks()[1];
		this.link.click();
		this.resp = this.wc.getCurrentPage();
		this.link = this.resp.getLinks()[2];
		assertEquals(this.link.getText(), "Pessoa F�sica");
		this.link.click();		
		this.resp = this.wc.getCurrentPage();
	}
	
	@Test
	//teste.unitarios para verificar se existe o link para Cadastrar
	public void testLinkCadastrar() throws IOException, SAXException {
		testLoginGerente();
		testLinkPessoaFisica();
		this.link = this.resp.getLinks()[6];
		assertEquals(this.link.getText(), "Cadastrar");
		this.link.click();
		this.resp = this.wc.getCurrentPage();
	}

	@Test
	//verifica se existe um formulario para cadastrar a PJ
	public void testverificaFormulario() throws IOException, SAXException{
		testLoginGerente();
		testLinkPessoaFisica();
		testLinkCadastrar();
		
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
		this.formulario = this.resp.getForms()[0];
		assertEquals(this.formulario.getName(), "cadastrar_pessoafisica");	
		assertTrue(this.formulario.hasParameterNamed("status_2"));
		assertTrue(this.formulario.hasParameterNamed("nome"));
		assertTrue(this.formulario.hasParameterNamed("dataNascimento"));
		assertTrue(this.formulario.hasParameterNamed("email"));
		assertTrue(this.formulario.hasParameterNamed("nacionalidade"));	
		assertTrue(this.formulario.hasParameterNamed("naturalidade"));	
		assertTrue(this.formulario.hasParameterNamed("estadoCivil"));	
		assertTrue(this.formulario.hasParameterNamed("nomeConjuge"));	
		assertTrue(this.formulario.hasParameterNamed("nacionalidadeConjuge"));	
		assertTrue(this.formulario.hasParameterNamed("nomeMae"));	
		assertTrue(this.formulario.hasParameterNamed("nacionalidadeMae"));	
		assertTrue(this.formulario.hasParameterNamed("nomePai"));	
		assertTrue(this.formulario.hasParameterNamed("nacionalidadePai"));	
		assertTrue(this.formulario.hasParameterNamed("racaCor"));	
		assertTrue(this.formulario.hasParameterNamed("peso"));	
		assertTrue(this.formulario.hasParameterNamed("altura"));	
		assertTrue(this.formulario.hasParameterNamed("corOlhos"));	
		assertTrue(this.formulario.hasParameterNamed("corCabelo"));	
		assertTrue(this.formulario.hasParameterNamed("grauInstrucao"));	
		assertTrue(this.formulario.hasParameterNamed("deficienteFisico"));	
		assertTrue(this.formulario.hasParameterNamed("sinaisParticulares"));	
		assertTrue(this.formulario.hasParameterNamed("CPF_CNPJ"));	
		assertTrue(this.formulario.hasParameterNamed("CNH"));	
		assertTrue(this.formulario.hasParameterNamed("reservista"));	
		assertTrue(this.formulario.hasParameterNamed("RG"));	
		assertTrue(this.formulario.hasParameterNamed("orgaoEmissor"));	
		assertTrue(this.formulario.hasParameterNamed("dataExpedicao"));	
		assertTrue(this.formulario.hasParameterNamed("CTPS"));	
		assertTrue(this.formulario.hasParameterNamed("serieCTPS"));	
		assertTrue(this.formulario.hasParameterNamed("UFCTPS"));	
		assertTrue(this.formulario.hasParameterNamed("emissaoCTPS"));	
		assertTrue(this.formulario.hasParameterNamed("PIS"));	
		assertTrue(this.formulario.hasParameterNamed("tituloEleitoral"));	
		assertTrue(this.formulario.hasParameterNamed("zonaTitulo"));	
		assertTrue(this.formulario.hasParameterNamed("secaoTitulo"));	
		assertTrue(this.formulario.hasParameterNamed("enderecoResidencial"));	
		assertTrue(this.formulario.hasParameterNamed("cidadeResidencial"));
		assertTrue(this.formulario.hasParameterNamed("UFResidencial"));
		assertTrue(this.formulario.hasParameterNamed("CEPResidencial"));
		assertTrue(this.formulario.hasParameterNamed("telefoneResidencial"));
		assertTrue(this.formulario.hasParameterNamed("telefoneCelular"));
		assertTrue(this.formulario.hasParameterNamed("matricula"));
		assertTrue(this.formulario.hasParameterNamed("senha"));
		assertTrue(this.formulario.hasParameterNamed("area"));
		assertTrue(this.formulario.hasParameterNamed("dataAdmissao"));
		assertTrue(this.formulario.hasParameterNamed("dataDesligamento"));
		assertTrue(this.formulario.hasParameterNamed("salario"));
		assertTrue(this.formulario.hasParameterNamed("cargo"));
		assertTrue(this.formulario.hasParameterNamed("horarioTrabalho"));
		assertTrue(this.formulario.hasParameterNamed("totalHoraSemanal"));
		assertTrue(this.formulario.hasParameterNamed("enderecoFuncional"));
		assertTrue(this.formulario.hasParameterNamed("cidadeFuncional"));
		assertTrue(this.formulario.hasParameterNamed("UFCidadeFuncional"));
		assertTrue(this.formulario.hasParameterNamed("CEPFuncional"));
		assertTrue(this.formulario.hasParameterNamed("telefoneComercial"));
	}
	
	@Test
	//Teste para verificar se existe o formul�rio Cadastrar Funcion�rio Pessoa F�sica
	
	public void testCadastrarPessoaFisica() throws IOException, SAXException {
		testLoginGerente();
		testLinkPessoaFisica();
		testLinkCadastrar();
		this.resp = this.wc.getCurrentPage();
		this.formulario = this.resp.getForms()[0];
		assertEquals(this.formulario.getName(), "cadastrar_pessoafisica");	
		this.formulario.setParameter("status_2","True");
		this.formulario.setParameter("nome","Ciclano de tal");
		this.formulario.setParameter("dataNascimento","28/04/1990");
		this.formulario.setParameter("email","ciclano@gmail.com");
		this.formulario.setParameter("nacionalidade","brasil");
		this.formulario.setParameter("naturalidade","brasilia");
		this.formulario.setParameter("estadoCivil","solteiro");
		this.formulario.setParameter("nomeConjuge","");
		this.formulario.setParameter("nacionalidadeConjuge","");
		this.formulario.setParameter("nomeMae","Maria da Silva");
		this.formulario.setParameter("nacionalidadeMae","Brasileira");
		this.formulario.setParameter("nomePai","Jos� da Silva");
		this.formulario.setParameter("nacionalidadePai","Brasileiro");		
		this.formulario.setParameter("racaCor","negro");
		this.formulario.setParameter("peso","76.5");
		this.formulario.setParameter("altura","1.90");
		this.formulario.setParameter("corOlhos","castanhos");
		this.formulario.setParameter("corCabelo","pretos");
		this.formulario.setParameter("grauInstrucao","Segundo grau");
		this.formulario.setParameter("deficienteFisico","False");
		this.formulario.setParameter("sinaisParticulares","");		
		this.formulario.setParameter("CPF_CNPJ","789.678.456-56");
		this.formulario.setParameter("CNH","");
		this.formulario.setParameter("reservista","12345");		
		this.formulario.setParameter("RG","123454");
		this.formulario.setParameter("orgaoEmissor","SSP-DF");
		this.formulario.setParameter("dataExpedicao","12/01/2003");
		this.formulario.setParameter("CTPS","347657");
		this.formulario.setParameter("serieCTPS","001");
		this.formulario.setParameter("UFCTPS","DF");
		this.formulario.setParameter("emissaoCTPS","23/02/2002");
		this.formulario.setParameter("PIS","0253");
		this.formulario.setParameter("tituloEleitoral","098765");
		this.formulario.setParameter("zonaTitulo","002");
		this.formulario.setParameter("secaoTitulo","07");
		this.formulario.setParameter("enderecoResidencial","edificio plaza, brasilia");
		this.formulario.setParameter("cidadeResidencial","asa sul");
		this.formulario.setParameter("UFResidencial","DF");
		this.formulario.setParameter("CEPResidencial","12345-987");
		this.formulario.setParameter("telefoneResidencial","(61)2333-3333");
		this.formulario.setParameter("telefoneCelular","(61)9833-3333");		
		this.formulario.setParameter("matricula","123");
		this.formulario.setParameter("senha","123");
		this.formulario.setParameter("area","Gerencia de RH");
		this.formulario.setParameter("dataAdmissao","08/08/2004");
		this.formulario.setParameter("dataDesligamento","");
		this.formulario.setParameter("salario","1.234");
		this.formulario.setParameter("cargo","Gerente");
		this.formulario.setParameter("horarioTrabalho","diurno");
		this.formulario.setParameter("totalHoraSemanal","40");	
		this.formulario.setParameter("enderecoFuncional","Sala 17");	
		this.formulario.setParameter("cidadeFuncional","Bras�lia");	
		this.formulario.setParameter("UFCidadeFuncional","DF");	
		this.formulario.setParameter("CEPFuncional","12345-987");	
		this.formulario.setParameter("telefoneComercial","(61)2333-3334");	
		this.formulario.submit();
		this.resp = this.wc.getCurrentPage();
		assertTrue(this.resp.getText().contains("cadastrado com Sucesso"));		

	}	
}

