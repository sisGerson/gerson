package teste;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebResponse;

public class CadastroPessoaFisicaTest {
	
	public String url = "localhost:8080/GeRsON/";
	private WebConversation wc;
	private WebResponse resp;
	private WebForm formulario;
	private WebForm form;
	private WebLink link;
	
	
	@Test
	public void testCadastroPessoaFisica() throws IOException, SAXException {
		this.wc = new WebConversation();
		
		this.resp = this.wc.getResponse(this.url+"index.jsp");
		this.resp.close();
	}

	@Test
	public void testExecuta1() throws SAXException, IOException {
		this.wc = new WebConversation();
		this.resp = this.wc.getResponse(this.url + "login.jsp");
		this.formulario = this.resp.getForms()[0];
		
		//logando como gerente
		if(this.formulario.hasParameterNamed("matricula"))
			this.formulario.setParameter("matricula", "123");
		
		if(this.formulario.hasParameterNamed("senha"))
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
		assertEquals(this.link.getText(), "Ponto");
		
		this.link = this.resp.getLinks()[6];
		assertEquals(this.link.getText(), "Sair");
		//this.link.click();
		//resp = wc.getCurrentPage();
		
		//assertEquals(resp.getText(), "");
	}
	
	@Test
	public void testExecuta2() throws IOException, SAXException{
		//colocando valores para os campos do formulario
		form.setParameter("status_2","Ativo");
		form.setParameter("nome","Ciclano de tal");
		form.setParameter("email","ciclano@gmail.com");
		form.setParameter("nacionalidade","brasil");
		form.setParameter("naturalidade","brasilia");
		form.setParameter("estadoCivil","solteiro");
		form.setParameter("racaCor","negro");
		form.setParameter("peso","76");
		form.setParameter("altura","190");
		form.setParameter("corOlhos","castanhos");
		form.setParameter("corCabelo","pretos");
		form.setParameter("grauInstrucao","Segundo grau");
		form.setParameter("CPF_CNPJ","789.678.456-56");
		form.setParameter("RG","123454");
		form.setParameter("orgaoEmissor","SSP-DF");
		form.setParameter("dataExpedicao","12/01/2003");
		form.setParameter("CTPS","347657");
		form.setParameter("serieCTPS","001");
		form.setParameter("UFCTPS","01");
		form.setParameter("emissaoCTPS","23/02/2002");
		form.setParameter("tituloEleitoral","098765");
		form.setParameter("zonaTitulo","002");
		form.setParameter("secaoTitulo","07");
		form.setParameter("enderecoResidencial","edificio plaza, brasilia");
		form.setParameter("cidadeResidencial","asa sul");
		form.setParameter("UFResidencial","DF");
		form.setParameter("CEPResidencial","12345-987");
		form.setParameter("matricula","123");
		form.setParameter("senha","123");
		form.setParameter("dataAdmissao","08/08/2004");
		form.setParameter("salario","1234");
		form.setParameter("cargo","Gerente");
		form.setParameter("horarioTrabalho","diurno");
		form.setParameter("totalHoraSemanal","20");
		//submetendo o formulario
		form.submit();
		
		//pegando a pagina atual do browser
		resp = wc.getCurrentPage();
		
		//fazendo a verificação se o usuario foi cadastrado
		assertTrue(resp.getText().contains("cadastrado com Sucesso"));
	}

}
