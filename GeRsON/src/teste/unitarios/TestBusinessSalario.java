package teste.unitarios;

import static org.junit.Assert.*;

import model.funcionarios.pf.PessoaFisica;

import org.junit.Before;
import org.junit.Test;

import controller.business.BusinessSalario;

public class TestBusinessSalario {
	BusinessSalario business = new BusinessSalario();
	PessoaFisica p1 = new PessoaFisica(); //funcionário de 20 horas

	@Before
	public void testBusinessSalario() {
		assertNotNull("Erro no construtor, business é nulo", business);
		
		p1.setTotalHoraSemanal(20);
		assertEquals(20, p1.getTotalHoraSemanal());
	}

	@Test
	public void testCalculoSalario() {
		business.calculoSalario(1000, 80, p1.getTotalHoraSemanal());
		
		//Cálculo para o salario das horas trabalhadas
		double salarioHorasTrabalhadas = 80*(1000/(double)(p1.getTotalHoraSemanal()*4));
		double INSS = salarioHorasTrabalhadas*0.08;
		double outrosImpostos = 1000*0.05;
		double salarioLiquido = salarioHorasTrabalhadas - INSS - 100.0 - outrosImpostos;
		double descontos = salarioHorasTrabalhadas - salarioLiquido;
		
		assertEquals(String.valueOf(INSS), String.valueOf(business.getINSS()));
		//Neste caso o imposto de renda é 0.0
		assertEquals("0.0", String.valueOf(business.getImpostoRenda()));
		//Plano de saúde é um valor fixo
		assertEquals("100.0", String.valueOf(business.getPlanoSaude()));
		assertEquals(String.valueOf(outrosImpostos), String.valueOf(business.getOutrosImpostos()));
		assertEquals(String.valueOf(salarioHorasTrabalhadas), String.valueOf(business.getSalarioHorasTrabalhadas()));
		assertEquals(String.valueOf(salarioLiquido), String.valueOf(business.getSalarioLiquido()));
		assertEquals(String.valueOf(descontos), String.valueOf(business.getDescontos()));
	}

	@Test
	public void testCalculoSalario1() {
		business.calculoSalario(2000, 80, p1.getTotalHoraSemanal());
		
		//Cálculo para o salario das horas trabalhadas
		double salarioHorasTrabalhadas = 80*(2000/(double)(p1.getTotalHoraSemanal()*4));
		double INSS = salarioHorasTrabalhadas*0.09;
		
		double aliquota = 0.075;
		double deducao = 128.31;
		double impostoRenda = (2000 - INSS - 100.0)*aliquota - deducao;

		double outrosImpostos = 2000*0.05;
		double salarioLiquido = salarioHorasTrabalhadas - INSS - impostoRenda - 100.0 - outrosImpostos;
		double descontos = salarioHorasTrabalhadas - salarioLiquido;
		
		assertEquals(String.valueOf(INSS), String.valueOf(business.getINSS()));
		assertEquals(String.valueOf(impostoRenda), String.valueOf(business.getImpostoRenda()));
		//Plano de saúde é um valor fixo
		assertEquals("100.0", String.valueOf(business.getPlanoSaude()));
		assertEquals(String.valueOf(outrosImpostos), String.valueOf(business.getOutrosImpostos()));
		assertEquals(String.valueOf(salarioHorasTrabalhadas), String.valueOf(business.getSalarioHorasTrabalhadas()));
		assertEquals(String.valueOf(salarioLiquido), String.valueOf(business.getSalarioLiquido()));
		assertEquals(String.valueOf(descontos), String.valueOf(business.getDescontos()));
	}
	
	@Test
	public void testCalculoSalario2() {
		business.calculoSalario(3000, 80, p1.getTotalHoraSemanal());
		
		//Cálculo para o salario das horas trabalhadas
		double salarioHorasTrabalhadas = 80*(3000/(double)(p1.getTotalHoraSemanal()*4));
		double INSS = salarioHorasTrabalhadas*0.11;
		double aliquota = 0.15;
		double deducao = 320.60;
		double impostoRenda = (3000 - INSS - 100.0)*aliquota - deducao;

		double outrosImpostos = 3000*0.05;
		double salarioLiquido = salarioHorasTrabalhadas - INSS - impostoRenda - 100.0 - outrosImpostos;
		double descontos = salarioHorasTrabalhadas - salarioLiquido;
		
		assertEquals(String.valueOf(INSS), String.valueOf(business.getINSS()));
		assertEquals(String.valueOf(impostoRenda), String.valueOf(business.getImpostoRenda()));
		//Plano de saúde é um valor fixo
		assertEquals("100.0", String.valueOf(business.getPlanoSaude()));
		assertEquals(String.valueOf(outrosImpostos), String.valueOf(business.getOutrosImpostos()));
		assertEquals(String.valueOf(salarioHorasTrabalhadas), String.valueOf(business.getSalarioHorasTrabalhadas()));
		assertEquals(String.valueOf(salarioLiquido), String.valueOf(business.getSalarioLiquido()));
		assertEquals(String.valueOf(descontos), String.valueOf(business.getDescontos()));
	}
	
