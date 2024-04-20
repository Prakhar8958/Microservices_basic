package com.example.MicroUserService.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="hotel")
public class Hotel {

    @Id
    private String id;

    private String name;

    private String location;

    private String about;



}
