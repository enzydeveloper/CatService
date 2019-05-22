/**
 * 
 */
package com.enzo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enzo.dao.CatDao;
import com.enzo.web.domain.CatFact;
import com.enzo.web.domain.SearchCriteria;


/**
 * Business logic for handling Cats
 * @author enzo
 *
 */
@Component
public class CatServiceImpl implements CatService {

	@Autowired
	CatDao catdao;

	/*
	 * (non-Javadoc)
	 * @see com.enzo.service.CatService#findCat(com.enzo.web.domain.SearchCriteria)
	 */
	@Override
	public List<CatFact> findCat(SearchCriteria searchCriteria) {
		
		//Do extra business logic here for finding cat information
		
		return catdao.findCat(searchCriteria.getText());
	}

	/*
	 * (non-Javadoc)
	 * @see com.enzo.service.CatService#getAllCats()
	 */
	@Override
	public List<CatFact> getAllCats() {
		return catdao.getAllCats();
	}
}
