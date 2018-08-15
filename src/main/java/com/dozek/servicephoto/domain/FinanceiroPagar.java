package com.dozek.servicephoto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.dozek.servicephoto.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class FinanceiroPagar implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="finac_id")
	private Integer finacid;
	
	private Integer estadoPagamento;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="pedidoCompra_id")
	private PedidoCompra pedidoCompra;
	
	private double ValorTotal;
	                
	@OneToMany(mappedBy="financeiroPagar", cascade=CascadeType.ALL)
	private List<FinanceiroPagarParcela> financeiroPagarParcela= new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="centroRateio_id")
	private CentroRateio centroRateio;
	
	public FinanceiroPagar() {
	}
	
	public FinanceiroPagar(Integer finacid, EstadoPagamento estadoPagamento, PedidoCompra pedidoCompra, double valorTotal) {
	super();
	this.finacid = finacid;
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
		return finacid;
	}

	public void setId(Integer id) {
		this.finacid = id;
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
	
	
	public Integer getFinacid() {
		return finacid;
	}

	public void setFinacid(Integer finacid) {
		this.finacid = finacid;
	}

	public CentroRateio getCentroRateio() {
		return centroRateio;
	}

	public void setCentroRateio(CentroRateio centroRateio) {
		this.centroRateio = centroRateio;
	}

	public void setEstadoPagamento(Integer estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((finacid == null) ? 0 : finacid.hashCode());
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
		if (finacid == null) {
			if (other.finacid != null)
				return false;
		} else if (!finacid.equals(other.finacid))
			return false;
		return true;
	}
	
}
