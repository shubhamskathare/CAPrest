package com.eatza.restaurantsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.eatza.restaurantsearch.model.Restaurant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RestaurantWithReviews {

    List<ReviewDto> reviewDtoList;
    Restaurant restaurant;
}
