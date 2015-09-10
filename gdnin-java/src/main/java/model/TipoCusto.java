package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="tipo_custo")
public class TipoCusto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_custo")
	private Integer id;
	
	private String descricao;
	
	@OneToMany(mappedBy="tipoCusto", fetch=FetchType.LAZY)
	private List<Custo> custos;

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

	public List<Custo> getCustos() {
		return custos;
	}

	public void setCustos(List<Custo> custos) {
		this.custos = custos;
	}

}
