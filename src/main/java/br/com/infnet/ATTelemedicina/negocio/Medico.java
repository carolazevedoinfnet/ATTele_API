package br.com.infnet.ATTelemedicina.negocio;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table (name = "TMedico")
public class Medico {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Integer id;
	@ApiModelProperty(value = "Nome do Médico")
	private String nome;
	private String email;
	private boolean clinico;
	private boolean especialista;
	private String[] especialidades;
	



	public Medico() {
	}

	public Medico(Integer id, String nome, String email, boolean clinico, boolean especialista, String[] especialidade) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.clinico = clinico;
		this.especialista = especialista;
		this.especialidades = especialidade;
		

	}
	
	@Override
	public String toString() {
	 return this.getNome();
				
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isClinico() {
		return clinico;
	}

	public void setClinico(boolean clinico) {
		this.clinico = clinico;
	}

	public boolean isEspecialista() {
		return especialista;
	}

	public void setEspecialista(boolean especialista) {
		this.especialista = especialista;
	}

	public String getEspecialidade() {
		if (especialidades ==null)
			return "" ;
		
		String especi = "";
		
		for (String spec : especialidades) {
			if(especi.equals(""))	
				especi = spec;
			else 
				especi = especi + ", " + spec;		
		}
		
		return especi;
	}

	public void setEspecialidade(String[] especialidade) {
		this.especialidades = especialidade;
	}



}
