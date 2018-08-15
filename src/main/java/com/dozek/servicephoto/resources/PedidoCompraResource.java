package com.dozek.servicephoto.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dozek.servicephoto.domain.Empresa;
import com.dozek.servicephoto.domain.ItemPedidoCompra;
import com.dozek.servicephoto.domain.PedidoCompra;
import com.dozek.servicephoto.domain.dto.ItemPedidoCompraDTO;
import com.dozek.servicephoto.domain.dto.PedidoCompraDTO;
import com.dozek.servicephoto.services.PedidoCompraService;

@RestController
@RequestMapping(value="/compras")
public class PedidoCompraResource {
	
	@Autowired
	private PedidoCompraService service; 
	
	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<PedidoCompra> find(@PathVariable Integer id) {
		
		PedidoCompra obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	// Get dos produtos relacionado a compra
	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(value="/{id}/produto",method=RequestMethod.GET)
	public ResponseEntity<List<ItemPedidoCompraDTO>> findByProduto(@PathVariable Integer id) {
		
		List<ItemPedidoCompra> list = service.findByProduto(id);
		List<ItemPedidoCompraDTO> listDTO = list.stream().map(obj -> new ItemPedidoCompraDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
		//Page<PedidoCompraDTO> listDTO = list.map(obj -> new PedidoCompraDTO(obj));
		//return ResponseEntity.ok().body(listDTO);
		
	}
	
	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PedidoCompra obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<PedidoCompraDTO>> findPage(
		    @RequestParam(value="page",defaultValue="0")Integer page,
		    @RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage,
		    @RequestParam(value="ordeBy",defaultValue="instante")String ordeBy,
		    @RequestParam(value="direction",defaultValue="DESC")String direction
			) {		
		Page<PedidoCompra> list = service.findPage(page, linesPerPage, ordeBy, direction);
		Page<PedidoCompraDTO> listDTO = list.map(obj -> new PedidoCompraDTO(obj));
		return ResponseEntity.ok().body(listDTO);
				
	}
	
	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(value="/empresa/{id}",method=RequestMethod.GET)
	public ResponseEntity<Empresa> empresaById(@PathVariable Integer id) {
		
		Empresa obj = service.empresaById(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	

}
