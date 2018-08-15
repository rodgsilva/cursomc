package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.ItemPedido;
import com.dozek.servicephoto.domain.ItemPedidoPK;
import java.util.List;		

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Integer> {
	
	

}
