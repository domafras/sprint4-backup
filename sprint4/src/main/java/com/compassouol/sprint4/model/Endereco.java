package com.compassouol.sprint4.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Endereco {

	@NotBlank
	private String pais;
	
	@NotBlank
	private String estado;
	
	@NotBlank
	private String cidade;
	
	@Id @NotBlank
	private String cep;
	
	@NotBlank
	private String rua;
	
	@SuppressWarnings("unused")
	private Endereco(){}
	
	public Endereco(String pais, String estado, String cidade, String cep, String rua) {
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
		this.rua = rua;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}
