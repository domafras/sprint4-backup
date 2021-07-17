package com.compassouol.sprint4.controller.form.atualizacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import com.compassouol.sprint4.model.Pedido;
import com.compassouol.sprint4.model.Produto;
import com.compassouol.sprint4.repository.PedidoRepository;
import com.compassouol.sprint4.repository.ProdutoRepository;

public class AtualizacaoPedidoForm {

	@NotEmpty
	private List<Long> idProduto = new ArrayList<>();

	public List<Long> getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(List<Long> idProduto) {
		this.idProduto = idProduto;
	}

	public Pedido atualizar(Long id, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {

		Optional<Pedido> pedido = pedidoRepository.findById(id);

		if (pedido.isPresent()) {
			Pedido pedidoCadastrado = pedido.get();
			pedidoCadastrado.getProduto().clear();

			carrinho(pedidoCadastrado, produtoRepository);

			pedidoCadastrado.setData(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

			return pedidoCadastrado;
		}

		return null;
	}

	public void carrinho(Pedido pedido, ProdutoRepository produtoRepository) {
		BigDecimal total = new BigDecimal("0.00");
		Optional<Produto> produto = null;

		for (Long id : idProduto) {
			produto = produtoRepository.findById(id);

			if (produto.isPresent()) {
				Produto produtoCadastrado = produto.get();
				total = total.add(produtoCadastrado.getPrecoUnitario());

				pedido.getProduto().add(produtoCadastrado);
			}
		}

		pedido.setTotal(total);
	}
}
