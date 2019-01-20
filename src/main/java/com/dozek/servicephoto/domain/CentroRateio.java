package com.dozek.servicephoto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CentroRateio  implements Serializable{
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
	
	@OneToMany(mappedBy="id.centroRateio")
	private Set<ItemRateioCentroCusto> itensRateio = new HashSet<>();
	@JsonIgnore
	@OneToMany(mappedBy="centroRateio", cascade=CascadeType.ALL)
	private List<Financeiro> financeiro= new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="centroRateio", cascade=CascadeType.ALL)
	private List<Financeiro> financeiroPagar= new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy="centroRateio")
	private List<ContaMovimento> contaMovimento = new ArrayList<>();

	public CentroRateio() {		
	}	

	public CentroRateio(Integer id, String nome, Date inicio, Date termino) {
		super();
		this.id = id;
		this.nome = nome;
		this.inicio = inicio;
		this.termino = termino;
		//this.itensRateio = itensRateio;
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

	public Set<ItemRateioCentroCusto> getItensRateio() {
		return itensRateio;
	}

	public void setItensRateio(Set<ItemRateioCentroCusto> itensRateio) {
		this.itensRateio = itensRateio;
	}

	


	public List<Financeiro> getFinanceiro() {
		return financeiro;
	}

	public void setFinanceiro(List<Financeiro> financeiro) {
		this.financeiro = financeiro;
	}

	public List<Financeiro> getFinanceiroPagar() {
		return financeiroPagar;
	}

	public void setFinanceiroPagar(List<Financeiro> financeiroPagar) {
		this.financeiroPagar = financeiroPagar;
	}

		
	public List<ContaMovimento> getContaMovimento() {
		return contaMovimento;
	}

	public void setContaMovimento(List<ContaMovimento> contaMovimento) {
		this.contaMovimento = contaMovimento;
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
		CentroRateio other = (CentroRateio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
