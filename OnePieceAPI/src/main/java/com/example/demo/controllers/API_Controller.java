package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.API;
import com.example.demo.service.API_Service;

@RestController

@RequestMapping(path = "/api")
public class API_Controller {

	private API_Service service;

	public API_Controller(API_Service service) {
		super();
		this.service = service;
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/create")
	public ResponseEntity<API> addCharacter(@RequestBody API api) {
		ResponseEntity<API> response = new ResponseEntity<API>(this.service.addCharacter(api), HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<API>> get() {
		ResponseEntity<List<API>> response = new ResponseEntity<List<API>>(this.service.getAllCharacters(),
				HttpStatus.OK);
		return response;
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<API> getById(@PathVariable Integer id) {
		return new ResponseEntity<API>(this.service.getById(id), HttpStatus.OK);

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<API> updateCharacter(@RequestBody API api, @PathVariable Integer id) {
		ResponseEntity<API> response = new ResponseEntity<API>(this.service.updateAPI(api, id), HttpStatus.ACCEPTED); // 202
		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable Integer id) {
		boolean deleted = this.service.deleteChar(id);

		if (deleted) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}







}
