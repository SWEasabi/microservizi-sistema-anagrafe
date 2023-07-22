package com.SWEasabi.gestione.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Sensore {

	@Id
	@Column(name="idmisuratore")
	private long id;
	private int raggio;
	
	@OneToOne
	@JoinColumn(name="idmisuratore")
	@MapsId
	private Misuratore misuratore;
	
	public Misuratore getMisuratore() {
		return misuratore;
	}

	public void setMisuratore(Misuratore misuratore) {
		this.misuratore = misuratore;
	}
	
	public Sensore()
	{
		this.raggio=0;
	}
	
	public Sensore(int raggio)
	{
		this.raggio=raggio;
	}
	
	public long getId() {
		return id;
	}
	public int getRaggio() {
		return raggio;
	}
	public void setLuminosita(int raggio) {
		this.raggio = raggio;
	}
}
