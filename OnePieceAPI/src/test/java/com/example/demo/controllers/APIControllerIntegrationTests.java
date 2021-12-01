package com.example.demo.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.model.API;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:test-schema.sql",
		"classpath:test-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class APIControllerIntegrationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;


	@DirtiesContext
	@Test
	void createCharTest() throws Exception {
		String testAPIAsJson = this.mapper.writeValueAsString(new API(null, 3, "Red-Haired Shanks", "4,048,900,000",
				"no devil fruit", "Red-Haired Pirates", "Captain"));
		String testAPIAsJsonResponse = this.mapper.writeValueAsString(
				new API(4, 3, "Red-Haired Shanks", "4,048,900,000", "no devil fruit", "Red-Haired Pirates", "Captain"));

		RequestBuilder request = post("/api/create").contentType(MediaType.APPLICATION_JSON).content(testAPIAsJson);

		ResultMatcher status = status().isCreated();
		ResultMatcher content = content().json(testAPIAsJsonResponse);

		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
	
	@DirtiesContext
	@Test
	void getAllCharacterTest() throws Exception {
		String listofCharJson = this.mapper.writeValueAsString(
				List.of(new API(1, 1, "Gold.D.Roger", "5,564,800,000", "no devil fruit", "Roger Pirates", "Captain"),
						new API(2, 2, "Edward Newgate", "5,046,000,000", "Gura-Gura no Mi (Tremor-Tremor Fruit)",
								"Whitebeard Pirates", "Captain"),
						new API(3, 4, "Kaido of the Beasts", "4,611,000,000", "Fish-Fish fruit, Model: Azure Dragon",
								"Beast Pirates", "Captain")));

		RequestBuilder request = get("/api/getAll");

		ResultMatcher status = status().isOk();
		ResultMatcher content = content().json(listofCharJson);
		System.out.println(request);
		this.mvc.perform(request).andExpect(status).andExpect(content);
		
	

	}

	@DirtiesContext
	@Test
	void getByIdTest() throws Exception {
		;
		String foundCharAsJson = this.mapper.writeValueAsString(
				new API(1, 1, "Gold.D.Roger", "5,564,800,000", "no devil fruit", "Roger Pirates", "Captain"));

		RequestBuilder request = get("/api/1");

		ResultMatcher status = status().isOk();
		ResultMatcher content = content().json(foundCharAsJson);

		this.mvc.perform(request).andExpect(status).andExpect(content);

	}
	
	@DirtiesContext
	@Test
	void updateCharTest() throws Exception {
		String testAPIAsJsonResponse = this.mapper.writeValueAsString(
				new API(2, 3, "Red-Haired Shanks", "4,048,900,000", "no devil fruit", "Red-Haired Pirates", "Captain"));

		RequestBuilder request = put("/api/update/2").contentType(MediaType.APPLICATION_JSON)
				.content(testAPIAsJsonResponse);

		ResultMatcher status = status().isAccepted();
		ResultMatcher content = content().json(testAPIAsJsonResponse);

		this.mvc.perform(request).andExpect(status).andExpect(content);
	}


	

}
