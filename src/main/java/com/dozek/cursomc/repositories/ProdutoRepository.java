package com.dozek.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dozek.cursomc.domain.Categoria;
import com.dozek.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
	
	//@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categoria cat WHERE obj.nome LIKE %:nome% AND cat IN :categoria ")
	//Page<Produto> search(@Param("nome") String nome, @Param("categoria")List<Categoria> categoria,Pageable pageRequest);

	@Transactional(readOnly=true)
	Page<Produto> findDistinctByNomeContainingAndCategoriaIn(String nome,List<Categoria> categoria,Pageable pageRequest);
}
