package com.example.HotelService.HotelService;

import com.example.HotelService.HotelEntity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel getById(String id);

    void deleteById(String id);
}
