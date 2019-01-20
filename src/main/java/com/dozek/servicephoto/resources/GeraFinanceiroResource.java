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

import com.dozek.servicephoto.domain.FinanceiroPagar;
import com.dozek.servicephoto.domain.FinanceiroPagarParcela;
import com.dozek.servicephoto.domain.PedidoCompra;
import com.dozek.servicephoto.domain.dto.GeraParcelaNewDTO;
import com.dozek.servicephoto.domain.dto.PagarParcelaDTO;
import com.dozek.servicephoto.domain.enums.EstadoPagamento;
import com.dozek.servicephoto.repositories.CentroRateioRepository;
import com.dozek.servicephoto.services.GeraFinanceiroService;

@RestController
@RequestMapping(value="/financeiro")
public class GeraFinanceiroResource {
	
	@Autowired
	private GeraFinanceiroService service; 
	 @Autowired
	 private CentroRateioRepository rateioRepository;
	
	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(value="/{Id}",method=RequestMethod.GET)
	public ResponseEntity<List<FinanceiroPagar>> find(@PathVariable Integer Id) {
		
		List<FinanceiroPagar> obj = service.find(Id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<GeraParcelaNewDTO>> findAll() {
		
	List<FinanceiroPagar> list = service.findAll();
	List<GeraParcelaNewDTO> listDTO =list.stream().map(obj -> new GeraParcelaNewDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(value="/{compraId}/parcelado",method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody FinanceiroPagar obj,@PathVariable Integer compraId ){// @RequestBody FinanceiroPagar obj){
		PedidoCompra ped = service.findByPedido(compraId);
		System.out.println(obj.getCentroRateio().getId());
		obj.setCentroRateio(rateioRepository.findOne(obj.getCentroRateio().getId()));
		obj.setPedidoCompra(ped);
		obj.setEstadoPagamento(EstadoPagamento.PENDENTE);
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(value="/{id}/parcelado",method=RequestMethod.PUT)
	public ResponseEntity<Void> updatePagar(@Valid @RequestBody PagarParcelaDTO objDto,@PathVariable Integer id){
		FinanceiroPagarParcela obj = service.fromDTO(objDto);
	//	obj= obj.setParcId(id);
		obj  = service.update(obj);
		return ResponseEntity.noContent().build();		
	}
	
	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<GeraParcelaNewDTO>> findPage(
		    @RequestParam(value="page",defaultValue="0")Integer page,
		    @RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage,
		    @RequestParam(value="ordeBy",defaultValue="finacid")String ordeBy,
		    @RequestParam(value="direction",defaultValue="DESC")String direction
			) {		
		
		Page<FinanceiroPagar> list = service.findPage(page, linesPerPage, ordeBy, direction);

		Page<GeraParcelaNewDTO> listDTO =list.map(obj -> new GeraParcelaNewDTO(obj));
		return ResponseEntity.ok().body(listDTO);
				
	}
	

}
