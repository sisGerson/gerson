package controller.business;

import dao.PesquisaDAO;
import model.funcionarios.pf.PessoaFisica;
import model.funcionarios.pj.PessoaJuridica;

public class BusinessController {
	PessoaFisica[] pessoasFisicas = {};
	PessoaJuridica[] pessoasJuridicas = {};

	public BusinessController() {

	}

	public PessoaFisica[] getPessoasFisicas() {
		return pessoasFisicas;
	}

	public void setPessoasFisicas(PesquisaDAO pesquisa) {
		this.pessoasFisicas = pesquisa.getPessoasFisicas();
	}

	public PessoaJuridica[] getPessoasJuridicas() {
		return pessoasJuridicas;
	}

	public void setPessoasJuridicas(PesquisaDAO pesquisa) {
		this.pessoasJuridicas = pesquisa.getPessoasJuridicas();
	}

	// Método para pegar o id de uma pessoa física
	public PessoaFisica idPessoaFisica(int id) {
		PesquisaDAO pesquisa = new PesquisaDAO();
		return pesquisa.getIdPessoaFisica(id);
	}

	// Método para pegar o id de uma pessoa jurídica
	public PessoaJuridica idPessoaJuridica(int id) {
		PesquisaDAO pesquisa = new PesquisaDAO();
		return pesquisa.getIdpessoaJuridica(id);
	}

	// Método para pegar informar o erro matrícula e senha
	public int MensagemDeErro(int OPCAO) {

		switch (OPCAO) {

		case -1:
			return -1;

		case -2:
			return -2;
		
		case -3:
			return -3;

		default:
			return 0;

		}

	}
}
