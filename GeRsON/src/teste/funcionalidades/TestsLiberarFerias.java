package teste.funcionalidades;

/**
 * Todos os testes dessa classe passaram com sucesso
 */

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebResponse;

public class TestsLiberarFerias {
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
	//teste para verificar o link de Visualizar pedidos de férias
	public void testLinkVisualizarFerias() throws IOException, SAXException {
		testLoginGerente();
		
		this.link = this.resp.getLinks()[4];
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
		
		this.link = this.resp.getLinks()[6];
		assertEquals(this.link.getText(), "Visualizar pedidos de férias");
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
		assertTrue(this.resp.getText().contains("Pedidos de Férias"));
		assertTrue(this.resp.getText().contains("Dados para pesquisa"));
	}
	
	@Test
	//teste para aceitar as férias do funcionário
	public void testAceitaFerias() throws IOException, SAXException {
		testLinkVisualizarFerias();
		
		this.formulario = this.resp.getForms()[0];
		assertEquals(this.formulario.getName(), "resultado_ferias");
		
		this.formulario.setParameter("resultado", "Sim");
		this.formulario.submit();
		
		this.resp = this.wc.getCurrentPage();
	}
}
