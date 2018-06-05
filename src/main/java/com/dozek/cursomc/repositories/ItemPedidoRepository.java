package com.dozek.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.cursomc.domain.ItemPedido;		

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Integer> {

}
