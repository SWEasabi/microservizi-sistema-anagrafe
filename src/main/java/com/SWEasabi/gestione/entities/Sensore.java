package com.SWEasabi.gestione.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sensore {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long idmisuratore;
	private int raggio;
	
	public Sensore()
	{
		this.idmisuratore=0;
		this.raggio=0;
	}
	
	public Sensore(long idmisuratore, int raggio)
	{
		this.idmisuratore=idmisuratore;
		this.raggio=raggio;
	}
	
	public long getId() {
		return id;
	}
	public long getIdMisuratore() {
		return idmisuratore;
	}
	public int getRaggio() {
		return raggio;
	}
	
	public void setIdMisuratore(long idMisuratore) {
		this.idmisuratore = idMisuratore;
	}
	public void setLuminosita(int raggio) {
		this.raggio = raggio;
	}
}
