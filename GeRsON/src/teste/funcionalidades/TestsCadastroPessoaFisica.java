package teste.funcionalidades;

/**
 * Todos os testes referentes as contra-cheque passaram nessa classe
 */

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebResponse;

public class TestsCadastroPessoaFisica {
	private WebConversation wc;
	private WebResponse resp;
	private WebForm formulario;
	private WebLink link;
	private String urlPrincipal = "http://localhost:8080/GeRsON/";
	
	@Test
	//teste para login do gerente
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
	//teste para verificar se existe o link para abrir opções de pessoa física
	public void testLinkPessoaFisica() throws IOException, SAXException {
		testLoginGerente();
		this.link = this.resp.getLinks()[1];
		this.link.click();
		this.resp = this.wc.getCurrentPage();
		this.link = this.resp.getLinks()[2];
		assertEquals(this.link.getText(), "Pessoa Física");
		this.link.click();		
		this.resp = this.wc.getCurrentPage();
	}
	
	@Test
	//teste para verificar se existe o link para Cadastrar
	public void testLinkCadastrar() throws IOException, SAXException {
		testLoginGerente();
		testLinkPessoaFisica();
		this.link = this.resp.getLinks()[6];
		assertEquals(this.link.getText(), "Cadastrar");
		this.link.click();
		this.resp = this.wc.getCurrentPage();
	}
	
	@Test
	//Teste para verificar se existe o formulário Cadastrar Funcionário Pessoa Física
	public void testCadastrarPessoaFisica() throws IOException, SAXException {
		testLoginGerente();
		testLinkPessoaFisica();
		testLinkCadastrar();
		this.resp = this.wc.getCurrentPage();
		this.formulario = this.resp.getForms()[0];
		assertEquals(this.formulario.getName(), "cadastrar_pessoafisica");		
		//this.formulario.submit();

	}
	
}
