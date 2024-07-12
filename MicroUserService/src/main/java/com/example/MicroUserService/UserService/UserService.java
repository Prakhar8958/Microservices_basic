package com.example.MicroUserService.UserService;

import com.example.MicroUserService.UserEntity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    void deleteUser(String userId);
}
