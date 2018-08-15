package com.dozek.servicephoto.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CentroRateioPK  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="centroCusto_id")
	private CentroCusto centroCusto;
	
	@ManyToOne
	@JoinColumn(name="rateioCentro_id")
	private CentroRateio centroRateio;

	public CentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	

	public CentroRateio getCentroRateio() {
		return centroRateio;
	}

	public void setCentroRateio(CentroRateio centroRateio) {
		this.centroRateio = centroRateio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centroCusto == null) ? 0 : centroCusto.hashCode());
		result = prime * result + ((centroRateio == null) ? 0 : centroRateio.hashCode());
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
		CentroRateioPK other = (CentroRateioPK) obj;
		if (centroCusto == null) {
			if (other.centroCusto != null)
				return false;
		} else if (!centroCusto.equals(other.centroCusto))
			return false;
		if (centroRateio == null) {
			if (other.centroRateio != null)
				return false;
		} else if (!centroRateio.equals(other.centroRateio))
			return false;
		return true;
	}
	
	
	
	

}
