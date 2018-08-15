package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.CentroRateio;
import com.dozek.servicephoto.domain.Pedido;

@Repository
public interface CentroRateioRepository extends JpaRepository<CentroRateio,Integer> {
	
	//@Transactional(readOnly=true)
	//Page<Pedido> findByCliente(Cliente cliente,Pageable pageReques);

}
