package com.compassouol.sprint4.controller.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.compassouol.sprint4.model.Pessoa;

public class PessoaDto {

	private String nome;
	private String cpf;	
	private List<EnderecoDto> enderecoDto = new ArrayList<>();
	
	public PessoaDto(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		this.enderecoDto.addAll(pessoa.getEnderecos().stream().map(EnderecoDto::new).collect(Collectors.toList()));
	}
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}

	public List<EnderecoDto> getEnderecoDto() {
		return this.enderecoDto;
	}
	
	public static List<PessoaDto> converter(Collection<Pessoa> pessoas) {
		return pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
	}

	public static Page<PessoaDto> converter(Page<Pessoa> pessoas) {
		return pessoas.map(PessoaDto::new);
	}
	
	
}
