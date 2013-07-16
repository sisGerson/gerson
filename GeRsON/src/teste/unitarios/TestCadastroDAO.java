package teste.unitarios;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;
import java.util.List;

import model.funcionarios.pf.Ferias;
import model.funcionarios.pf.PessoaFisica;
import model.funcionarios.pf.Ponto;
import model.funcionarios.pj.PessoaJuridica;

import org.junit.Test;

import dao.CadastroDAO;
import dao.PesquisaDAO;

public class TestCadastroDAO {
	CadastroDAO cadastro = new CadastroDAO();

	@Test
	public void testCadastroDAO() {
		assertNotNull(cadastro);
	}

	@Test
	public void testCadastrarPessoaFisica() {
		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setNome("Teste");
		cadastro.cadastrarPessoaFisica(pessoaFisica);
		
		PesquisaDAO pesquisa = new PesquisaDAO();
		List<PessoaFisica> todasPessoas = pesquisa.buscarTodasPessoasFisicas();
		
		boolean result = false;
		
		for (PessoaFisica pessoas : todasPessoas) {
			if(pessoas.getNome().equals("Teste"))
				result = true;
		}
		
		assertTrue(result);
	}

	@Test
	public void testCadastrarPessoaJuridica() {
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setNome("Teste");
		cadastro.cadastrarPessoaJuridica(pessoaJuridica);
		
		PesquisaDAO pesquisa = new PesquisaDAO();
		List<PessoaJuridica> todasPessoas = pesquisa.buscarTodasPessoasJuridicas();
		
		boolean result = false;
		
		for (PessoaJuridica pessoas : todasPessoas) {
			if(pessoas.getNome().equals("Teste"))
				result = true;
		}
		
		assertTrue(result);
		
		pessoaJuridica.setNome("Ateração do Teste");
		pesquisa.alterarPessoaJuridica(pessoaJuridica);
		
		boolean result2 = false;
		
		for (PessoaJuridica pessoas : todasPessoas) {
			if(pessoas.getNome().equals("Ateração do Teste"))
				result2 = true;
		}
		
		assertTrue(result2);
	}

	@Test
	public void testCadastrarPonto() {
		GregorianCalendar calendario = new GregorianCalendar();
		
		Ponto ponto = new Ponto();
		ponto.setOpcao("Teste");
		ponto.setIdFuncionario(1);
		ponto.setData(calendario.getTime());
		cadastro.cadastrarPonto(ponto);
		
		PesquisaDAO pesquisa = new PesquisaDAO();
		List<Ponto> todosPontos = pesquisa.buscarTodosPontos(1);
		
		boolean result = false;
		
		for (Ponto pontos : todosPontos) {
			if(pontos.getOpcao().equals("Teste"))
				result = true;
		}
		
		assertTrue(result);
		
		pesquisa.solicitarFolhaPonto("2013", "7", 1, 20);
		assertNotNull(pesquisa.getPontos());
	}

	@Test
	public void testCadastrarFerias() {
		Ferias ferias = new Ferias();
		ferias.setResultado("Teste");
		cadastro.cadastrarFerias(ferias);
		
		PesquisaDAO pesquisa = new PesquisaDAO();
		List<Ferias> todasFerias = pesquisa.buscarTodosPedidosFerias();
		
		boolean result = false;
		
		for (Ferias ferias2 : todasFerias) {
			if(ferias2.getResultado().equals("Teste"))
				result = true;
		}
		
		assertTrue(result);
	}

}
