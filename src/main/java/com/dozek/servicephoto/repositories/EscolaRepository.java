package com.dozek.servicephoto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dozek.servicephoto.domain.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola,Integer> {
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Escola obj WHERE obj.nome LIKE %:nome%")
	List<Escola> findByNomeLike(@Param("nome") String nome);

}
