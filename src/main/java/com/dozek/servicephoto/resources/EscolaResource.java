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

import com.dozek.servicephoto.domain.Cliente;
import com.dozek.servicephoto.domain.Escola;
//import com.dozek.servicephoto.domain.dto.EscolaDTO;
import com.dozek.servicephoto.services.EscolaService;

@RestController
@RequestMapping(value="/escola")
public class EscolaResource {
	
	@Autowired
	private EscolaService service; 
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Escola> find(@PathVariable Integer id) {
		
	Escola obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(value="/pesquisa",method=RequestMethod.GET)
	public ResponseEntity<List<Escola>> find(@RequestParam(value="value")String nome) {
	List<Escola> obj = service.findByNome(nome);
	return ResponseEntity.ok().body(obj);		
	}
	
/*	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody EscolaDTO objDto){
		Escola obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}*/
	
	/*@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody EscolaDTO objDto,@PathVariable Integer id){
		Escola obj = service.fromDTO(objDto);
		obj.setId(id);
		//obj = service.update(obj);
		return ResponseEntity.noContent().build();		
	}*/
	
		
	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Escola>> findAll() {
		
	List<Escola> list = service.findAll();
//	List<EscolaDTO> listDTO =list.stream().map(obj -> new EscolaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
		
	}
	

	/*@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<Escola>> findPage(
		    @RequestParam(value="page",defaultValue="0")Integer page,
		    @RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage,
		    @RequestParam(value="ordeBy",defaultValue="nome")String ordeBy,
		    @RequestParam(value="direction",defaultValue="ASC")String direction
			) {
		
	Page<Escola> list = service.findPage(page, linesPerPage, ordeBy, direction);
	//Page<EscolaDTO> listDTO =list.map(obj -> new EscolaDTO(obj));
		return ResponseEntity.ok().body(list);
		
	}*/
	
	

}
