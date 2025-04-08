package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	// Get all ratings
	@GetMapping("/all")
	public List<Rating> getAllRatings() {
		return ratingService.getAllRatings();
	}

	// Get rating by movie ID
	@GetMapping("/{movieId}")
	public Optional<Rating> getRatingById(@PathVariable int movieId) {
		return Optional.ofNullable(ratingService.getRatingById(movieId));
	}

	// Get top-rated movies
	@GetMapping("/topRated")
	public List<Rating> getTopRatedMovies() {
		return ratingService.getTopRatedMovies();
	}

	// Get worst-rated movies
	@GetMapping("/lowRated")
	public List<Rating> getLowRatedMovies() {
		return ratingService.getWorstRatedMovies();
	}

	// Get movies within a rating range
	@GetMapping("/range")
	public List<Rating> getMoviesByRatingRange(@RequestParam double min, @RequestParam double max) {
		return ratingService.getMoviesByRatingRange(min, max);
	}

	// Add a new rating
	@PostMapping("/add")
	public ResponseEntity<?> addRating(@RequestBody Rating rating) {
		try {
			Rating saved = ratingService.addRating(rating);
			return ResponseEntity.ok(saved);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
