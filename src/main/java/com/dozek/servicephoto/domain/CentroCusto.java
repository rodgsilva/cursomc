package com.dozek.servicephoto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CentroCusto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer id;
	
	private String nome;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date inicio;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date termino;
	
	@JsonIgnore
	@OneToMany(mappedBy="id.centroCusto")
	private Set<ItemRateioCentroCusto> itemRateio = new HashSet<>();
	
	public CentroCusto() {
		
	}
	
	public CentroCusto(Integer id, String nome, Date inicio, Date termino, Set<ItemRateioCentroCusto> itemRateio) {
		super();
		this.id = id;
		this.nome = nome;
		this.inicio = inicio;
		this.termino = termino;
		//this.itemRateio = itemRateio;
	}
	@JsonIgnore
	public List<CentroRateio> getCentroRateio(){
		List<CentroRateio> lista =new ArrayList<>();
		for (ItemRateioCentroCusto x : itemRateio) {
			lista.add(x.getCentroRateio());
		}
		return lista;
	}
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Date getInicio() {
		return inicio;
	}



	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}



	public Date getTermino() {
		return termino;
	}



	public void setTermino(Date termino) {
		this.termino = termino;
	}



	public Set<ItemRateioCentroCusto> getItemRateio() {
		return itemRateio;
	}


	public void setItemRateio(Set<ItemRateioCentroCusto> itemRateio) {
		this.itemRateio = itemRateio;
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
		CentroCusto other = (CentroCusto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
