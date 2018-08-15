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

import com.dozek.servicephoto.domain.Fornecedor;
import com.dozek.servicephoto.domain.dto.FornecedorDTO;
import com.dozek.servicephoto.domain.dto.FornecedorNewDTO;
import com.dozek.servicephoto.services.FornecedorService;

@RestController
@RequestMapping(value="/fornecedor")
public class FornecedorResource {
	
	@Autowired
	private FornecedorService service; 
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Fornecedor> find(@PathVariable Integer id) {
		
		Fornecedor obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(value="/email",method=RequestMethod.GET)
	public ResponseEntity<Fornecedor> find(@RequestParam(value="value")String email) {
		Fornecedor obj = service.findByEmail(email);
	return ResponseEntity.ok().body(obj);		
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody FornecedorNewDTO objDto){
		Fornecedor obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody FornecedorDTO objDto,@PathVariable Integer id){
		Fornecedor obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
		
	}
	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<FornecedorDTO>> findAll() {
		
	List<Fornecedor> list = service.findAll();
	List<FornecedorDTO> listDTO =list.stream().map(obj -> new FornecedorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<FornecedorDTO>> findPage(
		    @RequestParam(value="page",defaultValue="0")Integer page,
		    @RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage,
		    @RequestParam(value="ordeBy",defaultValue="nome")String ordeBy,
		    @RequestParam(value="direction",defaultValue="ASC")String direction
			) {
		
	Page<Fornecedor> list = service.findPage(page, linesPerPage, ordeBy, direction);
	Page<FornecedorDTO> listDTO =list.map(obj -> new FornecedorDTO(obj));
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	


}
