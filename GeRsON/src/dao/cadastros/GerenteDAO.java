package dao.cadastros;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.funcionarios.pf.PessoaFisica;
import model.funcionarios.pj.PessoaJuridica;

public class GerenteDAO {
	private EntityManagerFactory factory;
	private EntityManager entityManager;
	private Query query;
	private PessoaFisica[] pessoasFisicas = {};
	private PessoaJuridica[] pessoasJuridicas = {};
	

	public GerenteDAO() {
		//Fazer conexão  com o banco de dados
		this.factory = Persistence.createEntityManagerFactory("Banco");
		//Criar entidade para persistir no banco
		this.entityManager = this.factory.createEntityManager();
		
		this.entityManager.getTransaction().begin();
	}

	public PessoaFisica[] getPessoasFisicas() {
		return pessoasFisicas;
	}

	public PessoaJuridica[] getPessoasJuridicas() {
		return pessoasJuridicas;
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
	
	//Método para adicionar pessoa física
	private void adicionarPessoaFisica(PessoaFisica pessoaFisica){
		PessoaFisica[] novaPessoaFisica = new PessoaFisica[this.pessoasFisicas.length+1];
		
		for(int i=0;i<this.pessoasFisicas.length;i++){
			novaPessoaFisica[i] = this.pessoasFisicas[i];
		}
		novaPessoaFisica[this.pessoasFisicas.length] = pessoaFisica;
		this.pessoasFisicas = novaPessoaFisica;
	}
	
	//Método para adicionar pessoa juridica
	private void adicionarPessoaJuridica(PessoaJuridica pessoaJuridica){
		PessoaJuridica[] novaPessoaJuridica = new PessoaJuridica[this.pessoasJuridicas.length+1];
		
		for(int i=0;i<this.pessoasJuridicas.length;i++){
			novaPessoaJuridica[i] = this.pessoasJuridicas[i];
		}
		novaPessoaJuridica[this.pessoasJuridicas.length] = pessoaJuridica;
		this.pessoasJuridicas = novaPessoaJuridica;
	}
	
	//Método para pesquisar pessoa fisica
	public void pesquisarPessoaFisica(String nome, String matricula, String cargo, String area,
			String CPF){
		List<PessoaFisica> pessoaFisica = buscarTodasPessoasFisicas();
		
		for (PessoaFisica pessoa : pessoaFisica) {
			if((nome == "" || pessoa.getNome().equalsIgnoreCase(nome)) &&
					(matricula == "" || pessoa.getMatricula().equalsIgnoreCase(matricula)) &&
					(cargo == "" || pessoa.getCargo().equalsIgnoreCase(cargo)) &&
					(area == "" || pessoa.getArea().equalsIgnoreCase(area)) &&
					(CPF == "" || pessoa.getCPF_CNPJ().equalsIgnoreCase(CPF))){
				
				adicionarPessoaFisica(pessoa);
			}
		}
	}
	
	//Método para pesquisar pessoa jurídica
	public void pesquisarPessoaJuridica(String empresa, String matricula, String area, String CNPJ,
			String responsavel){
		List<PessoaJuridica> pessoaJuridica = buscarTodasPessoasJuridicas();
		
		for (PessoaJuridica pessoa : pessoaJuridica) {
			if((empresa == "" || pessoa.getNome().equalsIgnoreCase(empresa)) &&
					(matricula == "" || pessoa.getMatricula().equalsIgnoreCase(matricula)) &&
					(area == "" || pessoa.getArea().equalsIgnoreCase(area)) &&
					(CNPJ == "" || pessoa.getCPF_CNPJ().equalsIgnoreCase(CNPJ)) &&
					(responsavel == "" || pessoa.getResponsavel().equalsIgnoreCase(responsavel))){
				
				adicionarPessoaJuridica(pessoa);
			}
		}
	}
}
