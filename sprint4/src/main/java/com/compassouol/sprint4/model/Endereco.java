package com.compassouol.sprint4.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco {

	@Id @NotNull @NotEmpty
	private String cep;
	
	@NotNull @NotEmpty
	private String pais;
	
	@NotNull @NotEmpty
	private String estado;
	
	@NotNull @NotEmpty
	private String cidade;
	
	@NotNull @NotEmpty
	private String rua;
	
	@SuppressWarnings("unused")
	private Endereco(){}
	
	public Endereco(String cep, String pais, String estado, String cidade, String rua) {
		this.cep = cep;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
	}


	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}
