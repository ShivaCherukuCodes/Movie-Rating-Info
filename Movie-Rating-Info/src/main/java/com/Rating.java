package com;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

	private int movieId;

	@Min(0)
	@Max(10)
	private double rating;

	@NotBlank(message = "Description cannot be empty")
	private String description;

	private String ratingCategory;

}
