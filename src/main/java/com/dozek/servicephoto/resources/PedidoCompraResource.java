package com.dozek.servicephoto.resources;


import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dozek.servicephoto.domain.PedidoCompra;
import com.dozek.servicephoto.services.PedidoCompraService;

@RestController
@RequestMapping(value="/compras")
public class PedidoCompraResource {
	
	@Autowired
	private PedidoCompraService service; 
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<PedidoCompra> find(@PathVariable Integer id) {
		
		PedidoCompra obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PedidoCompra obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<PedidoCompra>> findPage(
		    @RequestParam(value="page",defaultValue="0")Integer page,
		    @RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage,
		    @RequestParam(value="ordeBy",defaultValue="instante")String ordeBy,
		    @RequestParam(value="direction",defaultValue="DESC")String direction
			) {		
		Page<PedidoCompra> list = service.findPage(page, linesPerPage, ordeBy, direction);
		return ResponseEntity.ok().body(list);
				
	}
	

}
