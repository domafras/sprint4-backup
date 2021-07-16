package com.compassouol.sprint4.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.compassouol.sprint4.model.Endereco;

public interface EnderecoRepository extends PagingAndSortingRepository<Endereco, String>,
		JpaSpecificationExecutor<Endereco>/*, JpaRepository<Endereco, String>*/ {

}
