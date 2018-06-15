package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.ItemPedidoCompra;		

@Repository
public interface ItemPedidoCompraRepository extends JpaRepository<ItemPedidoCompra,Integer> {

}
