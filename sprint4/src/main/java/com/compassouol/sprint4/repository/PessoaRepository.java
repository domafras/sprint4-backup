package com.compassouol.sprint4.repository;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.compassouol.sprint4.model.Pessoa;

public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long>, 
				JpaSpecificationExecutor<Pessoa>/*, JpaRepository<Pessoa, Long>*/ {

	Pessoa findByCpf(@NotNull @Length(max = 9) String cpf);
	
	Pessoa getOne(Long id);

	Optional<Pessoa> findById(String cpf);

}
