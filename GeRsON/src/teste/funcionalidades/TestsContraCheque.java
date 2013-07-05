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

public class TestsContraCheque {
	private WebConversation wc;
	private WebResponse resp;
	private WebForm formulario;
	private WebLink link;
	private String urlPrincipal = "http://localhost:8080/GeRsON/";
	
	@Test
	//teste para login do funcionario
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
	//teste para verificar o link de contra-cheque
	public void testLinkHoraExtra() throws IOException, SAXException {
		testLoginFuncionario();
		
		this.link = this.resp.getLinks()[2];
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
		
		this.link = this.resp.getLinks()[8];
		assertEquals(this.link.getText(), "Solicitar Contra Cheque");
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
	}
	
	@Test
	//teste para verificar o formulário
	public void testFormHoraExtra() throws IOException, SAXException{
		testLinkHoraExtra();
		
		this.formulario = this.resp.getForms()[0];
		
		assertEquals(this.formulario.getName(), "solicitar_contra_cheque");
		
		this.formulario.setParameter("ano", "2013");
		this.formulario.setParameter("mes", "07");
		
		this.formulario.submit();
		
		this.resp = this.wc.getCurrentPage();
	}
	
	@Test
	//teste para verificar o resultado da visualização do contra-cheque
	public void testResultHoraExtra() throws IOException, SAXException{
		testFormHoraExtra();
		
		assertTrue(this.resp.getText().contains("Contra-Cheque -"));
	}
}
