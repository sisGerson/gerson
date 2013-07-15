package teste.unitarios;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import controller.logicas.AtualizaPessoaFisica;

public class TestAtualizaPessoaFisica {
	AtualizaPessoaFisica atualiza = new AtualizaPessoaFisica();
	
	@Before
	public void testAtualizaPessoaFisica() {
		assertNotNull(atualiza);
	}
	@Test
	public void testExecuta() throws Exception {
		HttpServletRequest requestMock = requestMock();  
        atualiza.executa(requestMock, responseMock());  
        verify(requestMock);
	}
	
	private HttpServletRequest requestMock() {  
        HttpServletRequest requestMock = createMock(HttpServletRequest.class);  
        expect(requestMock.getParameter("id")).andReturn("2013");  
        expect(requestMock.getParameter("area")).andReturn("7");
        expect(requestMock.getParameter("dataAdmissao")).andReturn("2013");  
        expect(requestMock.getParameter("dataDesligamento")).andReturn("7");
        expect(requestMock.getParameter("status_2")).andReturn("2013");  
        expect(requestMock.getParameter("salario")).andReturn("7");
        expect(requestMock.getParameter("enderecoFuncional")).andReturn("2013");  
        expect(requestMock.getParameter("telefoneComercial")).andReturn("7");
        expect(requestMock.getParameter("Pessoa Física")).andReturn("2013");  
        expect(requestMock.getParameter("nome")).andReturn("7");
        expect(requestMock.getParameter("CPF_CNPJ")).andReturn("2013");  
        expect(requestMock.getParameter("email")).andReturn("7");
        expect(requestMock.getParameter("senha")).andReturn("2013");  
        expect(requestMock.getParameter("CEPFuncional")).andReturn("7");
        expect(requestMock.getParameter("cidadeFuncional")).andReturn("2013");  
        expect(requestMock.getParameter("UFCidadeFuncional")).andReturn("7");
        expect(requestMock.getParameter("cargo")).andReturn("2013");  
        expect(requestMock.getParameter("totalHoraSemanal")).andReturn("7");
        expect(requestMock.getParameter("RG")).andReturn("2013");  
        expect(requestMock.getParameter("orgaoEmissor")).andReturn("7");
        expect(requestMock.getParameter("dataExpedicao")).andReturn("2013");
        expect(requestMock.getParameter("CTPS")).andReturn("2013");
        expect(requestMock.getParameter("PIS")).andReturn("2013");
        expect(requestMock.getParameter("dataNascimento")).andReturn("2013");
        expect(requestMock.getParameter("telefoneCelular")).andReturn("2013");
        expect(requestMock.getParameter("telefoneResidencial")).andReturn("2013");
        expect(requestMock.getParameter("estadoCivil")).andReturn("2013");
        expect(requestMock.getParameter("nacionalidade")).andReturn("2013");
        expect(requestMock.getParameter("naturalidade")).andReturn("2013");
        expect(requestMock.getParameter("altura")).andReturn("2013");
        expect(requestMock.getParameter("peso")).andReturn("2013");
        expect(requestMock.getParameter("corCabelo")).andReturn("2013");
        expect(requestMock.getParameter("corOlhos")).andReturn("2013");
        expect(requestMock.getParameter("racaCor")).andReturn("2013");
        expect(requestMock.getParameter("deficienteFisico")).andReturn("2013");
        expect(requestMock.getParameter("sinaisParticulares")).andReturn("2013");
        expect(requestMock.getParameter("nomeMae")).andReturn("2013");
        expect(requestMock.getParameter("nomePai")).andReturn("2013");
        expect(requestMock.getParameter("nacionalidadeMae")).andReturn("2013");
        expect(requestMock.getParameter("nacionalidadePai")).andReturn("2013");
        expect(requestMock.getParameter("serieCTPS")).andReturn("2013");
        expect(requestMock.getParameter("emissaoCTPS")).andReturn("2013");
        expect(requestMock.getParameter("UFCTPS")).andReturn("2013");
        expect(requestMock.getParameter("tituloEleitoral")).andReturn("2013");
        expect(requestMock.getParameter("zonaTitulo")).andReturn("2013");
        expect(requestMock.getParameter("secaoTitulo")).andReturn("2013");
        expect(requestMock.getParameter("CNH")).andReturn("2013");
        expect(requestMock.getParameter("reservista")).andReturn("2013");
        expect(requestMock.getParameter("grauInstrucao")).andReturn("2013");
        expect(requestMock.getParameter("nomeConjuge")).andReturn("2013");
        expect(requestMock.getParameter("nacionalidadeConjuge")).andReturn("2013");
        expect(requestMock.getParameter("horarioTrabalho")).andReturn("2013");
        expect(requestMock.getParameter("enderecoResidencial")).andReturn("2013");
        expect(requestMock.getParameter("cidadeResidencial")).andReturn("2013");
        expect(requestMock.getParameter("UFResidencial")).andReturn("2013");
        expect(requestMock.getParameter("CEPResidencial")).andReturn("2013");
        
        expect(requestMock.getRequestDispatcher("/alteracao_pessoafisica.jsp")).  
            andReturn(requestDispatcher());  
        replay(requestMock);  
        return requestMock;  
    }
  
    private RequestDispatcher requestDispatcher() {  
        RequestDispatcher dispatcherMock = createNiceMock(RequestDispatcher.class);  
        replay(dispatcherMock);  
        return dispatcherMock;  
    }  
  
    private HttpServletResponse responseMock() throws Exception {  
        HttpServletResponse responseMock = createMock(HttpServletResponse.class);  
        replay(responseMock);  
        return responseMock;  
    }

}
