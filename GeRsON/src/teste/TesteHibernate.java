package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import funcionarios.pj.PessoaJuridica;

public class TesteHibernate {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Banco");
		EntityManager em = factory.createEntityManager();
		
		PessoaJuridica p = new PessoaJuridica();
		p.setResponsavel("Jefferson");
		p.setTelefoneResponsavel("3333-4444");
		p.setDescricaoServico("Engenheiro");
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
}
