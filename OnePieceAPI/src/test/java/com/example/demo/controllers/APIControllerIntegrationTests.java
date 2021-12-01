package com.example.demo.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



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


}
