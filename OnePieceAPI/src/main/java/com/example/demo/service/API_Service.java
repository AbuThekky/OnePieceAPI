package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exeptions.APINotFoundException;
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
	
	public API getById(Integer id) {
		API foundCharacter = this.repo.findById(id).orElseThrow(APINotFoundException::new);
		return foundCharacter;
		
	}
	
    public API updateAPI(API api, Integer id) {
		
		Optional<API> apiToFind = this.repo.findById(id);
		API apiToUpdate = apiToFind.get();
		
		apiToUpdate.setStrength_id(api.getStrength_id());
		apiToUpdate.setName(api.getName());
		apiToUpdate.setBounty(api.getBounty());
		apiToUpdate.setDevil_fruit(api.getDevil_fruit());
		apiToUpdate.setCrew(api.getCrew());
		apiToUpdate.setPosition(api.getPosition());
		return this.repo.save(apiToUpdate);
		
	}




	
}
