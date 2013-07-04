package controller.logicas;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.funcionarios.pf.PessoaFisica;
import model.funcionarios.pf.Ponto;
import controller.interfaces.Logica;
import dao.CadastroDAO;
import dao.PesquisaDAO;

public class CadastroPonto implements Logica{
	
	public CadastroPonto() {
		
	}

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String erro = "Ponto cadastrado com sucesso!";
		
		GregorianCalendar calendario = new GregorianCalendar();
		
		//Pegando a sessão
		PessoaFisica pessoaFisica = (PessoaFisica)request.getSession().getAttribute("funcionario");
		
		Ponto ponto = new Ponto();
		
		ponto.setData(calendario.getTime());
		ponto.setOpcao(request.getParameter("opcao"));
		
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");  
		String dataFormatada = formatador.format(ponto.getData());

		PesquisaDAO pesquisa = new PesquisaDAO();
		
		List<Ponto> pontos = pesquisa.buscarTodosPontos(pessoaFisica.getId());
		//Pegar o último ponto cadastrado
		Ponto pontoAtual = pesquisa.getIdPonto(pontos.size());
		
		//Se a data do ponto que está sendo batido já existir entrará nessa condição
		if(pontoAtual.getData().toString().equals(dataFormatada)){
			if(ponto.getOpcao().equals("Entrada")){
				//Tentar cadastrar outra entrada com a mesma data
				erro = "Já existe um ponto de entrada cadastrado hoje!";
			}
			else if(ponto.getOpcao().equals("Saida")){
				pontoAtual.setHoraSaida(calendario.getTime());
				pontoAtual.setOpcao(request.getParameter("opcao"));
			}
			else if(ponto.getOpcao().equals("Início Almoço")){
				pontoAtual.setHoraInicioAlmoco(calendario.getTime());
				pontoAtual.setOpcao(request.getParameter("opcao"));
			}
			else if(ponto.getOpcao().equals("Fim Almoço") && pontoAtual.getHoraInicioAlmoco() != null){
				pontoAtual.setHoraFimAlmoco(calendario.getTime());
				pontoAtual.setOpcao(request.getParameter("opcao"));
			}
			else{
				//Tentar cadastrar fim do almoço sem ter o início almoço
				erro = "Não existe nenhum ponto de início de almoço cadastrado hoje!";
			}
			//Atualizar este ponto
			pesquisa.alterarPonto(pontoAtual);
		}
		//Se for um novo dia entrará nessa condição
		else{
			if(ponto.getOpcao().equals("Entrada")){
				ponto.setHoraEntrada(calendario.getTime());
				ponto.setIdFuncionario(pessoaFisica.getId());
				
				//Cadastrar o novo ponto
				CadastroDAO cadastro = new CadastroDAO();
				cadastro.cadastrarPonto(ponto);
			}
			else{
				//Tentar cadastrar um novo ponto sem entrada
				erro = "Não existe nenhum ponto de entrada cadastrado hoje!";
			}
		}
		
		//Mandar para a página de resultado
		request.getSession().setAttribute("erro", erro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?item=14&situacao=2");
		dispatcher.forward(request, response);
	}
}
