package com.dozek.servicephoto.domain.enums;

public enum Perfil {
	
	ADMIN(1,"ROLE_ADMIN"),
	USUARIO(2,"ROLE_USUARIO"),
	CLIENTE(3,"ROLE_CLIENTE"),
	FOR(4,"ROLE_FORNECEDOR");
	
	private int cod;
	private String descricao;
	
	private Perfil(int cod, String descrica) {
		this.cod=cod;
		this.descricao=descrica;		
		
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum (Integer cod) {
		if(cod==null) {
			
			return null;
		}
		
		for (Perfil x :Perfil.values()) {
			if(cod.equals(x.getCod())) {
				return x;
				
			}
		}
		throw new IllegalArgumentException("id invalido: "+cod);
			
	}
	

}
