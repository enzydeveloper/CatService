/**
 * 
 */
package com.enzo.web.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO that represents the top lvl JSON response as a container
 * 
 * Container for {@link CatFacts}
 * @author enzo
 *
 */
public class All 
{
	List<CatFacts> all;

	public List<CatFacts> getAll() {
		return all;
	}

	public void setAll(List<CatFacts> all) {
		this.all = all;
	}
}
