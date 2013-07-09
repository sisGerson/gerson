package controller.logicas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pj.PessoaJuridica;
import controller.interfaces.Logica;
import dao.CadastroDAO;


public class CadastroPessoaJuridica implements Logica {

	public CadastroPessoaJuridica() {
		
	}

	public void executa(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		
		//Recebendo os dados da área de verificando se o mesmo está vazio
		String area = request.getParameter("area");
		if ((area == null || area.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaJuridica.setArea(request.getParameter("area"));
		}

		//Recebendo os dados da matricula de verificando se o mesmo está vazio
		String matricula = request.getParameter("matricula");
		if ((matricula == null || matricula.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaJuridica.setMatricula(request.getParameter("matricula"));
		}

		String dataAdmissaoTexto = request.getParameter("dataAdmissao");
		Date dataAdmissao;
		try {
			dataAdmissao = new SimpleDateFormat("dd/MM/yyyy").parse(dataAdmissaoTexto);
			pessoaJuridica.setDataAdmissao(dataAdmissao);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		String dataDesligamentoTexto = request.getParameter("dataDesligamento");
		Date dataDesligamento;
		try {
			dataDesligamento = new SimpleDateFormat("dd/MM/yyyy").parse(dataDesligamentoTexto);
			pessoaJuridica.setDataDesligamento(dataDesligamento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		pessoaJuridica.setStatus_2(Boolean.parseBoolean(request.getParameter("status_2")));
		
		//Recebendo os dados do salário e verificando se o mesmo está vazio
		String salario = request.getParameter("salario");
		if ((salario == null || salario.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaJuridica.setSalario(Double.parseDouble(request.getParameter("salario")));
		}

		//Recebendo os dados do endereço funcional e verificando se o mesmo está vazio
		String enderecoFuncional = request.getParameter("enderecoFuncional");
		if ((enderecoFuncional == null || enderecoFuncional.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaJuridica.setEnderecoFuncional(request.getParameter("enderecoFuncional"));
		}
		
		pessoaJuridica.setTelefoneComercial(request.getParameter("telefoneComercial"));
		pessoaJuridica.setTipoFuncionario("Pessoa Jurídica");
		
		//Recebendo os dados do nome da empresa e verificando se o mesmo está vazio
		String nome = request.getParameter("nome");
		if ((nome == null || nome.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaJuridica.setNome(request.getParameter("nome"));
		}

		//Recebendo os dados do CNPJ e verificando se o mesmo está vazio
		String CPF_CNPJ = request.getParameter("CPF_CNPJ");
		if ((CPF_CNPJ == null || CPF_CNPJ.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaJuridica.setCPF_CNPJ(request.getParameter("CPF_CNPJ"));
		}		

		//Recebendo os dados do email e verificando se o mesmo está vazio
		String email = request.getParameter("email");
		if ((email == null || email.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaJuridica.setEmail(request.getParameter("email"));
		}		
		
		//Recebendo os dados do CEP e verificando se o mesmo está vazio
		String CEPFuncional = request.getParameter("CEPFuncional");
		if ((CEPFuncional == null || CEPFuncional.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaJuridica.setCEPFuncional(request.getParameter("CEPFuncional"));
		}		

		//Recebendo os dados da cidade e verificando se o mesmo está vazio
		String cidadeFuncional = request.getParameter("cidadeFuncional");
		if ((cidadeFuncional == null || cidadeFuncional.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaJuridica.setCidadeFuncional(request.getParameter("cidadeFuncional"));
		}		
	
		//Recebendo os dados da UF da cidade e verificando se o mesmo está vazio
		String UFCidadeFuncional = request.getParameter("UFCidadeFuncional");
		if ((UFCidadeFuncional == null || UFCidadeFuncional.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaJuridica.setUFCidadeFuncional(request.getParameter("UFCidadeFuncional"));
		}		

		//Recebendo os dados do Responsavel da cidade e verificando se o mesmo está vazio
		String responsavel = request.getParameter("responsavel");
		if ((responsavel == null || responsavel.equals(""))){
			throw new RuntimeException();
		}else{
			pessoaJuridica.setResponsavel(request.getParameter("responsavel"));
		}
		
		pessoaJuridica.setTelefoneResponsavel(request.getParameter("telefoneResponsavel"));
		pessoaJuridica.setDescricaoServico(request.getParameter("descricaoServico"));
		
		CadastroDAO cadastro = new CadastroDAO();
		cadastro.cadastrarPessoaJuridica(pessoaJuridica);
		
		request.setAttribute("pessoaJuridica", pessoaJuridica);
		RequestDispatcher dispache = request.getRequestDispatcher("/index.jsp?item=9&situacao=2");
		dispache.forward(request, response);
	}

}