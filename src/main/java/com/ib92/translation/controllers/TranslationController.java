package com.ib92.translation.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ib92.translation.models.Key;
import com.ib92.translation.models.Translation;
import com.ib92.translation.services.KeyService;
import com.ib92.translation.services.TranslationService;

@RequestMapping("/translate")
@RestController
public class TranslationController {

	@Autowired
	private TranslationService translatervice;
	
	@Autowired
	private KeyService keyService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addTask(@RequestBody Translation translation){
		Translation savedTranslation = this.translatervice.saveTranslation(translation);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTranslation.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateTranslatin(@PathVariable int id, @RequestBody Translation trans) {
		Optional<Translation> t = translatervice.getTranslationById(id);
		if(!t.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value ="/{origin}", method = RequestMethod.GET)
	public String getOneTranslatoin(@RequestParam(value="lang", required=true) String key, @PathVariable String origin) {
		return translatervice.getTranslation(origin, key).getTranslated() ;
	}
	
	@RequestMapping(value ="/all/{origin}", method = RequestMethod.GET)
	public List<Translation> getAllByOrigin(@PathVariable String origin) {
		return translatervice.getAllByOrigin(origin) ;
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
	public void deleteTranslation(@PathVariable int id) {
		translatervice.deleteTranslation(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addKey(@RequestBody Key k){
		Key savedKey = this.keyService.saveKey(k);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedKey.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value ="/keys", method = RequestMethod.GET)
	public List<Key> getAllKeys() {
		return keyService.getAllKeys() ;
	}
	
}
