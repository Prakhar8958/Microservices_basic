package com.example.RatingService.RatingService;


import com.example.RatingService.RatingEntity.Rating;
import com.example.RatingService.RatingRepository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepo ratingRepo;


    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

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

    @Override
    public List<Rating> searchRatings(String text) {
        final List<Rating> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("microratingservice"); // Ensure this matches your database name
        MongoCollection<Document> collection = database.getCollection("rating");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$match", new Document("$or",
                        Arrays.asList(new Document("feedback", new Document("$regex", text).append("$options", "i"))))),
                new Document("$sort", new Document("rating", -1L)), new Document("$limit", 5L)));

        result.forEach(doc -> posts.add(converter.read(Rating.class, doc)));

        return posts;
    }

    @Override
    public void deleteRating(String ratingid) {
    ratingRepo.deleteById(ratingid);
    }
}
