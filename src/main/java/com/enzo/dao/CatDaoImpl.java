/**
 * 
 */
package com.enzo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.enzo.web.domain.All;
import com.enzo.web.domain.CatFacts;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author enzo
 *
 */
@Component
public class CatDaoImpl implements CatDao {
	Logger logger = LogManager.getLogger(this.getClass().getName());

	//Location of public API
	String server = "https://cat-fact.herokuapp.com";
	String uri = "/facts";
	
	List<CatFacts> cats = new ArrayList<CatFacts>();
	
	@PostConstruct
	public void init()
	{
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");
	    headers.add("Accept", "*/*");
	    
	    
		HttpStatus status;
		
	    HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
	    ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.GET, requestEntity, String.class);
	    status = (responseEntity.getStatusCode());
	    String response = responseEntity.getBody();
	    logger.debug("Got resposse: " + response);
	    
	    

        ObjectMapper mapper = new ObjectMapper();
        All jsonResponse = null;
        // Java objects to JSON string - compact-print
        try {
			jsonResponse = mapper.readValue(response, All.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        if(jsonResponse != null)
        {
        	cats = jsonResponse.getAll();
        }
	}
	
	@Override
	public List<CatFacts> getAllCats() {
		return cats;
	}

	@Override
	public List<CatFacts> findCat() {
		return null;
	}
	
}
