package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.funcionarios.pf.PessoaFisica;

public class LoginDAO {
	private EntityManagerFactory factory;
	private EntityManager entityManager;
	private Query query;
	
	public LoginDAO() {
		//Fazer conexão  com o banco de dados
		this.factory = Persistence.createEntityManagerFactory("Banco");
		//Criar entidade para persistir no banco
		this.entityManager = this.factory.createEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public PessoaFisica pesquisaFuncionario(String matricula, String senha) {
		this.query = this.entityManager.createQuery("SELECT func FROM PessoaFisica func " +
				"where matricula="+matricula+" and senha="+senha);

		List<PessoaFisica> pessoas = this.query.getResultList();
		
		for (PessoaFisica pessoaFisica : pessoas) {
			return pessoaFisica;
		}
		return null;
	}

}
