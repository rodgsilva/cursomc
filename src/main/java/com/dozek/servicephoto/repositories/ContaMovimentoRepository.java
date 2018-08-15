package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.ContaMovimento;

@Repository
public interface ContaMovimentoRepository extends JpaRepository<ContaMovimento,Integer> {

}
