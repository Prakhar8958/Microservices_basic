package com.example.HotelService.HotelController;

import com.example.HotelService.HotelEntity.Hotel;
import com.example.HotelService.HotelService.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/createHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
  {
      return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));

  }

    @GetMapping("/getHotelById/{hotelid}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelid)
    {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getById(hotelid));
    }

    @GetMapping("/getHotels")
    public ResponseEntity<List<Hotel>> getHotels()
    {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
    }

    @GetMapping("/deleteById/{hotelid}")
    public ResponseEntity<HotelService> deleteHotel(@PathVariable String hotelid){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService);
    }

}
