package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="observacao")
public class Observacao implements Serializable {
	
	private static final long serialVersionUID = 7526472295622776147L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_observacao")
	private Integer id;
	
	private String observacao;
	
	@Column(name="data_criacao")
	private Date dataCriacao;
	
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_demanda")
	@JsonIgnore
	private Demanda demanda;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Demanda getDemanda() {
		return null;
	}

	public void setDemanda(Demanda demanda) {
		this.demanda = demanda;
	}

}
