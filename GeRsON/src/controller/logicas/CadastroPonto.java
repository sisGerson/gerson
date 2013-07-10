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
		
		//Pegando a sess√£o
		PessoaFisica pessoaFisica = (PessoaFisica)request.getSession().getAttribute("funcionario");
		
		Ponto ponto = new Ponto();
		
		ponto.setData(calendario.getTime());
		ponto.setOpcao(request.getParameter("opcao"));
		
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");  
		String dataFormatada = formatador.format(ponto.getData());

		PesquisaDAO pesquisa = new PesquisaDAO();
		
		List<Ponto> pontos = pesquisa.buscarTodosPontos(pessoaFisica.getId());

		//Pegar o √∫ltimo ponto cadastrado se j√° existir algum ponto com o id desse funcion√°rio cadastrado
		if(pontos.size()>0) {
			int idPonto=1;
			
			//La√ßo para rodar e pegar o id do √∫ltimo ponto do funcion√°rio
			for (Ponto pontoFuncionario : pontos) {
				idPonto = pontoFuncionario.getIdPonto();
			}
			
			Ponto pontoAtual = pesquisa.getIdPonto(idPonto);
		
			//Se a data do ponto que est√° sendo batido j√° existir entrar√° nessa condi√ß√£o
			if(pontoAtual.getData().toString().equals(dataFormatada)){
				if(ponto.getOpcao().equals("Entrada")){
					//Tentar cadastrar outra entrada com a mesma data
					erro = "J· existe um ponto de entrada cadastrado hoje!";
				}
				else{
					if(pessoaFisica.getTotalHoraSemanal() == 40){
						if(ponto.getOpcao().equals("InÌcio AlmoÁo")){
							if(pontoAtual.getHoraInicioAlmoco() != null){
								erro = "J· existe um ponto de InÌcio de AlmoÁo cadastrado hoje!";
							}
							else{
								pontoAtual.setHoraInicioAlmoco(calendario.getTime());
								pontoAtual.setOpcao(request.getParameter("opcao"));
							}
						}
						else if(ponto.getOpcao().equals("Fim AlmoÁo")){
							if(pontoAtual.getHoraFimAlmoco() != null){
								erro = "J· existe um ponto de Fim de AlmoÁo cadastrado hoje!";
							}
							else if(pontoAtual.getHoraInicioAlmoco() == null){
								erro = "N„o existe nenhum ponto de InÌcio de AlmoÁo cadastrado hoje!";
							}
							else{
								pontoAtual.setHoraFimAlmoco(calendario.getTime());
								pontoAtual.setOpcao(request.getParameter("opcao"));
							}
						}
						else if(ponto.getOpcao().equals("Saida")){
							if(pontoAtual.getHoraFimAlmoco() == null){
								erro="N„o existe nenhum ponto de Fim de AlmoÁo cadastrado hoje!";
							}
							else if(pontoAtual.getHoraSaida() != null){
								erro="J· existe um ponto de SaÌda cadastrado hoje!";
							}
							else{
								pontoAtual.setHoraSaida(calendario.getTime());
								pontoAtual.setOpcao(request.getParameter("opcao"));
							}
						}
						
					}
					//condi√ß√µes para funcion√°rios que trabalhas 20 e 30 horas semanais
					else{
						if(ponto.getOpcao().equals("Saida")){
							
							if(pontoAtual.getHoraSaida() != null){
								erro="J· existe um ponto de SaÌda cadastrado hoje!";
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
		//Se for um novo dia entrar√° nessa condi√ß√£o
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
				erro = "N„o existe nenhum ponto de entrada cadastrado hoje!";
			}
		}
		
		//Mandar para a p√°gina de resultado
		request.getSession().setAttribute("erro", erro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?item=14&situacao=2");
		dispatcher.forward(request, response);
	}
}
