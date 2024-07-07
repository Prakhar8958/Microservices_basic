package com.example.MicroUserService.ExternalService;

import com.example.MicroUserService.UserEntity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTELSERVICE")
public interface HotelService {

    @GetMapping("/hotel/getHotelById/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

}
