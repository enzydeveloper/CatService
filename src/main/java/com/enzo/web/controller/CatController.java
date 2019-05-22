package com.enzo.web.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.enzo.service.CatService;
import com.enzo.web.domain.CatFact;
import com.enzo.web.domain.SearchCriteria;

/**
 * Main web controller
 * @author enzo
 *
 */
@Controller
public class CatController {
	Logger logger = LogManager.getLogger(this.getClass().getName());
	
	@Autowired
	CatService catService;

	/**
	 * Http endpoint that retrieves all cat objects and sends it back
	 * @param name
	 * @return
	 */
	@RequestMapping("/api/allCatFacts")
	@ResponseBody
	public List<CatFact> retrieveAllCatFacts(@RequestParam(value = "name", defaultValue = "CatFace") String name) {
		
		logger.debug("Returning cats");
		
		return catService.getAllCats();
	}
	
	/**
	 * Binds the request to a POJO and uses it to search
	 * @param model
	 * @param search (json request body)
	 * @return
	 */
	@RequestMapping("/api/searchCat")
	@ResponseBody
	public List<CatFact> searchCat(ModelMap model, @RequestBody SearchCriteria searchCriteria )
	{
		logger.debug("This is the model " + model);
		logger.debug("Searching cats");
		
		return catService.findCat(searchCriteria);
	}
	

	@RequestMapping("/search")
	public String search(ModelMap model )
	{
		return "search";
	}
	
}
