package com.dozek.servicephoto.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ContaMovimento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer id;
	private String descricao;
	private Double valor;	
	@Column(name="tipoMov",length =1)
	private String tipoMov;
	private String obs;
	
	@ManyToOne
	@JoinColumn(name="conta")
	private Conta conta;
	
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="centroRateio")
	private CentroRateio centroRateio;
	
	@ManyToOne
	@JoinColumn(name="financParcela")
	private FinanceiroParcela financParcela;
	
	@ManyToOne
	@JoinColumn(name="financPagarParcela")
	private FinanceiroPagarParcela financPagarParcela;
	
	
	public ContaMovimento() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public String getTipoMov() {
		return tipoMov;
	}


	public void setTipoMov(String tipoMov) {
		this.tipoMov = tipoMov;
	}


	public String getObs() {
		return obs;
	}


	public void setObs(String obs) {
		this.obs = obs;
	}


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public CentroRateio getCentroRateio() {
		return centroRateio;
	}


	public void setCentroRateio(CentroRateio centroRateio) {
		this.centroRateio = centroRateio;
	}


	public FinanceiroParcela getFinancParcela() {
		return financParcela;
	}


	public void setFinancParcela(FinanceiroParcela financParcela) {
		this.financParcela = financParcela;
	}


	public FinanceiroPagarParcela getFinancPagarParcela() {
		return financPagarParcela;
	}


	public void setFinancPagarParcela(FinanceiroPagarParcela financPagarParcela) {
		this.financPagarParcela = financPagarParcela;
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
		ContaMovimento other = (ContaMovimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
		
	
	

}
