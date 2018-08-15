package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dozek.servicephoto.domain.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Integer> {
	
	@Transactional(readOnly=true)
	Fornecedor findByEmail(String email);

}
