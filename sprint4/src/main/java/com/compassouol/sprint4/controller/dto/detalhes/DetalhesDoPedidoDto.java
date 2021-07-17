package com.compassouol.sprint4.controller.dto.detalhes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.compassouol.sprint4.model.Pedido;
import com.compassouol.sprint4.model.Produto;

public class DetalhesDoPedidoDto {

	private Long id;
	private BigDecimal total;
	private String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private List<Produto> produto = new ArrayList<>();
	private Boolean ativo = true;

	public DetalhesDoPedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.total = pedido.getTotal();
		this.data = pedido.getData();
		this.produto = pedido.getProduto();
		this.ativo = pedido.getAtivo();
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public String getData() {
		return data;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public Boolean getAtivo() {
		return ativo;
	}

}
