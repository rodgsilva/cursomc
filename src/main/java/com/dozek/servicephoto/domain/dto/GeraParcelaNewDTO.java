package com.dozek.servicephoto.domain.dto;

import java.io.Serializable;

import com.dozek.servicephoto.domain.FinanceiroPagar;

public class GeraParcelaNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
		
	private Integer id;
	private Integer pedidoCompraId;
	private String EstadoPagar;
	private double valorTotal;

	
	public GeraParcelaNewDTO(FinanceiroPagar obj) {
		id = obj.getId();		
		pedidoCompraId = obj.getPedidoCompra().getId();
		EstadoPagar = (obj.getEstadoPagamento()==null) ? "não informado" :obj.getEstadoPagamento().getDescricao();
		valorTotal = obj.getValorTotal();
		
	}


	public GeraParcelaNewDTO() {
		}



	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getEstadoPagar() {
		return EstadoPagar;
	}



	public void setEstadoPagar(String estadoPagar) {
		EstadoPagar = estadoPagar;
	}



	public double getValorTotal() {
		return valorTotal;
	}



	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	

	
	public Integer getPedidoCompraId() {
		return pedidoCompraId;
	}

	public void setPedidoCompraId(Integer pedidoCompraId) {
		this.pedidoCompraId = pedidoCompraId;
	}
	

	

}
