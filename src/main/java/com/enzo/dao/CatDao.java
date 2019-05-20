package com.enzo.dao;

import java.util.List;

import com.enzo.web.domain.CatFacts;

public interface CatDao {
	public List<CatFacts> getAllCats();
	
	public List<CatFacts> findCat();
}
