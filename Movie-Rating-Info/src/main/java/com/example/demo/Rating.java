package com.example.demo;

public class Rating {
	int movieId;
	double rating;
	String desc;
	String result;

	public Rating() {
		super();
	}

	public Rating(int movieId, double rating, String desc, String result) {
		super();
		this.movieId = movieId;
		this.rating = rating;
		this.desc = desc;
		this.result = result;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public double getRating() {
		return rating;
	}

	public double setRating(double rating) {
		return this.rating = rating;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Rating [movieId=" + movieId + ", rating=" + rating + ", desc=" + desc + ", result=" + result + "]";
	}

}
