package com.dozek.servicephoto.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.Categoria;
import com.dozek.servicephoto.domain.ItemPedidoCompra;
import com.dozek.servicephoto.domain.ItemPedidoCompraPK;
import java.util.List;
import com.dozek.servicephoto.domain.PedidoCompra;
import com.dozek.servicephoto.domain.Produto;		

@Repository
public interface ItemPedidoCompraRepository extends JpaRepository<ItemPedidoCompra,Integer> {
	
	//@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categoria cat WHERE obj.nome LIKE %:nome% AND cat IN :categoria ")
		//Page<Produto> search(@Param("nome") String nome, @Param("categoria")List<Categoria> categoria,Pageable pageRequest);

	@Query("SELECT DISTINCT obj FROM ItemPedidoCompra obj where obj.id.pedidoCompra =:pedido ")
	public List<ItemPedidoCompra> search(@Param("pedido") PedidoCompra pedido);
	


}
