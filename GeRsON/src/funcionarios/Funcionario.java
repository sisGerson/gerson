package funcionarios;

import java.util.Date;

public class Funcionario {
	
	protected int id;
	protected String area;
	protected String matricula;
	protected Date dataAdmissao;
	protected Date dataDesligamento;
	protected boolean status_2;
	protected double salario;
	protected String enderecoFuncional;
	protected String telefoneComercial;
	protected String tipoFuncionario;
	protected String nome;
	protected String CPF_CNPJ;
	protected String email;
	protected String senha;
	protected String CEPFuncional;
	protected String cidadeFuncional;
	protected String UFCidadeFuncional;
	
	
	public Funcionario() {
	}
	
	public int getId() {
		return id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public boolean isStatus_2() {
		return status_2;
	}

	public void setStatus_2(boolean status_2) {
		this.status_2 = status_2;
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

	public String getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
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

	public String getCEPFuncional() {
		return CEPFuncional;
	}

	public void setCEPFuncional(String cEPFuncional) {
		CEPFuncional = cEPFuncional;
	}

	public String getCidadeFuncional() {
		return cidadeFuncional;
	}

	public void setCidadeFuncional(String cidadeFuncional) {
		this.cidadeFuncional = cidadeFuncional;
	}

	public String getUFCidadeFuncional() {
		return UFCidadeFuncional;
	}

	public void setUFCidadeFuncional(String uFCidadeFuncional) {
		UFCidadeFuncional = uFCidadeFuncional;
	}
}