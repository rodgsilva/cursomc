package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer> {

}
