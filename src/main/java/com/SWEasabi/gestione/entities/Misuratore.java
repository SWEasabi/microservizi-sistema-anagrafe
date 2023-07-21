package com.SWEasabi.gestione.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Misuratore {

	@Id
	//@SequenceGenerator(name = "measurerGenerator", initialValue = 13)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long idarea;
	private String tipo;
	private double latitudine;
	private double longitudine;
	
	public Misuratore()
	{
		this.idarea=0;
		this.tipo="";
		this.latitudine=0.0;
		this.longitudine=0.0;
	}
	
	public Misuratore(long idarea, String tipo, double latitudine, double longitudine) {
		this.idarea = idarea;
		this.tipo = tipo;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	public long getId() {
		return id;
	}
	public long getIdArea() {
		return idarea;
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
	public void setIdArea(long idArea) {
		this.idarea = idArea;
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
	
	
}
