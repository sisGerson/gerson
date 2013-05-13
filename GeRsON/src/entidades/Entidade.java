package entidades;

import java.util.Date;

public abstract class Entidade {
	protected String empresa;
	protected String matricula;
	protected Date dataAdmissao;
	protected Date dataDesligamento;
	protected boolean status;
	protected double salario;
	protected String enderecoFuncional;
	protected String telefoneComercial;
	protected String tipoPessoa;
	protected String nome;
	protected String CPF_CNPJ;
	protected String email;
	protected String senha;
	protected String horarioTrabalho;
	protected String CEP;
	protected String cidade;
	protected String UFCidade;
	
	
	public Entidade() {
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public Date getDataAdmissao() {
		return dataAdmissao;
	}


	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}


	public Date getDataDesligamento() {
		return dataDesligamento;
	}


	public void setDataDesligamento(Date dataDesligamento) {
		this.dataDesligamento = dataDesligamento;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public String getEnderecoFuncional() {
		return enderecoFuncional;
	}


	public void setEnderecoFuncional(String enderecoFuncional) {
		this.enderecoFuncional = enderecoFuncional;
	}


	public String getTelefoneComercial() {
		return telefoneComercial;
	}


	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}


	public String getTipoPessoa() {
		return tipoPessoa;
	}


	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCPF_CNPJ() {
		return CPF_CNPJ;
	}


	public void setCPF_CNPJ(String cPF_CNPJ) {
		CPF_CNPJ = cPF_CNPJ;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getHorarioTrabalho() {
		return horarioTrabalho;
	}


	public void setHorarioTrabalho(String horarioTrabalho) {
		this.horarioTrabalho = horarioTrabalho;
	}


	public String getCEP() {
		return CEP;
	}


	public void setCEP(String cEP) {
		CEP = cEP;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getUFCidade() {
		return UFCidade;
	}


	public void setUFCidade(String uFCidade) {
		UFCidade = uFCidade;
	}
	
}
