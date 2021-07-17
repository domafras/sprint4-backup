package com.compassouol.sprint4.controller.dto;

import com.compassouol.sprint4.model.Endereco;

public class EnderecoDto {

	private String cidade;
	private String rua;

	public EnderecoDto(Endereco enderecos) {
		this.cidade = enderecos.getCidade();
		this.rua = enderecos.getRua();
	}

	public String getCidade() {
		return cidade;
	}

	public String getRua() {
		return rua;
	}

}
