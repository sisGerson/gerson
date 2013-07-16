package teste.unitarios;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import controller.logicas.ResultadoFerias;

public class TestResultadoFerias {

	ResultadoFerias resultado = new ResultadoFerias();
	
	@Before
	public void testResultadoFerias() {
		assertNotNull(resultado);
	}

	@Test
	public void testExecuta1() throws Exception {
		HttpServletRequest requestMock = requestMock1();  
        resultado.executa(requestMock, responseMock());  
        verify(requestMock);
	}
	@Test
	public void testExecuta2() throws Exception{
		HttpServletRequest requestMock = requestMock2();  
        resultado.executa(requestMock, responseMock());  
        verify(requestMock);
	}
	private HttpServletRequest requestMock1() {  
        HttpServletRequest requestMock = createMock(HttpServletRequest.class);  
        expect(requestMock.getParameter("resultado")).andReturn("Sim");  
        expect(requestMock.getParameter("idFerias")).andReturn("1");  
        expect(requestMock.getRequestDispatcher("/index.jsp?item=24&situacao=2")).  
            andReturn(requestDispatcher());  
        replay(requestMock);  
        return requestMock;  
    }
	
	private HttpServletRequest requestMock2() {  
        HttpServletRequest requestMock = createMock(HttpServletRequest.class);  
        expect(requestMock.getParameter("resultado")).andReturn("Não");  
        expect(requestMock.getParameter("idFerias")).andReturn("1");  
        expect(requestMock.getRequestDispatcher("/index.jsp?item=24&situacao=2")).  
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
