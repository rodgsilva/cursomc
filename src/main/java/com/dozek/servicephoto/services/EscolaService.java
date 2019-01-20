package com.dozek.servicephoto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dozek.servicephoto.domain.Cliente;
import com.dozek.servicephoto.domain.Escola;
import com.dozek.servicephoto.domain.enums.Perfil;
//import com.dozek.servicephoto.domain.dto.EscolaDTO;
import com.dozek.servicephoto.repositories.EscolaRepository;
import com.dozek.servicephoto.security.UserSS;
import com.dozek.servicephoto.services.execeptions.AuthorizationException;
import com.dozek.servicephoto.services.execeptions.DataIntegrityException;
import com.dozek.servicephoto.services.execeptions.ObjectNotFoundException;

@Service
public class EscolaService {
	
	@Autowired
	private EscolaRepository repo;
	
	public Escola find(Integer id) {
		
		Escola obj=repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id" + id
					+",Tipo: "+ Escola.class.getName());
		}
		return obj;
		
	}
	

	public List<Escola> findByNome(String nome) {
		List<Escola> obj = repo.findByNomeLike(nome);
		
		if(obj ==null) {
			throw new ObjectNotFoundException(
					"Objeto não encotrado! Nome: "+ nome+".");
		}
		return obj;
	}
	
	
	
	
	public Escola insert(Escola obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
/*	public Escola update(Escola obj) {
		Escola newObj = find(obj.getId());
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
				throw new DataIntegrityException("Não é possível excluir uma Escola que possui produtos");
			}
	}
	
	public List<Escola>findAll(){
		return repo.findAll();
	}
	
	public Page<Escola> findPage(Integer page,Integer linesPerPage, String ordeBy,String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf(direction),ordeBy);
		return repo.findAll(pageRequest);		
	}
	
	/*public Escola fromDTO(EscolaDTO objDto) {
		return new Escola(objDto.getId(), objDto.getNome());
	}
	
	private void updateData(Escola newObj, Escola obj) {
		newObj.setNome(obj.getNome());
		}
*/
}
