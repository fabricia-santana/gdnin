package model;

import java.io.Serializable;
import java.util.Calendar;
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
@Table(name="hora_trabalhada")
public class HoraTrabalhada implements Serializable {
	
	private static final long serialVersionUID = 7526472295622776147L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_hora_trabalhada")
	private Integer id;
	
	@Column(name="mes_ano")
	private Date mesAno;
	
	private Double horas;
	
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

	public Date getMesAno() {
		return mesAno;
	}

	public void setMesAno(Date mesAno) {
		this.mesAno = mesAno;
	}

	public Demanda getDemanda() {
		return demanda;
	}

	public void setDemanda(Demanda demanda) {
		this.demanda = demanda;
	}
	
	public Double getHoras() {
		return horas;
	}

	public void setHoras(Double horas) {
		this.horas = horas;
	}

	public String getMesAnoFormatted(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.mesAno);
		Integer mes = calendar.get(Calendar.MONTH);
		Integer ano = calendar.get(Calendar.YEAR);
		return mes.toString() + '/' + ano.toString();
	}

}
