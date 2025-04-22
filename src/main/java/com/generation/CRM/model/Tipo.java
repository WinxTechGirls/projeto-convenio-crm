package com.generation.CRM.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_tipos")
public class Tipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O artributo nome é obrigatório!")
	@Size(min = 2, max = 150, message = "O atributo nome deve conter no mínimo 05 e no máximo 150 caracteres")
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tipo") 
	private List<Convenio> convenio;

	public List<Convenio> getConvenio() {
		return convenio;
	}

	public void setConvenio(List<Convenio> convenio) {
		this.convenio = convenio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
