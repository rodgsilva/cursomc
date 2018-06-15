package com.dozek.servicephoto.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PedidoCompra implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instante;
	
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedidoCompra")
	private FinanceiroPagar financeiroPagar;
	
	
	@ManyToOne
	@JoinColumn(name="Fornecedor_id")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name="endereco_de_enterga_id")
	private Endereco enderecoDeEntrega;
	
	@OneToMany(mappedBy="id.pedidoCompra")
	private Set<ItemPedidoCompra> itens = new HashSet<>();
	
	public PedidoCompra() {
	}

	public PedidoCompra(Integer id, Date instante,Fornecedor fornecedor, Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.fornecedor = fornecedor;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	public double getValorTotal() {
		double soma=0.0;
		for(ItemPedidoCompra ip : itens) {
			soma = soma + ip.getSubTotal();
		}
		return soma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public FinanceiroPagar getFinanceiroPagar() {
		return financeiroPagar;
	}

	public void setFinanceiroPagar(FinanceiroPagar financeiroPagar) {
		this.financeiroPagar = financeiroPagar;
	}

    public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	public Set<ItemPedidoCompra> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedidoCompra> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoCompra other = (PedidoCompra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido número: ");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(sdf.format(getInstante()));
		builder.append(", Fornecedor: ");
		builder.append(getFornecedor().getNome());
		builder.append(", Situação do financeiroPagar: ");
		builder.append(getFinanceiroPagar().getEstadoPagamento().getDescricao());
		builder.append("\nDetalhes:\n");
		for(ItemPedidoCompra ip : getItens()) {
		builder.append(ip.toString());
		}
		builder.append("Valor total: ");
		builder.append(nf.format(getValorTotal()));
		return builder.toString();
		
	}


	
	

}
