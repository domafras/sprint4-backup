package com.compassouol.sprint4.controller.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import com.compassouol.sprint4.model.Pedido;
import com.compassouol.sprint4.model.Produto;
import com.compassouol.sprint4.repository.ProdutoRepository;

public class PedidoForm {

	@NotEmpty
	private List<Long> idProduto = new ArrayList<>();

	public List<Long> getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(List<Long> idProduto) {
		this.idProduto = idProduto;
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

	public Pedido converter(ProdutoRepository produtoRepository) {
		Pedido pedido = new Pedido();

		carrinho(pedido, produtoRepository);

		return pedido;
	}

	
}
