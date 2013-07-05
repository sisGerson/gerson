package controller.business;

import java.util.Date;
import java.util.List;

import dao.PesquisaDAO;

import model.funcionarios.pf.Ferias;
import model.funcionarios.pf.PessoaFisica;

public class BusinessFerias {
	private boolean pedidoFerias = false;
	private Ferias[] pedidosAtivos = {};
	private double periodoTrabalhado;
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
		System.out.println(this.periodoTrabalhado+"\n\n\n\n\n\n");
	}
	
	private void adicionarFerias(Ferias ferias){
		Ferias[] novaFerias = new Ferias[this.pedidosAtivos.length+1];
		
		for(int i=0;i<this.pedidosAtivos.length;i++){
			novaFerias[i] = this.pedidosAtivos[i];
		}
		novaFerias[this.pedidosAtivos.length] = ferias;
		this.pedidosAtivos = novaFerias;
	}
	
	public void buscarPedidosAtivos(){
		PesquisaDAO pesquisa = new PesquisaDAO();
		
		List<Ferias> pedidos = pesquisa.buscarTodosPedidosFerias();
		
		for (Ferias ferias : pedidos) {
			if(ferias.getResultado().equals("Aguarde")){
				adicionarFerias(ferias);
			}
		}
	}
	
}
