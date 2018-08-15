package com.dozek.servicephoto.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dozek.servicephoto.domain.Fornecedor;
import com.dozek.servicephoto.domain.PedidoCompra;

@Repository
public interface PedidoCompraRepository extends JpaRepository<PedidoCompra,Integer> {
	
	@Transactional(readOnly=true)
	Page<PedidoCompra> findByFornecedor(Fornecedor fornecedor,Pageable pageReques);
	
	@Transactional(readOnly=true)
	Page<PedidoCompra> findDistinctByFornecedorIn(List<Fornecedor> fornecedor,Pageable pageRequest);


}
