package br.com.infnet.ATTelemedicina.negocio;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table (name ="TExames")
public class Exame {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Integer id;
	@ApiModelProperty(value = "Nomes dos Exames")
	private String descricao;
	 
	@ManyToMany(mappedBy = "exames", cascade = CascadeType.DETACH)
	@JsonIgnore
	private List<Consulta> consultas;

	public Exame() {		
	}
	
	public Exame(Integer id, String descricao, List<Consulta> consultas) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.consultas = consultas;
	}
	
	@Override
	public String toString() {
		return this.getDescricao();
	}

	public void imprimir() {
		System.out.println(this);

	}
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
	
	  public List<Consulta> getConsultas() { return consultas; } public void
	  setConsultas(List<Consulta> consultas) { this.consultas = consultas; }
	 
}
