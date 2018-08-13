package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {

}
