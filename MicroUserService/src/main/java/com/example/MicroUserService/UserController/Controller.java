package com.example.MicroUserService.UserController;

import com.example.MicroUserService.UserEntity.User;
import com.example.MicroUserService.UserService.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/getUser/{userid}")
    @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getUserById(@PathVariable String userid){
        User user=userService.getUser(userid);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> ratingHotelFallBack(String userId,Exception ex){
        System.out.println(ex.getMessage());
        User user=User.builder()
                .email("pks8958saxena@gmail.com")
                .about("dummy user created").name("Prakhar").build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser=userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
