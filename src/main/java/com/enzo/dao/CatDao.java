package com.enzo.dao;

import java.util.List;

import com.enzo.web.domain.CatFact;

/**
 * Data access object
 * @author enzo
 *
 */
public interface CatDao {
	
	/**
	 * Gets all possible cat facts
	 * @return
	 */
	public List<CatFact> getAllCats();
	
	/**
	 * Searches for a specific cat fact
	 * @param catFact
	 * @return
	 */
	public List<CatFact> findCat(String catFact);
}
