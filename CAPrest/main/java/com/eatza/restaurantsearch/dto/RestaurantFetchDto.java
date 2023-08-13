package com.eatza.restaurantsearch.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantFetchDto {

	private Long id;
	private String name;
	private String location;
	private String cuisine;
	private int budget;
	private double rating;
	public Long getId() {
		return id;
	}
	
	public RestaurantFetchDto(Long id, String name, String location, String cuisine, int budget, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.cuisine = cuisine;
		this.budget = budget;
		this.rating = rating;
	}

	
}
