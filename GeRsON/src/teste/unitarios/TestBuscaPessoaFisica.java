package teste.unitarios;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNotNull;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import controller.logicas.BuscaPessoaFisica;

public class TestBuscaPessoaFisica {

	BuscaPessoaFisica busca = new BuscaPessoaFisica();
	
	@Before
	public void testTestVisualizarHoraExtra() {
		assertNotNull(busca);
	}

	@Test
	public void testExecuta() throws Exception {
		HttpServletRequest requestMock = requestMock();  
        busca.executa(requestMock, responseMock());  
        verify(requestMock);
	}
	
	private HttpServletRequest requestMock() {  
        HttpServletRequest requestMock = createMock(HttpServletRequest.class);  
        expect(requestMock.getParameter("nome")).andReturn("");  
        expect(requestMock.getParameter("matricula")).andReturn("");  
        expect(requestMock.getParameter("cargo")).andReturn("");  
        expect(requestMock.getParameter("area")).andReturn("");  
        expect(requestMock.getParameter("cpf")).andReturn("");  
        expect(requestMock.getRequestDispatcher("/resultado_busca_pessoafisica.jsp")).  
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
