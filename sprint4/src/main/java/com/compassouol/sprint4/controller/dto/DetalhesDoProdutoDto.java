package com.compassouol.sprint4.controller.dto;

import java.math.BigDecimal;

import com.compassouol.sprint4.model.Produto;

public class DetalhesDoProdutoDto {

	private Long id;
	private String descricao;
	private BigDecimal precoUnitario;
	private Boolean status;
	
	public DetalhesDoProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.precoUnitario = produto.getPrecoUnitario();
		this.status = produto.getStatus();
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public Boolean getStatus() {
		return status;
	}
	
}
