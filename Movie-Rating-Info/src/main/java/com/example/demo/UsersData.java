package com.example.demo;

import java.util.List;

public class UsersData {

	private List<Rating> ratingList;

	public UsersData() {

	}

	public UsersData(List<Rating> ratingList) {
		super();
		this.ratingList = ratingList;
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}

}
