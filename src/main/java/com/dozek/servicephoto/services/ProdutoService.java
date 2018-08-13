package com.dozek.servicephoto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dozek.servicephoto.domain.Categoria;
import com.dozek.servicephoto.domain.Produto;
import com.dozek.servicephoto.repositories.CategoriaRepository;
import com.dozek.servicephoto.repositories.ProdutoRepository;
import com.dozek.servicephoto.services.execeptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		
		Produto obj=repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id" + id
					+", Tipo: "+ Produto.class.getName());
		}
		return obj;
		
	}
	public Page<Produto> search(String nome, List<Integer> ids,Integer page,Integer linesPerPage, String ordeBy,String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf(direction),ordeBy);
		List<Categoria> categoria = categoriaRepository.findAll(ids);
				
		return repo.findDistinctByNomeContainingAndCategoriaIn(nome,categoria,pageRequest);
		
	}

}
