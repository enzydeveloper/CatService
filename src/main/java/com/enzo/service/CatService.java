package com.enzo.service;

import java.util.List;

import com.enzo.web.domain.CatFact;

/**
 * 
 * @author enzo
 *
 */
public interface CatService {
	List<CatFact> findCat();
	List<CatFact> getAllCats();
}
