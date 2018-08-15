package com.dozek.servicephoto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dozek.servicephoto.domain.Cidade;
import com.dozek.servicephoto.domain.Cliente;
import com.dozek.servicephoto.domain.Endereco;
import com.dozek.servicephoto.domain.dto.EnderecoDTO;
import com.dozek.servicephoto.repositories.ClienteRepository;
import com.dozek.servicephoto.repositories.EnderecoRepository;
import com.dozek.servicephoto.services.execeptions.DataIntegrityException;
import com.dozek.servicephoto.services.execeptions.ObjectNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repo;
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Endereco find(Integer id) {
		
		Endereco obj=repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id" + id
					+",Tipo: "+ Endereco.class.getName());
		}
		return obj;
		
	}
	
	public Endereco insert(Endereco obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
	public Endereco update(Endereco obj) {
		Endereco newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
			}
			catch(DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possível excluir uma endereço");
			}
	}
	
	public List<Endereco>findAll(){
		return repo.findAll();
	}
	
	/*public Page<Endereco> findPage(Integer page,Integer linesPerPage, String ordeBy,String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf(direction),ordeBy);
		return repo.findAll(pageRequest);		
	}*/
	
	public Endereco fromDTO(EnderecoDTO objDto) {
		Cliente cli = clienteRepository.findOne(objDto.getClienteId());
		Cidade cit = new Cidade (objDto.getCidadeId(),null,null);
		return new Endereco(objDto.getId(), objDto.getLogradouro(),objDto.getNumero(),objDto.getComplemento(), objDto.getBairro(),
				objDto.getCep(), cli, null,cit);
				
		
	}
	private void updateData(Endereco newObj, Endereco obj) {
		newObj.setId(obj.getId());
		newObj.setLogradouro(obj.getLogradouro());
		newObj.setNumero(obj.getNumero());
		newObj.setComplemento(obj.getComplemento());
		newObj.setBairro(obj.getBairro());
		newObj.setCep(obj.getCep());
				
		}

}
