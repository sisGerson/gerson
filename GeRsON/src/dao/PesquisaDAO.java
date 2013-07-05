package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import controller.business.BusinessHoraExtra;

import model.funcionarios.pf.Ferias;
import model.funcionarios.pf.PessoaFisica;
import model.funcionarios.pf.Ponto;
import model.funcionarios.pj.PessoaJuridica;

public class PesquisaDAO {
	private EntityManagerFactory factory;
	private EntityManager entityManager;
	private Query query;
	private PessoaFisica[] pessoasFisicas = {};
	private PessoaJuridica[] pessoasJuridicas = {};
	private Ponto[] pontos = {};	

	public PesquisaDAO() {
		//Fazer conexão  com o banco de dados
		this.factory = Persistence.createEntityManagerFactory("Banco");
		//Criar entidade para persistir no banco
		this.entityManager = this.factory.createEntityManager();
		
		this.entityManager.getTransaction().begin();
	}
	
	public Ponto[] getPontos() {
		return pontos;
	}

	public PessoaFisica[] getPessoasFisicas() {
		return pessoasFisicas;
	}

	public PessoaJuridica[] getPessoasJuridicas() {
		return pessoasJuridicas;
	}
	
	//Recuperar id de pessoaFisica
	public PessoaFisica getIdPessoaFisica(int id){
		PessoaFisica pessoaFisica = this.entityManager.find(PessoaFisica.class, id);
		return pessoaFisica;
	}
	
	//Recuperar id de pessoaJuridica
	public PessoaJuridica getIdpessoaJuridica(int id){
		PessoaJuridica pessoaJuridica = this.entityManager.find(PessoaJuridica.class, id);
		return pessoaJuridica;
	}
	
	//Recuperar id de ponto
	public Ponto getIdPonto(int id){
		Ponto ponto = this.entityManager.find(Ponto.class, id);
		return ponto;
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
	
	//Método para buscar todos os pedidos de férias
	@SuppressWarnings("unchecked")
	public List<Ferias> buscarTodosPedidosFerias(){
		this.query = this.entityManager.createQuery("SELECT func FROM Ferias func");
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
			if((nome == "" || pessoa.getNome().toUpperCase().startsWith(nome)) &&
					(matricula == "" || pessoa.getMatricula().toUpperCase().startsWith(matricula)) &&
					(cargo == "" || pessoa.getCargo().toUpperCase().startsWith(cargo)) &&
					(area == "" || pessoa.getArea().toUpperCase().startsWith(area)) &&
					(CPF == "" || pessoa.getCPF_CNPJ().toUpperCase().startsWith(CPF))){
				
				adicionarPessoaFisica(pessoa);
			}
		}
	}
	
	//Método para pesquisar pessoa jurídica
	public void pesquisarPessoaJuridica(String empresa, String matricula, String area, String CNPJ,
			String responsavel){
		List<PessoaJuridica> pessoaJuridica = buscarTodasPessoasJuridicas();
		
		for (PessoaJuridica pessoa : pessoaJuridica) {
			if((empresa == "" || pessoa.getNome().toUpperCase().startsWith(empresa)) &&
					(matricula == "" || pessoa.getMatricula().toUpperCase().startsWith(matricula)) &&
					(area == "" || pessoa.getArea().toUpperCase().startsWith(area)) &&
					(CNPJ == "" || pessoa.getCPF_CNPJ().toUpperCase().startsWith(CNPJ)) &&
					(responsavel == "" || pessoa.getResponsavel().toUpperCase().startsWith(responsavel))){
				
				adicionarPessoaJuridica(pessoa);
			}
		}
	}
	
	//Método para alterar PessoaFisica!
	public void alterarPessoaFisica(PessoaFisica pessoaFisica) {
		this.entityManager.persist(pessoaFisica);
		this.entityManager.getTransaction().commit();
	}
	
	//Método para alterar PessoaJuridica!
	public void alterarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.entityManager.persist(pessoaJuridica);
		this.entityManager.getTransaction().commit();
	}
	
	public void alterarPonto(Ponto ponto){
		this.entityManager.persist(ponto);
		this.entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ponto> buscarTodosPontos(int idFuncionario){
		this.query = this.entityManager.createQuery("SELECT pont FROM Ponto pont where idFuncionario="+idFuncionario);
		return this.query.getResultList();
	}
	
	//Método adicionar ponto
	private void adicionarPonto(Ponto ponto) {
		Ponto[] novoPonto = new Ponto[this.pontos.length+1];
		
		for(int i=0;i<this.pontos.length;i++){
			novoPonto[i] = this.pontos[i];
		}
		novoPonto[this.pontos.length] = ponto;
		this.pontos = novoPonto;
	}
	
	//Método que retorna os pontos pesquisados
	public void solicitarFolhaPonto(String ano, String mes, int idFuncionario, int totalHoraSemanal){
		List<Ponto> pontos = buscarTodosPontos(idFuncionario);
		
		BusinessHoraExtra horaExtra = new BusinessHoraExtra();
		horaExtra.setHoraExtra(horaExtra);
		
		for (Ponto ponto : pontos) {
			String data = ponto.getData().toString();
			
			if(data.startsWith(ano+"-"+mes)) {
				adicionarPonto(ponto);
				horaExtra.totalHorasTrabalhadas(ponto);
			}
		}
	}
}
