/**
 * 
 */
package com.enzo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enzo.dao.CatDao;
import com.enzo.web.domain.CatFacts;

/**
 * @author enzo
 *
 */
@Component
public class CatServiceImpl implements CatService {

	@Autowired
	CatDao catdao;

	@Override
	public List<CatFacts> findCat() {
		return catdao.getAllCats();
	}

	@Override
	public List<CatFacts> getAllCats() {
		return catdao.getAllCats();
	}
}
