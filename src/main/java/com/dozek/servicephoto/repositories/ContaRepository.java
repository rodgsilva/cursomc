package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Integer> {

}
