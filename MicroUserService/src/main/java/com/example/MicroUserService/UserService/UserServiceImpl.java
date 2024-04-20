package com.example.MicroUserService.UserService;


import com.example.MicroUserService.Exceptions.Exception;
import com.example.MicroUserService.ExternalService.HotelService;
import com.example.MicroUserService.UserEntity.Hotel;
import com.example.MicroUserService.UserEntity.Rating;
import com.example.MicroUserService.UserEntity.User;
import com.example.MicroUserService.UserRepository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        Rating[] RatingsofUsers=restTemplate.getForObject("http://RATING-SERVICE/rating/User/"+user.getId(), Rating[].class);

        List<Rating> ratings=Arrays.stream(RatingsofUsers).toList();

       /*
        List<Rating> ratinglist=ratings.stream().map(rating->{
            //ResponseEntity<Hotel> ratingforHotels=restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/getHotelById/"+rating.getHotelid(), Hotel.class);

            Hotel hotel=hotelService.getHotel(rating.getHotel().getId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
       */

        user.setRatings(ratings);
        return user;
    }
}
