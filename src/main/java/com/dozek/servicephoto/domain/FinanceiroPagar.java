package com.dozek.servicephoto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.dozek.servicephoto.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

//@Inheritance(strategy=InheritanceType.JOINED)
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type") 
@Entity
public class FinanceiroPagar implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer finac_id;
	
	private Integer estadoPagamento;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="pedidoCompra_id")
	private PedidoCompra pedidoCompra;
	
	private double ValorTotal;
	
	@OneToMany(mappedBy="financeiroPagar", cascade=CascadeType.ALL)
	private List<FinanceiroPagarParcela> financeiroPagarParcela= new ArrayList<>();
	
	public FinanceiroPagar() {
	}
	
	public FinanceiroPagar(Integer finac_id, EstadoPagamento estadoPagamento, PedidoCompra pedidoCompra, double valorTotal) {
	super();
	this.finac_id = finac_id;
	this.estadoPagamento =(estadoPagamento==null) ? null : estadoPagamento.getCod();
	this.pedidoCompra = pedidoCompra;
	this.ValorTotal = valorTotal;
	}
	
	
	

/*	public FinanceiroPagar(Integer id, EstadoPagamento estadoPagamento, PedidoCompra pedidoCompra) {
		super();
		this.finac_id = id;
		this.estadoPagamento = (estadoPagamento==null) ? null : estadoPagamento.getCod();
		this.pedidoCompra = pedidoCompra;
	}
*/



	public Integer getId() {
		return finac_id;
	}

	public void setId(Integer id) {
		this.finac_id = id;
	}

	public EstadoPagamento getEstadoPagamento() {
		return EstadoPagamento.toEnum(estadoPagamento);
	}

	public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
		this.estadoPagamento = estadoPagamento.getCod();
	}

	public PedidoCompra getPedidoCompra() {
		return pedidoCompra;
	}

	public void setPedidoCompra(PedidoCompra pedidoCompra) {
		this.pedidoCompra = pedidoCompra;
	}

	
	public double getValorTotal() {
		return ValorTotal;
	}

	public void setValorTotal(double valorTotal) {
		ValorTotal = valorTotal;
	}
		
	public List<FinanceiroPagarParcela> getFinanceiroPagarParcela() {
		return financeiroPagarParcela;
	}

	public void setFinanceiroPagarParcela(List<FinanceiroPagarParcela> financeiroPagarParcela) {
		this.financeiroPagarParcela = financeiroPagarParcela;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((finac_id == null) ? 0 : finac_id.hashCode());
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
		FinanceiroPagar other = (FinanceiroPagar) obj;
		if (finac_id == null) {
			if (other.finac_id != null)
				return false;
		} else if (!finac_id.equals(other.finac_id))
			return false;
		return true;
	}
	
}
