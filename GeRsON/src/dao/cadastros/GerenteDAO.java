package dao.cadastros;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import funcionarios.pf.PessoaFisica;
import funcionarios.pj.PessoaJuridica;

public class GerenteDAO {

	public GerenteDAO() {

	}

	//Método para cadastrar PessoaFisica!
	public void cadastrarPessoaFisica(PessoaFisica pessoaFisica) {
		//Fazer conexão  com o banco de dados
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Banco");
		//Criar entidade para persistir no banco
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(pessoaFisica);
		em.getTransaction().commit();
	}
	
	//Método para cadastrar PessoaJuridica
	public void cadastrarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		//Fazer conexão  com o banco de dados
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Banco");
		//Criar entidade para persistir no banco
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(pessoaJuridica);
		em.getTransaction().commit();
	}
}
