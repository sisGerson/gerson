package teste.funcionalidades;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.*;

public class TestsPontoFuncionaio {
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
		assertEquals(this.link.getText(), "Ponto");
		this.link.click();
	}
	
	@Test
	//Teste para clicar no link de Bater Ponto
	public void testLinkBaterPonto() throws SAXException, IOException {
		testPontoFuncionario();
		
		this.resp = this.wc.getCurrentPage();
		
		this.link = this.resp.getLinks()[5];
		assertEquals(this.link.getText(), "Bater Ponto");
		this.link.click();
	}
	
	@Test
	//Teste para verificar se existe o formulário bater ponto para funcionário
	public void testFormBaterPonto() throws IOException, SAXException {
		testLinkBaterPonto();
		
		this.resp = this.wc.getCurrentPage();
		
		this.formulario = this.resp.getForms()[0];
		assertEquals(this.formulario.getName(), "cadastrar_ponto");
	}
	
	@Test
	//Teste para submeter um cadastro de ponto (Hora de Entrada)
	public void testSubmitBaterPonto() throws IOException, SAXException {
		testFormBaterPonto();
		
		this.formulario.setParameter("opcao", "Entrada");
		this.formulario.submit();
	}
	
	@Test
	//Teste para clicar no link de Solicitar Ponto
	public void testLinkSolicitarPonto() throws SAXException, IOException {
		testPontoFuncionario();
		
		this.resp = this.wc.getCurrentPage();
		
		this.link = this.resp.getLinks()[6];
		assertEquals(this.link.getText(), "Solicitar Folha de Ponto");
		this.link.click();
	}
	
	@Test
	//Teste para verificar se existe o formulário solicitar folha ponto para funcionário
	public void testFormSolicitarPonto() throws IOException, SAXException {
		testLinkSolicitarPonto();
		
		this.resp = this.wc.getCurrentPage();
		
		this.formulario = this.resp.getForms()[0];
		assertEquals(this.formulario.getName(), "solicitar_folha_ponto");
	}
	
	@Test
	//Teste para submeter uma solicitação de folha de ponto (Mês de Janeiro)
	public void testSubmitSolicitarPonto() throws IOException, SAXException {
		testFormSolicitarPonto();
		
		this.formulario.setParameter("ano", "2013");
		this.formulario.setParameter("mes", "01");
		this.formulario.submit();
		
		this.resp = this.wc.getCurrentPage();
		assertTrue(this.resp.getText().contains("Relatório de Ponto"));
	}
	
	@Test
	//Teste para submeter uma solicitação de folha de ponto (Mês de Julho)
	public void testSubmitSolicitarPonto2() throws IOException, SAXException {
		testFormSolicitarPonto();
		
		this.formulario.setParameter("ano", "2013");
		this.formulario.setParameter("mes", "07");
		this.formulario.submit();
				
		this.resp = this.wc.getCurrentPage();
		assertTrue(this.resp.getText().contains("Relatório de Ponto"));
		assertTrue(this.resp.getText().contains("Entrada"));
	}	
}
