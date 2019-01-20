package com.dozek.servicephoto.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ContratoPrincipalPK  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="contratoPrincipal_id")
	private ContratoPrincipal contratoPrincipal;
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ContratoPrincipal getContratoPrincipal() {
		return contratoPrincipal;
	}

	public void setContratoPrincipal(ContratoPrincipal contratoPrincipal) {
		this.contratoPrincipal = contratoPrincipal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contratoPrincipal == null) ? 0 : contratoPrincipal.hashCode());
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
		ContratoPrincipalPK other = (ContratoPrincipalPK) obj;
		if (contratoPrincipal == null) {
			if (other.contratoPrincipal != null)
				return false;
		} else if (!contratoPrincipal.equals(other.contratoPrincipal))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
	
	
	
	
	

}
