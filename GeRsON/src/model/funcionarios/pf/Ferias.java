package model.funcionarios.pf;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ferias {
	@Id
	@GeneratedValue
	private int idFerias;
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	@Temporal(TemporalType.DATE)
	private Date dataRetorno;
	@Temporal(TemporalType.DATE)
	private Date dataTemp;
	private String resultado;
	private int idFuncionario;
	private double periodoTrabalhado;
	public Ferias() {
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public int getIdFerias() {
		return idFerias;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public double getPeriodoTrabalhado() {
		return periodoTrabalhado;
	}

	public void setPeriodoTrabalhado(double periodoTrabalhado) {
		this.periodoTrabalhado = periodoTrabalhado;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public Date getDataTemp() {
		return dataTemp;
	}

	public void setDataTemp(Date dataTemp) {
		this.dataTemp = dataTemp;
	}
	
	
}
