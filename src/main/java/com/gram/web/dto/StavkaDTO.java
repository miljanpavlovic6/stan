package com.gram.web.dto;


public class StavkaDTO {

	private Long id;
	private String name;
	private String cena;
	private String opis;
	private String picture;
	private Long sobaId;
	
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
	public Long getSobaId() {
		return sobaId;
	}
	public void setSobaId(Long sobaId) {
		this.sobaId = sobaId;
	}
	
	
	
	
	
	
}
