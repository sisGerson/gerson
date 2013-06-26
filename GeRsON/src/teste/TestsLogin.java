package teste;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class TestsLogin {
	private String urlPrincipal = "http://localhost:8080/GeRsON/";
	@Test
	//Testar se a página index.jsp existe
	public void testIndexExists() throws IOException, SAXException {
		WebConversation wc = new WebConversation();
		
		WebResponse resp = wc.getResponse(this.urlPrincipal+"index.jsp");
		resp.close();
	}
	
	@Test
	//Testar se existe a página de login e o seu formulário com os respectivos campos
	public void testFormExists() throws IOException, SAXException {
		WebConversation wc = new WebConversation();
		
		WebResponse resp = wc.getResponse(this.urlPrincipal+"login.jsp");
		
		assertEquals("GeRsON", resp.getTitle());
		
		WebForm form = resp.getForms()[0];
		
		assertTrue(form.hasParameterNamed("matricula"));
		assertTrue(form.hasParameterNamed("senha"));
		assertTrue(form.hasParameterNamed("logica"));		
	}
	
	@Test
	//Teste de setar atributos nos campos do formulário de login para se ter um usuário incorreto
	public void testFormPassword() throws IOException, SAXException {
		WebConversation wc = new WebConversation();
		
		WebResponse resp = wc.getResponse(this.urlPrincipal+"login.jsp");
		WebForm form = resp.getForms()[0];
		
		form.setParameter("matricula", "223");
		form.setParameter("senha", "123");
		form.submit();
		
		WebResponse next = wc.getCurrentPage();
		assertTrue(next.getText().contains("Usuário incorreto! Tente novamente!"));
	}
	
	@Test
	//Teste de setar atributos nos campos do formulário de login para se ter uma senha incorreta
	public void testFormUser() throws IOException, SAXException {
		WebConversation wc = new WebConversation();
		
		WebResponse resp = wc.getResponse(this.urlPrincipal+"login.jsp");
		WebForm form = resp.getForms()[0];
		
		form.setParameter("matricula", "123");
		form.setParameter("senha", "333");
		form.submit();
		
		WebResponse next = wc.getCurrentPage();
		assertTrue(next.getText().contains("Senha incorreta! Tente novamente!"));
	}
	
	@Test
	//Teste de setar atributos nos campos do formulário de login para se ter uma senha incorreta
	public void testProfileManager() throws IOException, SAXException {
		WebConversation wc = new WebConversation();
		
		WebResponse resp = wc.getResponse(this.urlPrincipal+"login.jsp");
		WebForm form = resp.getForms()[0];
		
		form.setParameter("matricula", "123");
		form.setParameter("senha", "123");
		form.submit();
		
		WebResponse next = wc.getCurrentPage();
		assertTrue(next.getText().contains("Perfil: Gerente"));
	}
	
	@Test
	//Teste de setar atributos nos campos do formulário de login para se ter uma senha incorreta
	public void testProfileFunctionary() throws IOException, SAXException {
		WebConversation wc = new WebConversation();
		
		WebResponse resp = wc.getResponse(this.urlPrincipal+"login.jsp");
		WebForm form = resp.getForms()[0];
		
		form.setParameter("matricula", "321");
		form.setParameter("senha", "321");
		form.submit();
		
		WebResponse next = wc.getCurrentPage();
		assertTrue(next.getText().contains("Perfil: Funcionário"));
	}
}
