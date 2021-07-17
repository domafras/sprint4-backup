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

import com.compassouol.sprint4.controller.dto.PessoaDto;
import com.compassouol.sprint4.controller.dto.detalhes.DetalhesDaPessoaDto;
import com.compassouol.sprint4.controller.form.PessoaForm;
import com.compassouol.sprint4.controller.form.atualizacao.AtualizacaoPessoaForm;
import com.compassouol.sprint4.model.Pessoa;
import com.compassouol.sprint4.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoasController {

	@Autowired
	private PessoaRepository pessoaRepository;

	// Cadastrar pessoa
	@PostMapping("")
	@Transactional
	public ResponseEntity<PessoaDto> cadastrar(@RequestBody @Valid PessoaForm form, UriComponentsBuilder uriBuilder) {
		Pessoa pessoa = form.converter(pessoaRepository);
		if (pessoa != null) {
			pessoaRepository.save(pessoa);
			URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
			return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
		} else {
			System.out.println("CPF já cadastrado, este valor deve ser único.");
			return null;
		}
	}

	// Listar pessoas cadastradas
	@GetMapping(value = "")
	public List<PessoaDto> listar(PessoaForm pessoaForm,
			@PageableDefault(direction = Direction.ASC, page = 0, size = 20) Pageable pageable) {
		Collection<Pessoa> pessoas = (Collection<Pessoa>) pessoaRepository.findAll(pessoaForm.toSpec(), pageable)
				.getContent();
		return PessoaDto.converter(pessoas);
	}

	// Detalhar pessoa por id (nome, cpf, endereçoDto(cidade, rua))
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDaPessoaDto> detalhar(@PathVariable Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if (pessoa.isPresent()) {
			return ResponseEntity.ok(new DetalhesDaPessoaDto(pessoa.get()));
		}
		return ResponseEntity.notFound().build();
	}

	// Atualizar pessoa por id
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PessoaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPessoaForm form) {
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if (optional.isPresent()) {
			Pessoa pessoa = form.atualizar(id, pessoaRepository);
			return ResponseEntity.ok(new PessoaDto(pessoa));
		}
		return ResponseEntity.notFound().build();
	}

	// Excluir pessoa por id
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Pessoa> optional = pessoaRepository.findById(id);

		if (optional.isPresent()) {
			pessoaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
