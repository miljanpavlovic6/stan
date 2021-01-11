package com.gram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gram.model.Stavka;
import com.gram.service.StavkaService;
import com.gram.web.support.StavkaDTOToStavka;
import com.gram.web.support.StavkaToStavkaDTO;
import com.gram.web.dto.StavkaDTO;

@RestController
@RequestMapping("/api/stavke")
public class ApiStavkaController {

	@Autowired
	private StavkaService stavkaService;
	@Autowired
	private StavkaToStavkaDTO toStavkaDTO;
	@Autowired
	private StavkaDTOToStavka toStavka;
	
//	GET ALL
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<StavkaDTO>> get(
			){
		
		List<Stavka> stavke;
		stavke = stavkaService.findAll();
		if(stavke == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(toStavkaDTO.convert(stavke), HttpStatus.OK);
	}
//PUT EDIT STAVKA
		@RequestMapping(method=RequestMethod.PUT, value="/{id}")
		public ResponseEntity<StavkaDTO> edit(
				@PathVariable Long id,
				@RequestBody StavkaDTO edited){
			
			if(!id.equals(edited.getId())) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Stavka stavka = toStavka.convert(edited);
			stavkaService.save(stavka);
			
			return new ResponseEntity<>(toStavkaDTO.convert(stavka), HttpStatus.OK);
		}
	
//	SAVE NEW Stavka
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<StavkaDTO> add (@RequestBody StavkaDTO newStavka){
		Stavka stavka = toStavka.convert(newStavka);
		stavkaService.save(stavka);
		
		return new ResponseEntity<>(toStavkaDTO.convert(stavka), HttpStatus.OK);
	}
	
//	DELETE STAVKA
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Stavka>delete(@PathVariable Long id){
		
		Stavka stavka = stavkaService.remove(id);
		
		return new ResponseEntity<>(stavka, HttpStatus.OK);
	}
	
//	GET WITH ID
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<Stavka> get(@PathVariable Long id){
		Stavka stavka = stavkaService.findById(id);
		if(stavka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(stavka, HttpStatus.OK);
	}
//	END GET WITH ID
	
	
	
}
