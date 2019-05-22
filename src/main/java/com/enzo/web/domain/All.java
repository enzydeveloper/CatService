/**
 * 
 */
package com.enzo.web.domain;

import java.util.List;

/**
 * POJO that represents the top lvl JSON response as a container
 * 
 * Container for {@link CatFact}
 * @author enzo
 *
 */
public class All 
{
	List<CatFact> all;

	public List<CatFact> getAll() {
		return all;
	}

	public void setAll(List<CatFact> all) {
		this.all = all;
	}
}
