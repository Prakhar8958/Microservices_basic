package com.example.MicroUserService.UserService;


import com.example.MicroUserService.Exceptions.Exception;
import com.example.MicroUserService.ExternalService.HotelService;
import com.example.MicroUserService.UserEntity.Hotel;
import com.example.MicroUserService.UserEntity.Rating;
import com.example.MicroUserService.UserEntity.User;
import com.example.MicroUserService.UserRepository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userrepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
        String randomUserId= UUID.randomUUID().toString();
        user.setId(randomUserId);
        return userrepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userrepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user=userrepo.findById(userId).orElseThrow(()->new Exception("User not found by this Id"+userId));


        Rating[] ratingsOfUsers;
        try {
            ratingsOfUsers = restTemplate.getForObject("http://RATING-SERVICE/rating/User/" + user.getId(), Rating[].class);
        } catch (RestClientException e) {
            // Handle the exception (log it, rethrow it, or return a default response)
            throw new RuntimeException("Failed to fetch ratings for user: " + userId, e);
        }
        List<Rating> ratings=Arrays.stream(ratingsOfUsers).toList();


        List<Rating> ratinglist=ratings.stream().map(rating->{
           ResponseEntity<Hotel> ratingforHotels=restTemplate.getForEntity("http://HOTELSERVICE/hotel/getHotelById/"+rating.getHotelid(), Hotel.class);

           // Hotel hotel=hotelService.getHotel(rating.getHotel().getId());
            Hotel hotel=ratingforHotels.getBody();
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());


        user.setRatings(ratings);
        return user;
    }
}
