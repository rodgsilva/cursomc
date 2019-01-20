package com.dozek.servicephoto.domain.dto;

import java.io.Serializable;

import com.dozek.servicephoto.domain.CentroRateio;

public class CentroRateioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nome;
	
	public CentroRateioDTO() {		
	}
	
	public CentroRateioDTO (CentroRateio obj){
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
