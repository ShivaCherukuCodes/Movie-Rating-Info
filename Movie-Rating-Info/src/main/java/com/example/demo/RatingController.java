package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@GetMapping("getRattingInfo")
	public List<Rating> getRating() {

		return ratingService.getRatingInfo();
	}
	
	@GetMapping("/getRattingInfoById/{movieId}")
	public Optional<Rating> getRatingById(@PathVariable("movieId") int movieId) {
		System.out.println("input ::"+movieId);

		return ratingService.getRatingInfoById(movieId);
	}
	
	@GetMapping("/getUserDataList")
	public UsersData getUserDataList() {
		List<Rating> ml = Arrays.asList(new Rating(6, 3.0, "One time watchable", "AVG"),new Rating(8, 1.0, "Horrible", "WORST"));
		UsersData data = new UsersData();
		data.setRatingList(ml);
		System.out.println("getUserDataList method is called>>>>>>");
		return data;
	}
}
