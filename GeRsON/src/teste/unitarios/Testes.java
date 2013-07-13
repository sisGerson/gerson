package teste.unitarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Testes {

	public Testes() {
	}

	//classe pra testar se tudo esta funcionando --> Epoca do RUP
	public static void main(String[] args) {
		Calendar data = Calendar.getInstance();
		data.set(2013, (8-1), 29);
		
		Date data1 = new Date();
		data1=data.getTime();
		System.out.println(data1);
		
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
		
		String formatada = formata.format(data1);
		System.out.println(formatada);
	}

}
