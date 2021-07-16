package com.compassouol.sprint4.controller.dto;

import java.math.BigDecimal;
import java.util.List;

import com.compassouol.sprint4.model.Endereco;
import com.compassouol.sprint4.model.Pessoa;

public class DetalhesDaPessoaDto {

	private Long id;
	private String nome;
	private String cpf;
	private BigDecimal salario;
	private String sexo;
	private List<Endereco> enderecos;
	
	
	public DetalhesDaPessoaDto(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		this.salario = pessoa.getSalario();
		this.sexo = pessoa.getSexo();
		this.enderecos = pessoa.getEnderecos();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public String getSexo() {
		return sexo;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
}
