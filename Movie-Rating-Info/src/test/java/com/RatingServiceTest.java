package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RatingServiceTest {

    private RatingService ratingService;

    @BeforeEach
    void setUp() {
        ratingService = new RatingService();
        ratingService.initRatings();
    }

    @Test
    void testInitRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        assertEquals(5, ratings.size(), "Should have 5 ratings initialized");
        assertEquals("FLOP", ratings.get(0).getRatingCategory());
        assertEquals(9.0, ratings.get(3).getRating());
    }

    @Test
    void testGetAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        assertEquals(5, ratings.size(), "Should have 5 ratings");
        assertTrue(ratings.stream().anyMatch(r -> r.getRatingCategory().equals("Blockbuster")));
    }


    @Test
    void testGetTopRatedMovies() {
        List<Rating> topRatedMovies = ratingService.getTopRatedMovies();

        // ASSERT: Should contain exactly two top-rated movies
        assertEquals(2, topRatedMovies.size(), "Expected two top-rated movies");

        // ASSERT: Verify all movies are rated above 7.0
        assertTrue(topRatedMovies.stream().allMatch(r -> r.getRating() > 7.0), "Some movies do not meet the top-rated criteria");
    }

    @Test
    void testGetWorstRatedMovies() {
        List<Rating> worstRatedMovies = ratingService.getWorstRatedMovies();

        // ASSERT: Should contain exactly one worst-rated movie
        assertEquals(1, worstRatedMovies.size(), "Expected one worst-rated movie");

        // ASSERT: Verify the description of the worst-rated movie
        assertEquals("Not Bearable", worstRatedMovies.get(0).getDescription(), "Unexpected description for the worst-rated movie");
    }

    @Test
    void testGetMoviesByRatingRange() {
        List<Rating> moviesInRange = ratingService.getMoviesByRatingRange(4.0, 8.0);

        // ASSERT: Should contain exactly two movies in this range
        assertEquals(2, moviesInRange.size(), "Expected two movies in the rating range");

        // ASSERT: Verify all movies are within the range
        assertTrue(moviesInRange.stream().allMatch(r -> r.getRating() >= 4.0 && r.getRating() <= 8.0), "Some movies are outside the rating range");
    }

    @Test
    void testAddRating() {
        Rating newRating = new Rating(6, 7.5, "Amazing visuals", "Super Hit");
        ratingService.addRating(newRating);

        List<Rating> allRatings = ratingService.getAllRatings();
        assertEquals(6, allRatings.size(), "Expected six ratings after adding a new one");
        assertTrue(allRatings.contains(newRating), "New rating was not added properly");
    }

    @Test
    void testGetMoviesByRatingRange_noResults() {
        List<Rating> moviesInRange = ratingService.getMoviesByRatingRange(0.0, 1.0);
        assertTrue(moviesInRange.isEmpty(), "Expected no movies in the given range");
    }

    @Test
    void testAddRating_duplicateMovieId() {
        Rating duplicateRating = new Rating(1, 8.0, "Duplicate movie", "Hit");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                ratingService.addRating(duplicateRating)
        );

        assertEquals("Movie with ID 1 already exists.", exception.getMessage());
    }

    @Test
    void testGetRatingById_movieNotFound() {
        MovieNotFoundException exception = assertThrows(MovieNotFoundException.class, () ->
                ratingService.getRatingById(99)
        );

        assertEquals("Movie with ID 99 not found.", exception.getMessage());
    }

    @Test
    void testGetMoviesByRatingRange_invalidRange() {
        InvalidRangeException exception = assertThrows(InvalidRangeException.class, () ->
                ratingService.getMoviesByRatingRange(9.0, 7.0)
        );

        assertEquals("Invalid range: min (9.0) cannot be greater than max (7.0).", exception.getMessage());
    }
}