package br.com.infnet.ATTelemedicina.negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table (name = "TConsulta")
public class Consulta {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	@ApiModelProperty(value = "Categoria da consulta")
	private String categoria;
	@Column(columnDefinition = "DATE")
	private LocalDate data;
	@Column(columnDefinition = "TIME")
	private LocalTime hora;
	
	@OneToMany(cascade = CascadeType.DETACH)
	@JoinTable(name ="TConsultaExames",
		joinColumns = {@JoinColumn(name="idConsulta")},
		inverseJoinColumns = {@JoinColumn(name="idExame")})	
	
	private List<Exame> exames;
	
	//@ManyToMany
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "idMedico")
	private Medico medico;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "idPaciente")
	private Paciente paciente;
	
	

	public Consulta() {
		
	}
	

	@Override
	public String toString() {
		return String.format("%d - Consulta com %s ,dia: %s, hora: %s.", 
		
				this.id,
				this.categoria,
				this.data,
				this.hora
			
				);
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


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public LocalTime getHora() {
		return hora;
	}


	public void setHora(LocalTime hora) {
		this.hora = hora;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public List<Exame> getExames() {
		return exames;
	}


	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}


	
}
