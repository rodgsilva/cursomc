package com.dozek.servicephoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dozek.servicephoto.domain.ItemRateioCentroCusto;		

@Repository
public interface ItemRateioCentroRepository extends JpaRepository<ItemRateioCentroCusto,Integer> {
	
	

}
