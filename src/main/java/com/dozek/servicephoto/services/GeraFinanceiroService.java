package com.dozek.servicephoto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dozek.servicephoto.domain.FinanceiroPagar;
import com.dozek.servicephoto.domain.FinanceiroPagarParcela;
import com.dozek.servicephoto.domain.PedidoCompra;
import com.dozek.servicephoto.domain.dto.GeraParcelaDTO;
import com.dozek.servicephoto.domain.dto.PagarParcelaDTO;
import com.dozek.servicephoto.domain.enums.EstadoPagamento;
import com.dozek.servicephoto.repositories.FinanceiroPagarParcelaRepository;
import com.dozek.servicephoto.repositories.FinanceiroPagarRepository;
import com.dozek.servicephoto.repositories.PedidoCompraRepository;
//import com.jayway.jsonpath.internal.function.text.Length;

@Service
public class GeraFinanceiroService {
	
	@Autowired
	private FinanceiroPagarRepository repo;

	@Autowired
	private PedidoCompraRepository pedidoCompraRepository;
	
	@Autowired
	private FinanceiroPagarParcelaRepository parcelaRepository;
//	@Autowired
	//private EmailService emailService;
	
	public List<FinanceiroPagar> find(Integer id) {
		
		//FinanceiroPagar obj = 
		
		List<FinanceiroPagar> obj = repo.findByPedidoCompra(id);
	
		return obj;
		
	}
	
	
	public FinanceiroPagarParcela FindParcela(Integer id) {
		
		//FinanceiroPagar obj = 
		
		FinanceiroPagarParcela obj = parcelaRepository.findOne(id);
	
		return obj;
		
	}
	
	public PedidoCompra findByPedido(Integer id) {
		
		//FinanceiroPagar obj = 
		
		PedidoCompra obj = pedidoCompraRepository.findOne(id);
	
		return obj;
		
	}
	
	public List<FinanceiroPagar> findAll() {
		return repo.findAll();
		
	}
	
	
	@Transactional
	public FinanceiroPagar insert(FinanceiroPagar obj) {
		
	//	List<FinanceiroPagarParcela> parc =(List<FinanceiroPagarParcela>) obj.getFinanceiroPagarParcela();
	//	parc.getFinanceiroPagar(obj.getId());
		//obj.getFinanceiroPagarParcela().
		obj = repo.save(obj);
		for(FinanceiroPagarParcela fpar : obj.getFinanceiroPagarParcela()) {
			fpar.setFinanceiroPagar(obj);
		}
		
	    parcelaRepository.save(obj.getFinanceiroPagarParcela());
		return obj;
		
		//LOG.info(obj.toString());
	}
  //**Removido o financeiro a pgar será incluido na proxima tela no frontend
	
	@Transactional
	public Page<FinanceiroPagar> findPage(Integer page,Integer linesPerPage, String ordeBy,String direction){

		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf(direction),ordeBy);

		
		return repo.findAll(pageRequest);	
		
	}
	
	public FinanceiroPagar fromDTO(GeraParcelaDTO objDTO) {
		PedidoCompra ped = pedidoCompraRepository.findOne(objDTO.getPedidoCompraId());
		
		FinanceiroPagar fpag = new FinanceiroPagar(null, EstadoPagamento.PENDENTE,ped,objDTO.getValorTotal());
		FinanceiroPagarParcela obj = new FinanceiroPagarParcela(null, objDTO.getNumerodoc(), objDTO.getDataVencimento(), null, objDTO.getValorTotal(), fpag);
		fpag.getFinanceiroPagarParcela().add(obj);
		//	(null, EstadoPagamento.PENDENTE, ped,objDTO.getNumerodoc(), objDTO.getDataVencimento(), null, objDTO.getValorTotal());
		
		//                     new FinanceiroPagarComBoleto(id, estadoPagamento, pedidoCompra, numeroDocumento, dataVencimento, dataPagamento, valorParcela)
	   return fpag;  
	 }
	
	public FinanceiroPagarParcela update(FinanceiroPagarParcela obj) {
		FinanceiroPagarParcela newObj = FindParcela(obj.getParcId());
		updateData(newObj,obj);
		return parcelaRepository.save(newObj);
	}
	
	private void updateData(FinanceiroPagarParcela newObj, FinanceiroPagarParcela obj) {
		newObj.setDataPagamento(obj.getDataPagamento());
		//newObj.setEmail(obj.getEmail());
	//	newObj.setCpfOuCnpj(obj.getCpfOuCnpj()); 
		
	}

	
	public FinanceiroPagarParcela fromDTO(PagarParcelaDTO objDto) {
		return new FinanceiroPagarParcela(objDto.getId(), objDto.getNumeroDocumento(),objDto.getDataVencimento(),objDto.getDataPagamento(),objDto.getValorParcela(), null);
			
		
		
	}
	
	
	
/*	public FinanceiroPagar from(FinanceiroPagar fpag) {
		PedidoCompra ped = pedidoCompraRepository.findOne(objDTO.getPedidoCompraId());
		
		
		for(ItemPedido ip : fpag.getFinanceiroPagarParcela())) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoRepository.findOne(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);			
		}
		
		fpag.getPedidoCompra(ped); FinanceiroPagar(null, EstadoPagamento.PENDENTE,ped,fpag.getValorTotal());
		FinanceiroPagarParcela obj = new FinanceiroPagarParcela(null, fpag.getNumerodoc(), objDTO.getDataVencimento(), null, objDTO.getValorTotal(), fpag);
		fpag.getFinanceiroPagarParcela().add(obj);
		//	(null, EstadoPagamento.PENDENTE, ped,objDTO.getNumerodoc(), objDTO.getDataVencimento(), null, objDTO.getValorTotal());
		
		//                     new FinanceiroPagarComBoleto(id, estadoPagamento, pedidoCompra, numeroDocumento, dataVencimento, dataPagamento, valorParcela)
	   return fpag;  
	 } 
	*/
	
}
