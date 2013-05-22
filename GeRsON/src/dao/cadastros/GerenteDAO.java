package dao.cadastros;

import javax.persistence.*;
import funcionarios.pf.PessoaFisica;

public class GerenteDAO {

	public GerenteDAO() {

	}

	//Método para cadastrar funcionário!
	public void cadastrarPessoaFisica(PessoaFisica pessoaFisica) {
		//Fazer conexão  com o banco de dados
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Banco");
		//Criar entidade para persistir no banco
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(pessoaFisica);
		em.getTransaction().commit();
	}
}
