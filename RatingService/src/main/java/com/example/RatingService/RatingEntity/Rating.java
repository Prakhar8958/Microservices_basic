package com.example.RatingService.RatingEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "rating")
public class Rating {

    @Id
    private String ratingid;

    private String userid;

    private String hotelid;

    private int rating;

    private String feedback;

    private Hotel hotel;

}
