package com.enzo.web.domain;

/**
 * Sub element of {@link CatFact}
 * @author enzo
 *
 */
class User
{
	String _id;
	Name name;
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
}