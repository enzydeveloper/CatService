package com.enzo.web.domain;

/**
 * Web model to hold user search input
 * @author enzo
 *
 */
public class SearchCriteria {
	String type;
	String text;
	
	public SearchCriteria()
	{
		super();
	}
	
	public SearchCriteria(String type, String text) {
		super();
		this.type = type;
		this.text = text;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
