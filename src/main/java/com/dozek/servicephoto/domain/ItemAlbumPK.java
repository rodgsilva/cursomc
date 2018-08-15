package com.dozek.servicephoto.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemAlbumPK  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="albumAluno_id")
	private AlbumAluno albumAluno;
	
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;


	public AlbumAluno getAlbumAluno() {
		return albumAluno;
	}


	public void setAlbumAluno(AlbumAluno albumAluno) {
		this.albumAluno = albumAluno;
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
		result = prime * result + ((albumAluno == null) ? 0 : albumAluno.hashCode());
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
		ItemAlbumPK other = (ItemAlbumPK) obj;
		if (albumAluno == null) {
			if (other.albumAluno != null)
				return false;
		} else if (!albumAluno.equals(other.albumAluno))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
	
		

}
