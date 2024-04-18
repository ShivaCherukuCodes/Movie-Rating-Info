package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class RatingService {

	public List<Rating> getRatingInfo() {
		List<Rating> rl = new ArrayList<Rating>();
		rl.add(new Rating(1, 2.0, "Not Bearable", "FLOP"));
		rl.add(new Rating(4, 4.0, "One time watchable", "Average"));
		rl.add(new Rating(3, 7.0, "Must watch", "Super Hit"));
		return rl;

	}

	public Optional<Rating> getRatingInfoById(int movieId) {
		List<Rating> rlist = getRatingInfo();		
		Optional<Rating> matchingMovies = rlist.stream()
			    .filter(movie -> movie.getMovieId() == movieId)
			    .findFirst();
		System.out.println("Data found for matching ID :: " + matchingMovies);
		return matchingMovies;
	}
}
