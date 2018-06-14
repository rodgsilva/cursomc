package com.dozek.servicephoto.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dozek.servicephoto.domain.Cidade;
import com.dozek.servicephoto.domain.Estado;
import com.dozek.servicephoto.domain.dto.CidadeDTO;
import com.dozek.servicephoto.domain.dto.EstadoDTO;
import com.dozek.servicephoto.services.CidadeService;
import com.dozek.servicephoto.services.EstadoService;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
	List<Estado> list = service.findAll();
	List<EstadoDTO> listDTO =list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
	return ResponseEntity.ok().body(listDTO);
		
	}
	
	@RequestMapping(value="/{estadoId}/cidades",method=RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
	List<Cidade> list = cidadeService.findByEstado(estadoId);
	List<CidadeDTO> listDTO =list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
	return ResponseEntity.ok().body(listDTO);
	}	
	
	
	

}
