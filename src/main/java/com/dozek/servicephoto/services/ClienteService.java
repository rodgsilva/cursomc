package com.dozek.servicephoto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dozek.servicephoto.domain.Cidade;
import com.dozek.servicephoto.domain.Cliente;
import com.dozek.servicephoto.domain.Endereco;
import com.dozek.servicephoto.domain.dto.ClienteDTO;
import com.dozek.servicephoto.domain.dto.ClienteNewDTO;
import com.dozek.servicephoto.domain.enums.Perfil;
import com.dozek.servicephoto.domain.enums.TipoCliente;
import com.dozek.servicephoto.repositories.ClienteRepository;
import com.dozek.servicephoto.repositories.EnderecoRepository;
import com.dozek.servicephoto.security.UserSS;
import com.dozek.servicephoto.services.execeptions.AuthorizationException;
import com.dozek.servicephoto.services.execeptions.DataIntegrityException;
import com.dozek.servicephoto.services.execeptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private  BCryptPasswordEncoder pe;
	
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public Cliente find(Integer id) {
		
		UserSS user = UserService.authenticated();
		
		if(user==null ||!user.hasRole(Perfil.ADMIN)&& !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso Negado");
		}
		 String name2;
		
		Cliente obj=repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id " + id
					+",Tipo: "+ Cliente.class.getName());
		}
		return obj;
		
	}
	
	public Cliente findByEmail(String email) {
		UserSS user =UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso Negado");
		}
		Cliente obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objento não encontrado! id: "+ user.getId()+", Tipo "+Cliente.class.getName());
			}
		return obj;
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		 repo.save(obj);
		 enderecoRepository.save(obj.getEndereco());
		 return obj;
		
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
			}
			catch(DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionadas");
			}
	}
	
	public List<Cliente>findAll(){
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page,Integer linesPerPage, String ordeBy,String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf(direction),ordeBy);
		return repo.findAll(pageRequest);		
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(),null,null);
		
		
	}
	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(),objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()),pe.encode(objDto.getSenha()));
		Cidade cit = new Cidade (objDto.getCidadeId(),null,null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli,null, cit);
		cli.getEndereco().add(end);
		cli.getTelefone().add(objDto.getTelefone1());
		
		if (objDto.getTelefone2()!=null) {
			cli.getTelefone().add(objDto.getTelefone2());
			}
		if (objDto.getTelefone3()!=null) {
			cli.getTelefone().add(objDto.getTelefone3());
		}
		return cli;
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setCpfOuCnpj(obj.getCpfOuCnpj()); 
		
	}  


}
