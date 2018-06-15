package com.dozek.servicephoto.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoCompraPK  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="pedidoCompra_id")
	private PedidoCompra pedidoCompra;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	public PedidoCompra getPedidoCompra() {
		return pedidoCompra;
	}
	public void setPedidoCompra(PedidoCompra pedidoCompra) {
		this.pedidoCompra = pedidoCompra;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedidoCompra == null) ? 0 : pedidoCompra.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		ItemPedidoCompraPK other = (ItemPedidoCompraPK) obj;
		if (pedidoCompra == null) {
			if (other.pedidoCompra != null)
				return false;
		} else if (!pedidoCompra.equals(other.pedidoCompra))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
	

}
