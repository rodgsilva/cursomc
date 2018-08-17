package com.dozek.servicephoto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer codigoBanco;
	private String  nome;
	private Integer contaCorrente;
	private Integer digito;
	private String agencia;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="conta")
	private List<ContaMovimento> contaMovimento = new ArrayList<>();
	
	public Conta() {		
	}
	
		

	public Conta(Integer id, Integer codigoBanco, String nome, Integer contaCorrente, Integer digito,
			List<ContaMovimento> contaMovimento) {
		super();
		this.id = id;
		this.codigoBanco = codigoBanco;
		this.nome = nome;
		this.contaCorrente = contaCorrente;
		this.digito = digito;
		this.contaMovimento = contaMovimento;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCodigoBanco() {
		return codigoBanco;
	}


	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getContaCorrente() {
		return contaCorrente;
	}


	public void setContaCorrente(Integer contaCorrente) {
		this.contaCorrente = contaCorrente;
	}


	public Integer getDigito() {
		return digito;
	}


	public void setDigito(Integer digito) {
		this.digito = digito;
	}


	public List<ContaMovimento> getContaMovimento() {
		return contaMovimento;
	}


	public void setContaMovimento(List<ContaMovimento> contaMovimento) {
		this.contaMovimento = contaMovimento;
	}
	
	
	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
}
