package com.example.RatingService.RatingController;

import com.example.RatingService.RatingEntity.Rating;
import com.example.RatingService.RatingService.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
@Autowired
private RatingService ratingService;

   @PostMapping("/createRating")
   public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
    return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.creteRating(rating));
   }

   @GetMapping("/getAllRatings")
   public ResponseEntity<List<Rating>> getAllRatings(){
    return ResponseEntity.ok(ratingService.getAllRating());
   }

    @GetMapping("/User/{userid}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserid(@PathVariable String userid){
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userid));
    }

    @GetMapping("/Hotel/{hotelid}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelid){
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelid));
    }
    @GetMapping("/search/{text}")
    public ResponseEntity<List<Rating>> getAllRatingsBySearch(@PathVariable String text){
        return ResponseEntity.ok(ratingService.searchRatings(text));
    }
    @GetMapping("/deleteById/{ratingid}")
    public ResponseEntity<RatingService> deleteById(@PathVariable String ratingid){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService);
   }

}
