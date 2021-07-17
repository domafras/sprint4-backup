package com.compassouol.sprint4.controller.form.atualizacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

	public BigDecimal getSalario() {
		return salario;
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

		return pessoa;
	}
}
