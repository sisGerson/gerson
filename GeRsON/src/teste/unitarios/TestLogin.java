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

import controller.logicas.Login;

public class TestLogin {

	Login login = new Login();
	@Before
	public void testLogin() {
		assertNotNull(login);
	}

	@Test
	public void testExecuta1() throws Exception {
		HttpServletRequest requestMock = requestMock1();  
        login.executa(requestMock, responseMock());  
        verify(requestMock);
	}
	
	@Test
	public void testExecuta2() throws Exception {
		HttpServletRequest requestMock = requestMock2();  
        login.executa(requestMock, responseMock());  
        verify(requestMock);
	}
	
	@Test
	public void testExecuta3() throws Exception {
		HttpServletRequest requestMock = requestMock3();
		expect(requestMock.getAttribute("funcionario")).andReturn(null);
        login.executa(requestMock, responseMock());  
        verify(requestMock);
	}
	
	private HttpServletRequest requestMock1() {  
        HttpServletRequest requestMock = createMock(HttpServletRequest.class);  
        expect(requestMock.getParameter("matricula")).andReturn("123");  
        expect(requestMock.getParameter("senha")).andReturn("321");  
        expect(requestMock.getRequestDispatcher("/index.jsp?situacao=0")).  
            andReturn(requestDispatcher());  
        replay(requestMock);  
        return requestMock;  
    }
	
	private HttpServletRequest requestMock2() {  
        HttpServletRequest requestMock = createMock(HttpServletRequest.class);  
        expect(requestMock.getParameter("matricula")).andReturn("3212");  
        expect(requestMock.getParameter("senha")).andReturn("123");  
        expect(requestMock.getRequestDispatcher("/index.jsp?situacao=1")).  
            andReturn(requestDispatcher());  
        replay(requestMock);  
        return requestMock;  
    }
	
	private HttpServletRequest requestMock3() {  
        HttpServletRequest requestMock = createMock(HttpServletRequest.class);  
        expect(requestMock.getParameter("matricula")).andReturn("123");  
        expect(requestMock.getParameter("senha")).andReturn("123");  
        expect(requestMock.getRequestDispatcher("/index.jsp?situacao=2")).  
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
