package com.example.apiExample;

import com.example.apiExample.dto.UserTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiExampleApplicationTests {

	@Test
	void contextLoads() throws JsonMappingException, JsonProcessingException {
		System.out.println("--------------");

		// object -> text
		var objectMapper = new ObjectMapper();

		var user = new UserTest();
		user.setName("minji");
		user.setAge(10);
		var text = "";
		try {
			text = objectMapper.writeValueAsString(user);
			System.out.println(text);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// text -> object
		var objectUser = objectMapper.readValue(text, UserTest.class);

	}

}
