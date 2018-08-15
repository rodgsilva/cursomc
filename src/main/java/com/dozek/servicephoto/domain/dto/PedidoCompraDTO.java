package com.dozek.servicephoto.domain.dto;

import java.io.Serializable;
import java.util.Date;

import com.dozek.servicephoto.domain.PedidoCompra;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PedidoCompraDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instante;
	
	private String financeiroPagar;
	
	private String fornecedor;
	
	private double valorTotal;
	

	
	public PedidoCompraDTO(PedidoCompra obj) {
		id = obj.getId();
		instante = obj.getInstante();
		financeiroPagar =(obj.getFinanceiroPagar()==null) ? "não informado":obj.getFinanceiroPagar().getEstadoPagamento().getDescricao();
		fornecedor = obj.getFornecedor().getNome();
		valorTotal = obj.getValorTotal();
	}

	public PedidoCompraDTO() {
		
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

	public String getFinanceiroPagar() {
		return financeiroPagar;
	}

	public void setFinanceiroPagar(String financeiroPagar) {
		this.financeiroPagar = financeiroPagar;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
	
	

}
