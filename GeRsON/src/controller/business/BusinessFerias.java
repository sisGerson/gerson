package controller.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import dao.PesquisaDAO;

import model.funcionarios.pf.Ferias;
import model.funcionarios.pf.PessoaFisica;

public class BusinessFerias {
	private boolean pedidoFerias = false;
	private Ferias[] pedidosAtivos = {};
	private PessoaFisica[] funcionariosFerias = {};
	private PessoaFisica[] funcionariosTirarFerias = {};
	private double periodoTrabalhado = 0;
	private String resultadoPedido = "Sem pedidos";
	public BusinessFerias() {

	}
	
	public boolean isPedidoFerias() {
		return pedidoFerias;
	}
	
	public double getPeriodoTrabalhado() {
		return periodoTrabalhado;
	}

	public Ferias[] getPedidosAtivos() {
		return pedidosAtivos;
	}
	
	public PessoaFisica[] getFuncionariosFerias() {
		return funcionariosFerias;
	}

	public PessoaFisica[] getFuncionariosTirarFerias() {
		return funcionariosTirarFerias;
	}

	public String getResultadoPedido() {
		return resultadoPedido;
	}
	
	//Método que verifica se o funcionário pode ou não pedir férias, e retorna também o periodo trabalhado
	public void pedidoFeriasPermitido(PessoaFisica pessoaFisica, Date data){
		if(pessoaFisica.getUltimasFerias() == null){
			if((data.getTime() - pessoaFisica.getDataAdmissao().getTime())/3600000 >=1){
				this.periodoTrabalhado = (data.getTime() - pessoaFisica.getDataAdmissao().getTime())/3600000;
				
				//Verificar se o periodoTrabalhado em anos é maior que um
				if(this.periodoTrabalhado/8640 > 1)
					this.pedidoFerias = true;
			}
		}
		else{
			if((data.getTime() - pessoaFisica.getUltimasFerias().getTime())/3600000 >=1){
				this.periodoTrabalhado = (data.getTime() - pessoaFisica.getUltimasFerias().getTime())/3600000;
				
				//Verificar se o periodoTrabalhado em anos é maior que um
				if(this.periodoTrabalhado/8640 > 1)
					this.pedidoFerias = true;
			}
		}
		//Cálculo para deixar o periodoTrabalhado que estava em horas em anos
		this.periodoTrabalhado/=8640;
	}
	
	//Método para popular o vetor de férias pedidos ativos
	private void adicionarFerias(Ferias ferias){
		Ferias[] novaFerias = new Ferias[this.pedidosAtivos.length+1];
		
		for(int i=0;i<this.pedidosAtivos.length;i++){
			novaFerias[i] = this.pedidosAtivos[i];
		}
		novaFerias[this.pedidosAtivos.length] = ferias;
		this.pedidosAtivos = novaFerias;
	}
	
	//Método para popular o vetor de funcionários que estão de férias
	private void adicionarFuncionariosFerias(PessoaFisica pessoaFisica){
		PessoaFisica[] novaPessoa = new PessoaFisica[this.funcionariosFerias.length+1];
		
		for(int i=0;i<this.funcionariosFerias.length;i++){
			novaPessoa[i] = this.funcionariosFerias[i];
		}
		novaPessoa[this.funcionariosFerias.length] = pessoaFisica;
		this.funcionariosFerias = novaPessoa;
	}
	
	//Método para popular o vetor de funcionários que irão de férias
		private void adicionarFuncionariosTirarFerias(PessoaFisica pessoaFisica){
			PessoaFisica[] novaPessoa = new PessoaFisica[this.funcionariosTirarFerias.length+1];
			
			for(int i=0;i<this.funcionariosTirarFerias.length;i++){
				novaPessoa[i] = this.funcionariosTirarFerias[i];
			}
			novaPessoa[this.funcionariosTirarFerias.length] = pessoaFisica;
			this.funcionariosTirarFerias = novaPessoa;
		}
	
	/**
	 * Método que busca dentre todos os pedidos os que então em aguarde ou que foram aprovados
	 * para se ter os dois vetores populados: pedidosAtivos e pedidosAceitos
	 * @throws ParseException 
	 */
	public void buscarPedidos() throws ParseException{
		PesquisaDAO pesquisa = new PesquisaDAO();
		
		List<Ferias> pedidos = pesquisa.buscarTodosPedidosFerias();
		
		for (Ferias ferias : pedidos) {
			if(ferias.getResultado().equals("Aguarde")){
				adicionarFerias(ferias);
			}
		}
	}
	/*
	 * @throws ParseException
	 */
	public void buscarTirarFuncionariosFerias() throws ParseException{
		PesquisaDAO pesquisa = new PesquisaDAO();
		
		List<Ferias> pedidos = pesquisa.buscarTodosPedidosFerias();
		
		for (Ferias ferias : pedidos) {
			
			GregorianCalendar calendario = new GregorianCalendar();
			ferias.setDataTemp(calendario.getTime());//tem q criar esse temporario para converter a data no formato certo
			System.out.println(ferias.getDataRetorno());
			System.out.println(ferias.getDataTemp()+"\n\n\n\n\n\n\n\n\n\n\n\n");
			
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd"); 
			String dataFormatada = formatador.format(ferias.getDataTemp());
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date minhaData = format.parse(dataFormatada);
			
			if(ferias.getResultado().equals("Aprovado") && ferias.getDataPedido().after(minhaData)) {
				PessoaFisica pessoaFisica = pesquisa.getIdPessoaFisica(ferias.getIdFuncionario());
				adicionarFuncionariosTirarFerias(pessoaFisica);
			}
		}
	}
	
	/*
	 * @throws ParseException
	 */
	public void buscarFuncionariosFerias() throws ParseException{
		PesquisaDAO pesquisa = new PesquisaDAO();
		
		List<Ferias> pedidos = pesquisa.buscarTodosPedidosFerias();
		
		for (Ferias ferias : pedidos) {
			
			GregorianCalendar calendario = new GregorianCalendar();
			ferias.setDataTemp(calendario.getTime());//tem q criar esse temporario para converter a data no formato certo
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd"); 
			String dataFormatada = formatador.format(ferias.getDataTemp());
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date minhaData = format.parse(dataFormatada);
			
			if(ferias.getResultado().equals("Aprovado") && ferias.getDataPedido().before(minhaData)) {
				
				if(ferias.getDataRetorno().after(minhaData)){
					PessoaFisica pessoaFisica = pesquisa.getIdPessoaFisica(ferias.getIdFuncionario());
					adicionarFuncionariosFerias(pessoaFisica);
				}
				else{
					ferias.setResultado("Retorno");
					pesquisa.alterarFerias(ferias);
				}
			}
		}
	}
	
	//Método que retorna para o funcionário a situação do seu pedido de férias
	public void verificarPedido(PessoaFisica pessoaFisica) {
		PesquisaDAO pesquisa = new PesquisaDAO();
		
		List<Ferias> pedidos = pesquisa.buscarTodosPedidosFerias();
		
		for (Ferias ferias : pedidos) {
			if(ferias.getIdFuncionario() == pessoaFisica.getId()) {
				this.resultadoPedido = ferias.getResultado();
			}
		}
	}
	
}
