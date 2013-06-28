package teste;

import model.funcionarios.pf.PessoaFisica;

public class Testes {

	public Testes() {
	}

	//classe pra testar se tudo esta funcionando --> Epoca do RUP
	public static void main(String[] args) {
		PessoaFisica pessoaFisica = new PessoaFisica();

		pessoaFisica.setNome("Abreu");
		pessoaFisica.criarDependentes();
		pessoaFisica.getDependentes()[0].setNomeDependente("Alfredo");
		pessoaFisica.criarDependentes();
		pessoaFisica.getDependentes()[1].setNomeDependente("Maria Joaquina");

		for (int i = 0; i < pessoaFisica.getDependentes().length; i++) {
			System.out.println("PessoaFisica: "+pessoaFisica.getNome()+
					"\nDependente: "+pessoaFisica.getDependentes()[i].getNomeDependente());
		}
	}

}
