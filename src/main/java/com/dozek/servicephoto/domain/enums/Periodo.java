package com.dozek.servicephoto.domain.enums;

public enum Periodo {
	
	 MATUTINO(1,"Manhã"),
	 VESPERTINO(2,"Tarde"),
	 NOTURNO(3,"Noite");
	
	
	private int cod;
	private String descricao;
	
	private Periodo(int cod, String descrica) {
		this.cod=cod;
		this.descricao=descrica;		
		
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Periodo toEnum (Integer cod) {
		if(cod==null) {
			
			return null;
		}
		
		for (Periodo x :Periodo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
				
			}
		}
		throw new IllegalArgumentException("id invalido: "+cod);
			
	}

}
