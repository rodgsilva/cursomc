package com.dozek.servicephoto.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dozek.servicephoto.domain.CentroCusto;
import com.dozek.servicephoto.domain.CentroRateio;
import com.dozek.servicephoto.domain.dto.CentroRateioDTO;
import com.dozek.servicephoto.services.CentroCustoService;

@RestController
@RequestMapping(value="/centrocusto")
public class CentroCustoResource {
	
	@Autowired
	private CentroCustoService service; 
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<CentroCusto> find(@PathVariable Integer id) {
		
	CentroCusto obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<CentroCusto>>findAll(){
		
		List<CentroCusto> obj = service.findCentroAll();
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CentroCusto obj){
	//	Endereco obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/rateio",method=RequestMethod.POST)
	public ResponseEntity<Void> insertRateio(@Valid @RequestBody CentroRateio obj ){
		System.out.println("Passou URL POST");
		obj = service.insertRateio(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping(value="/rateio")
	public ResponseEntity<List<CentroRateioDTO>> findAllRateio() {
		
	List<CentroRateio> list = service.findAll();
	List<CentroRateioDTO> listDTO =list.stream().map(obj -> new CentroRateioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	
	
	
/*	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<CentroRateioDTO>> findPage(
			@RequestParam(value="nome",defaultValue="")String nome,
			@RequestParam(value="categorias",defaultValue="")String categorias,
		    @RequestParam(value="page",defaultValue="0")Integer page,
		    @RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage,
		    @RequestParam(value="ordeBy",defaultValue="nome")String ordeBy,
		    @RequestParam(value="direction",defaultValue="ASC")String direction) {
	String nomeDecoded = URL.decodeParm(nome);
	List<Integer> ids = URL.decodeIntList(categorias);	
	Page<CentroCusto> list = service.search(nomeDecoded,ids,page, linesPerPage, ordeBy, direction);
	Page<CentroRateioDTO> listDTO =list.map(obj -> new CentroRateioDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}*/

}
