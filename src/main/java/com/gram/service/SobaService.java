package com.gram.service;

import java.util.List;

import com.gram.model.Soba;

public interface SobaService {

	List<Soba>findAll();
	Soba findOne(Long id);
	void save(Soba soba);
	Soba remove(Long id);
	List<Soba>FindByName(String name);
}
