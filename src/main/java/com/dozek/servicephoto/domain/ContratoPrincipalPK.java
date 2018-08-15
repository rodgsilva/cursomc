package com.dozek.servicephoto.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ContratoPrincipalPK  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="contratoAluno_id")
	private AlbumAluno contratoAluno;
	
	@ManyToOne
	@JoinColumn(name="contratoPrincipal_id")
	private ContratoPrincipal contratoPrincipal;
	
	

}
