package com.dozek.servicephoto.resources;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dozek.servicephoto.domain.FinanceiroPagar;
import com.dozek.servicephoto.domain.PedidoCompra;
import com.dozek.servicephoto.domain.dto.GeraParcelaDTO;
import com.dozek.servicephoto.domain.enums.EstadoPagamento;
import com.dozek.servicephoto.services.GeraFinanceiroService;

@RestController
@RequestMapping(value="/financeiro")
public class GeraFincanceiroResource {
	
	@Autowired
	private GeraFinanceiroService service; 
	
	@RequestMapping(value="/{Id}",method=RequestMethod.GET)
	public ResponseEntity<List<FinanceiroPagar>> find(@PathVariable Integer Id) {
		
		List<FinanceiroPagar> obj = service.find(Id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(value="/{compraId}/parcelado",method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody FinanceiroPagar obj,@PathVariable Integer compraId ){// @RequestBody FinanceiroPagar obj){
		PedidoCompra ped = service.findByPedido(compraId);
		obj.setPedidoCompra(ped);
		obj.setEstadoPagamento(EstadoPagamento.PENDENTE);
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/*@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<PedidoCompra>> findPage(
		    @RequestParam(value="page",defaultValue="0")Integer page,
		    @RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage,
		    @RequestParam(value="ordeBy",defaultValue="instante")String ordeBy,
		    @RequestParam(value="direction",defaultValue="DESC")String direction
			) {		
		Page<PedidoCompra> list = service.findPage(page, linesPerPage, ordeBy, direction);
		return ResponseEntity.ok().body(list);
				
	}*/
	

}
