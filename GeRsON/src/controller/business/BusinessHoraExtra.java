package controller.business;

import model.funcionarios.pf.PessoaFisica;
import model.funcionarios.pf.Ponto;

public class BusinessHoraExtra {
	private double totalHorasTrabalhadas = 0;
	private static BusinessHoraExtra horaExtra;

	public BusinessHoraExtra() {

	}
	
	public double getTotalHorasTrabalhadas() {
		return totalHorasTrabalhadas;
	}

	public static BusinessHoraExtra getHoraExtra() {
		return horaExtra;
	}

	public void setHoraExtra(BusinessHoraExtra horaExtra) {
		BusinessHoraExtra.horaExtra = horaExtra;
	}

	public double getHorasExtras(PessoaFisica pessoaFisica) {
		return this.totalHorasTrabalhadas - pessoaFisica.getTotalHoraSemanal()*4;
	}
	
	public void totalHorasTrabalhadas(Ponto ponto){
		double subTotal = 0;
		
		//Verificar se o funcionário trabalha menos de 40hs semanais
		if(ponto.getHoraInicioAlmoco() == null || ponto.getHoraFimAlmoco() == null) {
			if(ponto.getHoraSaida() != null) {
				subTotal = (double)ponto.getHoraSaida().getTime() - (double)ponto.getHoraEntrada().getTime();
				
				subTotal/=3600000;//resultado do trabalho em horas de um dia
			}
			
			this.totalHorasTrabalhadas+=subTotal;
		}
		
		//Verificar se o funcionário trabalha 40hs semanais
		else {
			if(ponto.getHoraSaida() != null && ponto.getHoraInicioAlmoco() != null
					&& ponto.getHoraFimAlmoco() != null) {
				
				subTotal = (double)ponto.getHoraInicioAlmoco().getTime() - (double)ponto.getHoraEntrada().getTime() +
						(double)ponto.getHoraSaida().getTime() - (double)ponto.getHoraFimAlmoco().getTime();
				
				subTotal/=3600000;//resultado do trabalho em horas de um dia
			}
			
			this.totalHorasTrabalhadas+=subTotal;
		}
	}
}
