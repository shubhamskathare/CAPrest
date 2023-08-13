/*package restaurantsearch.listener;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

import com.eatza.restaurantsearch.dto.Review;
import com.eatza.restaurantsearch.model.Restaurant;

import com.eatza.restaurantsearch.repository.RestaurantRepository;
import com.eatza.restaurantsearch.repository.ReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Configuration
public class KafkaListenerconsumer {
	
	private String topic="restaurant-review";
	
	ObjectMapper om=new ObjectMapper();
	
	@Autowired ReviewRepository reviewRepository;
	@Autowired RestaurantRepository restaurantRepository;
	
	@KafkaListener(topics="restaurant-review",groupId="groupId",containerFactory = "ratingsKafkaListenerContainerFactory")
	public void processReview(String  reviewString) {
		
		System.out.println("Received message: "+reviewString);
		Review review=null;
		try {
			review=om.readValue(reviewString, Review.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Restaurant restaurant=restaurantRepository.findById(review.getRestaurantId()).get();
		if(restaurant.getId()==review.getRestaurantId()) {
			restaurant.setRating((restaurant.getRating()+review.getScore())/2);
			//restaurant.setRating(review.getRating());
			review.setStatus("added review for existing restaurant");
			restaurantRepository.save(restaurant);
			reviewRepository.save(review);
		
	}
	}



}*/
