package teste;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebResponse;

public class TestsHoraExtra {
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
	//teste para verificar o link de hora extra
	public void testLinkHoraExtra() throws IOException, SAXException {
		testLoginFuncionario();
		
		this.link = this.resp.getLinks()[3];
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
		
		this.link = this.resp.getLinks()[7];
		assertEquals(this.link.getName(), "Visualizar Hora Extra");
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
	}
	
	@Test
	//teste para verificar o formulário
	public void testFormHoraExtra() throws IOException, SAXException{
		testLinkHoraExtra();
		
		this.formulario = this.resp.getForms()[0];
		
		assertEquals(this.formulario.getText(), "visualizar_hora_extra");
		
		this.formulario.setParameter("ano", "2013");
		this.formulario.setParameter("mes", "07");
		
		this.formulario.submit();
		
		this.resp = this.wc.getCurrentPage();
	}
	
	@Test
	//teste para verificar o resultado da visualização da hora extra
	public void testResultHoraExtra() throws IOException, SAXException{
		testFormHoraExtra();
		
		assertTrue(this.resp.getText().contains("Hora Extra: Julho de 2013"));
		assertTrue(this.resp.getText().contains("Total: 10"));
	}
}
