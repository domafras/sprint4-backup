package com.compassouol.sprint4.controller.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;

import com.compassouol.sprint4.model.Produto;
import com.compassouol.sprint4.repository.ProdutoRepository;

public class ProdutoForm {

	@NotNull
	@NotEmpty
	private String descricao;

	@NotNull
	private BigDecimal precoUnitario;

	private Boolean status;

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
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Produto converter(ProdutoRepository produtoRepository) {
		return new Produto(this.descricao, this.precoUnitario, this.status);

	}

	// Utilizando Specification para criar querys dinâmicas
	public Specification<Produto> toSpec() {
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			if (descricao != null) {
				Path<String> campoDescricao = root.<String>get("descricao");
				Predicate predicadoDescricao = builder.like(campoDescricao, "%" + descricao + "%");
				predicados.add(predicadoDescricao);
			}
			if (precoUnitario != null) {
				Path<String> campoPrecoUnitario = root.<String>get("precoUnitario");
				Predicate predicadoPrecoUnitario = builder.like(campoPrecoUnitario, "%" + precoUnitario + "%");
				predicados.add(predicadoPrecoUnitario);
			}
			if (status != null) {
				Path<String> campoStatus = root.<String>get("status");
				Predicate predicadoStatus = builder.like(campoStatus, "%" + status + "%");
				predicados.add(predicadoStatus);
			}
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}

	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isPresent()) {
			Produto produtos = produto.get();

			produtos.setDescricao(this.descricao);
			produtos.setPrecoUnitario(this.precoUnitario);

			return produtos;
		}

		return null;
	}
}
