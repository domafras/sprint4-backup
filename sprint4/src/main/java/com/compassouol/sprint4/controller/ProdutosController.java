package com.compassouol.sprint4.controller;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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

import com.compassouol.sprint4.controller.dto.DetalhesDoProdutoDto;
import com.compassouol.sprint4.controller.dto.ProdutoDto;
import com.compassouol.sprint4.controller.form.ProdutoForm;
import com.compassouol.sprint4.model.Produto;
import com.compassouol.sprint4.repository.ProdutoRepository;

@RestController
@RequestMapping("/protected/produto")
public class ProdutosController {

	@Autowired
	private ProdutoRepository produtoRepository;

	// Cadastrar produtos
	@PostMapping("")
	@Transactional
	public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {

		Produto produto = form.converter(produtoRepository);
		produtoRepository.save(produto);

		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();

		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}

	// Listar produtos cadastradas
	@GetMapping(value = "")
	public List<ProdutoDto> listar(ProdutoForm produtoForm,
			@PageableDefault(direction = Direction.ASC, page = 0, size = 20) Pageable pageable) {
		Collection<Produto> produtos = (Collection<Produto>) produtoRepository.findAll(produtoForm.toSpec(), pageable)
				.getContent();
		return ProdutoDto.converter(produtos);
	}

	// Detalhar produto por id
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoProdutoDto> detalhar(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoProdutoDto(produto.get()));
		}
		return ResponseEntity.notFound().build();
	}

	// Atualizar produto por id
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoForm form) {
		Optional<Produto> optional = produtoRepository.findById(id);
		if (optional.isPresent()) {
			Produto produto = form.atualizar(id, produtoRepository);
			return ResponseEntity.ok(new ProdutoDto(produto));
		}
		return ResponseEntity.notFound().build();
	}
	
	// Excluir produto por id
		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<?> remover(@PathVariable Long id) {
			Optional<Produto> optional = produtoRepository.findById(id);

			if (optional.isPresent()) {
				produtoRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}

			return ResponseEntity.notFound().build();
		}
}
