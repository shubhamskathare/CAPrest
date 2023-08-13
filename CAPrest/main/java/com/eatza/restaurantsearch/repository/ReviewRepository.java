package com.eatza.restaurantsearch.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eatza.restaurantsearch.dto.Review;



@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    
}
