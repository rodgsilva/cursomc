package com.dozek.servicephoto.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dozek.servicephoto.domain.Cliente;
import com.dozek.servicephoto.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
	
	@Transactional(readOnly=true)
	Page<Pedido> findByCliente(Cliente cliente,Pageable pageReques);

}
