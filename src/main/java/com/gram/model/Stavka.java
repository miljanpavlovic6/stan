package com.gram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Stavka {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String name;
	@Column
	private String cena;
	@Column
	private String opis;
	@Column
	private String picture;
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonBackReference
	private Soba soba;
	
	
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
	public String getCena() {
		return cena;
	}
	public void setCena(String cena) {
		this.cena = cena;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Soba getSoba() {
		return soba;
	}
	public void setSoba(Soba soba) {
		this.soba = soba;
		if(soba != null && !soba.getStavke().contains(this)) {
			soba.getStavke().add(this);
		}
	}
	
	
	
	
}
