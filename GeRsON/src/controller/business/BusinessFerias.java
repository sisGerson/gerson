package controller.business;

import java.util.Date;

import model.funcionarios.pf.PessoaFisica;

public class BusinessFerias {

	public BusinessFerias() {

	}
	
	public boolean pedidoFeriasPermitido(PessoaFisica pessoaFisica, Date data){
		if(pessoaFisica.getUltimasFerias() == null){
			if((data.getTime() - pessoaFisica.getDataAdmissao().getTime())/3600000 >=1)
				return true;
		}
		else{
			if((data.getTime() - pessoaFisica.getUltimasFerias().getTime())/3600000 >=1){
				return true;
			}
		}
		return false;
	}
	
}
