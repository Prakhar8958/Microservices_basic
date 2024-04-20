package com.example.HotelService.HotelRepository;


import com.example.HotelService.HotelEntity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,String> {
}
