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

		//Pegar o último ponto cadastrado se já existir algum ponto com o id desse funcionário cadastrado
		if(pontos.size()>0) {
			int idPonto=1;
			
			//Laço para rodar e pegar o id do último ponto do funcionário
			for (Ponto pontoFuncionario : pontos) {
				idPonto = pontoFuncionario.getIdPonto();
			}
			
			Ponto pontoAtual = pesquisa.getIdPonto(idPonto);
		
			//Se a data do ponto que está sendo batido já existir entrará nessa condição
			if(pontoAtual.getData().toString().equals(dataFormatada)){
				if(ponto.getOpcao().equals("Entrada")){
					//Tentar cadastrar outra entrada com a mesma data
					erro = "Já existe um ponto de entrada cadastrado hoje!";
				}
				else{
					if(pessoaFisica.getTotalHoraSemanal() == 40){
						if(ponto.getOpcao().equals("Início Almoço")){
							if(pontoAtual.getHoraInicioAlmoco() != null){
								erro = "Já existe um ponto de Início de Almoço cadastrado hoje!";
							}
							else{
								pontoAtual.setHoraInicioAlmoco(calendario.getTime());
								pontoAtual.setOpcao(request.getParameter("opcao"));
							}
						}
						else if(ponto.getOpcao().equals("Fim Almoço")){
							if(pontoAtual.getHoraFimAlmoco() != null){
								erro = "Já existe um ponto de Fim de Almoço cadastrado hoje!";
							}
							else if(pontoAtual.getHoraInicioAlmoco() == null){
								erro = "Não existe nenhum ponto de Início de Almoço cadastrado hoje!";
							}
							else{
								pontoAtual.setHoraFimAlmoco(calendario.getTime());
								pontoAtual.setOpcao(request.getParameter("opcao"));
							}
						}
						else if(ponto.getOpcao().equals("Saida")){
							if(pontoAtual.getHoraFimAlmoco() == null){
								erro="Não existe nenhum ponto de Fim de Almoço cadastrado hoje!";
							}
							else if(pontoAtual.getHoraSaida() != null){
								erro="Já existe um ponto de Saída cadastrado hoje!";
							}
							else{
								pontoAtual.setHoraSaida(calendario.getTime());
								pontoAtual.setOpcao(request.getParameter("opcao"));
							}
						}
						
					}
					//condições para funcionários que trabalhas 20 e 30 horas semanais
					else{
						if(ponto.getOpcao().equals("Saida")){
							
							if(pontoAtual.getHoraSaida() != null){
								erro="Já existe um ponto de Saída cadastrado hoje!";
							}
							else{
								pontoAtual.setHoraSaida(calendario.getTime());
								pontoAtual.setOpcao(request.getParameter("opcao"));
							}
						}
					}
				}
				//Atualizar este ponto
				pesquisa.alterarPonto(pontoAtual);
			}
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
