package com.gram.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gram.model.Soba;
import com.gram.repository.SobaRepository;
import com.gram.service.SobaService;

@Service
@Transactional
public class JpaSobaServiceImpl implements SobaService{

	@Autowired SobaRepository sobaRepository;
	
	@Override
	public List<Soba> findAll() {
		// TODO Auto-generated method stub
		return sobaRepository.findAll();
	}

	@Override
	public Soba findOne(Long id) {
		// TODO Auto-generated method stub
		return sobaRepository.getOne(id);
	}

	@Override
	public void save(Soba soba) {
		// TODO Auto-generated method stub
		sobaRepository.save(soba);
		
	}

	@Override
	public Soba remove(Long id) {
		Soba soba = sobaRepository.getOne(id);
		if(soba != null) {
			sobaRepository.delete(soba);
		}
		return soba;
	}

	@Override
	public List<Soba> FindByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
