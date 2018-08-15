package com.dozek.servicephoto.domain.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.dozek.servicephoto.domain.FinanceiroPagar;
import com.fasterxml.jackson.annotation.JsonFormat;

public class GeraParcelaDTO extends FinanceiroPagar {
	private static final long serialVersionUID = 1L;
	
		
	private String numerodoc;
	private Integer pedidoCompraId;
	private Integer financeiroPagar;
	@NotEmpty(message="Preenchimento Obrigatóro")
	private Integer qtdParc;
	@NotEmpty(message="Preenchimento Obrigatóro")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;
	private Integer numeroBanco;
	
	
	
	public GeraParcelaDTO() {
		}

	public String getNumerodoc() {
		return numerodoc;
	}

	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}
	

	
	public Integer getPedidoCompraId() {
		return pedidoCompraId;
	}

	public void setPedidoCompraId(Integer pedidoCompraId) {
		this.pedidoCompraId = pedidoCompraId;
	}
	

	public Integer getFinanceiroPagar() {
		return financeiroPagar;
	}

	public void setFinanceiroPagar(Integer financeiroPagar) {
		this.financeiroPagar = financeiroPagar;
	}

	public Integer getQtdParc() {
		return qtdParc;
	}

	public void setQtdParc(Integer qtdParc) {
		this.qtdParc = qtdParc;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroBanco(Integer numeroBanco) {
		this.numeroBanco = numeroBanco;
	}
	
	
	

}
