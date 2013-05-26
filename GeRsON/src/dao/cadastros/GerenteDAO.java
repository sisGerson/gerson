package dao.cadastros;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import funcionarios.pf.PessoaFisica;
import funcionarios.pj.PessoaJuridica;

public class GerenteDAO {
	private EntityManagerFactory factory;
	private EntityManager entityManager;
	private Query query;
	

	public GerenteDAO() {
		//Fazer conexão  com o banco de dados
		this.factory = Persistence.createEntityManagerFactory("Banco");
		//Criar entidade para persistir no banco
		this.entityManager = this.factory.createEntityManager();
		
		this.entityManager.getTransaction().begin();
	}

	//Método para cadastrar PessoaFisica!
	public void cadastrarPessoaFisica(PessoaFisica pessoaFisica) {
		this.entityManager.persist(pessoaFisica);
		this.entityManager.getTransaction().commit();
	}
	
	//Método para cadastrar PessoaJuridica!
	public void cadastrarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.entityManager.persist(pessoaJuridica);
		this.entityManager.getTransaction().commit();
	}
	
	//Método para buscar todas as PessoasFisicas
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> buscarTodasPessoasFisicas(){
		this.query = this.entityManager.createQuery("SELECT func FROM PessoaFisica func");
		return this.query.getResultList();
	}
	
	//Método para buscar todas as PessoasJuridicas
		@SuppressWarnings("unchecked")
		public List<PessoaJuridica> buscarTodasPessoasJuridicas(){
			this.query = this.entityManager.createQuery("SELECT func FROM PessoaJuridica func");
			return this.query.getResultList();
		}
	
}
