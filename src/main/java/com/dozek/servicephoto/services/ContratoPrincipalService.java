package com.dozek.servicephoto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dozek.servicephoto.domain.ContratoPrincipal;
//import com.dozek.servicephoto.domain.dto.ContratoPrincipalDTO;
import com.dozek.servicephoto.repositories.ContratoPrincipalRepository;
import com.dozek.servicephoto.services.execeptions.DataIntegrityException;
import com.dozek.servicephoto.services.execeptions.ObjectNotFoundException;

@Service
public class ContratoPrincipalService {
	
	@Autowired
	private ContratoPrincipalRepository repo;
	
	public ContratoPrincipal find(Integer id) {
		
		ContratoPrincipal obj=repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id" + id
					+",Tipo: "+ ContratoPrincipal.class.getName());
		}
		return obj;
		
	}
	
	public ContratoPrincipal insert(ContratoPrincipal obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
/*	public ContratoPrincipal update(ContratoPrincipal obj) {
		ContratoPrincipal newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	*/
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
			}
			catch(DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possível excluir uma ContratoPrincipal que possui produtos");
			}
	}
	
	public List<ContratoPrincipal>findAll(){
		return repo.findAll();
	}
	
	public Page<ContratoPrincipal> findPage(Integer page,Integer linesPerPage, String ordeBy,String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf(direction),ordeBy);
		return repo.findAll(pageRequest);		
	}
	
	/*public ContratoPrincipal fromDTO(ContratoPrincipalDTO objDto) {
		return new ContratoPrincipal(objDto.getId(), objDto.getNome());
	}
	
	private void updateData(ContratoPrincipal newObj, ContratoPrincipal obj) {
		newObj.setNome(obj.getNome());
		}
*/
}
