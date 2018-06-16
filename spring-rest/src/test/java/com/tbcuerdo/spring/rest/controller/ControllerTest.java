package com.tbcuerdo.spring.rest.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbcuerdo.spring.rest.domain.Domain;

public class ControllerTest extends BaseWebApplicationContextTests {
	
	private Logger logger = LoggerFactory.getLogger(ControllerTest.class);

	@Test
	public void whenPageObjectReturnedThenProp1IsFlattened() throws ServletException, IOException {
		request.setMethod("POST");
		request.addHeader("Accept", "application/json");
		request.addHeader("Content-Type", "application/json");
		request.setRequestURI("/controller/1");
		request.setContentType("application/json");
		
		Domain domain = new Domain();
		domain.setProp1("abc");
		
		ObjectMapper mapper = new ObjectMapper();
		request.setContent(mapper.writeValueAsString(domain).getBytes());
		
		servlet.service(request, response);
        String result = response.getContentAsString();
        
        Assert.assertEquals(200, response.getStatus());
        String expectedJSON = "{\"property1\":\"abc@\"}";
        Assert.assertEquals(createTree(expectedJSON), createTree(result));
	}
	
	private JsonNode createTree(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, JsonNode.class);
    }

}
