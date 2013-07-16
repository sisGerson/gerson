package teste.unitarios;

import static org.junit.Assert.*;

import model.funcionarios.pf.PessoaFisica;

import org.junit.Before;
import org.junit.Test;

import controller.business.BusinessController;
import dao.PesquisaDAO;

public class TestBusinessController {
	BusinessController business = new BusinessController();
	
	@Before
	public void testBusinessController() {
		assertNotNull(business);
	}

	@Test
	public void testIdPessoaFisica() {
		assertNull(business.idPessoaFisica(0));
		
		assertNotNull(business.idPessoaFisica(1));
		PessoaFisica pf = business.idPessoaFisica(1);
		assertEquals(1, pf.getId());
	}
	
	@Test
	public void testIdPessoaJuridica() {
		assertNull(business.idPessoaJuridica(0));
	}
	
	@Test
	public void testSetPessoasFisicas() {
		PesquisaDAO pesquisa = new PesquisaDAO();
		assertNotNull(pesquisa.buscarTodasPessoasFisicas());
		
		business.setPessoasFisicas(pesquisa);
		assertNotNull(business.getPessoasFisicas());
	}
	
	@Test
	public void testSetPessoasJuridicas() {
		PesquisaDAO pesquisa = new PesquisaDAO();
		assertNotNull(pesquisa.buscarTodasPessoasJuridicas());
		
		business.setPessoasJuridicas(pesquisa);
		assertNotNull(business.getPessoasJuridicas());
	}
	
	@Test
	public void testSetPontos() {
		PesquisaDAO pesquisa = new PesquisaDAO();
		assertNotNull(pesquisa.buscarTodosPontos(2));
		
		business.setPontos(pesquisa);
		assertNotNull(business.getPontos());
	}
	
	@Test
	public void testVerificarLogin() {
		assertEquals(0, business.verificarLogin("321", "321"));
		assertEquals(-1, business.verificarLogin("321", "asdf"));
		assertEquals(-2, business.verificarLogin("asdf", "321"));
	}

}
