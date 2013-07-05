package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.funcionarios.pf.Ferias;
import model.funcionarios.pf.PessoaFisica;
import model.funcionarios.pf.Ponto;
import model.funcionarios.pj.PessoaJuridica;

public class CadastroDAO {
	private EntityManagerFactory factory;
	private EntityManager entityManager;

	public CadastroDAO() {
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
	
	//Método para cadastrar Ponto de Pessoa Fisica!
	public void cadastrarPonto(Ponto ponto) {
		this.entityManager.persist(ponto);
		this.entityManager.getTransaction().commit();		
	}
	public void cadastrarFerias(Ferias ferias) {
		this.entityManager.persist(ferias);
		this.entityManager.getTransaction().commit();		
	}
	
}