package com.gram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gram.model.Soba;
import com.gram.model.Stavka;
import com.gram.service.SobaService;
import com.gram.service.StavkaService;

@RestController
@RequestMapping("/api/sobe")
public class ApiSobaController {

	@Autowired
	private SobaService sobaService;
	@Autowired
	private StavkaService stavkaService;
	
//	GET ALL
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Soba>> get (){
		List<Soba> sobe;
		sobe = sobaService.findAll();
		if(sobe == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(sobe, HttpStatus.OK);
	}
//	GET WITH ID
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<Soba> get(@PathVariable Long id){
		Soba soba = sobaService.findOne(id);
		if(soba == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(soba, HttpStatus.OK);
	}
//	SAVE EDIT STAVKA
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public ResponseEntity<Soba> edit(@PathVariable Long id, @RequestBody Soba edited){
		
		sobaService.save(edited);
		return new ResponseEntity<>(edited, HttpStatus.OK);
		
	}
	
//	SAVE NEW Stavka
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Soba> add (@RequestBody Soba newSoba){
		
		sobaService.save(newSoba);
		
		return new ResponseEntity(newSoba, HttpStatus.OK);
	}
	
//	DELETE STAVKA
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Soba>delete(@PathVariable Long id){
		
		Soba soba = sobaService.remove(id);
		
		return new ResponseEntity<>(soba, HttpStatus.OK);
	}
	
//	FIND BY SOBAID - stavke
//	@RequestMapping(value= "{id}/stavke", method=RequestMethod.GET)
//	ResponseEntity<List<Stavka>> getSobaStavke(
//			@PathVariable Long id, @RequestParam(defaultValue="0") int pageNum){
//		
//		Page<Stavka> stavkaPage = stavkaService.findBySobaId(id, pageNum);
//		
//		if(stavkaPage == null || stavkaPage.getContent().isEmpty()){
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("totalPages", Integer.toString(stavkaPage.getTotalPages()) );
//		
//		return new ResponseEntity<>(
//				stavkaPage.getContent(),
//				headers,
//				HttpStatus.OK);
//	}
	
	@RequestMapping(value= "{id}/stavke", method=RequestMethod.GET)
	ResponseEntity<List<Stavka>> getSobaStavke(
			@PathVariable Long id){
		
		List<Stavka> stavkaPage = stavkaService.findBySobaId(id);
		
		
		
		
		return new ResponseEntity<>(
				stavkaPage,
				HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
