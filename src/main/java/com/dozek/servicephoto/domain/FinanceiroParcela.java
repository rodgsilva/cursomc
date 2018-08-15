package com.dozek.servicephoto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class FinanceiroParcela implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer parcId;
	
	@Column(name="numeroDocumento",length =50)
	private String numeroDocumento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;
	private Double  valorParcela;
	@Column(name="tipoDoc",length =3)
	private String  tipoDoc;
	private Integer contabanco;
	private String codigoBarras;
	private String nossoNumero;
	private String obs1;
	private String obs2;
	private String obs3;
	private String obs4;
	
	@JsonIgnore
	@OneToMany(mappedBy="financParcela")
	private List<ContaMovimento> montaMovimento = new ArrayList<>();

	
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="financeiro_id")
	private Financeiro financeiro;
	
	public FinanceiroParcela() {
	}



	public FinanceiroParcela(Integer parcId, String numeroDocumento, Date dataVencimento, Date dataPagamento,
			Double valorParcela, Financeiro financeiro) {
		super();
		this.parcId = parcId;
		this.numeroDocumento = numeroDocumento;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.valorParcela = valorParcela;
		this.financeiro = financeiro;
	}

	public Integer getParcId() {
		return parcId;
	}

	public void setParcId(Integer parcId) {
		this.parcId = parcId;
	}


	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Financeiro getFinanceiro() {
		return financeiro;
	}

	public void setFinanceiro(Financeiro financeiro) {
		this.financeiro = financeiro;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parcId == null) ? 0 : parcId.hashCode());
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
		FinanceiroParcela other = (FinanceiroParcela) obj;
		if (parcId == null) {
			if (other.parcId != null)
				return false;
		} else if (!parcId.equals(other.parcId))
			return false;
		return true;
	}
	
	
	
	
	
}
