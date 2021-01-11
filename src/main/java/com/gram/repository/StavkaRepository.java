package com.gram.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.gram.model.Stavka;

public interface StavkaRepository extends JpaRepository<Stavka, Long> {
	
//	Page<Stavka> findBySobaId(Long id, Pageable page);

	List<Stavka> findBySobaId(Long id);
}
