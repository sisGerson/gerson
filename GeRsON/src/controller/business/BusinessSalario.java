package controller.business;

public class BusinessSalario {
	
	private double INSS, impostoRenda, planoSaude, outrosImpostos, salarioHorasTrabalhadas, salarioLiquido, descontos;
	
	public BusinessSalario() {
	
	}
	
	public double getINSS() {
		return INSS;
	}

	public double getImpostoRenda() {
		return impostoRenda;
	}

	public double getPlanoSaude() {
		return planoSaude;
	}

	public double getOutrosImpostos() {
		return outrosImpostos;
	}

	public double getSalarioHorasTrabalhadas() {
		return salarioHorasTrabalhadas;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}
	
	public double getDescontos() {
		return descontos;
	}

	public void calculoSalario(double salarioBruto, double horasTrabalhadas, int horaSemanal) {
		int horarioMensal = horaSemanal*4;
		double salarioHora = salarioBruto/(double)horarioMensal;
		
		this.salarioHorasTrabalhadas = salarioHora*horasTrabalhadas;
		this.INSS = this.salarioHorasTrabalhadas*0.08;
		this.impostoRenda = this.salarioHorasTrabalhadas*0.07;
		this.planoSaude = 100.00;
		this.outrosImpostos = this.salarioHorasTrabalhadas*0.05;
		
		this.salarioLiquido = this.salarioHorasTrabalhadas - this.INSS - this.impostoRenda - this.planoSaude - this.outrosImpostos;
		this.descontos = this.salarioHorasTrabalhadas - this.salarioLiquido;
	}

}
