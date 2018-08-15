package com.dozek.servicephoto.domain.enums;

public enum TipoContrato {
	
	 COBERTURAFOTOFILME(1,"Cober. Fotográfica/Filmagem"),
	 COBERTURAFOTO(2,"Cober. Fotográfica"),
	 COBERTURAFILME(3,"Cober. Filmagem");
	
	
	private int cod;
	private String descricao;
	
	private TipoContrato(int cod, String descrica) {
		this.cod=cod;
		this.descricao=descrica;		
		
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoContrato toEnum (Integer cod) {
		if(cod==null) {
			
			return null;
		}
		
		for (TipoContrato x :TipoContrato.values()) {
			if(cod.equals(x.getCod())) {
				return x;
				
			}
		}
		throw new IllegalArgumentException("id invalido: "+cod);
			
	}

}
