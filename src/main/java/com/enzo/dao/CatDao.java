package com.enzo.dao;

import java.util.List;

import com.enzo.web.domain.CatFact;

public interface CatDao {
	public List<CatFact> getAllCats();
	
	public List<CatFact> findCat();
}
