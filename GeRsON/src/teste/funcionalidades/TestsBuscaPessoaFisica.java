package teste.funcionalidades;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.WebTable;
import com.meterware.httpunit.WebWindow;

public class TestsBuscaPessoaFisica {

	private WebConversation wc;
	private WebResponse resp;
	private WebForm formulario;
	private WebLink link;
	private String urlPrincipal = "http://localhost:8080/GeRsON/";
	private WebTable table;
	private WebWindow[] window;
	@Test
	//Logando como gerente
	public void gerenteLoginTest() throws IOException, SAXException {
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
		assertEquals(this.link.getText(), "Sair");
		
	}

	@Test
	//Verificando se existe um link para pesquisar pessoa fisica
	public void linkPesquisarPessoaFisicaTest() throws IOException, SAXException {
		gerenteLoginTest();

		this.link = this.resp.getLinks()[2];
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
		
		this.link = this.resp.getLinks()[7];
		assertEquals(this.link.getText(), "Pesquisar/Alterar");
	}
	
	@Test
	//Verificando se existe campos para efetuar a pesquisa
	public void formularioPesquisaPessoaFisicaTest() throws IOException, SAXException {
		linkPesquisarPessoaFisicaTest();
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
		
		this.formulario = this.resp.getForms()[0];
		assertTrue(this.formulario.hasParameterNamed("matricula"));
		assertTrue(this.formulario.hasParameterNamed("area"));
		assertTrue(this.formulario.hasParameterNamed("nome"));
		assertTrue(this.formulario.hasParameterNamed("cpf"));
		assertTrue(this.formulario.hasParameterNamed("cargo"));
	}
	
	@Test
	//Verificando se a pesquisa é realmente feita(com o campo matricula)
	public void pesquisaPessoaFisicaMatriculaTest() throws IOException, SAXException{
		formularioPesquisaPessoaFisicaTest();
		
		this.formulario.setParameter("matricula","321");
		this.formulario.submit();
		
		//isto é porque o resultado abre em outra janela
		this.window = this.wc.getOpenWindows();
		assertEquals(2,window.length);
		this.resp = window[1].getCurrentPage();
		
		//verifica se a nova janela que abriu é a janela com o resultado da pesquisa 
		assertTrue(this.resp.getText().contains("Resultado da Pesquisa - Funcionário: Pessoa Física "));
	}
	
	@Test
	//Confere que há uma pessoa fisica com matricula 321 catalogada no banco de dados
	public void verificaPessoaFisica321Test() throws IOException, SAXException{
		pesquisaPessoaFisicaMatriculaTest();
		
		this.table = this.resp.getTables()[0];
		//verifica se o texto da celula(linha 1, coluna 0) é "321"
		assertEquals(table.getCellAsText(1, 0), "321");
	}
}