package com.SWEasabi.gestione.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Lampione {

	@Id
	//@SequenceGenerator(name = "lampGenerator", initialValue = 7)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long idmisuratore;
	private int voltaggio;
	
	public Lampione()
	{
		this.idmisuratore=0;
		this.voltaggio=0;
	}
	
	public Lampione(long idmisuratore, int voltaggio)
	{
		this.idmisuratore=idmisuratore;
		this.voltaggio=voltaggio;
	}
	
	public long getId() {
		return id;
	}
	public long getIdMisuratore() {
		return idmisuratore;
	}
	public int getVoltaggio() {
		return voltaggio;
	}
	
	public void setIdMisuratore(long idMisuratore) {
		this.idmisuratore = idMisuratore;
	}
	public void setVoltaggio(int voltaggio) {
		this.voltaggio = voltaggio;
	}
}
