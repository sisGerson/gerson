package funcionarios.pf;

import java.util.Date;

import funcionarios.Funcionario;
import funcionarios.dependentes.*;

public class PessoaFisica extends Funcionario{
	
	protected String cargo;
	protected int horaSemanal;
	protected String RG;
	protected String orgaoEmissor;
	protected Date dataExpedicao;
	protected String CTPS;
	protected String PIS;
	protected Date dataNascimento;
	protected String enderecoResidencial;
	protected String telefoneCelular;
	protected String telefoneResidencial;
	protected String estadoCivil;
	protected String naturalidade;
	protected double altura;
	protected double peso;
	protected String corCabelo;
	protected String corOlhos;
	protected String racaCor;
	protected boolean deficienteFisico;
	protected String sinaisParticulares;
	protected String nomeMae;
	protected String nomePai;
	protected String nacionalidadeMae;
	protected String nacionalidadePai;
	protected String serieCTPS;
	protected Date emissaoCTPS;
	protected String UFCTPS;
	protected String tituloEleitoral;
	protected String zonaTitulo;
	protected String secaoTitulo;
	protected String CNH;
	protected String reservista;
	protected String grauInstrucao;
	protected String nomeConjuge;
	protected String nacionalidadeConjuge;
	protected Dependentes[] dependentes = {};
	
	public PessoaFisica() {
		super();
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getHoraSemanal() {
		return horaSemanal;
	}

	public void setHoraSemanal(int horaSemanal) {
		this.horaSemanal = horaSemanal;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public Date getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public String getCTPS() {
		return CTPS;
	}

	public void setCTPS(String cTPS) {
		CTPS = cTPS;
	}

	public String getPIS() {
		return PIS;
	}

	public void setPIS(String pIS) {
		PIS = pIS;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEnderecoResidencial() {
		return enderecoResidencial;
	}

	public void setEnderecoResidencial(String enderecoResidencial) {
		this.enderecoResidencial = enderecoResidencial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getCorCabelo() {
		return corCabelo;
	}

	public void setCorCabelo(String corCabelo) {
		this.corCabelo = corCabelo;
	}

	public String getCorOlhos() {
		return corOlhos;
	}

	public void setCorOlhos(String corOlhos) {
		this.corOlhos = corOlhos;
	}

	public String getRacaCor() {
		return racaCor;
	}

	public void setRacaCor(String racaCor) {
		this.racaCor = racaCor;
	}

	public boolean isDeficienteFisico() {
		return deficienteFisico;
	}

	public void setDeficienteFisico(boolean deficienteFisico) {
		this.deficienteFisico = deficienteFisico;
	}

	public String getSinaisParticulares() {
		return sinaisParticulares;
	}

	public void setSinaisParticulares(String sinaisParticulares) {
		this.sinaisParticulares = sinaisParticulares;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNacionalidadeMae() {
		return nacionalidadeMae;
	}

	public void setNacionalidadeMae(String nacionalidadeMae) {
		this.nacionalidadeMae = nacionalidadeMae;
	}

	public String getNacionalidadePai() {
		return nacionalidadePai;
	}

	public void setNacionalidadePai(String nacionalidadePai) {
		this.nacionalidadePai = nacionalidadePai;
	}

	public String getSerieCTPS() {
		return serieCTPS;
	}

	public void setSerieCTPS(String serieCTPS) {
		this.serieCTPS = serieCTPS;
	}

	public Date getEmissaoCTPS() {
		return emissaoCTPS;
	}

	public void setEmissaoCTPS(Date emissaoCTPS) {
		this.emissaoCTPS = emissaoCTPS;
	}

	public String getUFCTPS() {
		return UFCTPS;
	}

	public void setUFCTPS(String uFCTPS) {
		UFCTPS = uFCTPS;
	}

	public String getTituloEleitoral() {
		return tituloEleitoral;
	}

	public void setTituloEleitoral(String tituloEleitoral) {
		this.tituloEleitoral = tituloEleitoral;
	}

	public String getZonaTitulo() {
		return zonaTitulo;
	}

	public void setZonaTitulo(String zonaTitulo) {
		this.zonaTitulo = zonaTitulo;
	}

	public String getSecaoTitulo() {
		return secaoTitulo;
	}

	public void setSecaoTitulo(String secaoTitulo) {
		this.secaoTitulo = secaoTitulo;
	}

	public String getCNH() {
		return CNH;
	}

	public void setCNH(String cNH) {
		CNH = cNH;
	}

	public String getReservista() {
		return reservista;
	}

	public void setReservista(String reservista) {
		this.reservista = reservista;
	}

	public String getGrauInstrucao() {
		return grauInstrucao;
	}

	public void setGrauInstrucao(String grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public String getNacionalidadeConjuge() {
		return nacionalidadeConjuge;
	}

	public void setNacionalidadeConjuge(String nacionalidadeConjuge) {
		this.nacionalidadeConjuge = nacionalidadeConjuge;
	}

	public Dependentes[] getDependentes() {
		return dependentes;
	}
	
	//Apenas com esse método será possível acessar a classe Dependentes
	public void setDependentes(Dependentes[] dependentes) {
		this.dependentes = dependentes;
	}

	//Método para criar dependentes do funcionário
	public void criarDependentes() {
		Dependentes novoDependente = new Dependentes(this);
		
		//Vetor temporário para receber o objeto novoDependente
		Dependentes[] tempDependentes = new Dependentes[this.dependentes.length+1];
		
		for(int i = 0; i < this.dependentes.length; i++){
			tempDependentes[i] = this.dependentes[i];
		}
		tempDependentes[this.dependentes.length] = novoDependente;
		//Mandar o novo dependente cadastrado para o vetor real de dependentes
		this.dependentes = tempDependentes;
	}
}
