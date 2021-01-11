package com.gram.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.gram.model.Stavka;

public interface StavkaService {

	List<Stavka>findAll();
	Stavka findById(Long id);
	void save(Stavka stavka);
	Stavka remove(Long id);
	List<Stavka>FindByName(String name);
//	Page<Stavka>findBySobaId(Long id, int pageNum);
	List<Stavka> findBySobaId(Long id);
	
	
}
