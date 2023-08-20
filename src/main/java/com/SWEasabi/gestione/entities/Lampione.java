package com.SWEasabi.gestione.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name= "lampione")
public class Lampione {

	@Id
	@Column(name="idmisuratore")
	private long id;
	private int wattaggio;
	private int luminosita;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	@MapsId
	private Misuratore misuratore;
	
	public Misuratore getMisuratore() {
		return misuratore;
	}

	public void setMisuratore(Misuratore misuratore) {
		this.misuratore = misuratore;
	}

	public Lampione()
	{
		this.wattaggio=0;
		this.luminosita=0;
	}
	
	public Lampione(int wattaggio)
	{
		this.wattaggio=wattaggio;
		this.luminosita=0;
	}
	
	public long getId() {
		return id;
	}
	public int getWattaggio() {
		return wattaggio;
	}
	public void setId(long id) {
		this.id=id;
	}
	public void setWattaggio(int wattaggio) {
		this.wattaggio = wattaggio;
	}
	
	@Override
	public boolean equals(Object obj)
	{
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Lampione other = (Lampione) obj;
        if (this.id == other.getId() 
        		&& this.wattaggio == other.getWattaggio() 
        		&& this.luminosita == other.getLuminosita()
        		&& this.misuratore.equals(other.getMisuratore())) {
        		return true;
        }

        return false;
	}

	public int getLuminosita() {
		return luminosita;
	}

	public void setLuminosita(int luminosita) {
		this.luminosita = luminosita;
	}
	
	
}
