package com.compassouol.sprint4.controller.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
//import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.domain.Specification;

import com.compassouol.sprint4.model.Endereco;
import com.compassouol.sprint4.model.Pessoa;
import com.compassouol.sprint4.repository.EnderecoRepository;
import com.compassouol.sprint4.repository.PessoaRepository;

public class PessoaForm {

	@NotNull
	@NotEmpty
	@Length(min = 2, max = 30)
	private String nome;

	@NotNull
	@NotEmpty
	@Length(min = 11, max = 11)
	// @CPF
	private String cpf;

	@NotNull
	@Digits(integer = 6, fraction = 2, message = "Apenas milhar, com 2 casas após o ponto.")
	private BigDecimal salario;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 1)
	private String sexo;

	@NotNull
	@NotEmpty
	private List<Endereco> enderecos = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Pessoa save(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {

		for (Endereco enderecos : enderecos) {
			enderecoRepository.save(enderecos);
		}

		Pessoa pessoa = new Pessoa(this.nome, this.cpf, this.salario, this.sexo, this.enderecos);
		pessoaRepository.save(pessoa);

		return pessoa;
	}

	public Pessoa converter(PessoaRepository pessoaRepository) {
		Pessoa pessoa = pessoaRepository.findByCpf(this.cpf);
		if (pessoa == null) {
			return new Pessoa(nome, cpf, salario, sexo, enderecos);
		} else {
			return null;
		}
	}

	// Utilizando Specification para criar querys dinâmicas
	public Specification<Pessoa> toSpec() {
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			if (nome != null) {
				Path<String> campoNome = root.<String>get("nome");
				Predicate predicadoNome = builder.like(campoNome, "%" + nome + "%");
				predicados.add(predicadoNome);
			}
			if (cpf != null) {
				Path<String> campoCpf = root.<String>get("cpf");
				Predicate predicadoCpf = builder.like(campoCpf, "%" + cpf + "%");
				predicados.add(predicadoCpf);
			}
			if (salario != null) {
				Path<String> campoSalario = root.<String>get("salario");
				Predicate predicadoSalario = builder.like(campoSalario, "%" + salario + "%");
				predicados.add(predicadoSalario);
			}
			if (sexo != null) {
				Path<String> campoSexo = root.<String>get("sexo");
				Predicate predicadoSexo = builder.like(campoSexo, "%" + sexo + "%");
				predicados.add(predicadoSexo);
			}
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}

}
