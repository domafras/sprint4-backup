package com.compassouol.sprint4.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.compassouol.sprint4.model.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long>,
		JpaSpecificationExecutor<Produto>/* , JpaRepository<Produto, Long> */ {

}
