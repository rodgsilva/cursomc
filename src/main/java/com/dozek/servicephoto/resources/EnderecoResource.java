package com.dozek.servicephoto.resources;


import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dozek.servicephoto.domain.Endereco;
import com.dozek.servicephoto.domain.dto.EnderecoDTO;
import com.dozek.servicephoto.services.EnderecoService;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service; 
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Endereco> find(@PathVariable Integer id) {
		
	Endereco obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody EnderecoDTO objDto){
		Endereco obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody EnderecoDTO objDto,@PathVariable Integer id){
		Endereco obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/*@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EnderecoDTO>> findAll() {
		
	List<Endereco> list = service.findAll();
	List<EnderecoDTO> listDTO =list.stream().map(obj -> new EnderecoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}*/
	

/*	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<EnderecoDTO>> findPage(
		    @RequestParam(value="page",defaultValue="0")Integer page,
		    @RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage,
		    @RequestParam(value="ordeBy",defaultValue="nome")String ordeBy,
		    @RequestParam(value="direction",defaultValue="ASC")String direction
			) {
		
	Page<Endereco> list = service.findPage(page, linesPerPage, ordeBy, direction);
	Page<EnderecoDTO> listDTO =list.map(obj -> new EnderecoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
		
	}*/
	
	

}
