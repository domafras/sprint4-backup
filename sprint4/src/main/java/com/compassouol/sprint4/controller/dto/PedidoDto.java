package com.compassouol.sprint4.controller.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.compassouol.sprint4.model.Pedido;
import com.compassouol.sprint4.model.Produto;

public class PedidoDto {

	private BigDecimal total = new BigDecimal("0.00");
	private String data;
	private List<ProdutoDto> produtoDto = new ArrayList<>();

	public PedidoDto(Pedido pedido) {
		this.data = pedido.getData();
		this.total = pedido.getTotal();
		this.setProdutoDto(pedido);
	}

	public BigDecimal getTotal() {
		return total;
	}

	public String getData() {
		return data;
	}

	public List<ProdutoDto> getProdutoDto() {
		return produtoDto;
	}

	private void setProdutoDto(Pedido pedido) {
		for (Produto produto : pedido.getProduto()) {
			this.produtoDto.add(new ProdutoDto(produto));
		}
	}

	public static List<PedidoDto> converter(Collection<Pedido> pedidos) {
		return pedidos.stream().map(PedidoDto::new).collect(Collectors.toList());
	}

	public static Page<PedidoDto> converter(Page<Pedido> pedidos) {
		return pedidos.map(PedidoDto::new);
	}
}
