package com.compassouol.sprint4.controller.form.atualizacao;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.compassouol.sprint4.model.Produto;
import com.compassouol.sprint4.repository.ProdutoRepository;

public class AtualizacaoProdutoForm {

	@NotNull
	@NotEmpty
	private String descricao;

	@NotNull
	private BigDecimal precoUnitario;

	@NotNull
	private Boolean ativo;

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Boolean getStatus() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isPresent()) {
			Produto produtos = produto.get();

			produtos.setDescricao(this.descricao);
			produtos.setPrecoUnitario(this.precoUnitario);
			produtos.setAtivo(this.ativo);

			return produtos;
		}

		return null;
	}
}
