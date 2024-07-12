package com.example.RatingService.RatingService;

import com.example.RatingService.RatingEntity.Rating;

import java.util.List;

public interface RatingService {

   Rating creteRating(Rating rating);

   List<Rating> getAllRating();

   List<Rating> getRatingsByUserId(String userId);

   List<Rating> getRatingsByHotelId(String hotelId);

   List<Rating> searchRatings(String text);

   void deleteRating(String ratingid);
}
