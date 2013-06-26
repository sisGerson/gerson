package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.business.BusinessController;

public class LoginTest {

	String matricula = "1221321";
	String senha = "12132231";
	  
	  @Test public void metodo() {
		BusinessController business = new BusinessController();  
		
		int resultadoEsperado = 0;
		int resultadoObtido = business.verificarLogin(matricula,senha);
		
	    assertEquals(resultadoEsperado, resultadoObtido);//(Resultado Esperado, Resultado obtido)

	}

}
