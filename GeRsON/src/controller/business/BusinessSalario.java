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
		
		//plano de saúde fixo
		this.planoSaude = 100.00;
		
		//calculo do INSS
		if(salarioBruto < 1247.71){
			this.INSS = this.salarioHorasTrabalhadas*0.08;
		}else if(salarioBruto < 2079.51){
			this.INSS = this.salarioHorasTrabalhadas*0.09;
		}else if(salarioBruto < 4159.01){
			this.INSS = this.salarioHorasTrabalhadas*0.11;
		}else{
			this.INSS = 457.49;
		}
		
		//calculo do imposto de renda. OBS: foi desconsiderado os dependentes,
		//deverá ser subtraído 171.97 do salario bruto para cada dependente legal
		if(salarioBruto < 1710.80){
			this.impostoRenda = 0;
		}else if(salarioBruto < 2563.92){
			double aliquota = 0.075;
			double deducao = 128.31;
			this.impostoRenda = (salarioBruto - this.INSS - this.planoSaude)*aliquota - deducao;
		}else if(salarioBruto < 3418.60){
			double aliquota = 0.15;
			double deducao = 320.60;
			this.impostoRenda = (salarioBruto - this.INSS - this.planoSaude)*aliquota - deducao;
		}else if(salarioBruto < 4271.59){
			double aliquota = 0.225;
			double deducao = 577.00;
			this.impostoRenda = (salarioBruto - this.INSS - this.planoSaude)*aliquota - deducao;
		}else{
			double aliquota = 0.275;
			double deducao = 790.58;
			this.impostoRenda = (salarioBruto - this.INSS - this.planoSaude)*aliquota - deducao;
		}
		
		
		this.outrosImpostos = salarioBruto*0.05;
		
		this.salarioLiquido = this.salarioHorasTrabalhadas - this.INSS - this.impostoRenda - this.planoSaude - this.outrosImpostos;
		this.descontos = this.salarioHorasTrabalhadas - this.salarioLiquido;
		
		if(this.salarioLiquido<0)
			this.salarioLiquido = 0;
	}

}
