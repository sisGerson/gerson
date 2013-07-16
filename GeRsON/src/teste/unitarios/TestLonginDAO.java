package teste.unitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.LoginDAO;

public class TestLonginDAO {
	LoginDAO login = new LoginDAO();

	@Before
	public void testLoginDAO() {
		assertNotNull(login);
	}

	@Test
	public void testPesquisaFuncionario() {
		assertNotNull(login.pesquisaFuncionario("321", "321"));
		assertNull(login.pesquisaFuncionario("3321", "321"));
	}
}
