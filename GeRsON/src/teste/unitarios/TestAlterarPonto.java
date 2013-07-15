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

import controller.logicas.AlterarPonto;

public class TestAlterarPonto {

	AlterarPonto alterar = new AlterarPonto();
	
	@Before
	public void testAlterarPonto() {
		assertNotNull(alterar);
	}
	@Test
	public void testExecuta() throws Exception {
		HttpServletRequest requestMock = requestMock();  
        alterar.executa(requestMock, responseMock());  
        verify(requestMock);
	}
	
	private HttpServletRequest requestMock() {  
        HttpServletRequest requestMock = createMock(HttpServletRequest.class);  
        expect(requestMock.getParameter("idPonto")).andReturn("1");  
        expect(requestMock.getParameter("data")).andReturn("15/07/2013");
        expect(requestMock.getParameter("horaEntrada")).andReturn("08:00:00");
        expect(requestMock.getParameter("horaInicioAlmoco")).andReturn("12:00:00");
        expect(requestMock.getParameter("horaFimAlmoco")).andReturn("14:00:00");
        expect(requestMock.getParameter("horaSaida")).andReturn("18:00:00");
        expect(requestMock.getRequestDispatcher("/alteracao_ponto.jsp")).  
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
