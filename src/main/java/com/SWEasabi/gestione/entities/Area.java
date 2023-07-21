package com.SWEasabi.gestione.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Area {

	@Id
	//@SequenceGenerator(name = "areaGenerator", initialValue = 4)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	private String nome;
	private boolean automode;
	private int lvlinf;
	private int lvlsup;
	
	public Area() {
		this.nome="test";
		this.automode=false;
		this.lvlinf=0;
		this.lvlsup=0;
	}
	
	public Area(String nome, boolean auto, int inf, int sup)
	{
		this.nome=nome;
		this.automode=auto;
		this.lvlinf=inf;
		this.lvlsup=sup;
	}
	
	@Override
	public String toString()
	{
		return "Id = " + Integer.toString(id) + " Nome = " + nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isautomode() {
		return automode;
	}

	public void setautomode(boolean automode) {
		this.automode = automode;
	}

	public int getlvlinf() {
		return lvlinf;
	}

	public void setlvlinf(int lvlinf) {
		this.lvlinf = lvlinf;
	}

	public int getlvlsup() {
		return lvlsup;
	}

	public void setlvlsup(int lvlsup) {
		this.lvlsup = lvlsup;
	}
	
	
	
	
}
