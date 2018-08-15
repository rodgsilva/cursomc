package com.dozek.servicephoto.domain.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.dozek.servicephoto.services.validation.ClienteInsert;


public class EnderecoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	

	private Integer id;

	private Integer clienteId;
	
	@NotEmpty(message="Preenchimento Obrigatóro")
	private String logradouro;
	
	@NotEmpty(message="Preenchimento Obrigatóro")
	private String numero;
	private String complemento;
	private String bairro;
	
	@NotEmpty(message="Preenchimento Obrigatóro")
	private String cep;
	

	private Integer cidadeId;
	
	public EnderecoDTO() {
		
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public Integer getClienteId() {
		return clienteId;
	}


	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}


	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	

	
	
	

}
