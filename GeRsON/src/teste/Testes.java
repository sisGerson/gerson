package teste;

import entidades.funcionarios.*;

public class Testes {

	public Testes() {
	}

	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();

		funcionario.setNome("Abreu");
		funcionario.criarDependentes();
		funcionario.getDependentes()[0].setNomeDependente("Alfredo");
		funcionario.criarDependentes();
		funcionario.getDependentes()[1].setNomeDependente("Maria Joaquina");

		for (int i = 0; i < funcionario.getDependentes().length; i++) {
			System.out.println("Funcionario: "+funcionario.getNome()+
					"\nDependente: "+funcionario.getDependentes()[i].getNomeDependente());
		}
	}

}
