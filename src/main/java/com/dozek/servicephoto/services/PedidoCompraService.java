package com.dozek.servicephoto.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dozek.servicephoto.domain.FinanceiroPagarParcela;
import com.dozek.servicephoto.domain.Fornecedor;
import com.dozek.servicephoto.domain.ItemPedidoCompra;
import com.dozek.servicephoto.domain.PedidoCompra;
import com.dozek.servicephoto.domain.enums.EstadoPagamento;
import com.dozek.servicephoto.repositories.FinanceiroPagarRepository;
import com.dozek.servicephoto.repositories.FornecedorRepository;
import com.dozek.servicephoto.repositories.ItemPedidoCompraRepository;
import com.dozek.servicephoto.repositories.PedidoCompraRepository;
import com.dozek.servicephoto.repositories.ProdutoRepository;
import com.dozek.servicephoto.security.UserSS;
import com.dozek.servicephoto.services.execeptions.AuthorizationException;
import com.dozek.servicephoto.services.execeptions.ObjectNotFoundException;



@Service
public class PedidoCompraService {
	
	@Autowired
	private PedidoCompraRepository repo;
	@Autowired
	private GeraBoletoFinanceiroApagarService boletoService;
	@Autowired
	private FinanceiroPagarRepository financeiroRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ItemPedidoCompraRepository itemPedidoCompraRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
//	@Autowired
	//private EmailService emailService;
	
	public PedidoCompra find(Integer id) {
		
		PedidoCompra obj=repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id" + id
					+", Tipo: "+ PedidoCompra.class.getName());
		}
		return obj;
		
	}
	
	@Transactional
	public PedidoCompra insert(PedidoCompra obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setFornecedor(fornecedorRepository.findOne(obj.getFornecedor().getId()));
		
		// obj.getFinanceiroPagar().setEstadoPagamento(EstadoPagamento.PENDENTE);
		// obj.getFinanceiroPagar().setPedidoCompra(obj);
		
		  FinanceiroPagarParcela pagto;// = obj.getFinanceiroPagar();
		 // boletoService.preencherPagamentoComBoleto(pagto,obj.getInstante());
		
		obj = repo.save(obj);
		//financeiroRepository.save(obj.getFinanceiroPagar());
		for(ItemPedidoCompra ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoRepository.findOne(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedidoCompra(obj);			
		}
		//obj.getFinanceiroPagar().setValorTotal(obj.getValorTotal());
		//financeiroRepository.save(obj.getFinanceiroPagar());
		itemPedidoCompraRepository.save(obj.getItens());
		
		//emailService.sendOrderConfirmationHtmlEmail(obj);
		return obj;
	}

	public Page<PedidoCompra> findPage(Integer page,Integer linesPerPage, String ordeBy,String direction){
		
		UserSS user =UserService.authenticated();
		if (user== null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf(direction),ordeBy);
		Fornecedor fornecedor = fornecedorRepository.findOne(user.getId());
		return repo.findByFornecedor(fornecedor, pageRequest);		
	}
}
