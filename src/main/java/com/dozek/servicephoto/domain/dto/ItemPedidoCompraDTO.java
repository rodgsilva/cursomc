package com.dozek.servicephoto.domain.dto;

import java.io.Serializable;

import com.dozek.servicephoto.domain.ItemPedidoCompra;
import com.dozek.servicephoto.domain.PedidoCompra;

public class ItemPedidoCompraDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer idPedido;
	private Double  desconto;
	private Integer quantidade;
	private Double  preco;
	private Integer idProd;
	private String  nome;
	
	
	
	public ItemPedidoCompraDTO(ItemPedidoCompra obj) {
		idPedido=obj.getPedidoCompra().getId();	
		desconto = obj.getDesconto();
		quantidade =  obj.getQuantidade();
		preco =  obj.getSubTotal();
		idProd =  obj.getProduto().getId();
		nome =  obj.getProduto().getNome();
	}
	public ItemPedidoCompraDTO(){
		
	}
	
	
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getIdProd() {
		return idProd;
	}
	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	

}
