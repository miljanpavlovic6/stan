package com.gram.web.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gram.model.Soba;
import com.gram.model.Stavka;
import com.gram.service.SobaService;
import com.gram.service.StavkaService;
import com.gram.web.dto.StavkaDTO;



@Component
public class StavkaDTOToStavka 
implements Converter<StavkaDTO, Stavka>{

	@Autowired
	private StavkaService stavkaService;
	@Autowired
	private SobaService sobaService;
	
	@Override
	public Stavka convert(StavkaDTO source) {
		Stavka stavka;
		Soba f = sobaService.findOne(source.getSobaId());
		
		if(source.getId() == null) {
			stavka = new Stavka();
		}else {
			stavka = stavkaService.findById(source.getId());
		}
		
		stavka.setSoba(f);
		
		stavka.setCena(source.getCena());
		stavka.setName(source.getName());
		stavka.setOpis(source.getOpis());
		stavka.setPicture(source.getPicture());
		
		return stavka;
	}

}
