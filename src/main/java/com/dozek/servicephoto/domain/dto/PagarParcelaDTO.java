package com.dozek.servicephoto.domain.dto;

import java.io.Serializable;
import java.util.Date;

import com.dozek.servicephoto.domain.FinanceiroPagarParcela;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PagarParcelaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String numeroDocumento;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;
	private Double valorParcela;
	
	
	
	public PagarParcelaDTO(FinanceiroPagarParcela obj) {
	
		id =obj.getParcId();
		numeroDocumento = obj.getNumeroDocumento();
		dataVencimento = obj.getDataVencimento();
		dataPagamento = obj.getDataPagamento();
		valorParcela = obj.getValorParcela();
	}


	public PagarParcelaDTO () {
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	


	
}
