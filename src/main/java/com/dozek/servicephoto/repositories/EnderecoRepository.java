package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {

}
