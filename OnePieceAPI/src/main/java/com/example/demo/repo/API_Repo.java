package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.API;

@Repository
public interface API_Repo extends JpaRepository<API, Integer> {
	
	List<API> findCharacterById(Integer id);

	List<API> findCharacByName(String name);

	List<API> findCharByPosition(String position);
	

	
	

}
