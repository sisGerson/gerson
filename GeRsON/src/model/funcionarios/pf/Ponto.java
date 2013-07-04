package model.funcionarios.pf;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Ponto {
	@Id
	@GeneratedValue
	protected int idPonto;
	@Temporal(TemporalType.DATE)
	private Date data;
	@Temporal(TemporalType.TIME)
	private Date horaEntrada, horaSaida, horaInicioAlmoco, horaFimAlmoco;
	private String opcao;
	private int idFuncionario;
	
	public Ponto() {
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Date getHoraInicioAlmoco() {
		return horaInicioAlmoco;
	}

	public void setHoraInicioAlmoco(Date horaInicioAlmoco) {
		this.horaInicioAlmoco = horaInicioAlmoco;
	}

	public Date getHoraFimAlmoco() {
		return horaFimAlmoco;
	}

	public void setHoraFimAlmoco(Date horaFimAlmoco) {
		this.horaFimAlmoco = horaFimAlmoco;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
	
	public int getIdPonto() {
		return idPonto;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
}
