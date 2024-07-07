package com.example.MicroUserService.UserEntity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Rating {

    @Id
    private String ratingid;

    private String userid;

    private String hotelid;

    private int rating;

    private String feedback;

    @Transient
    private Hotel hotel;
}
