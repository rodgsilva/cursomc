package com.dozek.servicephoto.resources;


import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dozek.servicephoto.domain.ContaMovimento;
import com.dozek.servicephoto.services.FinanceiroMovimentoService;

@RestController
@RequestMapping(value="/movimentofinan")
public class FinanceiroMovimentoResource {
	
	@Autowired
	private FinanceiroMovimentoService service; 
	

//	@RequestMapping(value="/{Id}",method=RequestMethod.GET)
	@PreAuthorize("hasAnyRole('USUARIO')")
	@GetMapping(value="/{Id}")
	public ResponseEntity<ContaMovimento> find(@PathVariable Integer Id) {
		System.out.println("AA**antes do find**AAA");
		ContaMovimento obj = service.find(Id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	/*@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<GeraParcelaNewDTO>> findAll() {
		
	List<FinanceiroPagar> list = service.findAll();
	List<GeraParcelaNewDTO> listDTO =list.stream().map(obj -> new GeraParcelaNewDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}*/
	
//	@RequestMapping(method=RequestMethod.POST)
	@PreAuthorize("hasAnyRole('USUARIO')")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ContaMovimento obj){// @RequestBody FinanceiroPagar obj){
	  System.out.println("AA**antes do insert**AAA");
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/*@PreAuthorize("hasAnyRole('USUARIO')")
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
	*/

}
