package com.enzo.service;

import java.util.List;

import com.enzo.web.domain.CatFacts;

/**
 * 
 * @author enzo
 *
 */
public interface CatService {
	List<CatFacts> findCat();
	List<CatFacts> getAllCats();
}
