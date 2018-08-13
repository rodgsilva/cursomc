package com.dozek.servicephoto.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dozek.servicephoto.domain.Cliente;
import com.dozek.servicephoto.domain.ItemPedido;
import com.dozek.servicephoto.domain.PagamentoComBoleto;
import com.dozek.servicephoto.domain.Pedido;
import com.dozek.servicephoto.domain.enums.EstadoPagamento;
import com.dozek.servicephoto.repositories.ClienteRepository;
import com.dozek.servicephoto.repositories.ItemPedidoRepository;
import com.dozek.servicephoto.repositories.PagamentoRepository;
import com.dozek.servicephoto.repositories.PedidoRepository;
import com.dozek.servicephoto.repositories.ProdutoRepository;
import com.dozek.servicephoto.security.UserSS;
import com.dozek.servicephoto.services.execeptions.AuthorizationException;
import com.dozek.servicephoto.services.execeptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	@Autowired
	private BoletoService boletoService;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EmailService emailService;
	
	public Pedido find(Integer id) {
		
		Pedido obj=repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id" + id
					+", Tipo: "+ Pedido.class.getName());
		}
		return obj;
		
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteRepository.findOne(obj.getCliente().getId()));
		obj.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto,obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for(ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoRepository.findOne(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);			
		}
		itemPedidoRepository.save(obj.getItens());
		emailService.sendOrderConfirmationHtmlEmail(obj);
		return obj;
	}

	public Page<Pedido> findPage(Integer page,Integer linesPerPage, String ordeBy,String direction){
		
		UserSS user =UserService.authenticated();
		if (user== null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf(direction),ordeBy);
		Cliente cliente = clienteRepository.findOne(user.getId());
		return repo.findByCliente(cliente, pageRequest);		
	}
}
