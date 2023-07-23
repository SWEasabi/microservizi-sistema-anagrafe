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
	
	public Area(Area area)
	{
		this.id=area.getId();
		this.nome=area.getNome();
		this.automode=area.isautomode();
		this.lvlinf=area.getlvlinf();
		this.lvlsup=area.getlvlsup();
	}
	
	@Override
	public String toString()
	{
		return "Id = " + Integer.toString(id) + " Nome = " + nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Area other = (Area) obj;
        if ((this.id == other.id && this.getlvlinf() == other.getlvlinf() && this.getlvlsup() == other.getlvlsup() && this.getNome() == other.getNome() && this.isautomode() == other.isautomode())) {
            return true;
        }

        return false;
    }
}
