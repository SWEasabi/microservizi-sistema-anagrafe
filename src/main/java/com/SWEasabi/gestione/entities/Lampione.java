package com.SWEasabi.gestione.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name= "lampione")
public class Lampione {

	@Id
	@Column(name="idmisuratore")
	private long id;
	private int voltaggio;
	
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

	public Lampione()
	{
		this.voltaggio=0;
	}
	
	public Lampione(int voltaggio)
	{
		this.voltaggio=voltaggio;
	}
	
	public long getId() {
		return id;
	}
	public int getVoltaggio() {
		return voltaggio;
	}
	public void setId(long id) {
		this.id=id;
	}
	public void setVoltaggio(int voltaggio) {
		this.voltaggio = voltaggio;
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
        if (this.id == other.getId() && this.voltaggio == other.getVoltaggio() && this.misuratore.equals(other.getMisuratore())) {
        		return true;
        }

        return false;
	}
}
