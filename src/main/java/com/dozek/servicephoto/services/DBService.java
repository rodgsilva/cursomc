package com.dozek.servicephoto.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dozek.servicephoto.domain.Categoria;
import com.dozek.servicephoto.domain.CentroRateio;
import com.dozek.servicephoto.domain.Cidade;
import com.dozek.servicephoto.domain.Cliente;
import com.dozek.servicephoto.domain.Empresa;
import com.dozek.servicephoto.domain.Endereco;
import com.dozek.servicephoto.domain.Estado;
import com.dozek.servicephoto.domain.Financeiro;
import com.dozek.servicephoto.domain.FinanceiroPagar;
import com.dozek.servicephoto.domain.FinanceiroPagarParcela;
import com.dozek.servicephoto.domain.FinanceiroParcela;
import com.dozek.servicephoto.domain.Fornecedor;
import com.dozek.servicephoto.domain.ItemPedido;
import com.dozek.servicephoto.domain.ItemPedidoCompra;
import com.dozek.servicephoto.domain.Pedido;
import com.dozek.servicephoto.domain.PedidoCompra;
import com.dozek.servicephoto.domain.Produto;
import com.dozek.servicephoto.domain.enums.EstadoPagamento;
import com.dozek.servicephoto.domain.enums.Perfil;
import com.dozek.servicephoto.domain.enums.TipoCliente;
import com.dozek.servicephoto.repositories.CategoriaRepository;
import com.dozek.servicephoto.repositories.CentroRateioRepository;
import com.dozek.servicephoto.repositories.CidadeRepository;
import com.dozek.servicephoto.repositories.ClienteRepository;
import com.dozek.servicephoto.repositories.EmpresaRepository;
import com.dozek.servicephoto.repositories.EnderecoRepository;
import com.dozek.servicephoto.repositories.EstadoRepository;
import com.dozek.servicephoto.repositories.FinanceiroPagarRepository;
import com.dozek.servicephoto.repositories.FinanceiroRepository;
import com.dozek.servicephoto.repositories.FornecedorRepository;
import com.dozek.servicephoto.repositories.ItemPedidoCompraRepository;
import com.dozek.servicephoto.repositories.ItemPedidoRepository;
import com.dozek.servicephoto.repositories.PagamentoRepository;
import com.dozek.servicephoto.repositories.PedidoCompraRepository;
import com.dozek.servicephoto.repositories.PedidoRepository;
import com.dozek.servicephoto.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;

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
	private PedidoCompraRepository pedidoCompraRepository;
	@Autowired
	private FinanceiroRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itempedidoRepository;
	@Autowired
	private ItemPedidoCompraRepository itempedidoCompraRepository;
	@Autowired
	private FinanceiroPagarRepository finenceiroRepository;
    @Autowired
	private FornecedorRepository fornecedorRepository;
    @Autowired
	private EmpresaRepository empresaRepository;
    @Autowired
	private CentroRateioRepository centroRateioRepository;

	@Autowired
	private ProdutoRepository prodRepo;

	public void instantiateTestDataBase() throws ParseException {

		Categoria cat1 = new Categoria(null, "Infromarica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");

		Produto p1 = new Produto(null, "Compudator", 2500.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		Produto p12 = new Produto(null, "Produto 12", 10.00);
		Produto p13 = new Produto(null, "Produto 13", 10.00);
		Produto p14 = new Produto(null, "Produto 14", 10.00);
		Produto p15 = new Produto(null, "Produto 15", 10.00);
		Produto p16 = new Produto(null, "Produto 16", 10.00);
		Produto p17 = new Produto(null, "Produto 17", 10.00);
		Produto p18 = new Produto(null, "Produto 18", 10.00);
		Produto p19 = new Produto(null, "Produto 19", 10.00);
		Produto p20 = new Produto(null, "Produto 20", 10.00);
		Produto p21 = new Produto(null, "Produto 21", 10.00);
		Produto p22 = new Produto(null, "Produto 22", 10.00);
		Produto p23 = new Produto(null, "Produto 23", 10.00);
		Produto p24 = new Produto(null, "Produto 24", 10.00);
		Produto p25 = new Produto(null, "Produto 25", 10.00);
		Produto p26 = new Produto(null, "Produto 26", 10.00);
		Produto p27 = new Produto(null, "Produto 27", 10.00);
		Produto p28 = new Produto(null, "Produto 28", 10.00);
		Produto p29 = new Produto(null, "Produto 29", 10.00);
		Produto p30 = new Produto(null, "Produto 30", 10.00);
		Produto p31 = new Produto(null, "Produto 31", 10.00);
		Produto p32 = new Produto(null, "Produto 32", 10.00);
		Produto p33 = new Produto(null, "Produto 33", 10.00);
		Produto p34 = new Produto(null, "Produto 34", 10.00);
		Produto p35 = new Produto(null, "Produto 35", 10.00);
		Produto p36 = new Produto(null, "Produto 36", 10.00);
		Produto p37 = new Produto(null, "Produto 37", 10.00);
		Produto p38 = new Produto(null, "Produto 38", 10.00);
		Produto p39 = new Produto(null, "Produto 39", 10.00);
		Produto p40 = new Produto(null, "Produto 40", 10.00);
		Produto p41 = new Produto(null, "Produto 41", 10.00);
		Produto p42 = new Produto(null, "Produto 42", 10.00);
		Produto p43 = new Produto(null, "Produto 43", 10.00);
		Produto p44 = new Produto(null, "Produto 44", 10.00);
		Produto p45 = new Produto(null, "Produto 45", 10.00);
		Produto p46 = new Produto(null, "Produto 46", 10.00);
		Produto p47 = new Produto(null, "Produto 47", 10.00);
		Produto p48 = new Produto(null, "Produto 48", 10.00);
		Produto p49 = new Produto(null, "Produto 49", 10.00);
		Produto p50 = new Produto(null, "Produto 50", 10.00);

		cat1.getProdutos().addAll(
		Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27,
		p28, p29, p30, p31, p32, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46, p47,
		p48, p49, p50));

		p12.getCategoria().add(cat1);
		p13.getCategoria().add(cat1);
		p14.getCategoria().add(cat1);
		p15.getCategoria().add(cat1);
		p16.getCategoria().add(cat1);
		p17.getCategoria().add(cat1);
		p18.getCategoria().add(cat1);
		p19.getCategoria().add(cat1);
		p20.getCategoria().add(cat1);
		p21.getCategoria().add(cat1);
		p22.getCategoria().add(cat1);
		p23.getCategoria().add(cat1);
		p24.getCategoria().add(cat1);
		p25.getCategoria().add(cat1);
		p26.getCategoria().add(cat1);
		p27.getCategoria().add(cat1);
		p28.getCategoria().add(cat1);
		p29.getCategoria().add(cat1);
		p30.getCategoria().add(cat1);
		p31.getCategoria().add(cat1);
		p32.getCategoria().add(cat1);
		p33.getCategoria().add(cat1);
		p34.getCategoria().add(cat1);
		p35.getCategoria().add(cat1);
		p36.getCategoria().add(cat1);
		p37.getCategoria().add(cat1);
		p38.getCategoria().add(cat1);
		p39.getCategoria().add(cat1);
		p40.getCategoria().add(cat1);
		p41.getCategoria().add(cat1);
		p42.getCategoria().add(cat1);
		p43.getCategoria().add(cat1);
		p44.getCategoria().add(cat1);
		p45.getCategoria().add(cat1);
		p46.getCategoria().add(cat1);
		p47.getCategoria().add(cat1);
		p48.getCategoria().add(cat1);
		p49.getCategoria().add(cat1);
		p50.getCategoria().add(cat1);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategoria().addAll(Arrays.asList(cat1, cat4));
		p2.getCategoria().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategoria().addAll(Arrays.asList(cat1, cat4));
		p4.getCategoria().addAll(Arrays.asList(cat2));
		p5.getCategoria().addAll(Arrays.asList(cat3));
		p6.getCategoria().addAll(Arrays.asList(cat3));
		p7.getCategoria().addAll(Arrays.asList(cat4));
		p8.getCategoria().addAll(Arrays.asList(cat5));
		p9.getCategoria().addAll(Arrays.asList(cat6));
		p10.getCategoria().addAll(Arrays.asList(cat6));
		p11.getCategoria().addAll(Arrays.asList(cat7));

		repo.save(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		prodRepo.save(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		prodRepo.save(Arrays.asList(p12, p13, p14, p15, p16, p17, p18,
				p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31,
				p32, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45,
				p46, p47, p48, p49, p50)); 

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidade().addAll(Arrays.asList(c1));
		est2.getCidade().addAll(Arrays.asList(c2, c3));

		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		
		Fornecedor for1= new Fornecedor(null, "CrisME", "Cris.tonetti@gmail.com", "13101503000103",
				TipoCliente.PESSOAJURIDICA, pe.encode("123"));
		for1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		for1.addPerfil(Perfil.FOR);
		Fornecedor for2= new Fornecedor(null, "PedroJrME", "rod_feroz@Hotmail.com", "15151241000109",
				TipoCliente.PESSOAJURIDICA, pe.encode("123"));
		for2.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		for2.addPerfil(Perfil.FOR);
		
		Fornecedor for3= new Fornecedor(null, "Maria da Silva Gomes", "gomes@gmail.com", "57955364000142",
				TipoCliente.PESSOAJURIDICA, pe.encode("123"));
		/*for3.getTelefone().addAll(Arrays.asList("27363323", "93838393"));*/
		for3.addPerfil(Perfil.FOR);
	//	 fornecedorRepository.save(Arrays.asList(for1,for2,for3));
		 
		Cliente cli1 = new Cliente(null, "Maria da Silva", "rod_feroz@hotmail.com", "36378913377",
				TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli1.getTelefone().addAll(Arrays.asList("27363328", "93837393"));
		cli1.addPerfil(Perfil.USUARIO);
		
		Cliente cli2 = new Cliente(null, "Ana Costa", "rod.gomes.silva@gmail.com", "31628882740",
				TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli2.getTelefone().addAll(Arrays.asList("27363323", "93838393"));
		cli2.addPerfil(Perfil.ADMIN);
		
		Endereco e5 = new Endereco(null, "Avenida Matos", "195", "Sala 800", "Centro", "38777012", null,for2,c2);

		Endereco e6 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "281777012", null,for3,c2);
		
		Endereco e4 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220634", null,for1,c1);

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220634", cli1,null,c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "195", "Sala 800", "Centro", "38777012", cli1,null,c2);

		Endereco e3 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "281777012", cli2,null,c2);
  
		//Endereco e4 = new Endereco(id, logradouro, numero, complemento, bairro, cep, cliente, fornecedor, cidade)
		cli1.getEndereco().addAll(Arrays.asList(e1, e2));
		cli2.getEndereco().addAll(Arrays.asList(e3));
		for1.getEndereco().addAll(Arrays.asList(e4));
		
		fornecedorRepository.save(Arrays.asList(for1,for2,for3));
		clienteRepository.save(Arrays.asList(cli1, cli2));
		enderecoRepository.save(Arrays.asList(e1, e2, e3,e4,e5,e6));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017  10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017  19:35"), cli1, e2);
		
		 Empresa emp = empresaRepository.findOne(1);
				
		PedidoCompra pedComp1 = new PedidoCompra(null, sdf.parse("30/09/2018  10:32"), for1, emp);
		PedidoCompra pedComp2 = new PedidoCompra(null, sdf.parse("10/10/2018  19:35"), for2, emp);

		FinanceiroPagar fincpt1 = new FinanceiroPagar(null, EstadoPagamento.QUITADO, pedComp1, 600.00);
		pedComp1.setFinanceiroPagar(fincpt1);
		FinanceiroPagarParcela fincptparc = new FinanceiroPagarParcela(null,"2257/1", sdf.parse("30/09/2018  10:32"), null, 100.00, fincpt1);
		                    //    new FinanceiroPagarComBoleto(id, estadoPagamento, pedidoCompra, numeroDocumento, dataVencimento, dataPagamento, valorParcela)
		fincpt1.getFinanceiroPagarParcela().add(fincptparc);
		
		FinanceiroPagar fincpt2 = new FinanceiroPagar(null, EstadoPagamento.PENDENTE, pedComp2,200.00);
			//	( null, EstadoPagamento.PENDENTE, pedComp2,"1/3", sdf.parse("20/10/2017 00:00"),null,200.00);
		pedComp2.setFinanceiroPagar(fincpt2);
		
		FinanceiroPagarParcela fincptparc1 = new FinanceiroPagarParcela(null,"2258/1", sdf.parse("30/09/2018  10:32"), null, 100.00, fincpt2);
				//( null, EstadoPagamento.PENDENTE, pedComp2,200.00);
	//	pedComp2.setFinanceiroPagar(fincpt2);
		
		FinanceiroPagarParcela fincptparc2 = new FinanceiroPagarParcela(null,"2258/2", sdf.parse("30/10/2018  10:32"), null, 100.00, fincpt2);
		fincpt2.getFinanceiroPagarParcela().addAll(Arrays.asList(fincptparc1,fincptparc2));
		
		//pedComp2.setFinanceiroPagar(fincpt2);
		
		
		CentroRateio rt = centroRateioRepository.findOne(1);
		CentroRateio rt2 = centroRateioRepository.findOne(1);
		
		Financeiro pagto1 = new Financeiro(null, EstadoPagamento.QUITADO, ped1, 600, rt);//(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setFinanceiro(pagto1);
		FinanceiroParcela fincPar = new FinanceiroParcela(null, "2018/1", sdf.parse("30/10/2018  10:32"), null,600.00, pagto1);
		pagto1.getFinanceiroParcela().addAll(Arrays.asList(fincPar));
		
		Financeiro pagto2 = new Financeiro(null, EstadoPagamento.QUITADO, ped2, 600, rt2);//(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				//null);
		ped2.setFinanceiro(pagto2);
		FinanceiroParcela fincPar2 = new FinanceiroParcela(null, "2018/1", sdf.parse("30/10/2018  10:32"), sdf.parse("30/10/2018  10:32"),600.00, pagto2);
		pagto2.getFinanceiroParcela().addAll(Arrays.asList(fincPar2));
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		for1.getPedidoCompras().addAll(Arrays.asList(pedComp1));
		for2.getPedidoCompras().addAll(Arrays.asList(pedComp2));

		pedidoRepository.save(Arrays.asList(ped1, ped2));
		pagamentoRepository.save(Arrays.asList(pagto1, pagto2));
		
		pedidoCompraRepository.save(Arrays.asList(pedComp1, pedComp2));
		finenceiroRepository.save(Arrays.asList(fincpt1, fincpt2));
		

		ItemPedido ip1 = new ItemPedido(ped1, p1, 00.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 00.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ItemPedidoCompra ipc1 = new ItemPedidoCompra(pedComp1, p6, 00.00, 1, 2000.00);
		ItemPedidoCompra ipc2 = new ItemPedidoCompra(pedComp1, p7, 00.00, 2, 80.00);
		ItemPedidoCompra ipc3 = new ItemPedidoCompra(pedComp2, p8, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		pedComp1.getItens().addAll(Arrays.asList(ipc1, ipc2));
		pedComp2.getItens().addAll(Arrays.asList(ipc3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		p6.getItensComp().addAll(Arrays.asList(ipc1));
		p8.getItensComp().addAll(Arrays.asList(ipc3));
		p7.getItensComp().addAll(Arrays.asList(ipc2));

		itempedidoRepository.save(Arrays.asList(ip1, ip2, ip3));
		
		itempedidoCompraRepository.save(Arrays.asList(ipc1, ipc2, ipc3));

	}

}
