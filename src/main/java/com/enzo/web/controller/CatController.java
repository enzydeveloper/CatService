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
import com.enzo.service.CatService;
import com.enzo.web.domain.CatFact;

@RestController
@RequestMapping("/api")
public class CatController {
	Logger logger = LogManager.getLogger(this.getClass().getName());
	
	@Autowired
	CatService catService;

	@RequestMapping("/catFacts")
	public List<CatFact> retrieveAllCatFacts(@RequestParam(value = "name", defaultValue = "CatFace") String name) {
		
		logger.debug("Returning cats");
		
		return catService.getAllCats();
		
	}
}
