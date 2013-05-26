package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.cadastros.GerenteDAO;
import funcionarios.pj.PessoaJuridica;

public class TesteHibernate {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Banco");
		EntityManager em = factory.createEntityManager();
		
		
		PessoaJuridica p = new PessoaJuridica();
		p.setNome("teste");
		p.setDescricaoServico("testa");
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		
		//Teste da listagem de todos os funcionários
		GerenteDAO dao = new GerenteDAO();
		List<PessoaJuridica> funcionarios = dao.buscarTodasPessoasJuridicas();
		
		for (PessoaJuridica funcionario : funcionarios) {
			System.out.println("Nome: "+ funcionario.getNome());
		}
	}
}
