package com.dozek.servicephoto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.dozek.servicephoto.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Financeiro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="finac_id")
	private Integer finacid;
	
	private Integer estadoPagamento;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	private double ValorTotal;
	                
	@OneToMany(mappedBy="financeiro", cascade=CascadeType.ALL)
	private List<FinanceiroParcela> financeiroParcela= new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="centroRateio_id")
	private CentroRateio centroRateio;
	
	public Financeiro() {
	}
	
	public Financeiro(Integer finacid, EstadoPagamento estadoPagamento, Pedido pedido, double valorTotal,
			 CentroRateio centroRateio) {
	super();
	this.finacid = finacid;
	this.estadoPagamento =(estadoPagamento==null) ? null : estadoPagamento.getCod();
	this.pedido = pedido;
	this.ValorTotal = valorTotal;
	
	this.centroRateio = centroRateio;
	}
	
	
	
/*	public FinanceiroPagar(Integer id, EstadoPagamento estadoPagamento, pedido pedido) {
		super();
		this.finac_id = id;
		this.estadoPagamento = (estadoPagamento==null) ? null : estadoPagamento.getCod();
		this.pedido = pedido;
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	
	public double getValorTotal() {
		return ValorTotal;
	}

	public void setValorTotal(double valorTotal) {
		ValorTotal = valorTotal;
	}
		
	public List<FinanceiroParcela> getFinanceiroParcela() {
		return financeiroParcela;
	}

	public void setFinanceiroParcela(List<FinanceiroParcela> financeiroParcela) {
		this.financeiroParcela = financeiroParcela;
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
		Financeiro other = (Financeiro) obj;
		if (finacid == null) {
			if (other.finacid != null)
				return false;
		} else if (!finacid.equals(other.finacid))
			return false;
		return true;
	}
	
}
