package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="status")
public class Status implements Serializable {
	
	private static final long serialVersionUID = 7526472295622776147L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_status")
	private Integer id;
	
	private String descricao;
	
	@OneToMany(mappedBy="status", fetch = FetchType.LAZY)
	private List<Demanda> demandas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Demanda> getDemandas() {
		return null;
	}

	public void setDemandas(List<Demanda> demandas) {
		this.demandas = demandas;
	}

	
}
