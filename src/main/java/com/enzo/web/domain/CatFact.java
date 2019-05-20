package com.enzo.web.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Main element of JSON
 * @author enzo
 *
 */
@JsonIgnoreProperties(value = { "_id", "user", "userUpvoted" })
public class CatFact 
{
	String _id;
	String text;
	String type;

	User user;
	String upvotes;
	String userUpvoted;
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(String upvotes) {
		this.upvotes = upvotes;
	}

	public String getUserUpvoted() {
		return userUpvoted;
	}

	public void setUserUpvoted(String userUpvoted) {
		this.userUpvoted = userUpvoted;
	}


	
}
