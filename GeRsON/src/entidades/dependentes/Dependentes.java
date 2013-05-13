package entidades.dependentes;

import entidades.funcionarios.*;

public class Dependentes {
	private String nomeDependente;
	private String parentesco;
	private String dataNascimentoDependente;
	private boolean IRRF;
	private boolean salarioFamilia;
	private Funcionario funcionario;

	public Dependentes(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getNomeDependente() {
		return nomeDependente;
	}

	public void setNomeDependente(String nomeDependente) {
		this.nomeDependente = nomeDependente;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getDataNascimentoDependente() {
		return dataNascimentoDependente;
	}

	public void setDataNascimentoDependente(String dataNascimentoDependente) {
		this.dataNascimentoDependente = dataNascimentoDependente;
	}

	public boolean isIRRF() {
		return IRRF;
	}

	public void setIRRF(boolean iRRF) {
		IRRF = iRRF;
	}

	public boolean isSalarioFamilia() {
		return salarioFamilia;
	}

	public void setSalarioFamilia(boolean salarioFamilia) {
		this.salarioFamilia = salarioFamilia;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

}
