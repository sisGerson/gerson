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

public class TestPedirFerias {
	private WebConversation wc;
	private WebResponse resp;
	private WebForm formulario;
	private WebLink link;
	private String urlPrincipal = "http://localhost:8080/GeRsON/";
	
	@Test
	//teste.unitarios para login do funcionario
	public void testLoginFuncionario() throws IOException, SAXException{
		this.wc = new WebConversation();
		this.resp = this.wc.getResponse(this.urlPrincipal+ "login.jsp");
		this.formulario = this.resp.getForms()[0];
		
		this.formulario.setParameter("matricula", "321");
		this.formulario.setParameter("senha", "321");
		this.formulario.submit();
		
		this.resp = this.wc.getCurrentPage();
	}
	
	@Test
	//teste.unitarios para verificar o link de pedir férias
	public void testLinkPedirFerias() throws IOException, SAXException {
		testLoginFuncionario();
		
		this.link = this.resp.getLinks()[4];
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
		
		this.link = this.resp.getLinks()[6];
		assertEquals(this.link.getText(), "Pedir Férias");
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
	}
	
	@Test
	//teste.unitarios para verificar o formulário e o resultado do pedido de férias
	public void testFormResult() throws IOException, SAXException{
		testLinkPedirFerias();
		
		this.formulario = this.resp.getForms()[0];
		
		assertEquals(this.formulario.getName(), "pedir_ferias");
		
		this.formulario.setParameter("ano", "2013");
		this.formulario.setParameter("mes", "02");
		
		this.formulario.submit();
		
		this.resp = this.wc.getCurrentPage();
		
		assertTrue(this.resp.getText().contains("Pedido de férias efetuado com sucesso!"));
	}

	@Test
	//Teste para verificar situação das férias
	public void testVerificarResult() throws IOException, SAXException {
		testLoginFuncionario();
		
		this.link = this.resp.getLinks()[4];
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
		
		this.link = this.resp.getLinks()[7];
		assertEquals(this.link.getText(), "Verificar Pedido de Férias");
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
		assertTrue(this.resp.getText().contains("Aguarde seu pedido ainda não foi processado!"));
	}
}
