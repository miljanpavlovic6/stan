package com.gram.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.gram.model.Stavka;
import com.gram.repository.StavkaRepository;
import com.gram.service.StavkaService;

@Service
@Transactional
public class JpaStavkaServiceImpl implements StavkaService{

	@Autowired StavkaRepository stavkaRepository;
	
	@Override
	public List<Stavka> findAll() {
		// TODO Auto-generated method stub
		return stavkaRepository.findAll();
	}

	@Override
	public Stavka findById(Long id) {
		// TODO Auto-generated method stub
		return stavkaRepository.getOne(id);
	}

	@Override
	public void save(Stavka stavka) {
		// TODO Auto-generated method stub
		stavkaRepository.save(stavka);
		
	}

	@Override
	public Stavka remove(Long id) {
		Stavka stavka = stavkaRepository.getOne(id);
		if(stavka != null) {
			stavkaRepository.delete(stavka);
		}
		return stavka;
	}

//	NEVALJA
	@Override
	public List<Stavka> FindByName(String name) {
		// TODO Auto-generated method stub
		return stavkaRepository.findAll();
	}

//	@Override
//	public Page<Stavka> findBySobaId(Long id, int pageNum) {
//		return stavkaRepository.findBySobaId(id, new PageRequest(pageNum, 20));
		
//		return null;
//	}
	
	@Override
	public List<Stavka> findBySobaId(Long id) {
		return stavkaRepository.findBySobaId(id);
		
	}
	
	

	

	
}
