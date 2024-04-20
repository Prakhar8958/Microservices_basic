package com.example.RatingService.RatingService;


import com.example.RatingService.RatingEntity.Rating;
import com.example.RatingService.RatingRepository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating creteRating(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepo.findByUserid(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepo.findByHotelid(hotelId);
    }
}
