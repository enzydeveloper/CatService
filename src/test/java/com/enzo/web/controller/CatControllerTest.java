package com.enzo.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.enzo.main.Application;
import com.enzo.service.CatService;
import com.enzo.web.domain.CatFact;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CatController.class, secure = false)
@ContextConfiguration(classes=Application.class)
//@SpringBootTest(classes = Application.class)
public class CatControllerTest 
{

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CatService service;
	
	
	@Test
	public void retrieveDetailsForCourse() throws Exception {

		List<CatFact> catFacts = new ArrayList<CatFact>();
		
		CatFact catFact = new CatFact();
		catFact.setText("THIS TEST");
		catFact.setType("CAT");
		
		catFacts.add(catFact);
		
		
		Mockito.when(service.getAllCats()).thenReturn(catFacts);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/catFacts").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{\"text\":\"THIS TEST\",\"type\":\"CAT\"}]";


		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
}
