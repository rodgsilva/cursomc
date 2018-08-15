package com.dozek.servicephoto.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1,"Pessoa Física"),
	PESSOAJURIDICA(2,"Pessoa Juridica");
	
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descrica) {
		this.cod=cod;
		this.descricao=descrica;		
		
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum (Integer cod) {
		if(cod==null) {
			
			return null;
		}
		
		for (TipoCliente x :TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
				
			}
		}
		throw new IllegalArgumentException("id invalido: "+cod);
			
	}

}
