package com.compassouol.sprint4.controller.dto;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.compassouol.sprint4.model.Produto;

public class ProdutoDto {

	private Long id;
	private String descricao;
	private BigDecimal precoUnitario;
	private Boolean ativo;

	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.precoUnitario = produto.getPrecoUnitario();
		this.ativo = produto.getAtivo();
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

	public Boolean getAtivo() {
		return ativo;
	}

	public static List<ProdutoDto> converter(Collection<Produto> produtos) {
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}

}
