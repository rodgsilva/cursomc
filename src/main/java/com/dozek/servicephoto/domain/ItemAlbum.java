package com.dozek.servicephoto.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemAlbum  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemAlbumPK id = new ItemAlbumPK();
	
	private Double desconto;
	private Integer quantidade;
	private Double preco;

	public ItemAlbum() {
	}

	
	public ItemAlbum(AlbumAluno album,Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		id.setAlbumAluno(album);
		id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}



	public double getSubTotal() {
		return (preco - desconto)*quantidade;
	}
	@JsonIgnore
	public AlbumAluno getAlbumAluno() {
		return id.getAlbumAluno();
	}
	public void setAlbumAluno (AlbumAluno album) {
		id.setAlbumAluno(album);
	}
	

	public Produto getProduto() {
		return id.getProduto();
	}
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public ItemAlbumPK getId() {
		return id;
	}

	public void setId(ItemAlbumPK id) {
		this.id = id;
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
		ItemAlbum other = (ItemAlbum) obj;
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
		StringBuilder builder = new StringBuilder();
		builder.append(getProduto().getNome());
		builder.append(", Qte: ");
		builder.append(getQuantidade());
		builder.append(", Preço unitário: ");
		builder.append(nf.format(getPreco()));
		builder.append(", SubTotal: ");
		builder.append(nf.format(getSubTotal()));
		builder.append("\n");
		return builder.toString();
	}
	
	
	
}

