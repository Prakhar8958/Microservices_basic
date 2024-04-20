package com.example.MicroUserService.UserRepository;

import com.example.MicroUserService.UserEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
