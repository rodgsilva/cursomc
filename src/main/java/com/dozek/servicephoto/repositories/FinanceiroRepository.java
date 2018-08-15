package com.dozek.servicephoto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dozek.servicephoto.domain.Financeiro;
import com.dozek.servicephoto.domain.FinanceiroPagar;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro,Integer> {
	
	//@Query("SELECT obj FROM Cidade obj WHERE obj.estado.id = :estadoId ORDER BY obj.nome")
	//public List<Cidade> findCidades(@Param("estadoId")Integer estado_id);
   @SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Financeiro obj  WHERE obj.pedido.id =:pedidoId ORDER BY obj.id")
	public List<Financeiro> findByPedido(@Param("pedidoId")Integer id);
}
