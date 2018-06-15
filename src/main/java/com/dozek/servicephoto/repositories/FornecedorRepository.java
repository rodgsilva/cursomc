package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Integer> {

}
