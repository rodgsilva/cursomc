package com.dozek.servicephoto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class FinanceiroPagarParcela implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer parcId;
	
	private String numeroDocumento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;
	private Double  valorParcela;
	private String  tipoDoc;
	private Integer banco;
	private Integer docTerceiro;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="financeiroPagar_id")
	private FinanceiroPagar financeiroPagar;
	
	@JsonIgnore
	@OneToMany(mappedBy="financPagarParcela")
	private List<ContaMovimento> contaMovimento = new ArrayList<>();

	
	public FinanceiroPagarParcela() {
	}


	public FinanceiroPagarParcela(Integer parcId, String numeroDocumento, Date dataVencimento, Date dataPagamento,
			Double valorParcela, FinanceiroPagar financeiroPagar) {
		super();
		this.parcId = parcId;
		this.numeroDocumento = numeroDocumento;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.valorParcela = valorParcela;
		this.financeiroPagar = financeiroPagar;
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

	public FinanceiroPagar getFinanceiroPagar() {
		return financeiroPagar;
	}

	public void setFinanceiroPagar(FinanceiroPagar financeiroPagar) {
		this.financeiroPagar = financeiroPagar;
	}


	public String getTipoDoc() {
		return tipoDoc;
	}


	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}


	public Integer getBanco() {
		return banco;
	}


	public void setBanco(Integer banco) {
		this.banco = banco;
	}


	public Integer getDocTerceiro() {
		return docTerceiro;
	}


	public void setDocTerceiro(Integer docTerceiro) {
		this.docTerceiro = docTerceiro;
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
		FinanceiroPagarParcela other = (FinanceiroPagarParcela) obj;
		if (parcId == null) {
			if (other.parcId != null)
				return false;
		} else if (!parcId.equals(other.parcId))
			return false;
		return true;
	}
	
	
	
	
	
}
