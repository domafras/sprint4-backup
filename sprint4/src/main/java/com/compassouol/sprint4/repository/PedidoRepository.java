package com.compassouol.sprint4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.compassouol.sprint4.model.Pedido;

public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Long>, 
JpaSpecificationExecutor<Pedido>, JpaRepository<Pedido, Long> {

}
