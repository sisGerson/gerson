package teste;

import java.util.*;

import dao.cadastros.GerenteDAO;

import funcionarios.Funcionario;

public class TesteHibernate {
	
	public static void main(String[] args) {
		/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("Banco");
		EntityManager em = factory.createEntityManager();*/
		
		/*
		PessoaJuridica p = new PessoaJuridica();
		p.setResponsavel("Isaac");
		p.setTelefoneResponsavel("3333-4444");
		p.setDescricaoServico("Engenheiro");
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		*/
		
		//Teste da listagem de todos os funcionários
		GerenteDAO dao = new GerenteDAO();
		List<Funcionario> funcionarios = dao.buscarTodosFuncionarios();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: "+ funcionario.getNome());
		}
	}
}
