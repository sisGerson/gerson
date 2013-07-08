package teste.funcionalidades;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebResponse;

public class TestsCadastroPessoaJuridica {

	private WebConversation wc;
	private WebResponse resp;
	private WebForm formulario;
	private WebLink link;
	private String urlPrincipal = "http://localhost:8080/GeRsON/";

	@Test
	//fazendo login como gerente
	public void loginTest() throws IOException, SAXException{
		this.wc = new WebConversation();
		this.resp = this.wc.getResponse(urlPrincipal + "index.jsp");
		
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
	}
	
	@Test
	//verifica a existencia de um link para cadastrar pessoa juridica
	public void linkCadastroPessoaJuridicaTest() throws IOException, SAXException{
		loginTest();
		this.link = this.resp.getLinks()[3];
		assertEquals(this.link.getText(), "Pessoa Jurídica");
		
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
		
		this.link = this.resp.getLinks()[6];
		assertEquals(this.link.getText(),"Cadastrar");
	}
	
	@Test
	//verifica se existe um formulario para cadastrar a PJ
	public void verificaFormularioTest() throws IOException, SAXException{
		linkCadastroPessoaJuridicaTest();
		
		this.link.click();
		
		this.resp = this.wc.getCurrentPage();
		this.formulario = this.resp.getForms()[0];
		
		assertTrue(this.formulario.hasParameterNamed("nome"));
		assertTrue(this.formulario.hasParameterNamed("CPF_CNPJ"));
		assertTrue(this.formulario.hasParameterNamed("email"));
		assertTrue(this.formulario.hasParameterNamed("descricaoServico"));
		assertTrue(this.formulario.hasParameterNamed("responsavel"));	
	}

	@Test
	//cadastra uma pessoa juridica
	public void cadastraPessoaJuridicaTest() throws IOException, SAXException{
		linkCadastroPessoaJuridicaTest();
		
		this.link.click();

		this.resp = this.wc.getCurrentPage();
		this.formulario = this.resp.getForms()[0];
	
		this.formulario.setParameter("nome", "Sonho Verde");
		this.formulario.setParameter("CPF_CNPJ","11.122.233/3444-44");
		this.formulario.setParameter("email", "sonhoverde@unb.com");
		this.formulario.setParameter("descricaoServico","vender plantas");
		this.formulario.setParameter("enderecoFuncional","gama df");
		this.formulario.setParameter("cidadeFuncional","gama");
		this.formulario.setParameter("UFCidadeFuncional","DF");
		this.formulario.setParameter("CEPFuncional", "23567-890");
		this.formulario.setParameter("telefoneComercial","(61)3444-3333");
		this.formulario.setParameter("matricula","098");
		this.formulario.setParameter("senha","098");
		this.formulario.setParameter("area","qualquer");
		this.formulario.setParameter("salario","7900");
		this.formulario.setParameter("dataAdmissao","09/09/2009");
		this.formulario.setParameter("responsavel","fulano");
		this.formulario.setParameter("telefoneResponsavel","(61)9988-7766");
		this.formulario.submit();
		
		this.resp = this.wc.getCurrentPage();
		
		assertTrue(this.resp.getText().contains("cadastrada com Sucesso"));
	}

}

