package com.compassouol.sprint4.controller.form.atualizacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.compassouol.sprint4.model.Endereco;
import com.compassouol.sprint4.model.Pessoa;
import com.compassouol.sprint4.repository.PessoaRepository;

public class AtualizacaoPessoaForm {

	@NotNull
	@Digits(integer = 6, fraction = 2, message = "Apenas milhar, com 2 casas após o ponto.")
	private BigDecimal salario;

	@NotNull
	@NotEmpty
	private List<Endereco> enderecos = new ArrayList<>();

	@NotNull
	@NotEmpty
	@Length(min = 2, max = 30)
	private String nome;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 1)
	private String sexo;

	public BigDecimal getSalario() {
		return salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Pessoa atualizar(Long id, PessoaRepository pessoaRepository) {

		Pessoa pessoa = pessoaRepository.getOne(id);

		pessoa.setSalario(this.salario);
		pessoa.setEnderecos(this.enderecos);
		pessoa.setNome(this.nome);
		pessoa.setSexo(this.sexo);

		return pessoa;
	}

}
