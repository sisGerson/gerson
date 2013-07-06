package controller.business;

import java.util.Date;
import java.util.List;

import dao.PesquisaDAO;

import model.funcionarios.pf.Ferias;
import model.funcionarios.pf.PessoaFisica;

public class BusinessFerias {
	private boolean pedidoFerias = false;
	private Ferias[] pedidosAtivos = {};
	private PessoaFisica[] pedidosAceitos = {};
	private double periodoTrabalhado;
	private String resultadoPedido;
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
	
	public PessoaFisica[] getPedidosAceitos() {
		return pedidosAceitos;
	}

	public String getResultadoPedido() {
		return resultadoPedido;
	}

	public void pedidoFeriasPermitido(PessoaFisica pessoaFisica, Date data){
		if(pessoaFisica.getUltimasFerias() == null){
			if((data.getTime() - pessoaFisica.getDataAdmissao().getTime())/3600000 >=1){
				this.periodoTrabalhado = (data.getTime() - pessoaFisica.getDataAdmissao().getTime())/3600000;
				this.pedidoFerias = true;
			}
		}
		else{
			if((data.getTime() - pessoaFisica.getUltimasFerias().getTime())/3600000 >=1){
				this.periodoTrabalhado = (data.getTime() - pessoaFisica.getUltimasFerias().getTime())/3600000;
				this.pedidoFerias = true;
			}
		}
		this.periodoTrabalhado/=8640;
	}
	
	private void adicionarFerias(Ferias ferias){
		Ferias[] novaFerias = new Ferias[this.pedidosAtivos.length+1];
		
		for(int i=0;i<this.pedidosAtivos.length;i++){
			novaFerias[i] = this.pedidosAtivos[i];
		}
		novaFerias[this.pedidosAtivos.length] = ferias;
		this.pedidosAtivos = novaFerias;
	}
	
	private void adicionarFeriasAceitas(PessoaFisica pessoaFisica){
		PessoaFisica[] novaPessoa = new PessoaFisica[this.pedidosAceitos.length+1];
		
		for(int i=0;i<this.pedidosAceitos.length;i++){
			novaPessoa[i] = this.pedidosAceitos[i];
		}
		novaPessoa[this.pedidosAceitos.length] = pessoaFisica;
		this.pedidosAceitos = novaPessoa;
	}
	
	public void buscarPedidos(){
		PesquisaDAO pesquisa = new PesquisaDAO();
		
		List<Ferias> pedidos = pesquisa.buscarTodosPedidosFerias();
		
		for (Ferias ferias : pedidos) {
			if(ferias.getResultado().equals("Aguarde")){
				adicionarFerias(ferias);
			}
			else if(ferias.getResultado().equals("Aprovado")) {
				PessoaFisica pessoaFisica = pesquisa.getIdPessoaFisica(ferias.getIdFuncionario());
				adicionarFeriasAceitas(pessoaFisica);
			}
		}
	}
	
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
