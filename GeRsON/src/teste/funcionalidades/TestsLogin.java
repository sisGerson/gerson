package teste.funcionalidades;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebResponse;

/**
 * Testes referentes ao login estão todos passando como o esperado
 * */

public class TestsLogin {
	private WebConversation wc;
	private WebResponse resp;
	private WebForm formulario;
	private WebLink link;
	private String urlPrincipal = "http://localhost:8080/GeRsON/";
	
	@Test
	//Testar se a página index.jsp existe
	public void testIndexExists() throws IOException, SAXException {
		this.wc = new WebConversation();
		
		this.resp = this.wc.getResponse(this.urlPrincipal+"index.jsp");
		this.resp.close();
	}
	
	@Test
	//Testar se existe a página de login e o seu formulário com os respectivos campos
	public void testFormExists() throws IOException, SAXException {
		this.wc = new WebConversation();
		
		this.resp = this.wc.getResponse(this.urlPrincipal+"login.jsp");
		
		assertEquals("GeRsON", this.resp.getTitle());
		
		this.formulario = this.resp.getForms()[0];
		
		assertTrue(this.formulario.hasParameterNamed("matricula"));
		assertTrue(this.formulario.hasParameterNamed("senha"));
		assertTrue(this.formulario.hasParameterNamed("logica"));		
	}
	
	@Test
	//Teste de setar atributos nos campos do formulário de login para se ter um usuário incorreto
	public void testFormPassword() throws IOException, SAXException {
		this.wc = new WebConversation();
		
		this. resp = this.wc.getResponse(this.urlPrincipal+"login.jsp");
		this.formulario = this.resp.getForms()[0];
		
		this.formulario.setParameter("matricula", "223");
		this.formulario.setParameter("senha", "123");
		this.formulario.submit();
		
		this.resp = this.wc.getCurrentPage();
		assertTrue(this.resp.getText().contains("Usuário incorreto! Tente novamente!"));
	}
	
	@Test
	//Teste de setar atributos nos campos do formulário de login para se ter uma senha incorreta
	public void testFormUser() throws IOException, SAXException {
		this.wc = new WebConversation();
		
		this.resp = this.wc.getResponse(this.urlPrincipal+"login.jsp");
		this.formulario = this.resp.getForms()[0];
		
		this.formulario.setParameter("matricula", "123");
		this.formulario.setParameter("senha", "333");
		this.formulario.submit();
		
		this.resp = this.wc.getCurrentPage();
		assertTrue(this.resp.getText().contains("Senha incorreta! Tente novamente!"));
	}
	
	@Test
	//Teste para verificar a página inicial de um funcionário
	public void testProfileManager() throws IOException, SAXException {
		this.wc = new WebConversation();
		
		this.resp = wc.getResponse(this.urlPrincipal+"login.jsp");
		this.formulario = resp.getForms()[0];
		
		this.formulario.setParameter("matricula", "321");
		this.formulario.setParameter("senha", "321");
		this.formulario.submit();
		
		this.resp = this.wc.getCurrentPage();
		
		this.link = this.resp.getLinks()[1];
		assertEquals(this.link.getText(), "Início");
		
		this.link = this.resp.getLinks()[2];
		assertEquals(this.link.getText(), "Relatórios");
		
		this.link = this.resp.getLinks()[3];
		assertEquals(this.link.getText(), "Ponto");
		
		this.link = this.resp.getLinks()[4];
		assertEquals(this.link.getText(), "Férias");
		
		this.link = this.resp.getLinks()[5];
		assertEquals(this.link.getText(), "Sair");
	}
	
	@Test
	//Teste para verificar a página inicial de um gerente
	public void testProfileFunctionary() throws IOException, SAXException {
		this.wc = new WebConversation();
		
		this.resp = this.wc.getResponse(this.urlPrincipal+"login.jsp");
		this.formulario = this.resp.getForms()[0];
		
		this.formulario.setParameter("matricula", "123");
		this.formulario.setParameter("senha", "123");
		this.formulario.submit();
		
		this.resp = this.wc.getCurrentPage();
		
		this.link = this.resp.getLinks()[1];
		assertEquals(this.link.getText(), "Início");
		
		this.link = this.resp.getLinks()[2];
		assertEquals(this.link.getText(), "Pessoa Física");
		
		this.link = this.resp.getLinks()[3];
		assertEquals(this.link.getText(), "Pessoa Jurídica");
		
		this.link = this.resp.getLinks()[4];
		assertEquals(this.link.getText(), "Relatórios");
		
		this.link = this.resp.getLinks()[5];
		assertEquals(this.link.getText(), "Férias");
		
		this.link = this.resp.getLinks()[6];
		assertEquals(this.link.getText(), "Sair");
	}
}
