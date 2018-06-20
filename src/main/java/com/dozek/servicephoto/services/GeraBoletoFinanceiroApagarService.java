package com.dozek.servicephoto.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.dozek.servicephoto.domain.FinanceiroPagarParcela;

@Service
public class GeraBoletoFinanceiroApagarService {
	
	public void preencherPagamentoComBoleto(FinanceiroPagarParcela pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH,7);
		pagto.setDataVencimento(cal.getTime());
	}

}
