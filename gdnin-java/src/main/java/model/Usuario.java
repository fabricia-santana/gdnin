package model;

import java.io.Serializable;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 7526472295622776147L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_usuario")
    private Integer id;

    private String nome;
    private String login;
    private String senha;
    private boolean analisar;
    private boolean ativo;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_perfil")
    @Fetch(FetchMode.JOIN)
    private Perfil perfil;
    
	@OneToMany()
    private List<Demanda> demandas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAnalisar() {
		return analisar;
	}

	public void setAnalisar(boolean analisar) {
		this.analisar = analisar;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
    
	public List<Demanda> getDemandas() {
		return null;
	}

	public void setDemandas(List<Demanda> demandas) {
		this.demandas = demandas;
	}
  
}