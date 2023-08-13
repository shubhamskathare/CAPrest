package com.eatza.restaurantsearch.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Builder
@NoArgsConstructor
public class ReviewDto {

	private String comments;
	private String description;
	private Integer score;
	private Long restaurantId;
}
