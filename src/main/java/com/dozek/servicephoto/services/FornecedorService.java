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
import com.dozek.servicephoto.domain.Endereco;
import com.dozek.servicephoto.domain.Fornecedor;
import com.dozek.servicephoto.domain.dto.FornecedorDTO;
import com.dozek.servicephoto.domain.dto.FornecedorNewDTO;
import com.dozek.servicephoto.domain.enums.Perfil;
import com.dozek.servicephoto.domain.enums.TipoCliente;
import com.dozek.servicephoto.repositories.EnderecoRepository;
import com.dozek.servicephoto.repositories.FornecedorRepository;
import com.dozek.servicephoto.security.UserSS;
import com.dozek.servicephoto.services.execeptions.AuthorizationException;
import com.dozek.servicephoto.services.execeptions.DataIntegrityException;
import com.dozek.servicephoto.services.execeptions.ObjectNotFoundException;

@Service
public class FornecedorService {
	
	@Autowired
	private  BCryptPasswordEncoder pe;
	
	@Autowired
	private FornecedorRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public Fornecedor find(Integer id) {
		
	/*	UserSS user = UserService.authenticated();
		
		if(user==null ||!user.hasRole(Perfil.ADMIN)&& !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso Negado");
		}
		*/
		Fornecedor obj=repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id " + id
					+",Tipo: "+ Fornecedor.class.getName());
		}
		return obj;
		
	}
	
	public Fornecedor findByEmail(String email) {
		UserSS user =UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso Negado");
		}
		Fornecedor obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objento não encontrado! id: "+ user.getId()+", Tipo "+Fornecedor.class.getName());
			}
		return obj;
	}
	
	@Transactional
	public Fornecedor insert(Fornecedor obj) {
		obj.setId(null);
		 repo.save(obj);
		 enderecoRepository.save(obj.getEndereco());
		 return obj;
		
	}
	
	public Fornecedor update(Fornecedor obj) {
		Fornecedor newObj = find(obj.getId());
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
	
	public List<Fornecedor>findAll(){
		return repo.findAll();
	}
	
	public Page<Fornecedor> findPage(Integer page,Integer linesPerPage, String ordeBy,String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf(direction),ordeBy);
		return repo.findAll(pageRequest);		
	}
	
	public Fornecedor fromDTO(FornecedorDTO objDto) {
		return new Fornecedor(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null,null);
		
	}
	
	public Fornecedor fromDTO(FornecedorNewDTO objDto) {
		Fornecedor fornec = new Fornecedor(null, objDto.getNome(), objDto.getEmail(),objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()),pe.encode(objDto.getSenha()));
		Cidade cit = new Cidade (objDto.getCidadeId(),null,null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(),null,fornec, cit);
		fornec.getEndereco().add(end);
		//fornec.getTelefone().add(objDto.getTelefone1());
		
		/*if (objDto.getTelefone2()!=null) {
			cli.getTelefone().add(objDto.getTelefone2());
			}
		if (objDto.getTelefone3()!=null) {
			cli.getTelefone().add(objDto.getTelefone3());
		}*/
		return fornec;
	}
	
	private void updateData(Fornecedor newObj, Fornecedor obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}


}
