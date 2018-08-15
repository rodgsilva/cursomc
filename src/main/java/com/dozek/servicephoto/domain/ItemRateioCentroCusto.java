package com.dozek.servicephoto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class ItemRateioCentroCusto implements Serializable{
	private static final long serialVersionUID = 1L;
	// Produto 
	@JsonIgnore
	@EmbeddedId
	private CentroRateioPK id = new CentroRateioPK();
	
	private double porcento;

	/*@JsonIgnore
	@OneToMany(mappedBy="id.rateioCentro")
	private Set<CentroRateio> centroRateio = new HashSet<>();
	*/
	
	public ItemRateioCentroCusto() {
	}

	
	public ItemRateioCentroCusto(CentroCusto centroCusto, CentroRateio centroRateio, double porcento) {
		super();
		id.setCentroCusto(centroCusto);
		id.setCentroRateio(centroRateio);
		this.porcento = porcento;
		
	}
	
	@JsonIgnore
	public CentroRateio getCentroRateio() {
		return id.getCentroRateio();
	}
	
	public void setCentroRateio(CentroRateio centroRateio) {
		id.setCentroRateio(centroRateio);
	}

	
	public void setCentroCusto(CentroCusto centroCusto) {
		id.setCentroCusto(centroCusto);
	}
	

	public CentroCusto getCentroCusto() {
		return id.getCentroCusto();
	}
	

	public CentroRateioPK getId() {
		return id;
	}


	public void setId(CentroRateioPK id) {
		this.id = id;
	}



	/*public Set<CentroRateio> getCentroRateio() {
		return centroRateio;
	}



	public void setCentroRateio(Set<CentroRateio> centroRateio) {
		this.centroRateio = centroRateio;
	}

*/

	public double getPorcento() {
		return porcento;
	}

	public void setPorcento(double porcento) {
		this.porcento = porcento;
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
		ItemRateioCentroCusto other = (ItemRateioCentroCusto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemRateioCentroCusto [id=");
		builder.append(id);
		builder.append("ItemRateioCentroCusto [id2=");
		builder.append(getCentroCusto());
		builder.append(", porcento=");
		builder.append(porcento);
		builder.append("]");
		return builder.toString();
	}



	
	
	

}
