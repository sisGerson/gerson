package teste;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.*;

public class TestsPonto {
	private WebConversation wc;
	private WebResponse resp;
	private WebForm formulario;
	private WebLink link;
	private String urlPrincipal = "http://localhost:8080/GeRsON/";

	@Test
	//Teste para verificar se existe o link para a página de ponto para funcionario
	public void testPontoFuncionario() throws IOException, SAXException {
		this.wc = new WebConversation();
		
		this.resp = this.wc.getResponse(this.urlPrincipal+"login.jsp");
		
		this.formulario = this.resp.getForms()[0];
		
		this.formulario.setParameter("matricula", "321");
		this.formulario.setParameter("senha", "321");
		this.formulario.submit();
		
		this.resp = this.wc.getCurrentPage();
		
		this.link = this.resp.getLinks()[3];
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
		
		this.link = this.resp.getLinks()[5];
		assertEquals(this.link.getText(), "Bater Ponto");
	}
	
	@Test
	//Teste para verificar se existe o formulário bater ponto para funcionário
	public void testFormPontoFuncionario() throws IOException, SAXException {
		testPontoFuncionario();
		
		this.link.click();
		this.resp = this.wc.getCurrentPage();
		
		this.formulario = this.resp.getForms()[0];
		assertEquals(this.formulario.getName(), "cadastrar_ponto");
	}
}
