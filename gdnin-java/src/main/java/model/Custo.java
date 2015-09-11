package model;

import java.io.Serializable;

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
@Table(name="custo")
public class Custo implements Serializable {
	
	private static final long serialVersionUID = 7526472295622776147L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_custo")
	private Integer id;
	
	private Float custo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_tipo_custo")
	private TipoCusto tipoCusto;
	
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

	public Float getCusto() {
		return custo;
	}

	public void setCusto(Float custo) {
		this.custo = custo;
	}

	public TipoCusto getTipoCusto() {
		return tipoCusto;
	}

	public void setTipoCusto(TipoCusto tipoCusto) {
		this.tipoCusto = tipoCusto;
	}
}
