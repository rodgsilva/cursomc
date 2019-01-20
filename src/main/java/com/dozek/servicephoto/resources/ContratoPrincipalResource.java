package com.dozek.servicephoto.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dozek.servicephoto.domain.ContratoPrincipal;
//import com.dozek.servicephoto.domain.dto.ContratoPrincipalDTO;
import com.dozek.servicephoto.services.ContratoPrincipalService;

@RestController
@RequestMapping(value="/contratoprincipal")
public class ContratoPrincipalResource {
	
	@Autowired
	private ContratoPrincipalService service; 
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<ContratoPrincipal> find(@PathVariable Integer id) {
		
	ContratoPrincipal obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
/*	@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ContratoPrincipalDTO objDto){
		ContratoPrincipal obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}*/
	
	/*@PreAuthorize("hasAnyRole('USUARIO')")
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ContratoPrincipalDTO objDto,@PathVariable Integer id){
		ContratoPrincipal obj = service.fromDTO(objDto);
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
	public ResponseEntity<List<ContratoPrincipal>> findAll() {
		
	List<ContratoPrincipal> list = service.findAll();
//	List<ContratoPrincipalDTO> listDTO =list.stream().map(obj -> new ContratoPrincipalDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
		
	}
	

/*	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<ContratoPrincipalDTO>> findPage(
		    @RequestParam(value="page",defaultValue="0")Integer page,
		    @RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage,
		    @RequestParam(value="ordeBy",defaultValue="nome")String ordeBy,
		    @RequestParam(value="direction",defaultValue="ASC")String direction
			) {
		
	Page<ContratoPrincipal> list = service.findPage(page, linesPerPage, ordeBy, direction);
	Page<ContratoPrincipalDTO> listDTO =list.map(obj -> new ContratoPrincipalDTO(obj));
		return ResponseEntity.ok().body(listDTO);
		
	}*/
	
	

}