	@Test
	public void testCalculoSalario3() {
		business.calculoSalario(4000, 80, p1.getTotalHoraSemanal());
		
		//Cálculo para o salario das horas trabalhadas
		double salarioHorasTrabalhadas = 80*(4000/(double)(p1.getTotalHoraSemanal()*4));
		double INSS = salarioHorasTrabalhadas*0.11;
		double aliquota = 0.225;
		double deducao = 577.00;
		double impostoRenda = (4000 - INSS - 100.0)*aliquota - deducao;

		double outrosImpostos = 4000*0.05;
		double salarioLiquido = salarioHorasTrabalhadas - INSS - impostoRenda - 100.0 - outrosImpostos;
		double descontos = salarioHorasTrabalhadas - salarioLiquido;
		
		assertEquals(String.valueOf(INSS), String.valueOf(business.getINSS()));
		assertEquals(String.valueOf(impostoRenda), String.valueOf(business.getImpostoRenda()));
		//Plano de saúde é um valor fixo
		assertEquals("100.0", String.valueOf(business.getPlanoSaude()));
		assertEquals(String.valueOf(outrosImpostos), String.valueOf(business.getOutrosImpostos()));
		assertEquals(String.valueOf(salarioHorasTrabalhadas), String.valueOf(business.getSalarioHorasTrabalhadas()));
		assertEquals(String.valueOf(salarioLiquido), String.valueOf(business.getSalarioLiquido()));
		assertEquals(String.valueOf(descontos), String.valueOf(business.getDescontos()));
	}
	
	@Test
	public void testCalculoSalario4() {
		business.calculoSalario(5000, 80, p1.getTotalHoraSemanal());
		
		//Cálculo para o salario das horas trabalhadas
		double salarioHorasTrabalhadas = 80*(5000/(double)(p1.getTotalHoraSemanal()*4));
		
		double aliquota = 0.275;
		double deducao = 790.58;
		double impostoRenda = (5000 - 457.49 - 100.0)*aliquota - deducao;

		double outrosImpostos = 5000*0.05;
		double salarioLiquido = salarioHorasTrabalhadas - 457.49 - impostoRenda - 100.0 - outrosImpostos;
		double descontos = salarioHorasTrabalhadas - salarioLiquido;
		
		assertEquals("457.49", String.valueOf(business.getINSS()));
		assertEquals(String.valueOf(impostoRenda), String.valueOf(business.getImpostoRenda()));
		//Plano de saúde é um valor fixo
		assertEquals("100.0", String.valueOf(business.getPlanoSaude()));
		assertEquals(String.valueOf(outrosImpostos), String.valueOf(business.getOutrosImpostos()));
		assertEquals(String.valueOf(salarioHorasTrabalhadas), String.valueOf(business.getSalarioHorasTrabalhadas()));
		assertEquals(String.valueOf(salarioLiquido), String.valueOf(business.getSalarioLiquido()));
		assertEquals(String.valueOf(descontos), String.valueOf(business.getDescontos()));
	}
	
	@Test
	public void testCalculoSalario5() {
		business.calculoSalario(1000, 0, p1.getTotalHoraSemanal());
		
		double outrosImpostos = 1000*0.05;
		double descontos = 100.0 + outrosImpostos;
		
		assertEquals("0.0", String.valueOf(business.getINSS()));
		//Neste caso o imposto de renda é 0.0
		assertEquals("0.0", String.valueOf(business.getImpostoRenda()));
		//Plano de saúde é um valor fixo
		assertEquals("100.0", String.valueOf(business.getPlanoSaude()));
		assertEquals(String.valueOf(outrosImpostos), String.valueOf(business.getOutrosImpostos()));
		assertEquals("0.0", String.valueOf(business.getSalarioHorasTrabalhadas()));
		//Como o funcionário não trabalhou seu salário líquido deve ser 0
		assertEquals("0.0", String.valueOf(business.getSalarioLiquido()));
		assertEquals(String.valueOf(descontos), String.valueOf(business.getDescontos()));
	}
}
