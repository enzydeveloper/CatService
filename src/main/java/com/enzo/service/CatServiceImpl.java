/**
 * 
 */
package com.enzo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enzo.dao.CatDao;
import com.enzo.web.domain.CatFact;

/**
 * @author enzo
 *
 */
@Component
public class CatServiceImpl implements CatService {

	@Autowired
	CatDao catdao;

	@Override
	public List<CatFact> findCat() {
		return catdao.getAllCats();
	}

	@Override
	public List<CatFact> getAllCats() {
		return catdao.getAllCats();
	}
}
