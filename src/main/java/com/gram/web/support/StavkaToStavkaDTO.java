package com.gram.web.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gram.model.Stavka;
import com.gram.web.dto.StavkaDTO;



@Component
public class StavkaToStavkaDTO 
implements Converter<Stavka, StavkaDTO>{

	@Override
	public StavkaDTO convert(Stavka source) {
		StavkaDTO stavkaDTO = new StavkaDTO();
		
		stavkaDTO.setSobaId(source.getSoba().getId());
		stavkaDTO.setId(source.getId());

		stavkaDTO.setCena(source.getCena());
		stavkaDTO.setOpis(source.getOpis());
		stavkaDTO.setName(source.getName());
		stavkaDTO.setPicture(source.getPicture());
		
		return stavkaDTO;
	}
	
//	RETURN LIST OF POLISE
	public List<StavkaDTO>convert(List<Stavka> stavke){
		List<StavkaDTO> ret = new ArrayList<>();
		
		for(Stavka p : stavke) {
			ret.add(convert(p));
		}
		return ret;
	}

}
