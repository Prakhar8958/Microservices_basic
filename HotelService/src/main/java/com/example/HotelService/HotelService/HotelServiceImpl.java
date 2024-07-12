package com.example.HotelService.HotelService;

import com.example.HotelService.HotelEntity.Hotel;
import com.example.HotelService.HotelRepository.HotelRepo;
import com.example.HotelService.HotelService.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepo hotelrepo;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelid=UUID.randomUUID().toString();
        hotel.setId(hotelid);
        return hotelrepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelrepo.findAll();
    }

    @Override
    public Hotel getById(String id) {
        return hotelrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("NO hoetls found By this Id"));
    }

    @Override
    public void deleteById(String id) {
        hotelrepo.deleteById(id);
    }
}
