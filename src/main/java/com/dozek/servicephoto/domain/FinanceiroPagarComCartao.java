package com.dozek.servicephoto.domain;

import javax.persistence.Entity;

import com.dozek.servicephoto.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("pagamentoComCartao")
public class FinanceiroPagarComCartao extends Pagamento  {
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcela;
	
	public FinanceiroPagarComCartao() {		
	}

	public FinanceiroPagarComCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido,Integer numeroDeParcela) {
		super(id, estadoPagamento, pedido);
		this.numeroDeParcela = numeroDeParcela;
	
	}

	public Integer getNumeroDeParcela() {
		return numeroDeParcela;
	}

	public void setNumeroDeParcela(Integer numeroDeParcela) {
		this.numeroDeParcela = numeroDeParcela;
	}
	
	
	
	

}
