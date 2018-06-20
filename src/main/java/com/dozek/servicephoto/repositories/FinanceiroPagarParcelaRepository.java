package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.FinanceiroPagarParcela;

@Repository
public interface FinanceiroPagarParcelaRepository extends JpaRepository<FinanceiroPagarParcela,Integer> {
	
	//@Query("SELECT obj FROM Cidade obj WHERE obj.estado.id = :estadoId ORDER BY obj.nome")
	//public List<Cidade> findCidades(@Param("estadoId")Integer estado_id);
/*	@Query("SELECT obj FROM FinanceiroPagar obj  WHERE obj.pedidoCompra.id = :compraid ORDER BY obj.id")
	public List<FinanceiroPagar> findByPedidoCompra(@Param("compraid")Integer id);*/
}
