package com.SWEasabi.gestione.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="misuratore")
public class Misuratore {

	@Id
	//@SequenceGenerator(name = "measurerGenerator", initialValue = 13)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String tipo;
	private double latitudine;
	private double longitudine;
	
	@OneToOne(mappedBy = "misuratore", cascade = CascadeType.ALL)
	private Lampione lampione;
	
	@OneToOne(mappedBy="misuratore")
	private Sensore sensore;
	
	@ManyToOne
	@JoinColumn(name="area_id")
	private Area area;

	public Sensore getSensore() {
		return sensore;
	}

	public void setSensore(Sensore sensore) {
		this.sensore = sensore;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Lampione getLampione() {
		return lampione;
	}

	public void setLampione(Lampione lampione) {
		this.lampione = lampione;
	}

	public Misuratore()
	{
		this.tipo="";
		this.latitudine=0.0;
		this.longitudine=0.0;
		this.area=null;
	}
	
	public Misuratore(String tipo, double latitudine, double longitudine, Area area) {
		this.tipo = tipo;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.area=area;
	}
	public long getId() {
		return id;
	}
	public String getTipo() {
		return tipo;
	}
	public double getLatitudine() {
		return latitudine;
	}
	public double getLongitudine() {
		return longitudine;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setLatitudine(double latitudine) {
		this.latitudine = latitudine;
	}
	public void setLongitudine(double longitudine) {
		this.longitudine = longitudine;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
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

        final Misuratore other = (Misuratore) obj;
        if ((this.getId() == other.getId() && this.getArea() == other.getArea() && this.getTipo() == other.getTipo() && this.getLatitudine() == other.getLatitudine() && this.getLongitudine() == other.getLongitudine())) {
            return true;
        }

        return false;
	}
}
