package com.eatza.restaurantsearch.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;

    private String comments;
    private String description;
    private Integer score;
    private Long restaurantId;
    private String status;

    public Review(String comments, String description, Integer score, Long restaurantId,String status) {
        super();
        this.comments = comments;
        this.description = description;
        this.score = score;
        this.restaurantId = restaurantId;
        this.status=status;
    }
}
