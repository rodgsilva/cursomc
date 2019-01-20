package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.Categoria;
import com.dozek.servicephoto.domain.ContratoPrincipal;

@Repository
public interface ContratoPrincipalRepository extends JpaRepository<ContratoPrincipal,Integer> {

}
