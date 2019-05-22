package com.enzo.service;

import java.util.List;

import com.enzo.web.domain.CatFact;
import com.enzo.web.domain.SearchCriteria;

/**
 * Business logic for handling Cats
 * @author enzo
 *
 */
public interface CatService {
	
	/**
	 * Gets all the cat facts
	 * @return
	 */
	List<CatFact> getAllCats();
	
	/**
	 * Looks specifically for text
	 * @param searchCriteria
	 * @return
	 */
	List<CatFact> findCat(SearchCriteria searchCriteria);
}
