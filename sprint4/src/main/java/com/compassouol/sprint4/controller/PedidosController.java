package com.compassouol.sprint4.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compassouol.sprint4.controller.dto.PedidoDto;
import com.compassouol.sprint4.controller.dto.detalhes.DetalhesDoPedidoDto;
import com.compassouol.sprint4.controller.form.PedidoForm;
import com.compassouol.sprint4.controller.form.atualizacao.AtualizacaoPedidoForm;
import com.compassouol.sprint4.model.Pedido;
import com.compassouol.sprint4.repository.PedidoRepository;
import com.compassouol.sprint4.repository.ProdutoRepository;

@RestController
@RequestMapping("/protected/pedido")
public class PedidosController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	// Cadastrar pedidos
	@PostMapping("")
	@Transactional
	@CacheEvict(value = "listaDePedidos", allEntries = true)
	public ResponseEntity<PedidoDto> cadastrar(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uriBuilder) {

		Pedido pedido = form.converter(produtoRepository);
		pedidoRepository.save(pedido);

		URI uri = uriBuilder.path("/pedido/{id}").buildAndExpand(pedido.getId()).toUri();

		return ResponseEntity.created(uri).body(new PedidoDto(pedido));
	}

	// Listar pedidos cadastrados
	@GetMapping(value = "")
	@Cacheable(value = "listaDePedidos")
	public List<PedidoDto> listar() {
		List<Pedido> pedidos = pedidoRepository.findAll();

		return PedidoDto.converter(pedidos);
	}

	// Detalhar pedido por id
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoPedidoDto> detalhar(@PathVariable Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (pedido.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoPedidoDto(pedido.get()));
		}
		return ResponseEntity.notFound().build();
	}

	// Atualizar pedido por id
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePedidos", allEntries = true)
	public ResponseEntity<PedidoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPedidoForm form) {
		Optional<Pedido> optional = pedidoRepository.findById(id);
		if (optional.isPresent()) {
			Pedido pedido = form.atualizar(id, pedidoRepository, produtoRepository);
			return ResponseEntity.ok(new PedidoDto(pedido));
		}
		return ResponseEntity.notFound().build();
	}

	// Excluir pedido por id
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePedidos", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Pedido> optional = pedidoRepository.findById(id);
		if (optional.isPresent()) {
			pedidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
