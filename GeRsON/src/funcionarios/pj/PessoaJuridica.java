package funcionarios.pj;

import funcionarios.*;

public class PessoaJuridica extends Funcionario{
	
	private String responsavel;
	private String telefoneResponsavel;
	private String descricaoServico;
	
	public PessoaJuridica() {
		super();
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getTelefoneResponsavel() {
		return telefoneResponsavel;
	}

	public void setTelefoneResponsavel(String telefoneResponsavel) {
		this.telefoneResponsavel = telefoneResponsavel;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}
	
}