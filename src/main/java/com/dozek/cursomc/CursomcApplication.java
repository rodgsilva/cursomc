package com.dozek.cursomc;

import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dozek.cursomc.domain.Categoria;
import com.dozek.cursomc.domain.Cidade;
import com.dozek.cursomc.domain.Cliente;
import com.dozek.cursomc.domain.Endereco;
import com.dozek.cursomc.domain.Estado;
import com.dozek.cursomc.domain.Pagamento;
import com.dozek.cursomc.domain.PagamentoComBoleto;
import com.dozek.cursomc.domain.PagamentoComCartao;
import com.dozek.cursomc.domain.Pedido;
import com.dozek.cursomc.domain.Produto;
import com.dozek.cursomc.domain.enums.EstadoPagamento;
import com.dozek.cursomc.domain.enums.TipoCliente;
import com.dozek.cursomc.repositories.CategoriaRepository;
import com.dozek.cursomc.repositories.CidadeRepository;
import com.dozek.cursomc.repositories.ClienteRepository;
import com.dozek.cursomc.repositories.EnderecoRepository;
import com.dozek.cursomc.repositories.EstadoRepository;
import com.dozek.cursomc.repositories.PagamentoRepository;
import com.dozek.cursomc.repositories.PedidoRepository;
import com.dozek.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoRepository prodRepo;
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null,"Infromarica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto p1 = new Produto(null,"Compudator",2000.00);
		Produto p2 = new Produto (null,"Impressoara",800.00);
		Produto p3 = new Produto(null,"mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1,cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));
		
				
		repo.save(Arrays.asList(cat1,cat2));
		prodRepo.save(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia",est1);
		Cidade c2 = new Cidade(null,"São Paulo", est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidade().addAll(Arrays.asList(c1));
		est2.getCidade().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.save(Arrays.asList(est1,est2));
		cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
		
		Cliente cli1 =new Cliente(null, "Maria da Silva", "maria@gmail.com","36378913377", TipoCliente.PESSOAFISICA);
		cli1.getTelefone().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 =new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim","38220634", cli1, c1);
		Endereco e2 =new Endereco(null, "Avenida Matos", "195", "Sala 800","Centro","38777012", cli1, c2);
		
		cli1.getEndereco().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017  10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017  19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.save(Arrays.asList(ped1,ped2));
		pagamentoRepository.save(Arrays.asList(pagto1,pagto2));
		
	}
	
}
