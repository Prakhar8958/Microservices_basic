package com.example.RatingService.RatingRepository;

import com.example.RatingService.RatingEntity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepo extends MongoRepository<Rating,String> {

    List<Rating> findByUserid(String userid);
    List<Rating> findByHotelid(String hotelid);
}
