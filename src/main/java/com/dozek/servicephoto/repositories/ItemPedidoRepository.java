package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.ItemPedido;		

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Integer> {

}
