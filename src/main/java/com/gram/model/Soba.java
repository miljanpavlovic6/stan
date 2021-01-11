package com.gram.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Soba {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String name;
	@OneToMany(mappedBy="soba", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Stavka> stavke = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Stavka> getStavke() {
		return stavke;
	}
	public void setStavke(List<Stavka> stavke) {
		this.stavke = stavke;
	}
	public void addStavka(Stavka stavka) {
		this.stavke.add(stavka);
		if(!this.equals(stavka.getSoba())) {
			stavka.setSoba(this);
		}
	}
	
	
	
}
