package com;


import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RatingService {

	private final List<Rating> ratingList = new ArrayList<>();

	// Initialize some default ratings on startup
	@PostConstruct
	public void initRatings() {
		ratingList.add(new Rating(1, 2.0, "Not Bearable", "FLOP"));
		ratingList.add(new Rating(4, 4.0, "One time watchable", "Average"));
		ratingList.add(new Rating(3, 7.0, "Must watch", "Super Hit"));
		ratingList.add(new Rating(2, 9.0, "Must watch movie", "Blockbuster"));
		ratingList.add(new Rating(5, 8.5, "Highly recommended", "Hit"));
	}

	// Get all ratings
	public List<Rating> getAllRatings() {
		return ratingList;
	}

	// Get rating by movie ID
	public Rating getRatingById(int movieId) {
		return ratingList.stream()
				.filter(movie -> movie.getMovieId() == movieId)
				.findFirst()
				.orElseThrow(() -> new MovieNotFoundException("Movie with ID " + movieId + " not found."));
	}

	// Get top-rated movies (above 7.0)
	public List<Rating> getTopRatedMovies() {
		List<Rating> topRatedMovies = ratingList.stream()
				.filter(movie -> movie.getRating() > 7.0)
				.collect(Collectors.toList());

		if (topRatedMovies.isEmpty()) {
			throw new MovieNotFoundException("No top-rated movies found (rating > 7.0).");
		}
		return topRatedMovies;
	}

	// Get worst-rated movies (below 4.0)
	public List<Rating> getWorstRatedMovies() {
		List<Rating> worstRatedMovies = ratingList.stream()
				.filter(movie -> movie.getRating() < 4.0)
				.collect(Collectors.toList());

		if (worstRatedMovies.isEmpty()) {
			throw new MovieNotFoundException("No worst-rated movies found (rating < 4.0).");
		}
		return worstRatedMovies;
	}

	// Get movies within a rating range
	public List<Rating> getMoviesByRatingRange(double min, double max) {
		if (min > max) {
			throw new InvalidRangeException("Invalid range: min (" + min + ") cannot be greater than max (" + max + ").");
		}
		return ratingList.stream()
				.filter(movie -> movie.getRating() >= min && movie.getRating() <= max)
				.collect(Collectors.toList()); // Return an empty list if no movies match
	}

	// Add a new movie rating
	public Rating addRating(Rating rating) {
		if (ratingList.stream().anyMatch(r -> r.getMovieId() == rating.getMovieId())) {
			throw new IllegalArgumentException("Movie with ID " + rating.getMovieId() + " already exists.");
		}

		ratingList.add(rating);
		return rating;
	}
}