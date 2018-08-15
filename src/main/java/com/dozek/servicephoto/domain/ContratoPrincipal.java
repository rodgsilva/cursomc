package com.dozek.servicephoto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.dozek.servicephoto.domain.enums.Periodo;
import com.dozek.servicephoto.domain.enums.TipoContrato;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ContratoPrincipal implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer id;	
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtFechamento;	
	
	@JsonIgnore
	@OneToMany(mappedBy="contrato")
	private List<AlbumAluno> album= new ArrayList<>();
	
	
	@ManyToOne
	@JoinColumn(name="escola_id")
	private Escola escola; 
	
	@Column(name="evento",length = 6)
	private String  evento;	
	private Integer periodo;	
	private String  turma;	
	private Integer tipoContrato;	
	private Integer qtdFormando;	
	private Integer qtdParticipantes;	
	private Integer qtdIdentificado;	
	private Integer comissão;	
	private double  vlrMulta;

	@ManyToOne
	@JoinColumn(name="centrocusto_id")
	private CentroCusto centroCusto;
	
		
	public ContratoPrincipal(Integer id, Date dtFechamento, Escola instituicao, String evento, Integer periodo,
			String turma, Integer tipoContrato, Integer qtdFormando, Integer qtdParticipantes,
			Integer qtdIdentificado, Integer comissão, double vlrMulta) {
		super();
		this.id = id;
		this.dtFechamento = dtFechamento;
		this.escola = instituicao;
		this.evento = evento;
		this.periodo = periodo;
		this.turma = turma;
		this.tipoContrato = tipoContrato;
		this.qtdFormando = qtdFormando;
		this.qtdParticipantes = qtdParticipantes;
		this.qtdIdentificado = qtdIdentificado;
		this.comissão = comissão;
		this.vlrMulta = vlrMulta;
	}

	public ContratoPrincipal() {		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDtFechamento() {
		return dtFechamento;
	}

	public void setDtFechamento(Date dtFechamento) {
		this.dtFechamento = dtFechamento;
	}


	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public Periodo getPeriodo() {
		return Periodo.toEnum(periodo);
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo.getCod();
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public TipoContrato getTipoContrato() {
		return TipoContrato.toEnum(tipoContrato);
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato.getCod();
	}

	public Integer getQtdFormando() {
		return qtdFormando;
	}

	public void setQtdFormando(Integer qtdFormando) {
		this.qtdFormando = qtdFormando;
	}

	public Integer getQtdParticipantes() {
		return qtdParticipantes;
	}

	public void setQtdParticipantes(Integer qtdParticipantes) {
		this.qtdParticipantes = qtdParticipantes;
	}

	public Integer getQtdIdentificado() {
		return qtdIdentificado;
	}

	public void setQtdIdentificado(Integer qtdIdentificado) {
		this.qtdIdentificado = qtdIdentificado;
	}

	public Integer getComissão() {
		return comissão;
	}

	public void setComissão(Integer comissão) {
		this.comissão = comissão;
	}

	public double getVlrMulta() {
		return vlrMulta;
	}

	public void setVlrMulta(double vlrMulta) {
		this.vlrMulta = vlrMulta;
	}
	
	
	public CentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}
		

	public List<AlbumAluno> getAlbum() {
		return album;
	}

	public void setAlbum(List<AlbumAluno> album) {
		this.album = album;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public void setTipoContrato(Integer tipoContrato) {
		this.tipoContrato = tipoContrato;
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
		ContratoPrincipal other = (ContratoPrincipal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
