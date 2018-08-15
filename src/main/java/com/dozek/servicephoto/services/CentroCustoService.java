package com.dozek.servicephoto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dozek.servicephoto.domain.Categoria;
import com.dozek.servicephoto.domain.CentroCusto;
import com.dozek.servicephoto.domain.CentroRateio;
import com.dozek.servicephoto.domain.ItemRateioCentroCusto;
import com.dozek.servicephoto.domain.Pedido;
import com.dozek.servicephoto.repositories.CentroCustoRepository;
import com.dozek.servicephoto.repositories.CentroRateioRepository;
import com.dozek.servicephoto.repositories.ItemRateioCentroRepository;
import com.dozek.servicephoto.services.execeptions.ObjectNotFoundException;

@Service
public class CentroCustoService {
	
	@Autowired
	private CentroCustoRepository centroCustoRepository;
	@Autowired
	private CentroRateioRepository centroRateioRepository;
	
	@Autowired
	private ItemRateioCentroRepository itemRateioRepository;
	
	public CentroCusto find(Integer id) {
		
		CentroCusto obj = centroCustoRepository.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id" + id
					+", Tipo: "+ CentroCusto.class.getName());
		}
		return obj;
		
	 }
	
	public CentroCusto insert(CentroCusto obj) {
		obj.setId(null);
		return centroCustoRepository.save(obj);
	}
	
	@Transactional
	public CentroRateio insertRateio(CentroRateio obj) {
		obj.setId(null);
		
		obj = centroRateioRepository.save(obj);
		
		for(ItemRateioCentroCusto ir : obj.getItensRateio()) {
		  ir.setCentroCusto(centroCustoRepository.findOne(ir.getCentroCusto().getId()));
		  ir.setCentroRateio(obj);
		}
		itemRateioRepository.save(obj.getItensRateio());
		return obj;
		
		
	}
	

}
