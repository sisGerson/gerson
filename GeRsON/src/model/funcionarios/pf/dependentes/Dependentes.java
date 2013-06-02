package model.funcionarios.pf.dependentes;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.funcionarios.pf.PessoaFisica;

public class Dependentes {
	private String nomeDependente;
	private String parentesco;
	@Temporal(TemporalType.DATE)
	private Date dataNascimentoDependente;
	private boolean IRRF;
	private boolean salarioFamilia;
	private PessoaFisica pessoaFisica;

	public Dependentes(PessoaFisica pessoaFisica) {
		//Mostrar que essa é a classe parte da classe todo que a compôs logo na instancia
		this.pessoaFisica = pessoaFisica;
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

	public Date getDataNascimentoDependente() {
		return dataNascimentoDependente;
	}

	public void setDataNascimentoDependente(Date dataNascimentoDependente) {
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

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

}
