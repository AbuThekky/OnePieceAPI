package com.example.demo.service;



import java.util.List;

import org.springframework.stereotype.Service;


import com.example.demo.model.API;
import com.example.demo.repo.API_Repo;

@Service
public class API_Service {
     
	private API_Repo repo;
	
	public API_Service(API_Repo repo) {
		this.repo = repo;
	}
	
	public API addCharacter(API api) {
		return this.repo.save(api);
	}
	

	public List<API> getAllCharacters() {
		return this.repo.findAll();
	}

	
}
