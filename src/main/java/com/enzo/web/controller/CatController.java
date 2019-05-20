package com.enzo.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enzo.dao.CatDao;
import com.enzo.web.domain.CatFacts;

@RestController
@RequestMapping("/api")
public class CatController {
	Logger logger = LogManager.getLogger(this.getClass().getName());
	
	@Autowired
	CatDao catdao;
	
//	private static final String template = "Hello, %s!";
//	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public List<CatFacts> greeting(@RequestParam(value = "name", defaultValue = "CatFace") String name) {
		
		logger.debug("Returning cats");
		
		return catdao.getAllCats();
		
	}
}
