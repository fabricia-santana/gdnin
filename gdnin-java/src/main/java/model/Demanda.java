package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="demanda")
public class Demanda implements Serializable {

	private static final long serialVersionUID = 7526472295622776147L;
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_demanda")
    private Integer id;
    
    @Column(name="num_controle")
	private String numControle;
    
	private String descricao;
	private String sistema;
	private String nucleo;
	private String solicitante;
	private String fornecedor;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="data_solicitada")
	private Date dataSolicitada;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="data_finalizada")
	private Date dataFinalizada;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_tipo_demanda")
	private TipoDemanda tipoDemanda;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_status")
	private Status status;
	
	private String grade;
	private Integer ano;
	
	@Column(name="horas_estimadas")
	private Integer horasEstimadas;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="responsavel_acompanhamento")
    @Fetch(FetchMode.JOIN)
	private Usuario responsavelAcompanhamento;
	
	@Column(name="horas_realizadas")
	private Integer horasRelizadas;	
	
	@OneToMany(mappedBy="demanda")
	@JsonIgnore
	private List<Observacao> observacoes;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_classificacao")
	private Classificacao classificacao;
	
	@Transient
	private boolean isInterna;
	
	@Transient
	private Observacao observacao;
	
	public Demanda(){
		
	}

	public Demanda(String descricao, String sistema, String nucleo, int id) {
		super();
		this.descricao = descricao;
		this.sistema = sistema;
		this.nucleo = nucleo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumControle() {
		return numControle;
	}

	public void setNumControle(String numControle) {
		this.numControle = numControle;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getNucleo() {
		return nucleo;
	}

	public void setNucleo(String nucleo) {
		this.nucleo = nucleo;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Date getDataSolicitada() {
		return dataSolicitada;
	}

	public void setDataSolicitada(Date dataSolicitada) {
		this.dataSolicitada = dataSolicitada;
	}

	public Date getDataFinalizada() {
		return dataFinalizada;
	}

	public void setDataFinalizada(Date dataFinalizada) {
		this.dataFinalizada = dataFinalizada;
	}

	public TipoDemanda getTipoDemanda() {
		this.tipoDemanda.setDemandas(null);
		return tipoDemanda;
	}

	public void setTipoDemanda(TipoDemanda tipoDemanda) {
		this.tipoDemanda = tipoDemanda;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(Integer horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public Usuario getResponsavelAcompanhamento() {
		return responsavelAcompanhamento;
	}

	public void setResponsavelAcompanhamento(Usuario responsavelAcompanhamento) {
		this.responsavelAcompanhamento = responsavelAcompanhamento;
	}

	public Integer getHorasRelizadas() {
		return horasRelizadas;
	}

	public void setHorasRelizadas(Integer horasRelizadas) {
		this.horasRelizadas = horasRelizadas;
	}

	public Classificacao getClassificacao() {
		this.classificacao.setDemandas(null);
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
	
	public boolean isInterna() {
		return isInterna;
	}

	public void setInterna(boolean isInterna) {
		if(this.tipoDemanda.getDescricao() == "DemandaInterna"){
			this.isInterna = true;
		}else{
			this.isInterna = false;
		}
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Observacao> getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(List<Observacao> observacoes) {
		this.observacoes = observacoes;
	}

	public Observacao getObservacao() {
		return observacao;
	}

	public void setObservacao(Observacao observacao) {
		this.observacao = observacao;
	}

}
